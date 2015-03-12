/**   
* @Title: BasicDao.java 
* @Package cn.fuego.misp.dao.hibernate.util 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 下午03:03:18 
* @version V1.0   
*/ 
package cn.fuego.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.CreateException;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: BasicDao 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 下午03:03:18 
 *  
 */

public interface Dao extends ViewDao
{

	/**
	 * 新增对象
	 * @param object
	 */
	void create(PersistenceObject object);

	/**
	 * 更新对象
	 * @param object
	 */
	void update(PersistenceObject object);
 
	
	/**
	 * 根据条件删除
	 * @param conditionList
	 */
	void delete(List<QueryCondition> conditionList);
	
	/**
	 * 根据条件删除
	 * @param conditionList
	 */
	void delete(QueryCondition condition);

}
