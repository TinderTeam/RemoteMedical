package cn.fuego.remote.medical.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.util.format.DateUtil;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.remote.medical.constant.ApplyStatusEnum;
import cn.fuego.remote.medical.constant.ApplyTypeEnum;
import cn.fuego.remote.medical.constant.LinkStatusEnum;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.domain.Hospital;
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
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"applyName",filter.getApplyName()));
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
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER_EQ,"applyTime",filter.getEndDate()));
			}			
		}
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"status",ApplyStatusEnum.APPROVING.getStatus()));
		AbstractDataSource<Approval> dataSource = new DataBaseSourceImpl<Approval>(Approval.class,conditionList);
	 
		return dataSource;
		
		
	}

	@Override
	public void createHospitalApply(HospitalModel hospital)
	{
		hospital.getHospital().setState(UserStatusEnum.APPLIED.getStatus());
		DaoContext.getInstance().getHospitalDao().update(hospital.getHospital());
		createApply(ApplyTypeEnum.MODIFY_HOSPITAL,hospital.getHospital().getId(),hospital.getHospital().getId(),null);
		 
		
	}
	@Override
	public void createExpertApply(ExpertModel expert)
	{
		expert.getExpert().setState(UserStatusEnum.APPLIED.getStatus());
		ServiceContext.getInstance().getUserService().saveExpertInfo(expert);
		createApply(ApplyTypeEnum.MODIFY_EXPERT,expert.getExpert().getId(),null,expert.getExpert().getId());

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

	}

	@Override
	public Approval getApprovalByID(String approvalID)
	{
		QueryCondition condition =new QueryCondition(ConditionTypeEnum.EQUAL,"id",approvalID);
		Approval approval =(Approval) DaoContext.getInstance().getApprovalDao().getUniRecord(condition);
		return approval;
	}

	@Override
	public HospitalModel modifyHospitalByID(String hospitalID)
	{
		QueryCondition condition =new QueryCondition(ConditionTypeEnum.EQUAL,"id",hospitalID);
		HospitalModel hospitalModel =(HospitalModel) DaoContext.getInstance().getHospitalDao().getUniRecord(condition);
		return hospitalModel;
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
				expertModel.getExpert().setState(UserStatusEnum.REGISTERED.getStatus());
				DaoContext.getInstance().getExpertDao().update(expertModel.getExpert());
				break;
			case MODIFY_HOSPITAL: 
				HospitalModel hospitalModel =ServiceContext.getInstance().getUserService().getHospitalByID(approval.getHospitalID());
				hospitalModel.getHospital().setState(UserStatusEnum.REGISTERED.getStatus());
				DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());				
								  
				break;
			case ADD_EXPERT:
				LinkModel linkModel= ServiceContext.getInstance().getUserService().getLinkByID(approval.getHospitalID(), approval.getExpertID());
				linkModel.getLink().setLinkState(LinkStatusEnum.LINK_SUCCESS.getStatusValue());
				linkModel.getLink().setLinkTime(DateUtil.getCurrentDate());
				DaoContext.getInstance().getLinkDao().update(linkModel.getLink());
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
				expertModel.getExpert().setState(UserStatusEnum.CREATED.getStatus());
				DaoContext.getInstance().getExpertDao().update(expertModel.getExpert());
				break;
			case MODIFY_HOSPITAL: 
				HospitalModel hospitalModel =ServiceContext.getInstance().getUserService().getHospitalByID(approval.getHospitalID());
				hospitalModel.getHospital().setState(UserStatusEnum.CREATED.getStatus());
				DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());				
								  
				break;
			case ADD_EXPERT:
				LinkModel linkModel= ServiceContext.getInstance().getUserService().getLinkByID(approval.getHospitalID(), approval.getExpertID());
				linkModel.getLink().setLinkState(LinkStatusEnum.LINK_FAILED.getStatusValue());
				linkModel.getLink().setLinkTime(DateUtil.getCurrentDate());
				DaoContext.getInstance().getLinkDao().update(linkModel.getLink());
				break;
			default:
				break;
					
				
		}		
		
	}

 
}
