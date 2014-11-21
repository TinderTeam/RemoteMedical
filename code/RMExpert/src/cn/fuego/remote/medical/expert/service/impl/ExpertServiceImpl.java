/**   
* @Title: ExpertServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:00:53 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.util.format.DateUtil;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.misp.constant.MISPOperLogConsant;
import cn.fuego.misp.service.MISPServiceContext;
import cn.fuego.remote.medical.constant.DayNumEnum;
import cn.fuego.remote.medical.constant.LinkStatusEnum;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.domain.ImageArchiving;
import cn.fuego.remote.medical.domain.Link;
import cn.fuego.remote.medical.domain.Report;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.service.cache.ReportTemplateCache;
import cn.fuego.remote.medical.expert.web.model.ExpertModel;
import cn.fuego.remote.medical.expert.web.model.ImageModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportFilterModel;
import cn.fuego.remote.medical.expert.web.model.ReportTemplateModel;

/** 
 * @ClassName: ExpertServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午03:00:53 
 *  
 */

/** 
* @ClassName: ExpertServiceImpl 
* @Description: TODO
* @author Aether
* @date 2014-10-30 下午3:55:50 
*  
*/ 
public class ExpertServiceImpl implements ExpertService
{
	private Log log = LogFactory.getLog(ExpertServiceImpl.class);

