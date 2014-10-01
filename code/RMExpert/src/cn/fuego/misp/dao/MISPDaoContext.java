package cn.fuego.misp.dao;

import cn.fuego.common.dao.Dao;
import cn.fuego.common.dao.impl.CommonDaoImpl;
import cn.fuego.misp.domain.SystemIDType;
import cn.fuego.misp.domain.SystemMenu;
import cn.fuego.misp.domain.SystemUser;


/**
 * 
* @ClassName: DaoContext 
* @Description: TODO
* @author Nan Bowen
* @date 2014-3-23 下午11:27:41 
* 
 */
public class MISPDaoContext
{
	private static MISPDaoContext instance;
 
	private Dao systemMenuDao = null;
 
  
	private Dao systemIDTypeDao = null;
 
	private Dao systemUserDao = null;
	

	private MISPDaoContext()
	{

	}

	public static synchronized MISPDaoContext getInstance()
	{
		if (null == instance)
		{
			instance = new MISPDaoContext();
		}
		return instance;
	}
 
	public synchronized Dao getSystemUserDao() 
	{
		if (null == systemUserDao)
		{
			systemUserDao = new CommonDaoImpl(SystemUser.class);
		}
		return systemUserDao;
	}
	
	public synchronized Dao getSystemMenuDao() 
	{
		if (null == systemMenuDao)
		{
			systemMenuDao = new CommonDaoImpl(SystemMenu.class);
		}
		return systemMenuDao;
	}
	
 
	
	public synchronized Dao getSystemIDTypeDao() 
	{
		if (null == systemIDTypeDao)
		{
			systemIDTypeDao = getDaoInstanceByClass(SystemIDType.class);
		}
		return systemIDTypeDao;
	}
	private Dao getDaoInstanceByClass(Class clazz)
	{
		Dao dao;
 
		dao = new CommonDaoImpl(clazz); 
		return dao;
	}
	 
}
