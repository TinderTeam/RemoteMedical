package cn.fuego.misp.service;

import cn.fuego.misp.service.impl.MISPOperLogServiceImpl;
import cn.fuego.misp.service.impl.MISPPrivilegeManageImpl;
import cn.fuego.remote.medical.manage.service.impl.UserServiceImpl;

public class MISPServiceContext
{
	private static MISPServiceContext instance;

	private MISPUserService userService = null;
	private MISPOperLogService operLogService = null;

	private MISPPrivilegeManage privilegeManage = null;

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
	

	public synchronized MISPOperLogService getMISPOperLogService()
	{
		if (null == operLogService)
		{
			operLogService = new MISPOperLogServiceImpl();
		}
		return operLogService;
	}
	
	public synchronized MISPPrivilegeManage MISPPrivilegeManage()
	{
		if (null == privilegeManage)
		{
			privilegeManage = new MISPPrivilegeManageImpl();
		}
		return privilegeManage;
	}

}
