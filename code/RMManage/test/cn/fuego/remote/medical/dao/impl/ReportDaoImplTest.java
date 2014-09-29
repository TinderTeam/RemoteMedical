/**   
* @Title: ReportDaoImplTest.java 
* @Package cn.fuego.remote.medical.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:55:32 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Test;

import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.Report;

/** 
 * @ClassName: ReportDaoImplTest 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午03:55:32 
 *  
 */

public class ReportDaoImplTest
{

	ReportDao dao = new ReportDaoImpl();
	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractDao#create(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testCreate()
	{
		for(int i=2;i<200;i++)
		{
			Report report = new Report();
			report.setSerialNo(i);
			report.setHospitalID("admin");
			
			report.setPatientName("patient"+i);
			report.setPatientAge("33");

			report.setPatientSex("男");
			dao.create(report);
			
		}

		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractDao#update(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testUpdate()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractDao#delete(cn.fuego.common.domain.PersistenceObject)}.
	 */
	@Test
	public void testDelete()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getAll()}.
	 */
	@Test
	public void testGetAll()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getUniRecord(cn.fuego.common.dao.QueryCondition)}.
	 */
	@Test
	public void testGetUniRecord()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getAll(java.util.List)}.
	 */
	@Test
	public void testGetAllListOfQueryCondition()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getAll(java.util.List, int, int)}.
	 */
	@Test
	public void testGetAllListOfQueryConditionIntInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getCount(java.util.List)}.
	 */
	@Test
	public void testGetCount()
	{
		fail("Not yet implemented");
	}

}
