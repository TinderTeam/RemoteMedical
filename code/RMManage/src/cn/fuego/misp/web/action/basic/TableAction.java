/**   
* @Title: TableAction.java 
* @Package cn.fuego.misp.web.action.basic 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-16 下午11:23:14 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.basic;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.remote.medical.constant.UserStatusEnum;

/** 
 * @ClassName: TableAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-16 下午11:23:14 
 *  
 */

public abstract class TableAction extends MISPAction
{
	public static final String SHOW_INFO = "showInfo";
	public static final String EDIT_INFO ="editInfo";
	private String jumpActionName;
	
	
	private String selectedID;  //表格选中项目
	private String[] selectedIDList; //表格多选选中项目
	private String operateType;//当前操作类型

 
	/**
	 * 新增表格数据
	 * @return
	 */
	abstract public String create();
	
	/**
	 * 删除单条数据
	 * @return
	 */
	abstract public String delete();
	
	/**
	 * 删除多条数据
	 * @return
	 */
	abstract public String deleteList();
	
	/**
	 * 修改数据
	 * @return
	 */
	abstract public String modify();
	
	/**
	 * 展示详细信息
	 * @return
	 */
	abstract public String show();
	
	private UserStatusEnum[] userStatusList = UserStatusEnum.values();
	
	public List<String> convertToPageMessage(List<String> messageList)
	{
		List<String> resourceList = new ArrayList<String>();
		if(!ValidatorUtil.isEmpty(messageList))
		{
			for(String message : messageList)
			{
				resourceList.add(this.getText(message));
			}
		}
		return resourceList;

	}


	public String getOperateType()
	{
		return operateType;
	}

	public void setOperateType(String operateType)
	{
		this.operateType = operateType;
	}

	public String[] getSelectedIDList()
	{
		return selectedIDList;
	}

	public void setSelectedIDList(String[] selectedIDList)
	{
		this.selectedIDList = selectedIDList;
	}

	public String getSelectedID()
	{
		return selectedID;
	}

	public void setSelectedID(String selectedID)
	{
		this.selectedID = selectedID;
	}
	public String getJumpActionName()
	{
		return jumpActionName;
	}
	public void setJumpActionName(String jumpActionName)
	{
		this.jumpActionName = jumpActionName;
	}
 
	public static String getShowInfo()
	{
		return SHOW_INFO;
	}
	public UserStatusEnum[] getUserStatusList()
	{
		return userStatusList;
	}
	public void setUserStatusList(UserStatusEnum[] userStatusList)
	{
		this.userStatusList = userStatusList;
	}

	

}
