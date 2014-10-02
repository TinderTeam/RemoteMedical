/**   
* @Title: AjaxDoneModel.java 
* @Package cn.fuego.misp.web.model.dwz 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-1 下午09:53:57 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.message;

import cn.fuego.common.exception.CommonExceptionMsg;

/** 
 * @ClassName: AjaxDoneModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-1 下午09:53:57 
 *  
 */

public class MispMessageModel
{
	
	private String statusCode = "200";
	private String message = CommonExceptionMsg.OPERATE_SUCCESS;
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	private String confirmMsg;
	public String getStatusCode()
	{
		return statusCode;
	}
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getNavTabId()
	{
		return navTabId;
	}
	public void setNavTabId(String navTabId)
	{
		this.navTabId = navTabId;
	}
	public String getRel()
	{
		return rel;
	}
	public void setRel(String rel)
	{
		this.rel = rel;
	}
	public String getCallbackType()
	{
		return callbackType;
	}
	public void setCallbackType(String callbackType)
	{
		this.callbackType = callbackType;
	}
	public String getForwardUrl()
	{
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl)
	{
		this.forwardUrl = forwardUrl;
	}
	public String getConfirmMsg()
	{
		return confirmMsg;
	}
	public void setConfirmMsg(String confirmMsg)
	{
		this.confirmMsg = confirmMsg;
	}
 
}
