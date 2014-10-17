package cn.fuego.remote.medical.manage.web.model;

import cn.fuego.remote.medical.constant.ApplyTypeEnum;

public class ApprovalFilterModel
{
	private String applyName;
	private String startDate;
	private String endDate;	
	private ApplyTypeEnum[] applyTypeList = ApplyTypeEnum.values();
	private String applyType;
	
	public String getApplyName()
	{
		return applyName;
	}
	public void setApplyName(String applyName)
	{
		this.applyName = applyName;
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
	public ApplyTypeEnum[] getApplyTypeList()
	{
		return applyTypeList;
	}
	public void setApplyTypeList(ApplyTypeEnum[] applyTypeList)
	{
		this.applyTypeList = applyTypeList;
	}
	public String getApplyType()
	{
		return applyType;
	}
	public void setApplyType(String applyType)
	{
		this.applyType = applyType;
	}


 
	
	
}
