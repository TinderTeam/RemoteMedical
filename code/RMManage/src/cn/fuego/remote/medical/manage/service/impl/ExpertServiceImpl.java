/**   
* @Title: ExpertServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:00:53 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.util.format.DateUtil;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.misp.domain.SystemUser;
import cn.fuego.remote.medical.constant.DayNumEnum;
import cn.fuego.remote.medical.constant.LinkStatusEnum;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.Link;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.manage.service.ExpertService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.web.model.ImageModel;
import cn.fuego.remote.medical.manage.web.model.MedicalReportModel;
import cn.fuego.remote.medical.manage.web.model.ReportFilterModel;

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
			SystemUser user = ServiceContext.getInstance().getUserService().getSystemUserByUserName(userName);
			switch(UserTypeEnum.getEnumByInt(user.getAccountType()))
			{
			case LOW_ADMIN:
 				break;
			case ADMIN:
 				break;
			case EXPERT:
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"exDoctor",userName));	
				break;
			case HOSPITAL:
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"hospitalID",userName));	
				break;
			}
		}
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getPatientName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"patientName",filter.getPatientName()));
			}
			if(!ValidatorUtil.isEmpty(filter.getModality()))
			{
				List<String> list = new ArrayList<String>();
				if(filter.getModality().equals("DX"))
				{
					list.add("DR");
				}
				list.add(filter.getModality());
				
				conditionList.add(new QueryCondition(ConditionTypeEnum.IN,"modality",list));
			}
			if(!ValidatorUtil.isEmpty(filter.getHospitalName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"hospitalName",filter.getHospitalName()));
			}
			
			if(!ValidatorUtil.isEmpty(filter.getExReportState()) && !ConditionTypeEnum.ALL.equals(filter.getExReportState()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"exReportState",String.valueOf(ReportStatusEnum.getEnumByStr(filter.getExReportState()).getStatusValue())));
			}
			
			conditionList.add(new QueryCondition(ConditionTypeEnum.NOT_EQUAL, "exReportState",String.valueOf(ReportStatusEnum.CANCEL.getStatusValue())));

			if(!ValidatorUtil.isEmpty(filter.getStartDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"exApply",filter.getStartDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getEndDate()))
			{
				Date  endDate = DateUtil.addDay(DateUtil.stringToDate(filter.getEndDate()), 1);
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER,"exApply",DateUtil.DateToString(endDate)));
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
	public List<ImageModel> getImageByMedical(String seralNo, String hospitalID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#submitMedicalReport(cn.fuego.remote.medical.constant.ReportStatusEnum, cn.fuego.remote.medical.expert.web.model.MedicalReportModel)
	 */
	@Override
	public void submitMedicalReport(ReportStatusEnum status, MedicalReportModel report)
	{
		// TODO Auto-generated method stub

	}

	public List<String> getLinkHosptialByExpert(String expertID)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>(); 
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "expertID",expertID));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "linkState",String.valueOf(LinkStatusEnum.LINK_SUCCESS.getStatusValue())));
		List<Link> linkList = (List<Link>) DaoContext.getInstance().getLinkDao().getAll(conditionList);
		Set<String> hospNameList = new HashSet<String>();
		for(Link e : linkList)
		{
			if(!ValidatorUtil.isEmpty(e.getHospitalName()))
			{
				hospNameList.add(e.getHospitalName());
			}
		}
		return new ArrayList<String>(hospNameList);
	}
}
