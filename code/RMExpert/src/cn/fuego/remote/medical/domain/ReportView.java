/**   
* @Title: ReportView.java 
* @Package cn.fuego.remote.medical.expert.domain 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午04:57:38 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.domain;

import java.util.Date;

import cn.fuego.common.domain.PersistenceObject;
import cn.fuego.common.util.format.DateUtil;
import cn.fuego.remote.medical.constant.ReportStatusEnum;

/** 
 * @ClassName: ReportView 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午04:57:38 
 *  
 */

public class ReportView implements PersistenceObject
{
	
	private String id;
 
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
	
	private String statusColor;//状态颜色
	
	//hosptial table
	//医院信息
 	private String hospitalName;
	private String hospitalContactWay;
	
	//patient table
	private String modality;
 
	/*专家信息*/
	//expert table
	private String expertName;
	private String expertPhoneNo;
 
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
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
	public String getReportNo()
	{
		return reportNo;
	}
	public void setReportNo(String reportNo)
	{
		this.reportNo = reportNo;
	}
	public String getPatientID()
	{
		return patientID;
	}
	public void setPatientID(String patientID)
	{
		this.patientID = patientID;
	}
	public String getPatientName()
	{
		return patientName;
	}
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	public String getPatientSex()
	{
		return patientSex;
	}
	public void setPatientSex(String patientSex)
	{
		this.patientSex = patientSex;
	}
	public String getPatientAge()
	{
		return patientAge;
	}
	public void setPatientAge(String patientAge)
	{
		this.patientAge = patientAge;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getHospitalNo()
	{
		return hospitalNo;
	}
	public void setHospitalNo(String hospitalNo)
	{
		this.hospitalNo = hospitalNo;
	}
	public String getBedNo()
	{
		return bedNo;
	}
	public void setBedNo(String bedNo)
	{
		this.bedNo = bedNo;
	}
	public String getPreView()
	{
		return preView;
	}
	public void setPreView(String preView)
	{
		this.preView = preView;
	}
	public String getDiagnosis()
	{
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis)
	{
		this.diagnosis = diagnosis;
	}
	public String getStudyContent()
	{
		return studyContent;
	}
	public void setStudyContent(String studyContent)
	{
		this.studyContent = studyContent;
	}
	public String getStudyConclusion()
	{
		return studyConclusion;
	}
	public void setStudyConclusion(String studyConclusion)
	{
		this.studyConclusion = studyConclusion;
	}
	public String getExStudyContent()
	{
		return exStudyContent;
	}
	public void setExStudyContent(String exStudyContent)
	{
		this.exStudyContent = exStudyContent;
	}
	public String getExStudyConclusion()
	{
		return exStudyConclusion;
	}
	public void setExStudyConclusion(String exStudyConclusion)
	{
		this.exStudyConclusion = exStudyConclusion;
	}
	public String getExStudyContentCode()
	{
		return exStudyContentCode;
	}
	public void setExStudyContentCode(String exStudyContentCode)
	{
		this.exStudyContentCode = exStudyContentCode;
	}
	public String getExStudyConclusionCode()
	{
		return exStudyConclusionCode;
	}
	public void setExStudyConclusionCode(String exStudyConclusionCode)
	{
		this.exStudyConclusionCode = exStudyConclusionCode;
	}
	public Date getStudyDate()
	{
		return studyDate;
	}
	public void setStudyDate(Date studyDate)
	{
		this.studyDate = studyDate;
	}
	public Date getReportDate()
	{
		return reportDate;
	}
	public void setReportDate(Date reportDate)
	{
		this.reportDate = reportDate;
	}
	public Date getReviewDate()
	{
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate)
	{
		this.reviewDate = reviewDate;
	}
	public String getOperatorsPhysician()
	{
		return operatorsPhysician;
	}
	public void setOperatorsPhysician(String operatorsPhysician)
	{
		this.operatorsPhysician = operatorsPhysician;
	}
	public String getReportPhysician()
	{
		return reportPhysician;
	}
	public void setReportPhysician(String reportPhysician)
	{
		this.reportPhysician = reportPhysician;
	}
	public String getReviewPhysician()
	{
		return reviewPhysician;
	}
	public void setReviewPhysician(String reviewPhysician)
	{
		this.reviewPhysician = reviewPhysician;
	}
	public int getImageCount()
	{
		return imageCount;
	}
	public void setImageCount(int imageCount)
	{
		this.imageCount = imageCount;
	}
	public String getImagePathWL()
	{
		return imagePathWL;
	}
	public void setImagePathWL(String imagePathWL)
	{
		this.imagePathWL = imagePathWL;
	}
	public Date getExApply()
	{
		return exApply;
	}
	public void setExApply(Date exApply)
	{
		this.exApply = exApply;
	}
	public Date getExStartUpImg()
	{
		return exStartUpImg;
	}
	public void setExStartUpImg(Date exStartUpImg)
	{
		this.exStartUpImg = exStartUpImg;
	}
	public Date getExEndUpImg()
	{
		return exEndUpImg;
	}
	public void setExEndUpImg(Date exEndUpImg)
	{
		this.exEndUpImg = exEndUpImg;
	}
	public Date getExReport()
	{
		return exReport;
	}
	public void setExReport(Date exReport)
	{
		this.exReport = exReport;
	}
	public Date getExDownReport()
	{
		return exDownReport;
	}
	public void setExDownReport(Date exDownReport)
	{
		this.exDownReport = exDownReport;
	}
	public String getExApplyDoctor()
	{
		return exApplyDoctor;
	}
	public void setExApplyDoctor(String exApplyDoctor)
	{
		this.exApplyDoctor = exApplyDoctor;
	}
	public String getExDoctor()
	{
		return exDoctor;
	}
	public void setExDoctor(String exDoctor)
	{
		this.exDoctor = exDoctor;
	}
	public String getExState()
	{
		return exState;
	}
	public void setExState(String exState)
	{
		this.exState = exState;
	}
	public String getExReportState()
	{
		return exReportState;
	}
	public void setExReportState(String exReportState)
	{
		this.exReportState = exReportState;
	}
	public String getHospitalName()
	{
		return hospitalName;
	}
	public void setHospitalName(String hospitalName)
	{
		this.hospitalName = hospitalName;
	}
	public String getHospitalContactWay()
	{
		return hospitalContactWay;
	}
	public void setHospitalContactWay(String hospitalContactWay)
	{
		this.hospitalContactWay = hospitalContactWay;
	}
	public String getModality()
	{
		return modality;
	}
	public void setModality(String modality)
	{
		this.modality = modality;
	}
	public String getExpertName()
	{
		return expertName;
	}
	public void setExpertName(String expertName)
	{
		this.expertName = expertName;
	}
	public String getExpertPhoneNo()
	{
		return expertPhoneNo;
	}
	public void setExpertPhoneNo(String expertPhoneNo)
	{
		this.expertPhoneNo = expertPhoneNo;
	}
	public String getBodyPart()
	{
		return bodyPart;
	}
	public void setBodyPart(String bodyPart)
	{
		this.bodyPart = bodyPart;
	}
	

	public String getStatusColor()
	{
	  
	    if(ReportStatusEnum.SUBMIT.getStatus().equals(this.getExReportState()))
	    {
	    	statusColor= "grey";
	    }
	    else
	    {
	    	  Date applyDate = this.getExApply();
	    	  int dayNum = DateUtil.countDayNum(DateUtil.getCurrentDateTime(),applyDate);
	    	  if(dayNum >= 1)
	    	  {
	    		  statusColor= "red";
	    	  }
	    	  else
	    	  {
	    		  statusColor= "green";
	    	  }
	    }
		return statusColor;
	}


	public void setStatusColor(String dealStatus)
	{
		this.statusColor = dealStatus;
	}
 	
 
}
