/**   
 * @Title: ShartMessageServiceImpl.java 
 * @Package cn.fuego.misp.service.impl 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-10-30 上午10:50:46 
 * @version V1.0   
 */
package cn.fuego.misp.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cn.fuego.common.util.SystemConfigInfo;
import cn.fuego.misp.service.MISPShortMessageService;

/**
 * @ClassName: ShartMessageServiceImpl
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-30 上午10:50:46
 * 
 */
public class MXShortMessageServiceImpl implements MISPShortMessageService
{
	private static String MX_MESSAGE_URL = "http://www.mxtong.net.cn/GateWay/Services.asmx/DirectSend?";
	private Log log = LogFactory.getLog(MXShortMessageServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.fuego.misp.service.ShortMessageService#sendMessage(java.util.List,
	 * java.lang.String)
	 */
	@Override
	public void sendMessage(List<String> phoneNumList, String content)
	{
		String url = MX_MESSAGE_URL + "UserID="
				+ SystemConfigInfo.getMessageUserID();
		url += "&Account=" + SystemConfigInfo.getMessageAccount();
		url += "&Password=" + SystemConfigInfo.getMessagePassword();

		String phoneStr = "";
		for (String e : phoneNumList)
		{
			phoneStr += e + ";";
		}
		url += "&Phones=" + phoneStr;
		url += "&Content=" + content;
		url += "&SendTime=";
		url += "&SendType=1";
		url += "&PostFixNumber=";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		
		CloseableHttpResponse response = null;
		try
		{

			response = httpclient.execute(httpget);

			HttpEntity entity = response.getEntity();
			if (entity != null)
			{
				String result = EntityUtils.toString(entity);
				log.info(result);  
			    EntityUtils.consume(entity);  
			}
		}
		catch(Exception e)
		{
			log.error("send message error",e);
		}
		finally
		{
			try
			{
				if(null != response)
				{
					response.close();
				}
				
			} catch (IOException e1)
			{
				log.error("close failed",e1);
			}
		}

	}

}
