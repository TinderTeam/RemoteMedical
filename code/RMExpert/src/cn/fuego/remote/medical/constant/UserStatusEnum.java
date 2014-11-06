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
	CREATED("已创建",0),  
	APPLIED("已申请",1),    
	CANCELED("已注销",2),
	REGISTERED("已注册",3);   
	private String strValue;
	private int intValue;
	private UserStatusEnum(String strValue, int intValue)
	{
		this.strValue = strValue;
		this.intValue = intValue;
	}
 

	
	public String getStrValue()
	{
		return strValue;
	}



	public int getIntValue()
	{
		return intValue;
	}



	public static UserStatusEnum getEnumByInt(int intValue)
	{
		for (UserStatusEnum c : UserStatusEnum.values())
		{
			if (intValue == c.intValue)
			{
				return c;
			}
		}
		return null;
	}
	public static UserStatusEnum getEnumByStr(String strValue)
	{
		for (UserStatusEnum c : UserStatusEnum.values())
		{
			if (strValue.equals(c.strValue) )
			{
				return c;
			}
		}
		return null;
	}
 
}
