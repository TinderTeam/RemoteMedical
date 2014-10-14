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
	SUBMIT("已报告"), // 提交报告
	SAVE("已编写"), // 保存报告
	CACAL("未报告"); // 撤销报告
	private String status;

	private ReportStatusEnum(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}

	public static ReportStatusEnum getEnumByStatus(String status)
	{
		for (ReportStatusEnum c : ReportStatusEnum.values())
		{
			if (c.status.equals(status))
			{
				return c;
			}
		}
		return null;
	}

}
