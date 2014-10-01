/**   
* @Title: ImageModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:30:36 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.web.model;

/** 
 * @ClassName: ImageModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:30:36 
 *  
 */

public class ImageModel
{
	private String imageName;
	private String imageUrl;
	private String bodyPart;
	private String fileSize;
	public String getImageName()
	{
		return imageName;
	}
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
	public String getImageUrl()
	{
		return imageUrl;
	}
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
	public String getBodyPart()
	{
		return bodyPart;
	}
	public void setBodyPart(String bodyPart)
	{
		this.bodyPart = bodyPart;
	}
	public String getFileSize()
	{
		return fileSize;
	}
	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}
	
	
	
	

}
