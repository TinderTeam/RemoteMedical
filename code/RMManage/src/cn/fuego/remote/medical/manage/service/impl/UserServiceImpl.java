/**   
* @Title: UserServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午02:39:40 
* @version V1.0   
*/ 
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
import cn.fuego.misp.service.impl.MISPUserServiceImpl;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午02:39:40 
 *  
 */

public class UserServiceImpl extends MISPUserServiceImpl implements UserService
{
	private Log log = LogFactory.getLog(UserServiceImpl.class);

	@Override
	public AbstractDataSource<Hospital> getHospitalList(HospitalModel filter)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getHospital().getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"id",filter.getHospital().getId()));
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"name",filter.getHospital().getName()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getProvince()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"province",filter.getHospital().getProvince()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getCity()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"city",filter.getHospital().getCity()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getCounty()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"county",filter.getHospital().getCounty()));
				
			}			
		}
		
		AbstractDataSource<Hospital> dataSource = new DataBaseSourceImpl<Hospital>(Hospital.class,conditionList);
		
		 
		return dataSource;
	}

	@Override
	public HospitalModel getHospitalByID(String id)
	{
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",id);
		
		HospitalModel hospitalModel = new HospitalModel();
		Hospital hospital = (Hospital) DaoContext.getInstance().getHospitalDao().getUniRecord(condition);
		hospitalModel.setHospital(hospital);
	  		
		return hospitalModel;
	}

	@Override
	public void modifyHospitalInfo(HospitalModel hospitalModel)
	{
		DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());
		
	}

	@Override
	public AbstractDataSource<Expert> getExpertList(ExpertModel filter)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getExpert().getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"id",filter.getExpert().getId()));
			}
			if(!ValidatorUtil.isEmpty(filter.getExpert().getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"name",filter.getExpert().getName()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getExpert().getJobTitle()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"jobTitle",filter.getExpert().getJobTitle()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getExpert().getWorkPlace()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"workPlace",filter.getExpert().getWorkPlace()));
				
			}
			
		}
		
		AbstractDataSource<Expert> dataSource = new DataBaseSourceImpl<Expert>(Expert.class,conditionList);
		
		 
		return dataSource;
	}

 
 

}
