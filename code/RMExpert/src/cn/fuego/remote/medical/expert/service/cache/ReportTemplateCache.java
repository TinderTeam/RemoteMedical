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

		template.setName("模板");
		if("Report".equals(e.getName()))
		{
			template.setName("诊断报告");
		}
		if("Conclusion".equals(e.getName()))
		{
			template.setName("诊断结论");
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
}
