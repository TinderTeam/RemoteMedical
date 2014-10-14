package cn.fuego.remote.medical.manage.web.model;

import cn.fuego.remote.medical.constant.UserTypeEnum;

public class UserFilterModel
{
	private int userID;
	private String userName;
	private String password;
	private String accountType;
	private String regDate;
	private String startDate;
	private String endDate;
	private UserTypeEnum[] userTypeList = UserTypeEnum.values();
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}


	public String getAccountType()
	{
		return accountType;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public String getRegDate()
	{
		return regDate;
	}
	public void setRegDate(String regDate)
	{
		this.regDate = regDate;
	}
	public UserTypeEnum[] getUserTypeList()
	{
		return userTypeList;
	}
	public void setUserTypeList(UserTypeEnum[] userTypeList)
	{
		this.userTypeList = userTypeList;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	
	
}
