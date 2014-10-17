/**   
* @Title: Approval.java 
* @Package cn.fuego.remote.medical.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午07:11:29 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: Approval 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午07:11:29 
 *  
 */

public class Approval implements PersistenceObject
{
	private int id;
	private int applyType;
	private String applyName;
	private String status;
	private String applyTime;
	private String handleTime;
	private String desp;
	private String hospitalID;
	private String expertID;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public int getApplyType()
	{
		return applyType;
	}
	public void setApplyType(int applyType)
	{
		this.applyType = applyType;
	}
	public String getHospitalID()
	{
		return hospitalID;
	}
	public void setHospitalID(String hospitalID)
	{
		this.hospitalID = hospitalID;
	}
	public String getExpertID()
	{
		return expertID;
	}
	public void setExpertID(String expertID)
	{
		this.expertID = expertID;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getApplyTime()
	{
		return applyTime;
	}
	public void setApplyTime(String applyTime)
	{
		this.applyTime = applyTime;
	}
	public String getHandleTime()
	{
		return handleTime;
	}
	public void setHandleTime(String handleTime)
	{
		this.handleTime = handleTime;
	}
	public String getDesp()
	{
		return desp;
	}
	public void setDesp(String desp)
	{
		this.desp = desp;
	}
	public String getApplyName()
	{
		return applyName;
	}
	public void setApplyName(String applyName)
	{
		this.applyName = applyName;
	}
	

}
