/**   
* @Title: ReportTemplate.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-1 下午11:33:20 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.model;

import java.util.List;

/** 
 * @ClassName: ReportTemplate 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-1 下午11:33:20 
 *  
 */

public class ReportTemplateModel
{
	private String name;
	private String value;
	private List<ReportTemplateModel> childList;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public List<ReportTemplateModel> getChildList()
	{
		return childList;
	}
	public void setChildList(List<ReportTemplateModel> childList)
	{
		this.childList = childList;
	}

	
}
