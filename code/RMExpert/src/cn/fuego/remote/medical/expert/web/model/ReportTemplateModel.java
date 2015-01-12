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
	private String id;
	private String name;
	private String value;
	private List<ReportTemplateModel> children;
	
    public String pId;
    public boolean open;
    public String url;
    public String target ="";
    public String icon;
    public String title;
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
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
 
	public List<ReportTemplateModel> getChildren()
	{
		return children;
	}
	public void setChildren(List<ReportTemplateModel> children)
	{
		this.children = children;
	}
	public String getpId()
	{
		return pId;
	}
	public void setpId(String pId)
	{
		this.pId = pId;
	}
	public boolean isOpen()
	{
		return open;
	}
	public void setOpen(boolean open)
	{
		this.open = open;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getIcon()
	{
		return icon;
	}
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTarget()
	{
		return target;
	}
	public void setTarget(String target)
	{
		this.target = target;
	}
	 
	
}
