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
	private String hospitalID;
	private String expertID;
	private String hospitalName;
	private String expertName;
	private Date linkTime;
	private String linkState;
}
