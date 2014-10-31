/**   
 * @Title: ReportOperateTypeEnum.java 
 * @Package cn.fuego.remote.medical.expert.constant 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-9-25 下午10:55:37 
 * @version V1.0   
 */
package cn.fuego.remote.medical.constant;

/**
 * @ClassName: ReportOperateTypeEnum
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-25 下午10:55:37
 * 
 */

public enum ReportStatusEnum
{
	SUBMIT("已完结",2), // 提交报告
	SAVE("已编写",1), // 保存报告
	CANCEL("未完结",0); // 撤销报告
	private String status;
    private int statusValue;
	private ReportStatusEnum(String status,int statusValue)
	{
		this.status = status;
		this.statusValue=statusValue;
	}

	public String getStatus()
	{
		return status;
	}

	public int getStatusValue()
	{
		return statusValue;
	}

	public void setStatusValue(int statusValue)
	{
		this.statusValue = statusValue;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}


	public static ReportStatusEnum getEnumByInt(int statusValue)
	{
		for (ReportStatusEnum c : ReportStatusEnum.values())
		{
			if (statusValue == c.statusValue)
			{
				return c;
			}
		}
		return null;
	}
	public static ReportStatusEnum getEnumByStr(String status)
	{
		for (ReportStatusEnum c : ReportStatusEnum.values())
		{
			if (status.equals(c.status) )
			{
				return c;
			}
		}
		return null;
	}

}
