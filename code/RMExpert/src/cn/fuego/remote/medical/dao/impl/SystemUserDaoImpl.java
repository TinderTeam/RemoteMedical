/**   
* @Title: SystemUserDaoImpl.java 
* @Package cn.fuego.remote.medical.expert.dao.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-24 下午03:57:04 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.dao.impl;

import java.util.Collection;

import cn.fuego.common.dao.impl.AbstractDao;
import cn.fuego.common.domain.PersistenceObject;
import cn.fuego.remote.medical.dao.SystemUserDao;
import cn.fuego.remote.medical.domain.SystemUser;

/** 
 * @ClassName: SystemUserDaoImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-24 下午03:57:04 
 *  
 */

public class SystemUserDaoImpl extends AbstractDao implements SystemUserDao
{

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.AbstractDao#getFeaturedClass()
	 */
	@Override
	public Class getFeaturedClass()
	{
		// TODO Auto-generated method stub
		return SystemUser.class;
	}

	 
}
