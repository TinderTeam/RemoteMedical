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
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.service.UserService;
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
			if(!ValidatorUtil.isEmpty(filter.getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"id",filter.getId()));
			}
			if(!ValidatorUtil.isEmpty(filter.getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"name",filter.getName()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getProvince()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"province",filter.getProvince()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getCity()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"city",filter.getCity()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getCounty()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"county",filter.getCounty()));
				
			}			
		}
		
		AbstractDataSource<Hospital> dataSource = new DataBaseSourceImpl<Hospital>(Hospital.class,conditionList);
		
		 
		return dataSource;
	}

 
 

}