	private ReportDao repertDao = DaoContext.getInstance().getReportDao();

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#getMedicalList(java.lang.String, cn.fuego.remote.medical.expert.web.model.ReportQueryModel, cn.fuego.misp.web.model.page.PageModel)
	 */
	@Override
	public AbstractDataSource<ReportView> getMedicalList(String userName, ReportFilterModel filter)
	{
 
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		
		if(!ValidatorUtil.isEmpty(userName))
		{
			conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"exDoctor",userName));	
		}
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getPatientName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"patientName",filter.getPatientName()));
			}
			if(!ValidatorUtil.isEmpty(filter.getModality()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"modality",filter.getModality()));
			}
			if(!ValidatorUtil.isEmpty(filter.getHospitalName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"hospitalName",filter.getHospitalName()));
			}
			
			if(!ValidatorUtil.isEmpty(filter.getExReportState()) && !ConditionTypeEnum.ALL.equals(filter.getExReportState()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"exReportState",String.valueOf(ReportStatusEnum.getEnumByStr(filter.getExReportState()).getStatusValue())));
			}
			
			if(!ValidatorUtil.isEmpty(filter.getStartDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"exApply",filter.getStartDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getEndDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER_EQ,"exApply",filter.getEndDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getDays()))
			{
				Calendar today = Calendar.getInstance();
				today.add(Calendar.DAY_OF_MONTH, -Integer.valueOf(DayNumEnum.getEnumByStr(filter.getDays()).getDayValue()));
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"exApply",DateUtil.DateToString(today.getTime())));
			}
		}

		conditionList.add(new QueryCondition(ConditionTypeEnum.DESC_ORDER,"exReportState"));
		conditionList.add(new QueryCondition(ConditionTypeEnum.DESC_ORDER,"exApply"));
		AbstractDataSource<ReportView> dataSource = new DataBaseSourceImpl<ReportView>(ReportView.class,conditionList);
		
 		return dataSource;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#getImageByMedical(java.lang.String, java.lang.String)
	 */
	@Override
	public MedicalReportModel getImageByMedical(String reportViewID)
	{
		//get medical report information
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",reportViewID);
		ReportView reportView = (ReportView) DaoContext.getInstance().getReportViewDao().getUniRecord(condition);		
		MedicalReportModel reportModel = new MedicalReportModel();
		reportModel.setReportView(reportView);
		
		//get the image list of medical report
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "hospitalID",reportModel.getReportView().getHospitalID()));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "serialNo",String.valueOf(reportModel.getReportView().getSerialNo())));

		List<ImageArchiving> imageList = (List<ImageArchiving>) DaoContext.getInstance().getImageArchivingDao().getAll(conditionList);
		
		for(ImageArchiving image :imageList)
		{
			ImageModel imageModel = new ImageModel();
			imageModel.setImage(image);
			reportModel.getImageList().add(imageModel);
		}
		
		//read template information
		reportModel.setTemplate(ReportTemplateCache.getInstance().getTemplateTreeByName(reportView.getModality()));
		return reportModel;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#submitMedicalReport(cn.fuego.remote.medical.constant.ReportStatusEnum, cn.fuego.remote.medical.expert.web.model.MedicalReportModel)
	 */
	@Override
	public void submitMedicalReport(ReportStatusEnum status, MedicalReportModel reportModel)
	{
		log.info("submit report.");
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "hospitalID",reportModel.getReportView().getHospitalID()));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "serialNo",String.valueOf(reportModel.getReportView().getSerialNo())));
		Report report = (Report) repertDao.getUniRecord(conditionList);
		//根据医院ID获取医院的信息（电话列表）
		QueryCondition hsCondition =new QueryCondition(ConditionTypeEnum.EQUAL, "id",reportModel.getReportView().getHospitalID());
		Hospital hospital= (Hospital) DaoContext.getInstance().getHospitalDao().getUniRecord(hsCondition);
		
		String operate = "";
		if(null != report)
		{	
			if(status==ReportStatusEnum.CANCEL||status==ReportStatusEnum.SUBMIT)//撤销报告或提交报告需要短信通知
			{
			    String content = "";
			    if(status==ReportStatusEnum.CANCEL)
			    {
			    	content="病人"+reportModel.getReportView().getPatientID()+"的报告已经被撤销！";
			    	operate = MISPOperLogConsant.CANCEL_REPORT;
			    }
			    else
			    {
			    	content="病人"+reportModel.getReportView().getPatientID()+"的报告已经回传，请注意查收！";
			    	
			    	operate = MISPOperLogConsant.SUBMIT_REPORT;
			    }
			    if(null != hospital.getContactsPhone())
			    {
				    String[] a =hospital.getContactsPhone().split(";");//通知电话列表所用字段
					List<String> phoneNumList = new ArrayList<String>();

				    if(!ValidatorUtil.isEmpty(a))
				    {
					    phoneNumList = Arrays.asList(a);
					    MISPServiceContext.getInstance().getMISPShortMessageService().sendMessage(phoneNumList, content);
				    }
				    else
				    {
				    	log.warn("hospital phone is empty, the hospitalID is"+reportModel.getReportView().getHospitalID());
				    }
			    }
			    else
			    {
			    	log.warn("hospital phone is empty, the hospitalID is"+reportModel.getReportView().getHospitalID());
			    }

				
			}
			else
			{
		    	operate = MISPOperLogConsant.SAVE_REPORT;

			}

			report.setExStudyContent(reportModel.getReportView().getExStudyContent());
			report.setExStudyConclusion(reportModel.getReportView().getExStudyConclusion());
			report.setExReportState(status.getStatusValue());
			repertDao.update(report);
			MISPServiceContext.getInstance().getMISPOperLogService().recordLog(report.getExDoctor(), operate, "报告编号"+String.valueOf(report.getSerialNo()), MISPOperLogConsant.OPERATE_SUCCESS); 
			

		}
		else
		{
			log.error("can not find the report.the report is " + reportModel);
		}

	}

	@Override
	@SuppressWarnings("unchecked")	
	public AbstractDataSource<Expert> getExpertList(ExpertModel ExpertFilter,  String userName,String reportViewID)
	{
		//通过reportViewID查找reportView
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",reportViewID);
		ReportView reportView = (ReportView) DaoContext.getInstance().getReportViewDao().getUniRecord(condition);
        //根据reportView查找医院ID和关联表
		List<QueryCondition> linkConditionList = new ArrayList<QueryCondition>();
		List<String> expertList= new ArrayList<String>();
		linkConditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"hospitalID", reportView.getHospitalID()));
		linkConditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"linkState",String.valueOf(LinkStatusEnum.LINK_SUCCESS.getStatusValue())));

		List<Link> linkList = (List<Link>) DaoContext.getInstance().getLinkDao().getAll(linkConditionList);		
		if(ValidatorUtil.isEmpty(linkList))
		{
			
		 
			conditionList.add(new QueryCondition(ConditionTypeEnum.FALSE,null));
			
		}
		else
		{
			for(int i=0;i<linkList.size();i++)
			{
				String linkExpertID = linkList.get(i).getExpertID();
				expertList.add(linkExpertID);
			}
			
			conditionList.add(new QueryCondition(ConditionTypeEnum.IN,"id",expertList));//指定范围内专家列表
			
		}
 
		if (null != ExpertFilter)
		{
			if (!ValidatorUtil.isEmpty(ExpertFilter.getExpert().getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "id", ExpertFilter.getExpert().getId()));
			}
			if (!ValidatorUtil.isEmpty(ExpertFilter.getExpert().getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "name", ExpertFilter.getExpert().getName()));

			}
			if (!ValidatorUtil.isEmpty(ExpertFilter.getExpert().getJobTitle()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "jobTitle", ExpertFilter.getExpert().getJobTitle()));

			}
			if (!ValidatorUtil.isEmpty(ExpertFilter.getExpert().getWorkPlace()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "workPlace", ExpertFilter.getExpert().getWorkPlace()));

			}

		}
		 
		conditionList.add(new QueryCondition(ConditionTypeEnum.NOT_EQUAL,"id",userName));//除操作者本身以外

		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "state",String.valueOf(UserStatusEnum.REGISTERED.getIntValue())));
		
		AbstractDataSource<Expert> dataSource = new DataBaseSourceImpl<Expert>(Expert.class,conditionList);
		
		 
		return dataSource;
	}
	/**
	 * 
	 */
	@Override
	public void transferExpert(String expertID, String reportViewID)
	{
		//根据reportViewID查找report
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",reportViewID);
		ReportView reportView = (ReportView) DaoContext.getInstance().getReportViewDao().getUniRecord(condition);
		
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "hospitalID",reportView.getHospitalID()));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "serialNo",String.valueOf(reportView.getSerialNo())));
		Report report = (Report) repertDao.getUniRecord(conditionList);
		if(null != report)
		{
			report.setExDoctor(expertID);
			repertDao.update(report);

		}
		else
		{
			log.error("can not find the report.the reportView is " + reportView);
		}
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(report.getExDoctor(), MISPOperLogConsant.TRANS_REPORT, "报告编号"+String.valueOf(report.getSerialNo()), MISPOperLogConsant.OPERATE_SUCCESS); 
		
		
	}

	@Override
	public ReportTemplateModel getReportModalById(String modalID)
	{
		ReportTemplateModel reportModal=ReportTemplateCache.getInstance().getReportTemplateById(modalID);
		return reportModal;
	}	

	

}
