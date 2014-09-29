/**   
* @Title: UserServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午02:39:40 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.spi.ServiceException;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.exception.CommonExceptionMsg;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.SystemUser;
import cn.fuego.remote.medical.expert.service.UserService;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午02:39:40 
 *  
 */

public class UserServiceImpl implements UserService
{
	private Log log = LogFactory.getLog(UserServiceImpl.class);

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.UserService#Login(java.lang.String, java.lang.String)
	 */
	@Override
	public void Login(String userName, String password)
	{
		// get targetUser
		
		SystemUser targetUser = (SystemUser) DaoContext.getInstance().getSystemUserDao().getUniRecord(new QueryCondition(ConditionTypeEnum.EQUAL,"userName",userName));
 
		if (null == targetUser )
		{
			// User isnot existant
			log.warn("User not exist：" + userName);
			throw new ServiceException(CommonExceptionMsg.LOGIN_FAILED);
		}
		else if (!targetUser.getPassword().equals(password))
		{
			log.warn("the password is wrong");
			throw new ServiceException(CommonExceptionMsg.LOGIN_FAILED);
		}
		else
		{
			log.info("User Login : " + userName);
		}

	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.UserService#modifyPassword()
	 */
	@Override
	public void modifyPassword(String userName,String oldPwd,String newPwd)
	{
		// TODO Auto-generated method stub

	}

}
