/**   
* @Title: UserModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:28:16 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.user;

import java.util.Date;

import cn.fuego.remote.medical.constant.UserTypeEnum;

/** 
 * @ClassName: UserModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:28:16 
 *  
 */

public class UserModel
{  
	private int userID;  //用户ID
	private String userName; //用户名称
	private String password; //用户密码
	private int accountType; //账号类型
	private Date regDate; //注册类型
	private String validateCode; //验证类型
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

	public Date getRegDate()
	{
		return regDate;
	}
	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}
	public int getAccountType()
	{
		return accountType;
	}
	public void setAccountType(int accountType)
	{
		this.accountType = accountType;
	}
	public String getValidateCode()
	{
		return validateCode;
	}
	public void setValidateCode(String validateCode)
	{
		this.validateCode = validateCode;
	}

	

}
