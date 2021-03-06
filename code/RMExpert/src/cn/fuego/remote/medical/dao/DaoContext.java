package cn.fuego.remote.medical.dao;

import cn.fuego.remote.medical.dao.impl.ReportDaoImpl;
import cn.fuego.remote.medical.dao.impl.ReportViewDaoImpl;
import cn.fuego.remote.medical.dao.impl.SystemUserDaoImpl;



/**
 * 
* @ClassName: DaoContext 
* @Description: TODO
* @author Nan Bowen
* @date 2014-3-23 下午11:27:41 
* 
 */
public class DaoContext
{
	private static DaoContext instance;
	private SystemUserDao systemUserDao=null;

	private ReportViewDao reportViewDao = null;
	
	private ReportDao reportDao = null;

	private DaoContext()
	{

	}

	public static synchronized DaoContext getInstance()
	{
		if (null == instance)
		{
			instance = new DaoContext();
		}
		return instance;
	}

	public synchronized SystemUserDao getSystemUserDao() 
	{
		if (null == systemUserDao)
		{
			systemUserDao = new SystemUserDaoImpl();
		}
		return systemUserDao;
	}
 
	public synchronized ReportViewDao getReportViewDao() 
	{
		if (null == reportViewDao)
		{
			reportViewDao = new ReportViewDaoImpl();
		}
		return reportViewDao;
	}
	
	public synchronized ReportDao getReportDao() 
	{
		if (null == reportDao)
		{
			reportDao = new ReportDaoImpl();
		}
		return reportDao;
	}
}
