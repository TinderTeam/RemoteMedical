package cn.fuego.remote.medical.dao;

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
 
}
