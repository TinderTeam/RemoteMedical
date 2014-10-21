/**   
* @Title: Approval.java 
* @Package cn.fuego.remote.medical.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午07:11:29 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

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
	private int id; //申请单号 自增长
	private int applyType; //申请类型
	private String applyName; //申请名称
	private String applyUser; //申请者账号名
	private String handleUser; //处理人账号
	private String status;  //申请状态
	private Date applyTime; //申请时间
	private Date handleTime; //处理时间
	private String desp;  //申请描述
	
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

	public Date getApplyTime()
	{
		return applyTime;
	}
	public void setApplyTime(Date applyTime)
	{
		this.applyTime = applyTime;
	}
	public Date getHandleTime()
	{
		return handleTime;
	}
	public void setHandleTime(Date handleTime)
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
	public String getApplyUser()
	{
		return applyUser;
	}
	public void setApplyUser(String applyUser)
	{
		this.applyUser = applyUser;
	}
	public String getHandleUser()
	{
		return handleUser;
	}
	public void setHandleUser(String handleUser)
	{
		this.handleUser = handleUser;
	}
	

}
