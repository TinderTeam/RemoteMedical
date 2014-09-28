/**   
* @Title: UserModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:28:16 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.model;

/** 
 * @ClassName: UserModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:28:16 
 *  
 */

public class UserModel
{
	private int userID;
	private String userName;
	private String password;
	private String accountType;
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

}
