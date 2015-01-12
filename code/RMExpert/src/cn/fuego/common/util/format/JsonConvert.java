/**   
* @Title: JsonConvert.java 
* @Package cn.fuego.common.util.format 
* @Description: TODO
* @author Tang Jun   
* @date 2014-12-4 上午12:51:02 
* @version V1.0   
*/ 
package cn.fuego.common.util.format;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;


 /** 
 * @ClassName: JsonConvert 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-12-4 上午12:51:02 
 *  
 */
public class JsonConvert
{
	private static final Log log = LogFactory.getLog(DataTypeConvert.class);

	public static String ObjectToJson(Object object)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		 String json = "";
		try
		{
			json = mapper.writeValueAsString(object);
		} catch (Exception e)
		{
			log.error("object to json failed",e);
		}
		return json;
	}
	
	public static Object jsonToObject(String json,Class clazz)
	{
		ObjectMapper mapper = new ObjectMapper();
		 
		Object	rspObj = null;
		try
		{
			rspObj = mapper.readValue(json,clazz);
		} catch (Exception e)
		{
			log.error("json to object failed",e);
		}
		return rspObj;
	}
}