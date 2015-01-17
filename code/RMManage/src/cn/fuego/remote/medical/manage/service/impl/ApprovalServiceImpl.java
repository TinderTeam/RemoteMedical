package cn.fuego.remote.medical.manage.service.impl;

import java.util.ArrayList;
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
import cn.fuego.misp.domain.SystemUser;
import cn.fuego.misp.service.MISPServiceContext;
import cn.fuego.remote.medical.constant.ApplyStatusEnum;
import cn.fuego.remote.medical.constant.ApplyTypeEnum;
import cn.fuego.remote.medical.constant.LinkStatusEnum;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.domain.Link;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.web.model.ApprovalFilterModel;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;
import cn.fuego.remote.medical.manage.web.model.LinkModel;

public class ApprovalServiceImpl implements ApprovalService
{
	private Log log = LogFactory.getLog(ApprovalServiceImpl.class);
	
	public AbstractDataSource<Approval> getApprovalList(ApprovalFilterModel filter)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getApplyName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"applyUser",filter.getApplyName()));
			}
			if(!ValidatorUtil.isEmpty(filter.getApplyType()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"applyType",String.valueOf(ApplyTypeEnum.getEnumByStr(filter.getApplyType()).getTypeValue())));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getStartDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"applyTime",filter.getStartDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getEndDate()))
			{
				Date  endDate = DateUtil.addDay(DateUtil.stringToDate(filter.getEndDate()), 1);		
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER_EQ,"applyTime",DateUtil.DateToString(endDate)));
			
 			}			
		}
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"status",ApplyStatusEnum.APPROVING.getStatus()));
		AbstractDataSource<Approval> dataSource = new DataBaseSourceImpl<Approval>(Approval.class,conditionList);
	 
		return dataSource;
		
		
	}

	@Override
	public void createHospitalApply(HospitalModel hospital)
	{
 
		ServiceContext.getInstance().getUserService().saveHospitalInfo(hospital, hospital.getHospital().getId(),"apply");
 		createApply(ApplyTypeEnum.MODIFY_HOSPITAL,hospital.getHospital().getId(),hospital.getHospital().getId(),null);
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(hospital.getHospital().getId(), MISPOperLogConsant.MODIFY_HOSPITAL, null, MISPOperLogConsant.OPERATE_SUCCESS);		
		 
		
	}
	@Override
	public void createExpertApply(ExpertModel expert)
	{

		ServiceContext.getInstance().getUserService().saveExpertInfo(expert,expert.getExpert().getId(),"apply");
		createApply(ApplyTypeEnum.MODIFY_EXPERT,expert.getExpert().getId(),null,expert.getExpert().getId());
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(expert.getExpert().getId(), MISPOperLogConsant.MODIFY_APPLY, null, MISPOperLogConsant.OPERATE_SUCCESS);

	}

	private void createApply(ApplyTypeEnum applyType,String applyUser,String hopitalID,String expertID)
	{
		Approval approval = new Approval();
		 approval.setApplyTime(DateUtil.getCurrentDate());
		 approval.setApplyName(applyType.getType());
		 approval.setApplyType(applyType.getTypeValue());
		 approval.setApplyUser(applyUser);
		 approval.setHospitalID(hopitalID);
		 approval.setExpertID(expertID);
		 approval.setStatus(ApplyStatusEnum.APPROVING.getStatus());
		 DaoContext.getInstance().getApprovalDao().create(approval);
	}


	@Override
	public void createAddExpertApply(String hospitalID, String expertID)
	{
		Link link = new Link();
		link.setExpertID(expertID);
		link.setHospitalID(hospitalID);
		link.setLinkTime(DateUtil.getCurrentDate());
		link.setLinkState(LinkStatusEnum.LINK_FAILED.getStatusValue());
		createApply(ApplyTypeEnum.ADD_EXPERT,hospitalID,hospitalID,expertID);
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(hospitalID, MISPOperLogConsant.ADD_EXPERT, expertID, MISPOperLogConsant.OPERATE_SUCCESS);
	}

	@Override
	public Approval getApprovalByID(String approvalID)
	{
		QueryCondition condition =new QueryCondition(ConditionTypeEnum.EQUAL,"id",approvalID);
		Approval approval =(Approval) DaoContext.getInstance().getApprovalDao().getUniRecord(condition);
		return approval;
	}
 

	@Override
	public void handleAgree(String handleUser,String approvalID)
	{
		Approval approval=this.getApprovalByID(approvalID);
		approval.setStatus(ApplyStatusEnum.AGREED.getStatus());
		approval.setHandleUser(handleUser);
		approval.setHandleTime(DateUtil.getCurrentDate());
		DaoContext.getInstance().getApprovalDao().update(approval);
		switch(ApplyTypeEnum.getEnumByInt(approval.getApplyType()))
		{
			case MODIFY_EXPERT:  
				ExpertModel expertModel =ServiceContext.getInstance().getUserService().getExpertByID(approval.getExpertID());
				expertModel.getExpert().setState(UserStatusEnum.REGISTERED.getIntValue());
				expertModel.getExpert().setAuthority(1);
				expertModel.getExpert().setAuditor(handleUser);
				expertModel.getExpert().setReg(DateUtil.getCurrentDate());

				DaoContext.getInstance().getExpertDao().update(expertModel.getExpert());
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_AGREE);
				break;
			case MODIFY_HOSPITAL: 
				HospitalModel hospitalModel =ServiceContext.getInstance().getUserService().getHospitalByID(approval.getHospitalID());
				hospitalModel.getHospital().setState(UserStatusEnum.REGISTERED.getIntValue());
				hospitalModel.getHospital().setAuthority(1);
				hospitalModel.getHospital().setAuditor(handleUser);
				hospitalModel.getHospital().setReg(DateUtil.getCurrentDate());
				
				
				DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());				
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_AGREE);				  
				break;
			case ADD_EXPERT:
				LinkModel linkModel= ServiceContext.getInstance().getUserService().getLinkByID(approval.getHospitalID(), approval.getExpertID());
				linkModel.getLink().setLinkState(LinkStatusEnum.LINK_SUCCESS.getStatusValue());
				linkModel.getLink().setAuditor(handleUser);
				linkModel.getLink().setLinkTime(DateUtil.getCurrentDate());
				DaoContext.getInstance().getLinkDao().update(linkModel.getLink());
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_AGREE);
				break;
			default:
				break;
					
				
		}
	}

	@Override
	public void handleRefuse(String handleUser, String approvalID)
	{
		Approval approval=this.getApprovalByID(approvalID);
		approval.setStatus(ApplyStatusEnum.REFUSED.getStatus());
		approval.setHandleUser(handleUser);
		approval.setHandleTime(DateUtil.getCurrentDate());
		DaoContext.getInstance().getApprovalDao().update(approval);
		switch(ApplyTypeEnum.getEnumByInt(approval.getApplyType()))
		{
			case MODIFY_EXPERT:  
				ExpertModel expertModel =ServiceContext.getInstance().getUserService().getExpertByID(approval.getExpertID());
				expertModel.getExpert().setState(UserStatusEnum.CREATED.getIntValue());
				expertModel.getExpert().setAuditor(handleUser);				
				DaoContext.getInstance().getExpertDao().update(expertModel.getExpert());
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_REFUSE);
				break;
			case MODIFY_HOSPITAL: 
				HospitalModel hospitalModel =ServiceContext.getInstance().getUserService().getHospitalByID(approval.getHospitalID());
				hospitalModel.getHospital().setState(UserStatusEnum.CREATED.getIntValue());
				hospitalModel.getHospital().setAuditor(handleUser);	
				DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());				
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_REFUSE);								  
				break;
			case ADD_EXPERT:
				LinkModel linkModel= ServiceContext.getInstance().getUserService().getLinkByID(approval.getHospitalID(), approval.getExpertID());
				List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"hospitalID",linkModel.getLink().getHospitalID()));
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"expertID",linkModel.getLink().getExpertID()));				
				DaoContext.getInstance().getLinkDao().delete(conditionList);
				MISPServiceContext.getInstance().getMISPOperLogService().recordLog(handleUser, MISPOperLogConsant.APPLY_CHECK, approval.getApplyName(), MISPOperLogConsant.APPLY_REFUSE);
				break;
			default:
				break;
					
				
		}		
		
	}
	
	public int getApprovalCount(String userName)
	{
		SystemUser user = ServiceContext.getInstance().getUserService().getSystemUserByUserName(userName);
		if(null == user)
		{
			return 0;
		}
		if(user.getAccountType() == UserTypeEnum.ADMIN.getTypeValue() || user.getAccountType() == UserTypeEnum.LOW_ADMIN.getTypeValue())
		{
			List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
			conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"status",ApplyStatusEnum.APPROVING.getStatus()));
			
			List<Approval> approvalList = (List<Approval>) DaoContext.getInstance().getApprovalDao().getAll(conditionList);
			return approvalList.size();
		}
		
 
	return 0;
		
		
	}
	
	public Approval getApprovalInfo(String userName)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		 
        conditionList.add(new QueryCondition(ConditionTypeEnum.DESC_ORDER, "id"));
        
		//conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"status",ApplyStatusEnum.REFUSED.getStatus()));
		conditionList.add(new QueryCondition(ConditionTypeEnum.NOT_EQUAL,"applyType",String.valueOf(ApplyTypeEnum.ADD_EXPERT.getTypeValue())));

		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"applyUser",userName));

		List<Approval> approvalList = (List<Approval>) DaoContext.getInstance().getApprovalDao().getAll(conditionList,0,1);
		if(!ValidatorUtil.isEmpty(approvalList))
		{
			return approvalList.get(0);
		}
		return null;
	}
 
 
}
