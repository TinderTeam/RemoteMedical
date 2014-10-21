/**   
* @Title: ApplyTypeEnum.java 
* @Package cn.fuego.remote.medical.constant 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午09:24:04 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.constant;

/** 
 * @ClassName: ApplyTypeEnum 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午09:24:04 
 *  
 */

public enum ApplyTypeEnum
{
	MODIFY_EXPERT("专家信息修改",1),  
	MODIFY_HOSPITAL("医院信息修改",2),    
	ADD_EXPERT("医院添加专家",3);

	private String type;
	private int typeValue;
	private ApplyTypeEnum(String type, int typeValue)
	{
		this.type = type;
		this.typeValue = typeValue;
	}
	public String getType()
	{
		return type;
	}
	public int getTypeValue()
	{
		return typeValue;
	}
	
	

	public static ApplyTypeEnum getEnumByInt(int typeInt)
	{
		for (ApplyTypeEnum c : ApplyTypeEnum.values())
		{
			if (typeInt == c.typeValue)
			{
				return c;
			}
		}
		return null;
	}
	public static ApplyTypeEnum getEnumByStr(String typeStr)
	{
		for (ApplyTypeEnum c : ApplyTypeEnum.values())
		{
			if (typeStr.equals(c.type) )
			{
				return c;
			}
		}
		return null;
	}	

 
}
