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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private Integer imageCount; // 图像数目
	private String imagePathWL; // 报告缩略图像路径
	private Date exApply; // 申请远程日期
	private Date exStartUpImg; // 开始上传图像时间
	private Date exEndUpImg; // 结束图像上传时间
	private Date exReport; //  专家报告时间
	private Date exDownReport; // 本地下载报告时间
	private String exApplyDoctor; //申请远程医生
	private String exDoctor; // 诊断专家
	private String exState; //专家状态（）
	private int exReportState; // 专家报告状态（0-未完结，1-已编写，2-已完结)
	
	private Date exGetReport;
	private String modality;
	private String expertDoctorName;
	private String positive;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	private Integer reserve5;
	private Integer reserve6;
 
	public Date getExGetReport()
	{
		return exGetReport;
	}
	public void setExGetReport(Date exGetReport)
	{
		this.exGetReport = exGetReport;
	}
	public String getModality()
	{
		return modality;
	}
	public void setModality(String modality)
	{
		this.modality = modality;
	}
	public String getExpertDoctorName()
	{
		return expertDoctorName;
	}
	public void setExpertDoctorName(String expertDoctorName)
	{
		this.expertDoctorName = expertDoctorName;
	}
	public String getPositive()
	{
		return positive;
	}
	public void setPositive(String positive)
	{
		this.positive = positive;
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
	public String getReserve4()
	{
		return reserve4;
	}
	public void setReserve4(String reserve4)
	{
		this.reserve4 = reserve4;
	}
	public Integer getReserve5()
	{
		return reserve5;
	}
	public void setReserve5(Integer reserve5)
	{
		this.reserve5 = reserve5;
	}
	public Integer getReserve6()
	{
		return reserve6;
	}
	public void setReserve6(Integer reserve6)
	{
		this.reserve6 = reserve6;
	}
	//private String 
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
	public String getBodyPart()
	{
		return bodyPart;
	}
	public void setBodyPart(String bodyPart)
	{
		this.bodyPart = bodyPart;
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
	public Integer getImageCount()
	{
		return imageCount;
	}
	public void setImageCount(Integer imageCount)
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

	public int getExReportState()
	{
		return exReportState;
	}
	public void setExReportState(int exReportState)
	{
		this.exReportState = exReportState;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospitalID == null) ? 0 : hospitalID.hashCode());
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
		Report other = (Report) obj;
		if (hospitalID == null)
		{
			if (other.hospitalID != null)
				return false;
		}
		else if (!hospitalID.equals(other.hospitalID))
			return false;
		if (serialNo != other.serialNo)
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Report [hospitalID=" + hospitalID + ", serialNo=" + serialNo
				+ ", reportNo=" + reportNo + ", patientID=" + patientID
				+ ", patientName=" + patientName + ", patientSex=" + patientSex
				+ ", patientAge=" + patientAge + ", department=" + department
				+ ", hospitalNo=" + hospitalNo + ", bedNo=" + bedNo
				+ ", bodyPart=" + bodyPart + ", preView=" + preView
				+ ", diagnosis=" + diagnosis + ", studyContent=" + studyContent
				+ ", studyConclusion=" + studyConclusion + ", exStudyContent="
				+ exStudyContent + ", exStudyConclusion=" + exStudyConclusion
				+ ", exStudyContentCode=" + exStudyContentCode
				+ ", exStudyConclusionCode=" + exStudyConclusionCode
				+ ", studyDate=" + studyDate + ", reportDate=" + reportDate
				+ ", reviewDate=" + reviewDate + ", operatorsPhysician="
				+ operatorsPhysician + ", reportPhysician=" + reportPhysician
				+ ", reviewPhysician=" + reviewPhysician + ", imageCount="
				+ imageCount + ", imagePathWL=" + imagePathWL + ", exApply="
				+ exApply + ", exStartUpImg=" + exStartUpImg + ", exEndUpImg="
				+ exEndUpImg + ", exReport=" + exReport + ", exDownReport="
				+ exDownReport + ", exApplyDoctor=" + exApplyDoctor
				+ ", exDoctor=" + exDoctor + ", exState=" + exState
				+ ", exReportState=" + exReportState + "]";
	}
	
	

}
