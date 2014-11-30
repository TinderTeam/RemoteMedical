/**   
* @Title: Hospital.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午05:05:44 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: Hospital 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午05:05:44 
 *  
 */

public class Hospital implements PersistenceObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name = "";
	private String province;
	private String city;
	private String county;
	private String address;
	private String hospitalPhone;
	private String contactWay;
	private String contacts;
	private String contactsPhone;
	private String rank;
	private String resume;
	private String remark;
	private Date apply;
	private Date reg;
	private String auditor;
	private Integer state;
	private Integer authority = 0;
	private String reserve1;
	private String reserve2;
	private Integer reserve3;
	private Integer reserve4;
 
	
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

	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getHospitalPhone()
	{
		return hospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone)
	{
		this.hospitalPhone = hospitalPhone;
	}
	public String getContactWay()
	{
		return contactWay;
	}
	public void setContactWay(String contactWay)
	{
		this.contactWay = contactWay;
	}
	public String getContacts()
	{
		return contacts;
	}
	public void setContacts(String contacts)
	{
		this.contacts = contacts;
	}
	public String getContactsPhone()
	{
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone)
	{
		this.contactsPhone = contactsPhone;
	}
	public String getRank()
	{
		return rank;
	}
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	public String getResume()
	{
		return resume;
	}
	public void setResume(String resume)
	{
		this.resume = resume;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
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
	public Integer getState()
	{
		return state;
	}
	public void setState(Integer state)
	{
		this.state = state;
	}
	public Integer getAuthority()
	{
		return authority;
	}
	public void setAuthority(Integer authority)
	{
		this.authority = authority;
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
	public Integer getReserve3()
	{
		return reserve3;
	}
	public void setReserve3(Integer reserve3)
	{
		this.reserve3 = reserve3;
	}
	public Integer getReserve4()
	{
		return reserve4;
	}
	public void setReserve4(Integer reserve4)
	{
		this.reserve4 = reserve4;
	}
	@Override
	public String toString()
	{
		return "Hospital [id=" + id + ", name=" + name + ", province="
				+ province + ", city=" + city + ", county=" + county
				+ ", address=" + address + ", hospitalPhone=" + hospitalPhone
				+ ", contactWay=" + contactWay + ", contacts=" + contacts
				+ ", contactsPhone=" + contactsPhone + ", rank=" + rank
				+ ", resume=" + resume + ", remark=" + remark + ", apply="
				+ apply + ", reg=" + reg + ", auditor=" + auditor + ", state="
				+ state + ", authority=" + authority + ", reserve1=" + reserve1
				+ ", reserve2=" + reserve2 + ", reserve3=" + reserve3
				+ ", reserve4=" + reserve4 + "]";
	}
 

	
}
