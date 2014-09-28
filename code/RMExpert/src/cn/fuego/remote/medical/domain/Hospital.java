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
	private String id;
	private String name;
	private String Province;
	private String city;
	private String county;
	private String Address;
	private String HospitalPhone;
	private String ContactWay;
	private String Contacts;
	private String ContactsPhone;
	private String Rank;
	private String Resume;
	private String Remark;
	private Date Apply;
	private Date Reg;
	private String Auditor;
	private String State;
	private int Authority;
	private String Reserve1;
	private String Reserve2;
	private String Reserve3;
	private int Reserve4;
	private int Reserve5;
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
		return Province;
	}
	public void setProvince(String province)
	{
		Province = province;
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
		return Address;
	}
	public void setAddress(String address)
	{
		Address = address;
	}
	public String getHospitalPhone()
	{
		return HospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone)
	{
		HospitalPhone = hospitalPhone;
	}
	public String getContactWay()
	{
		return ContactWay;
	}
	public void setContactWay(String contactWay)
	{
		ContactWay = contactWay;
	}
	public String getContacts()
	{
		return Contacts;
	}
	public void setContacts(String contacts)
	{
		Contacts = contacts;
	}
	public String getContactsPhone()
	{
		return ContactsPhone;
	}
	public void setContactsPhone(String contactsPhone)
	{
		ContactsPhone = contactsPhone;
	}
	public String getRank()
	{
		return Rank;
	}
	public void setRank(String rank)
	{
		Rank = rank;
	}
	public String getResume()
	{
		return Resume;
	}
	public void setResume(String resume)
	{
		Resume = resume;
	}
	public String getRemark()
	{
		return Remark;
	}
	public void setRemark(String remark)
	{
		Remark = remark;
	}
	public Date getApply()
	{
		return Apply;
	}
	public void setApply(Date apply)
	{
		Apply = apply;
	}
	public Date getReg()
	{
		return Reg;
	}
	public void setReg(Date reg)
	{
		Reg = reg;
	}
	public String getAuditor()
	{
		return Auditor;
	}
	public void setAuditor(String auditor)
	{
		Auditor = auditor;
	}
	public String getState()
	{
		return State;
	}
	public void setState(String state)
	{
		State = state;
	}
	public int getAuthority()
	{
		return Authority;
	}
	public void setAuthority(int authority)
	{
		Authority = authority;
	}
	public String getReserve1()
	{
		return Reserve1;
	}
	public void setReserve1(String reserve1)
	{
		Reserve1 = reserve1;
	}
	public String getReserve2()
	{
		return Reserve2;
	}
	public void setReserve2(String reserve2)
	{
		Reserve2 = reserve2;
	}
	public String getReserve3()
	{
		return Reserve3;
	}
	public void setReserve3(String reserve3)
	{
		Reserve3 = reserve3;
	}
	public int getReserve4()
	{
		return Reserve4;
	}
	public void setReserve4(int reserve4)
	{
		Reserve4 = reserve4;
	}
	public int getReserve5()
	{
		return Reserve5;
	}
	public void setReserve5(int reserve5)
	{
		Reserve5 = reserve5;
	}
	
	
	
}
