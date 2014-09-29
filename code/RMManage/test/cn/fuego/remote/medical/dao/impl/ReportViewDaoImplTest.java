/**   
* @Title: ReportViewDaoImplTest.java 
* @Package cn.fuego.remote.medical.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午05:09:56 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import cn.fuego.remote.medical.dao.ReportViewDao;
import cn.fuego.remote.medical.domain.ReportView;

/** 
 * @ClassName: ReportViewDaoImplTest 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午05:09:56 
 *  
 */

public class ReportViewDaoImplTest
{

	ReportViewDao viewDao = new ReportViewDaoImpl();
	/**
	 * Test method for {@link cn.fuego.common.dao.AbstractViewDao#getAll()}.
	 */
	@Test
	public void testGetAll()
	{
		List<ReportView> recordList;
		recordList = (List<ReportView>) viewDao.getAll();
		System.out.println(recordList.size());
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
