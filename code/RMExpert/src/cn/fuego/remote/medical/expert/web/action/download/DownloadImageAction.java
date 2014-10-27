/**   
* @Title: DownloadImageAction.java 
* @Package cn.fuego.remote.medical.expert.web.action.download 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-22 上午11:14:18 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.action.download;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.web.action.basic.MISPAction;
import cn.fuego.misp.web.filter.AuthenticationFilter;

/** 
 * @ClassName: DownloadImageAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-22 上午11:14:18 
 *  
 */

public class DownloadImageAction extends MISPAction
{
	private Log log = LogFactory.getLog(AuthenticationFilter.class);

	private String filePath;
	private InputStream imageStream;
	
	public String execute()
	{
 		try
		{
 			imageStream = new FileInputStream(filePath);
		}
		catch (FileNotFoundException e)
		{
			log.error("can not find the file " + filePath,e);
		}
		return SUCCESS;
	}
 

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}


	public InputStream getImageStream()
	{
		return imageStream;
	}


	public void setImageStream(InputStream imageStream)
	{
		this.imageStream = imageStream;
	}


 
	
	

}
