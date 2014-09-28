/**   
* @Title: Report.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 上午10:09:47 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;

/** 
 * @ClassName: Report 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 上午10:09:47 
 *  
 */

public class Report implements PersistenceObject
{
	private String hospitalID; //主键，医院ID
	private int serialNo; // 主键 报告ID
	private String reportNo; //报告号（由Ri_SerialNO得到）
	private String patientID; //病人ID
	private String patientName; //病人姓名
	private String patientSex; //性别
	private String patientAge; //年龄
	private String department; //申请科室
	private String hospitalNo; //住院号
	private String bedNo; //床号
	private String bodyPart; //检查部位
	private String preView; // 临床表现
	private String diagnosis;  //临床诊断
	private String studyContent; //检查所见
	private String studyConclusion; // 检查结论
	private String exStudyContent; // 专家诊断所见
	private String exStudyConclusion; // 专家检查结论
	private String exStudyContentCode; // 专家诊断所见加密
	private String exStudyConclusionCode; // 专家检查结论加密
	private Date studyDate; // 检查日期
	private Date reportDate; // 报告日期
	private Date reviewDate; // 审核日期
	private String operatorsPhysician; // 检查医生	 
	private String reportPhysician; // 报告医生
	private String reviewPhysician; // 审核医生
	private int imageCount; // 图像数目
	private String imagePathWL; // 报告缩略图像路径
	private Date exApply; // 申请远程日期
	private Date exStartUpImg; // 开始上传图像时间
	private Date exEndUpImg; // 结束图像上传时间
	private Date exReport; //  专家报告时间
	private Date exDownReport; // 本地下载报告时间
	private String exApplyDoctor; //申请远程医生
	private String exDoctor; // 诊断专家
	private String exState; //专家状态（）
	private String exReportState; // 专家报告状态（已报告，已编写，未报告)
	//private String 

}
