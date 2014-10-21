package cn.fuego.remote.medical.constant;

public enum LinkStatusEnum
{	
	LINK_FAILED("未关联",0),
	LINK_SUCCESS("已关联",1); 
	   
 
	private String status;
	private int statusValue;
	 
	private LinkStatusEnum(String status,int statusValue)
	{
		this.status = status;
		this.statusValue = statusValue;
	}
	public String getStatus()
	{
		return status;
	}
	public int getStatusValue()
	{
		return statusValue;
	}
 

}