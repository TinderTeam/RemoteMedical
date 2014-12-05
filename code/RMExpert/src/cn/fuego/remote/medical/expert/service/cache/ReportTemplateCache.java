/**   
* @Title: ReportTemplateCache.java 
* @Package cn.fuego.remote.medical.expert.service.cache 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-9 下午03:22:29 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service.cache;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.fuego.common.util.SystemConfigInfo;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.remote.medical.expert.service.impl.ExpertServiceImpl;
import cn.fuego.remote.medical.expert.web.model.ReportTemplateModel;

/** 
 * @ClassName: ReportTemplateCache 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-9 下午03:22:29 
 *  
 */

public class ReportTemplateCache
{
	private Log log = LogFactory.getLog(ReportTemplateCache.class);

	private ReportTemplateModel templateTree = loadTemplate();
	private static ReportTemplateCache instance = null;
	
	private static int treeCurrID = 1;
	private ReportTemplateCache()
	{
	}
	
	public synchronized static ReportTemplateCache getInstance()
	{
		if(null == instance)
		{
			instance = new ReportTemplateCache();
		}
		return instance;
	}
	
	public ReportTemplateModel getTemplateTree()
	{
		return templateTree;
	}

	public ReportTemplateModel getTemplateTreeByName(String name)
	{
		if(name.equals("DX"))
		{
			name = "DR";
		}
		if(name.equals("CR"))
		{
			name = "DR";
		}
		for(ReportTemplateModel e : templateTree.getChildList())
		{
			if(e.getName().equals(name))
			{
				return e;
			}
		}
		log.error("can not find template by device name " + name);
 
		return null;
	}

	private ReportTemplateModel loadTemplate() 
	{
		log.info("start read template");
		SAXReader reader = new SAXReader();

		ReportTemplateModel templateModel = null;
		Document document;
		try
		{
			document = reader.read(new File(SystemConfigInfo.getTemplatePath()));
			Element root = document.getRootElement();
			
			templateModel = getTemplateByElement(root);
		}
		catch (DocumentException e)
		{
			log.error("read template failed",e);
		}
		log.info("read template done");
		


		return templateModel;
	}
	
 
	private ReportTemplateModel getTemplateByElement(Element e)
	{
		ReportTemplateModel template = new ReportTemplateModel();
 
		template.setId(String.valueOf(treeCurrID));
		treeCurrID++;
		
		template.setName("模板");
		if("Report".equals(e.getName()))
		{
			template.setName("检查所见");
		}
		if("Conclusion".equals(e.getName()))
		{
			template.setName("诊断意见");
		}
		
		if(!ValidatorUtil.isEmpty(e.elements()))
		{
			List<ReportTemplateModel> childList = new ArrayList<ReportTemplateModel>();
			for (Iterator<?> i = e.elementIterator(); i.hasNext();)
			{
				Element child = (Element) i.next();
				if("name".equals(child.getName()))
				{
					template.setName(child.getText());
				}
				else
				{
					childList.add(getTemplateByElement(child));
				}

			}
			template.setChildList(childList);

		}
		template.setValue(e.getText());

		return template;
	}
	public ReportTemplateModel getReportTemplateById(String id)
	{
		return getReportTemplateById(id,this.templateTree);
	}
	private ReportTemplateModel getReportTemplateById(String templateID,ReportTemplateModel tree)
	{
		if(tree.getId().equals(templateID))
		{
		   return tree;
		}
		ReportTemplateModel result = null;

		if(null != tree.getChildList())
		{
			for(ReportTemplateModel e : tree.getChildList())
			{
				result = getReportTemplateById(templateID, e);
				if(null != result)
				{
					return result;
				}
			}
		}
		return result;
		
	}
}
