/**   
* @Title: ViewDao.java 
* @Package cn.fuego.common.dao 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午06:45:05 
* @version V1.0   
*/ 
package cn.fuego.common.dao;

import java.util.Collection;
import java.util.List;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: ViewDao 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午06:45:05 
 *  
 */

public interface ViewDao
{
	/**
	 * 获取所有数据
	 * @return
	 */
	Collection getAll();
	
	/**
	 * 根据条件获取数据条目数
	 * @param conditionList
	 * @return
	 */
	long getCount(List<QueryCondition> conditionList);
	
	/**
	 * 根据条件获取多条数据
	 * @param conditionList
	 * @return
	 */
	Collection getAll(List<QueryCondition> conditionList);
	
	/**
	 * 根据条件获取多条数据
	 * @param conditionList
	 * @return
	 */
	Collection getAll(List<QueryCondition> conditionList,int startNum,int pageSize);
	
	/**
	 * 根据条件获取多条数据
	 * @param conditionList
	 * @return
	 */
	Collection getAll(QueryCondition condition);

	/**
	 * 根据条件获取单条数据
	 * @param conditionList
	 * @return
	 */
	PersistenceObject getUniRecord(QueryCondition condition);
	
	/**
	 * 根据条件获取单条数据
	 * @param conditionList
	 * @return
	 */
	PersistenceObject getUniRecord(List<QueryCondition> conditionList);


}
