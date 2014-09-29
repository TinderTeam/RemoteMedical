/**   
* @Title: LinkDaoImpl.java 
* @Package cn.fuego.remote.medical.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-27 下午09:52:39 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import cn.fuego.common.dao.AbstractDao;
import cn.fuego.remote.medical.dao.LinkDao;
import cn.fuego.remote.medical.domain.Link;

/** 
 * @ClassName: LinkDaoImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-27 下午09:52:39 
 *  
 */

public class LinkDaoImpl extends AbstractDao implements LinkDao
{

	/* (non-Javadoc)
	 * @see cn.fuego.common.dao.AbstractViewDao#getFeaturedClass()
	 */
	@Override
	public Class getFeaturedClass()
	{
		// TODO Auto-generated method stub
		return Link.class;
	}

}
