/**   
* @Title: Link.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午06:40:03 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: Link 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午06:40:03 
 *  
 */

public class Link implements PersistenceObject
{
	private String hospitalID;
	private String expertID;
	private String hospitalName;
	private String expertName;
	private Date linkTime;
	private String auditor;
	private int linkState;
	
	
	public String getHospitalName()
	{
		return hospitalName;
	}
	public void setHospitalName(String hospitalName)
	{
		this.hospitalName = hospitalName;
	}
	public String getExpertName()
	{
		return expertName;
	}
	public void setExpertName(String expertName)
	{
		this.expertName = expertName;
	}
	public String getAuditor()
	{
		return auditor;
	}
	public void setAuditor(String auditor)
	{
		this.auditor = auditor;
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
	public Date getLinkTime()
	{
		return linkTime;
	}
	public void setLinkTime(Date linkTime)
	{
		this.linkTime = linkTime;
	}
	public int getLinkState()
	{
		return linkState;
	}
	public void setLinkState(int linkState)
	{
		this.linkState = linkState;
	}
	@Override
	public String toString()
	{
		return "Link [hospitalID=" + hospitalID + ", expertID=" + expertID
				+ ", linkTime=" + linkTime + ", linkState=" + linkState + "]";
	}
	 

}
