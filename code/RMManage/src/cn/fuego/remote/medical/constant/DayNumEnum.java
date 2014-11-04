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
* @ClassName: DayNumEnum 
* @Description: 快速日期筛选，数字加1
* @author Aether
* @date 2014-10-30 下午10:19:12 
*  
*/ 
public enum DayNumEnum
{
	TODAY("今天",0),
	LAST3("近三天",3),
	LAST7("近七天",7);

	private String day;
    private int dayValue;
	private DayNumEnum(String day,int dayValue)
	{
		this.day = day;
		this.dayValue=dayValue;
	}

	public String getDay()
	{
		return day;
	}
	public void setDay(String day)
	{
		this.day = day;
	}
	public int getDayValue()
	{
		return dayValue;
	}
	public void setDayValue(int dayValue)
	{
		this.dayValue = dayValue;
	}


	public static DayNumEnum getEnumByInt(int dayValue)
	{
		for (DayNumEnum c : DayNumEnum.values())
		{
			if (dayValue == c.dayValue)
			{
				return c;
			}
		}
		return null;
	}
	public static DayNumEnum getEnumByStr(String day)
	{
		for (DayNumEnum c : DayNumEnum.values())
		{
			if (day.equals(c.day) )
			{
				return c;
			}
		}
		return null;
	}

}
