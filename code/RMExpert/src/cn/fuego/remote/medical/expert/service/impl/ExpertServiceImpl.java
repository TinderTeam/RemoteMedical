/**   
* @Title: ExpertServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:00:53 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.ImageArchiving;
import cn.fuego.remote.medical.domain.Report;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.service.cache.ReportTemplateCache;
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
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"exReportState",filter.getExReportState()));
			}
			
			if(!ValidatorUtil.isEmpty(filter.getStartDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"exReportState",filter.getStartDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getEndDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER_EQ,"exReportState",filter.getEndDate()));
			}
		}
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
		reportModel.setTemplate(ReportTemplateCache.getInstance().getTemplateTree());
		return reportModel;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#submitMedicalReport(cn.fuego.remote.medical.constant.ReportStatusEnum, cn.fuego.remote.medical.expert.web.model.MedicalReportModel)
	 */
	@Override
	public void submitMedicalReport(ReportStatusEnum status, MedicalReportModel reportModel)
	{
		
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "hospitalID",reportModel.getReportView().getHospitalID()));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "serialNo",String.valueOf(reportModel.getReportView().getSerialNo())));
		Report report = (Report) repertDao.getUniRecord(conditionList);
		if(null != report)
		{
			report.setExStudyContent(reportModel.getReportView().getExStudyContent());
			report.setExStudyConclusion(reportModel.getReportView().getExStudyConclusion());
			report.setExReportState(status.getStatus());
			repertDao.update(report);

		}
		else
		{
			log.error("can not find the report.the report is " + reportModel);
		}

	}	
	

	

}
