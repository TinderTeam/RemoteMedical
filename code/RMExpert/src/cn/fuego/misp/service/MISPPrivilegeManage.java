/**   
* @Title: MISPPrivilegeManage.java 
* @Package cn.fuego.misp.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-21 上午10:16:50 
* @version V1.0   
*/ 
package cn.fuego.misp.service;

import java.util.Set;

 /** 
 * @ClassName: MISPPrivilegeManage 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-21 上午10:16:50 
 *  
 */
public interface MISPPrivilegeManage
{
	/**
	 * 根据用户ID获取菜单权限
	 * @param userID
	 * @return
	 */
	public Set<String> getMenuIDListByUser(String userID);
	
	/**
	 * 根据用户角色获取菜单权限
	 * @param roleID
	 * @return
	 */
	public Set<String> getMenuIDListByRole(String roleID);
 	
	
	/**
	 * 用户是否对该功能有权限
	 * @param userID
	 * @param prvilegeID
	 * @return
	 */
	public boolean hasPrivilege(String userID,int prvilegeID);
	
 
}
