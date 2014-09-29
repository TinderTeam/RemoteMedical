/**   
* @Title: ApplyStatusEnum.java 
* @Package cn.fuego.remote.medical.constant 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午07:31:35 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.constant;

/** 
 * @ClassName: ApplyStatusEnum 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午07:31:35 
 *  
 */

public enum ApplyStatusEnum
{	
	APPROVING("审批中"), 
	AGREED("已同意"),    
	REFUSED("已拒绝");  
	private String status;
	 
	private ApplyStatusEnum(String status)
	{
		this.status = status;
	}
	public String getStatus()
	{
		return status;
	}
 

}
