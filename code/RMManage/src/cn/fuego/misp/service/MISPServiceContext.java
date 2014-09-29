package cn.fuego.misp.service;

import cn.fuego.misp.service.UserService;
import cn.fuego.remote.medical.expert.service.impl.ExpertServiceImpl;
import cn.fuego.remote.medical.expert.service.impl.UserServiceImpl;

import cn.fuego.remote.medical.expert.service.impl.UserServiceImpl;



public class MISPServiceContext
{
	private static MISPServiceContext instance;
 
	private UserService userService = null;
	  
	private MISPServiceContext()
	{
		
	}
	public static synchronized MISPServiceContext getInstance()
	{
		if (null == instance)
		{
			instance = new MISPServiceContext();
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
 
}
