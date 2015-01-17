/**   
* @Title: WorkStaticsModel.java 
* @Package cn.fuego.remote.medical.manage.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2015-1-17 下午3:28:24 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.web.model;

 /** 
 * @ClassName: WorkStaticsModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2015-1-17 下午3:28:24 
 *  
 */
public class WorkStaticsModel
{
	private int total = 0;
	private int crCount = 0;
	private int ctCount = 0;
	private int mrCount = 0;
	private float cost = 0;
	public int getTotal()
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	public int getCrCount()
	{
		return crCount;
	}
	public void setCrCount(int crCount)
	{
		this.crCount = crCount;
	}
	public int getCtCount()
	{
		return ctCount;
	}
	public void setCtCount(int ctCount)
	{
		this.ctCount = ctCount;
	}
	public int getMrCount()
	{
		return mrCount;
	}
	public void setMrCount(int mrCount)
	{
		this.mrCount = mrCount;
	}
	public float getCost()
	{
		return cost;
	}
	public void setCost(float cost)
	{
		this.cost = cost;
	}
	

}
