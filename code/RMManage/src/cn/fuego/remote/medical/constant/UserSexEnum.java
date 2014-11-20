/**   
* @Title: UserTypeEnumj.java 
* @Package cn.fuego.remote.medical.constant 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午07:00:09 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.constant;


/** 
* @ClassName: UserSexEnum 
* @Description: TODO
* @author Aether
* @date 2014-10-20 下午1:56:23 
*  
*/ 
public enum UserSexEnum
{	
	MAN("男","M"),  
	WOMAN("女","W"),    
	OTHER("其他","O");

	private String type;
	private String typeValue;
	private UserSexEnum(String type, String typeValue)
	{
		this.type = type;
		this.typeValue = typeValue;
	}
	public String getType()
	{
		return type;
	}
	public String getTypeValue()
	{
		return typeValue;
	}
	public static UserSexEnum getEnumByInt(String typeValue)
	{
		for (UserSexEnum c : UserSexEnum.values())
		{
			if (typeValue.equals(c.typeValue))
			{
				return c;
			}
		}
		return null;
	}
	public static UserSexEnum getEnumByStr(String strValue)
	{
		for (UserSexEnum c : UserSexEnum.values())
		{
			if (strValue.equals(c.type) )
			{
				return c;
			}
		}
		return null;
	}
	
 

}
