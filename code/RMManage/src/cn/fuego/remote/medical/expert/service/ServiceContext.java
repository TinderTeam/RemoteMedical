package cn.fuego.remote.medical.expert.service;

import cn.fuego.misp.service.MISPUserService;
import cn.fuego.remote.medical.expert.service.impl.ExpertServiceImpl;
import cn.fuego.remote.medical.expert.service.impl.UserServiceImpl;

import cn.fuego.remote.medical.expert.service.impl.UserServiceImpl;



public class ServiceContext
{
	private static ServiceContext instance;
 
	private MISPUserService userService = null;

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
 
	public  synchronized MISPUserService getUserService() {
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
