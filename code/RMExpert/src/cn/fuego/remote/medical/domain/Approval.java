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
	private String applyType;
	private String hospitalID;
	private String expertID;
	private String status;
	private String applyTime;
	private String handleTime;
	private String desp;

}
