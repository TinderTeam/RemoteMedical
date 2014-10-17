/**   
* @Title: UserStatusEnum.java 
* @Package cn.fuego.remote.medical.constant 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午07:06:15 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.constant;

/** 
 * @ClassName: UserStatusEnum 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午07:06:15 
 *  
 */

public enum UserStatusEnum
{
	CREATED("已创建"),  
	APPLIED("已申请"),    
	CANCELED("已注销"),
	REGISTERED("已注册");   
	private String status;
	private UserStatusEnum(String status)
	{
		this.status = status;
	}
	public String getStatus()
	{
		return status;
	}
 
}
