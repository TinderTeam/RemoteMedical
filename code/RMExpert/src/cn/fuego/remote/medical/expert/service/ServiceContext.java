package cn.fuego.remote.medical.expert.service;

import cn.fuego.remote.medical.expert.service.impl.ExpertServiceImpl;



public class ServiceContext
{
	private static ServiceContext instance;
 
 
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
 
 
	
	public  synchronized ExpertService getExpertService() {
		if (null == expertService)
		{
			expertService = new ExpertServiceImpl();
		}
		return expertService;
	}
}
