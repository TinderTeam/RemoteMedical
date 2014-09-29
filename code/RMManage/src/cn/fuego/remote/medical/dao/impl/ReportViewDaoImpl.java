/**   
* @Title: ReportViewDao.java 
* @Package cn.fuego.remote.medical.expert.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午06:48:43 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import cn.fuego.common.dao.AbstractViewDao;
import cn.fuego.remote.medical.dao.ReportViewDao;
import cn.fuego.remote.medical.domain.ReportView;

/** 
 * @ClassName: ReportViewDao 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午06:48:43 
 *  
 */

public class ReportViewDaoImpl extends AbstractViewDao implements ReportViewDao 
{

	/* (non-Javadoc)
	 * @see cn.fuego.common.dao.AbstractViewDao#getFeaturedClass()
	 */
	@Override
	public Class getFeaturedClass()
	{
		// TODO Auto-generated method stub
		return ReportView.class;
	}

}
