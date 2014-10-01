package cn.fuego.remote.medical.manage.service;

import cn.fuego.misp.service.MISPUserService;

import cn.fuego.remote.medical.manage.service.impl.ExpertServiceImpl;
import cn.fuego.remote.medical.manage.service.impl.UserServiceImpl;



public class ServiceContext
{
	private static ServiceContext instance;
 
	private UserService userService = null;

	private ExpertService expertService = null;
	  
	private ServiceContext()
	{
		
	}
	public static synchronized ServiceContext getInstance()
	{
		if (null == instance)
		{
			instance = new ServiceContext();
		}
		return instance;
	}
 
	public  synchronized UserService getUserService() {
		if (null == userService)
		{
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
	public  synchronized ExpertService getExpertService() {
		if (null == expertService)
		{
			expertService = new ExpertServiceImpl();
		}
		return expertService;
	}
}
