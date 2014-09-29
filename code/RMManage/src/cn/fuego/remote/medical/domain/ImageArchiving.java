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
	private String ImageID; //图像ID,用于图像命名
	
	private String modality; //设备类型
	private int  imageNo; //图像号	
	private String sOPInstanceUID; //图像UID	
	private String seriesID; //序列号
	private String seriesDescription; //序列描述 	
	private String seriesUID; //序列UID
	private int imageCount; //图像数
	private int minImageID; //最小图像号
	private int maxImageID; //最大图像号
	private String imageSavePath; //远程图像本地存储路径
 	
	private String bodyPart;  //检查体位
	private String ProtocolName; //检查协议体位
	private String OriImgName; //图像未改名前名字
	private String ImageCode; //上传图像在发送端的MD5校验码
	
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	
	
}
