/**   
* @Title: LinkDaoImplTest.java 
* @Package cn.fuego.remote.medical.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午09:53:59 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;

/** 
 * @ClassName: LinkDaoImplTest 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午09:53:59 
 *  
 */

public class LinkDaoImplTest
{

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#create(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testCreate()
	{
		for(int i=0;i<300;i++)
		{
			Hospital hosp = new Hospital();
			hosp.setId("hospital"+i);
			hosp.setName("湘雅");
			DaoContext.getInstance().getHospitalDao().create(hosp);	
		}

	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#update(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testUpdate()
	{
		for(int i=2000;i<3000;i++)
		{
			Expert hosp = new Expert();
			hosp.setId("expert"+i);
			hosp.setName("专家"+i);
			DaoContext.getInstance().getExpertDao().create(hosp);	
		}
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractDao#delete(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testDelete()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractViewDao#getAll()}.
	 */
	@Test
	public void testGetAll()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractViewDao#getAll(java.util.List)}.
	 */
	@Test
	public void testGetAllListOfQueryCondition()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractViewDao#getAll(java.util.List, int, int)}.
	 */
	@Test
	public void testGetAllListOfQueryConditionIntInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.impl.AbstractViewDao#getCount(java.util.List)}.
	 */
	@Test
	public void testGetCount()
	{
		fail("Not yet implemented");
	}

}
