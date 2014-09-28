package cn.fuego.remote.medical.expert.service;



public class ServiceContext
{
	private static ServiceContext instance;
 
	private UserService userManagerService = null;

	  
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
 
	public  synchronized UserService getUserManagerService() {
		if (null == userManagerService)
		{
			userManagerService = null;//new UserManageServiceImpl();
		}
		return userManagerService;
	}
}
