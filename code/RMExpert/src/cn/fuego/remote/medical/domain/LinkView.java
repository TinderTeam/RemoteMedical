/**   
* @Title: LinkView.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午06:43:19 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: LinkView 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午06:43:19 
 *  
 */

public class LinkView  implements PersistenceObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hospitalID;
	private String expertID;
	private String hospitalName;
	private String expertName;    
	private String expertAuditor; //审核人姓名（新增）
	private Date linkTime;        //挂钩时间
	private String linkState;     //连接状态（1=已关联，0=未关联）
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
	public Date getLinkTime()
	{
		return linkTime;
	}
	public void setLinkTime(Date linkTime)
	{
		this.linkTime = linkTime;
	}
	public String getLinkState()
	{
		return linkState;
	}
	public void setLinkState(String linkState)
	{
		this.linkState = linkState;
	}
	public String getExpertAuditor()
	{
		return expertAuditor;
	}
	public void setExpertAuditor(String expertAuditor)
	{
		this.expertAuditor = expertAuditor;
	}
	@Override
	public String toString()
	{
		return "LinkView [hospitalID=" + hospitalID + ", expertID=" + expertID
				+ ", hospitalName=" + hospitalName + ", expertName="
				+ expertName + ", expertAuditor=" + expertAuditor
				+ ", linkTime=" + linkTime + ", linkState=" + linkState + "]";
	}
	
}
