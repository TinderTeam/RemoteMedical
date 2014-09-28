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
	private String id;
	private String name;
	private String sex;
	private String age;
	private String phoneNo;
	private String telephoneNo;
	private String email;
	private String qq;
	private String weixin;
	private String remuse;
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
	private String ctCount;
	private String drCount;
	private String mrCount;
	private String ulCount;
	
	
	private String otherCount;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private int reserve4;
	private int reserve5;
	
}
