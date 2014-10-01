/**   
* @Title: MedicalReportModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:30:57 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.web.model;

import java.util.Date;

/** 
 * @ClassName: MedicalReportModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:30:57 
 *  
 */

public class MedicalReportModel
{

	private int serialNo; // 主键 报告ID
	
	/*医院信息*/
	private String hospitalID; //主键，医院ID
 	private String hospitalName;
	private String hospitalContactWay;
	
	
	/*检查设备*/
	private String modality;
	
	/*病人信息*/
	private String reportNo; //报告号（由Ri_SerialNO得到）
	private String patientID; //病人ID
	private String patientName; //病人姓名
	private String patientSex; //性别
	private String patientAge; //年龄
	private String bodyPart; //检查部位
 
	/*诊断信息*/
	private String preView; // 临床表现
	private String diagnosis;  //临床诊断
	private String studyContent; //检查所见
	private String studyConclusion; // 检查结论
	private String exStudyContent; // 专家诊断所见
	private String exStudyConclusion; // 专家检查结论
 
  
	
	private String exApplyDoctor; //申请远程医生
	private String exReportState; // 专家报告状态（已报告，已编写，未报告)
	private Date exReportTime; //  专家报告回传时间
	
	/*专家信息*/
	private String expertID;
	private String expertName;
	private String expertPhoneNo;
	

	private Date exApply; //申请远程时间
	private Date exStartUpImg; // 开始上传图像时间
	private Date exEndUpImg; // 结束图像上传时间
	public int getSerialNo()
	{
		return serialNo;
	}
	public void setSerialNo(int serialNo)
	{
		this.serialNo = serialNo;
	}
	public String getHospitalID()
	{
		return hospitalID;
	}
	public void setHospitalID(String hospitalID)
	{
		this.hospitalID = hospitalID;
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
	public String getExApplyDoctor()
	{
		return exApplyDoctor;
	}
	public void setExApplyDoctor(String exApplyDoctor)
	{
		this.exApplyDoctor = exApplyDoctor;
	}
	public String getExReportState()
	{
		return exReportState;
	}
	public void setExReportState(String exReportState)
	{
		this.exReportState = exReportState;
	}
	public Date getExReportTime()
	{
		return exReportTime;
	}
	public void setExReportTime(Date exReportTime)
	{
		this.exReportTime = exReportTime;
	}
	public String getExpertID()
	{
		return expertID;
	}
	public void setExpertID(String expertID)
	{
		this.expertID = expertID;
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
	
 


}
