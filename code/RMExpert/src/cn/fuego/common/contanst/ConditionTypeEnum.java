/**   
* @Title: QueryCondition.java 
* @Package cn.fuego.misp.contanst 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 下午04:11:10 
* @version V1.0   
*/ 
package cn.fuego.common.contanst;

/** 
 * @ClassName: QueryCondition 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 下午04:11:10 
 *  
 */

public enum  ConditionTypeEnum
{
	INCLUDLE("包含",1),
	EXCLUDLE("不包含",2), 
	EQUAL("等于",3), 
	NOT_EQUAL("不等于",4), 
	BIGER("大于",5), 
	BIGER_EQ("大于等于",6),
	LOWER("小于",7), 
	LOWER_EQ("小于等于",8),  
	BETWEEN("之间",9);
	
    // 成员变量  
    private String typeName;  
    private int typeValue;
    private ConditionTypeEnum(String type,int typeValue)
    {
    	this.typeName = type;
    	this.typeValue = typeValue;
    }
	public String getTypeName()
	{
		return typeName;
	}
	public int getTypeValue()
	{
		return typeValue;
	}
 
	
  
}
