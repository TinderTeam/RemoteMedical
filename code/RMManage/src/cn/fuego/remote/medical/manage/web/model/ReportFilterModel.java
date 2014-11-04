/**   
* @Title: ReportQueryModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-25 下午11:31:12 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.web.model;

import cn.fuego.remote.medical.constant.DayNumEnum;
import cn.fuego.remote.medical.constant.ReportStatusEnum;

/** 
 * @ClassName: ReportQueryModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-25 下午11:31:12 
 *  
 */

public class ReportFilterModel
{
	private String patientName;
	private String exReportState;
	private String modality;
	private String hospitalName;
	private String startDate;
	private String endDate;
	private String days;
	private DayNumEnum[] dayList = DayNumEnum.values();
	
	private ReportStatusEnum[] reportStatusList = ReportStatusEnum.values();
	public String getPatientName()
	{
		return patientName;
	}
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	public String getExReportState()
	{
		return exReportState;
	}
	public void setExReportState(String exReportState)
	{
		this.exReportState = exReportState;
	}
	public String getModality()
	{
		return modality;
	}
	public void setModality(String modality)
	{
		this.modality = modality;
	}
	public String getHospitalName()
	{
		return hospitalName;
	}
	public void setHospitalName(String hospitalName)
	{
		this.hospitalName = hospitalName;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	public ReportStatusEnum[] getReportStatusList()
	{
		return reportStatusList;
	}
	public void setReportStatusList(ReportStatusEnum[] reportStatusList)
	{
		this.reportStatusList = reportStatusList;
	}
	public DayNumEnum[] getDayList()
	{
		return dayList;
	}
	public void setDayList(DayNumEnum[] dayList)
	{
		this.dayList = dayList;
	}
	public String getDays()
	{
		return days;
	}
	public void setDays(String days)
	{
		this.days = days;
	}

}