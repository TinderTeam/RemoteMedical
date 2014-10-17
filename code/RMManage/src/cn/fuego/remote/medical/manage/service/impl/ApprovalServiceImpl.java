package cn.fuego.remote.medical.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.remote.medical.constant.ApplyTypeEnum;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.web.model.ApprovalFilterModel;

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
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"applyType",String.valueOf(ApplyTypeEnum.getEnumByStatus(filter.getApplyType()).getTypeValue())));
				
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

		AbstractDataSource<Approval> dataSource = new DataBaseSourceImpl<Approval>(Approval.class,conditionList);
	 
		return dataSource;
		
		
	}
}
