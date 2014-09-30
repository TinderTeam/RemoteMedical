/**   
* @Title: ReportDaoImpl.java 
* @Package cn.fuego.remote.medical.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:06:42 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import cn.fuego.common.dao.impl.AbstractDao;
import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.Report;

/** 
 * @ClassName: ReportDaoImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午03:06:42 
 *  
 */

public class ReportDaoImpl extends AbstractDao implements ReportDao
{

	/* (non-Javadoc)
	 * @see cn.fuego.common.dao.AbstractViewDao#getFeaturedClass()
	 */
	@Override
	public Class getFeaturedClass()
	{
		// TODO Auto-generated method stub
		return Report.class;
	}

}
