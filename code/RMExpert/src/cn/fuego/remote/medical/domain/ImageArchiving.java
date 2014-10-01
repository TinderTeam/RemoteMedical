/**   
* @Title: ImageArchiving.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 上午11:55:35 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: ImageArchiving 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 上午11:55:35 
 *  
 */

public class ImageArchiving implements PersistenceObject
{
	private String hospitalID; //主键，医院ID
	private int serialNo; // 主键 报告ID
	private String imgArchName; //主键
	private String imageID; //图像ID,用于图像命名
	
	private String modality; //设备类型
	private Integer  imageNo; //图像号	
	private String sOPInstanceUID; //图像UID	
	private String seriesID; //序列号
	private String seriesDescription; //序列描述 	
	private String seriesUID; //序列UID
	private Integer imageCount; //图像数
	private Integer minImageID; //最小图像号
	private Integer maxImageID; //最大图像号
	private String imageSavePath; //远程图像本地存储路径
 	
	private String bodyPart;  //检查体位
	private String protocolName; //检查协议体位
	private String oriImgName; //图像未改名前名字
	private String imageCode; //上传图像在发送端的MD5校验码
	
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private Integer reserve4;
 
	public String getHospitalID()
	{
		return hospitalID;
	}
	public void setHospitalID(String hospitalID)
	{
		this.hospitalID = hospitalID;
	}
	public int getSerialNo()
	{
		return serialNo;
	}
	public void setSerialNo(int serialNo)
	{
		this.serialNo = serialNo;
	}
	public String getImgArchName()
	{
		return imgArchName;
	}
	public void setImgArchName(String imgArchName)
	{
		this.imgArchName = imgArchName;
	}
	public String getImageID()
	{
		return imageID;
	}
	public void setImageID(String imageID)
	{
		this.imageID = imageID;
	}
	public String getModality()
	{
		return modality;
	}
	public void setModality(String modality)
	{
		this.modality = modality;
	}
	public Integer getImageNo()
	{
		return imageNo;
	}
	public void setImageNo(Integer imageNo)
	{
		this.imageNo = imageNo;
	}
	public String getsOPInstanceUID()
	{
		return sOPInstanceUID;
	}
	public void setsOPInstanceUID(String sOPInstanceUID)
	{
		this.sOPInstanceUID = sOPInstanceUID;
	}
	public String getSeriesID()
	{
		return seriesID;
	}
	public void setSeriesID(String seriesID)
	{
		this.seriesID = seriesID;
	}
	public String getSeriesDescription()
	{
		return seriesDescription;
	}
	public void setSeriesDescription(String seriesDescription)
	{
		this.seriesDescription = seriesDescription;
	}
	public String getSeriesUID()
	{
		return seriesUID;
	}
	public void setSeriesUID(String seriesUID)
	{
		this.seriesUID = seriesUID;
	}
	public Integer getImageCount()
	{
		return imageCount;
	}
	public void setImageCount(Integer imageCount)
	{
		this.imageCount = imageCount;
	}
	public Integer getMinImageID()
	{
		return minImageID;
	}
	public void setMinImageID(Integer minImageID)
	{
		this.minImageID = minImageID;
	}
	public Integer getMaxImageID()
	{
		return maxImageID;
	}
	public void setMaxImageID(Integer maxImageID)
	{
		this.maxImageID = maxImageID;
	}
	public String getImageSavePath()
	{
		return imageSavePath;
	}
	public void setImageSavePath(String imageSavePath)
	{
		this.imageSavePath = imageSavePath;
	}
	public String getBodyPart()
	{
		return bodyPart;
	}
	public void setBodyPart(String bodyPart)
	{
		this.bodyPart = bodyPart;
	}
	public String getProtocolName()
	{
		return protocolName;
	}
	public void setProtocolName(String protocolName)
	{
		this.protocolName = protocolName;
	}
	public String getOriImgName()
	{
		return oriImgName;
	}
	public void setOriImgName(String oriImgName)
	{
		this.oriImgName = oriImgName;
	}
	public String getImageCode()
	{
		return imageCode;
	}
	public void setImageCode(String imageCode)
	{
		this.imageCode = imageCode;
	}
	public String getReserve1()
	{
		return reserve1;
	}
	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1;
	}
	public String getReserve2()
	{
		return reserve2;
	}
	public void setReserve2(String reserve2)
	{
		this.reserve2 = reserve2;
	}
	public String getReserve3()
	{
		return reserve3;
	}
	public void setReserve3(String reserve3)
	{
		this.reserve3 = reserve3;
	}
	public Integer getReserve4()
	{
		return reserve4;
	}
	public void setReserve4(Integer reserve4)
	{
		this.reserve4 = reserve4;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospitalID == null) ? 0 : hospitalID.hashCode());
		result = prime * result + ((imgArchName == null) ? 0 : imgArchName.hashCode());
		result = prime * result + serialNo;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageArchiving other = (ImageArchiving) obj;
		if (hospitalID == null)
		{
			if (other.hospitalID != null)
				return false;
		}
		else if (!hospitalID.equals(other.hospitalID))
			return false;
		if (imgArchName == null)
		{
			if (other.imgArchName != null)
				return false;
		}
		else if (!imgArchName.equals(other.imgArchName))
			return false;
		if (serialNo != other.serialNo)
			return false;
		return true;
	}
	
	
}
