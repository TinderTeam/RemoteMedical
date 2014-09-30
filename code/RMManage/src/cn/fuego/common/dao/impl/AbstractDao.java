/**   
* @Title: AbstractDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 下午03:34:48 
* @version V1.0   
*/ 
package cn.fuego.common.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.Dao;
import cn.fuego.common.dao.hibernate.util.HibernateUtil;
import cn.fuego.common.domain.PersistenceObject;
import cn.fuego.common.util.meta.ReflectionUtil;

/** 
 * @ClassName: AbstractDao 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 下午03:34:48 
 *  
 */

public abstract  class AbstractDao extends AbstractViewDao implements Dao
{

	private Log log = LogFactory.getLog(AbstractDao.class);

	public void create(PersistenceObject object)
	{
		log.info("the object calss is " + getFeaturedClass()+"the object is "+object.toString());
		try
		{
			HibernateUtil.add(object);
		} catch (RuntimeException re)
		{
			log.error("database error",re);
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
	}

	public void update(PersistenceObject object)
	{
		log.info("the object calss is " + getFeaturedClass()+"the object is "+object.toString());

		try
		{
			HibernateUtil.update(object);
		} catch (RuntimeException re)
		{
			log.error("update error",re);
			throw re;

		} finally
		{
			HibernateUtil.closeSession();
		}
	}
	public void delete(PersistenceObject object)
	{
		log.info("the object calss is " + getFeaturedClass()+"the object is "+object.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(getFeaturedClass(), object);

			session.delete(classObj);

			tx.commit();
		} catch (RuntimeException re)
		{
			log.error("delete error",re);
			throw re;

		} finally
		{
			if (session != null)
			{
				session.close();
			}
		}
	}

}
