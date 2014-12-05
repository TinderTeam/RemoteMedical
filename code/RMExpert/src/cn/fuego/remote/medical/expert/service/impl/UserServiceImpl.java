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

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.exception.CommonExceptionMsg;
import cn.fuego.common.exception.SystemOperateException;
import cn.fuego.misp.constant.MISPOperLogConsant;
import cn.fuego.misp.domain.SystemUser;
import cn.fuego.misp.service.MISPServiceContext;
import cn.fuego.misp.service.impl.MISPUserServiceImpl;
import cn.fuego.misp.web.model.user.UserModel;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Expert;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午02:39:40 
 *  
 */

public class UserServiceImpl  extends MISPUserServiceImpl  
{
	private Log log = LogFactory.getLog(UserServiceImpl.class);
	
	public UserModel Login(String userName, String password)
	{
		UserModel userModel = super.Login(userName, password); 
		
		SystemUser targetUser = super.getSystemUserByUserName(userName);
		if(targetUser.getAccountType()!=UserTypeEnum.EXPERT.getTypeValue())
		{
			log.warn("the accountType is wrong"+targetUser.getAccountType());
			throw new SystemOperateException(CommonExceptionMsg.NOT_ALLOWED);			
		}
		else
		{
			Expert expert=(Expert) DaoContext.getInstance().getExpertDao().getUniRecord(new QueryCondition(ConditionTypeEnum.EQUAL, "id", userName));
			if(null!=expert)
			{
				if(!expert.getState().equals(UserStatusEnum.REGISTERED.getIntValue()))
				{
					if(expert.getState().equals(UserStatusEnum.CANCELED.getIntValue()))
					{
						throw new SystemOperateException(CommonExceptionMsg.ALREADY_CANCEL);

					}
					else
					{
						throw new SystemOperateException(CommonExceptionMsg.NOT_REGISTED);

					}
				}
				
			}
			else
			{
				log.warn("the expert  not exist in table expert");
				throw new SystemOperateException(CommonExceptionMsg.NOT_IN_EXPERT);				
			}
		}
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(userName, MISPOperLogConsant.LOGIN, null, MISPOperLogConsant.OPERATE_SUCCESS);
		return userModel;
	}


 
 
}
