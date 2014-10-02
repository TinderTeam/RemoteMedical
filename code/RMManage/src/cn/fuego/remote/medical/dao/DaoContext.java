package cn.fuego.remote.medical.dao;

import cn.fuego.common.dao.Dao;
import cn.fuego.common.dao.impl.CommonDaoImpl;
import cn.fuego.remote.medical.dao.impl.ReportDaoImpl;
import cn.fuego.remote.medical.dao.impl.ReportViewDaoImpl;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.domain.ImageArchiving;



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
 
	private ReportViewDao reportViewDao = null;
	
	private ReportDao reportDao = null;
	
	private Dao imageArchivingDao = null;
	private Dao hospitalDao = null;

	private Dao expertDao= null;

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
	public synchronized Dao getImageArchivingDao() 
	{
		if (null == imageArchivingDao)
		{
			imageArchivingDao = new CommonDaoImpl(ImageArchiving.class);
		}
		return imageArchivingDao;
	}
	
	public synchronized Dao getHospitalDao() 
	{
		if (null == hospitalDao)
		{
			hospitalDao = new CommonDaoImpl(Hospital.class);
		}
		return hospitalDao;
	}
	public synchronized Dao getExpertDao() 
	{
		if (null == expertDao)
		{
			expertDao = new CommonDaoImpl(Expert.class);
		}
		return expertDao;
	}
}
