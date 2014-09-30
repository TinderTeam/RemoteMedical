package cn.fuego.misp.service;

import cn.fuego.remote.medical.expert.service.impl.UserServiceImpl;

public class MISPServiceContext
{
	private static MISPServiceContext instance;

	private MISPUserService userService = null;

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

	public synchronized MISPUserService getUserService()
	{
		if (null == userService)
		{
			userService = new UserServiceImpl();
		}
		return userService;
	}
	


}
