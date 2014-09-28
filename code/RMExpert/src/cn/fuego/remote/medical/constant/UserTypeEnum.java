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
 * @ClassName: UserTypeEnumj 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午07:00:09 
 *  
 */

public enum UserTypeEnum
{	
	EXPERT("专家",1),  
	HOSPITAL("医院",2),    
	LOW_ADMIN("普通管理员",99),
	ADMIN("管理员",88);  

	private String type;
	private int typeValue;
	private UserTypeEnum(String type, int typeValue)
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
 
 

}
