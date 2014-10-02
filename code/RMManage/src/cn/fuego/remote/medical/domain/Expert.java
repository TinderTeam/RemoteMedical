/**   
* @Title: Expert.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午05:06:09 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.sql.Blob;
import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: Expert 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午05:06:09 
 *  
 */

public class Expert implements PersistenceObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String sex;
	private String age;
	private String phoneNo;
	private String telephoneNo;
	private String email;
	private String qq;
	private String weixin;
	private String resume;
	private Blob exPhoto;
	private String jobTitle;
	private String workPlace;
	private String province;
	private String city;
	private String county;
	
	private String expertise;
	private String remark;
	private Blob signName;
	private String authority;
	private String state;
	private String onlineState;
	
	private Date login;
	private Date apply;
	private Date reg;
	
	private String auditor;
	
	private Integer ctCount;
	private Integer drCount;
	private Integer mrCount;
	private Integer ulCount;
	
	
	private Integer otherCount;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private int reserve4;
	private int reserve5;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	public String getTelephoneNo()
	{
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo)
	{
		this.telephoneNo = telephoneNo;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getWeixin()
	{
		return weixin;
	}
	public void setWeixin(String weixin)
	{
		this.weixin = weixin;
	}
	public String getResume()
	{
		return resume;
	}
	public void setResume(String resume)
	{
		this.resume = resume;
	}

	public Blob getExPhoto()
	{
		return exPhoto;
	}
	public void setExPhoto(Blob exPhoto)
	{
		this.exPhoto = exPhoto;
	}
	public String getJobTitle()
	{
		return jobTitle;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	public String getWorkPlace()
	{
		return workPlace;
	}
	public void setWorkPlace(String workPlace)
	{
		this.workPlace = workPlace;
	}
	public String getProvince()
	{
		return province;
	}
	public void setProvince(String province)
	{
		this.province = province;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getCounty()
	{
		return county;
	}
	public void setCounty(String county)
	{
		this.county = county;
	}
	public String getExpertise()
	{
		return expertise;
	}
	public void setExpertise(String expertise)
	{
		this.expertise = expertise;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public Blob getSignName()
	{
		return signName;
	}
	public void setSignName(Blob signName)
	{
		this.signName = signName;
	}
	public String getAuthority()
	{
		return authority;
	}
	public void setAuthority(String authority)
	{
		this.authority = authority;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getOnlineState()
	{
		return onlineState;
	}
	public void setOnlineState(String onlineState)
	{
		this.onlineState = onlineState;
	}
	public Date getLogin()
	{
		return login;
	}
	public void setLogin(Date login)
	{
		this.login = login;
	}
	public Date getApply()
	{
		return apply;
	}
	public void setApply(Date apply)
	{
		this.apply = apply;
	}
	public Date getReg()
	{
		return reg;
	}
	public void setReg(Date reg)
	{
		this.reg = reg;
	}
	public String getAuditor()
	{
		return auditor;
	}
	public void setAuditor(String auditor)
	{
		this.auditor = auditor;
	}
	public Integer getCtCount()
	{
		return ctCount;
	}
	public Integer getDrCount()
	{
		return drCount;
	}
	public Integer getMrCount()
	{
		return mrCount;
	}
	public Integer getUlCount()
	{
		return ulCount;
	}
	public Integer getOtherCount()
	{
		return otherCount;
	}
	public void setCtCount(Integer ctCount)
	{
		this.ctCount = ctCount;
	}
	public void setDrCount(Integer drCount)
	{
		this.drCount = drCount;
	}
	public void setMrCount(Integer mrCount)
	{
		this.mrCount = mrCount;
	}
	public void setUlCount(Integer ulCount)
	{
		this.ulCount = ulCount;
	}
	public void setOtherCount(Integer otherCount)
	{
		this.otherCount = otherCount;
	}
	
	public String getReserve1()
	{
		return reserve1;
	}
	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1;
	}
	public String getReserve2()
	{
		return reserve2;
	}
	public void setReserve2(String reserve2)
	{
		this.reserve2 = reserve2;
	}
	public String getReserve3()
	{
		return reserve3;
	}
	public void setReserve3(String reserve3)
	{
		this.reserve3 = reserve3;
	}
	public int getReserve4()
	{
		return reserve4;
	}
	public void setReserve4(int reserve4)
	{
		this.reserve4 = reserve4;
	}
	public int getReserve5()
	{
		return reserve5;
	}
	public void setReserve5(int reserve5)
	{
		this.reserve5 = reserve5;
	}
	
}
