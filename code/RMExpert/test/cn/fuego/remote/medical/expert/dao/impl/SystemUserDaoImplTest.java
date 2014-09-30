/**   
* @Title: SystemUserDaoImplTest.java 
* @Package cn.fuego.remote.medical.expert.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 下午05:39:11 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.dao.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.apps.mailreader.dao.User;
import org.junit.Test;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.remote.medical.dao.SystemUserDao;
import cn.fuego.remote.medical.dao.impl.SystemUserDaoImpl;
import cn.fuego.remote.medical.domain.SystemUser;

/** 
 * @ClassName: SystemUserDaoImplTest 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 下午05:39:11 
 *  
 */

public class SystemUserDaoImplTest
{
	SystemUserDao userDao=new SystemUserDaoImpl();
	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#create(cn.fuego.misp.domain.PersistenceObject)}.
	 */
	@Test
	public void testCreate()
	{
		SystemUser user = new SystemUser();
		user.setUserName("admin1");
		user.setPassword("2345");
		user.setRegDate(new Date(System.currentTimeMillis()));
		userDao.create(user);
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#update(cn.fuego.misp.domain.PersistenceObject)}.
	 */
	@Test
	public void testUpdate()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#delete(cn.fuego.misp.domain.PersistenceObject)}.
	 */
	@Test
	public void testDelete()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#getAll()}.
	 */
	@Test
	public void testGetAll()
	{
		List<User> userList = (List<User>) userDao.getAll();
		System.out.println(userList);
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#getAll(java.util.List)}.
	 */
	@Test
	public void testGetAllListOfQueryCondition()
	{
		List<QueryCondition> list = new ArrayList<QueryCondition>();
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL,"userID","1");
 
		list.add(condition);
		List<User> userList = (List<User>) userDao.getAll(list);
		System.out.println(userList.size());
	}
	@Test
	public void testGetUniResult()
	{
		List<QueryCondition> list = new ArrayList<QueryCondition>();
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL,"userName","admin");
 
		list.add(condition);
	    userDao.getUniRecord(condition); 
		System.out.println( "");
	}
}
