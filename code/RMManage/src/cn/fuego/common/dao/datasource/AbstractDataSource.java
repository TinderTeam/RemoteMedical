/**   
* @Title: AbstractDataSource.java 
* @Package cn.fuego.misp.service.datasource 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-26 上午12:13:50 
* @version V1.0   
*/ 
package cn.fuego.common.dao.datasource;

import java.util.List;

/** 
 * @ClassName: AbstractDataSource 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-26 上午12:13:50 
 *  
 */

public interface AbstractDataSource<E>
{
	/**
	 * 获取当前页面数据
	 * @param startNum
	 * @param endNum
	 * @return
	 */
	public List<E> getCurrentPageData(int startNum,int endNum);
	
	/**
	 * 获取所有数据
	 * @return
	 */
	public List<E> getAllPageData();
	
	/**
	 * 获取数据总数
	 * @return
	 */
	public long getDataCount();

}
