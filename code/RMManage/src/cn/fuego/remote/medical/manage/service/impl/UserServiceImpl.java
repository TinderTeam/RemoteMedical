/**   
* @Title: UserServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午02:39:40 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.spi.ServiceException;

import cn.fuego.common.contanst.ConditionTypeEnum;
import cn.fuego.common.dao.QueryCondition;
import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.common.dao.hibernate.util.HibernateUtil;
import cn.fuego.common.exception.CommonExceptionMsg;
import cn.fuego.common.exception.SystemOperateException;
import cn.fuego.common.util.SystemConfigInfo;
import cn.fuego.common.util.format.DateUtil;
import cn.fuego.common.util.validate.ValidatorUtil;
import cn.fuego.misp.constant.MISPOperLogConsant;
import cn.fuego.misp.dao.MISPDaoContext;
import cn.fuego.misp.domain.SystemUser;
import cn.fuego.misp.service.MISPServiceContext;
import cn.fuego.misp.service.impl.MISPUserServiceImpl;
import cn.fuego.misp.web.model.user.UserModel;
import cn.fuego.remote.medical.constant.LinkStatusEnum;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.domain.Link;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;
import cn.fuego.remote.medical.manage.web.model.LinkModel;
import cn.fuego.remote.medical.manage.web.model.UserFilterModel;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午02:39:40 
 *  
 */

public class UserServiceImpl extends MISPUserServiceImpl implements UserService
{
	private Log log = LogFactory.getLog(UserServiceImpl.class);

	
	public UserModel Login(String userName, String password)
	{
		
		UserModel userModel = super.Login(userName, password);
		SystemUser targetUser = super.getSystemUserByUserName(userName);
		switch(UserTypeEnum.getEnumByInt(targetUser.getAccountType()))
		{
		case EXPERT:
			ExpertModel expertModel = this.getExpertByID(userName);
			if(expertModel.getExpert().getState()==UserStatusEnum.CANCELED.getIntValue())
			{
				log.warn("the account is canceled"+expertModel.getExpert().getState());
				throw new SystemOperateException(CommonExceptionMsg.ALREADY_CANCEL);
			}

			break;
		case HOSPITAL:
			HospitalModel hospitalModel = this.getHospitalByID(userName);
			if(hospitalModel.getHospital().getState()==UserStatusEnum.CANCELED.getIntValue())
			{
				log.warn("the account is canceled"+hospitalModel.getHospital().getState());
				throw new SystemOperateException(CommonExceptionMsg.ALREADY_CANCEL);
			}
			break;
		default :break;
		}
			
		return 	userModel;
	}
	@Override	
	public AbstractDataSource<Hospital> getHospitalList(HospitalModel filter)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		if(null != filter)
		{
			if(!ValidatorUtil.isEmpty(filter.getHospital().getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"id",filter.getHospital().getId()));
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"name",filter.getHospital().getName()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getProvince())&&(!filter.getHospital().getProvince().equals("所在省份")))
			{
				
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"province",filter.getHospital().getProvince()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getCity())&&(!filter.getHospital().getCity().equals("所在城市"))&&(!filter.getHospital().getCity().equals("市辖区")))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"city",filter.getHospital().getCity()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getHospital().getCounty())&&(!filter.getHospital().getCounty().equals("所在区县"))&&(!filter.getHospital().getCounty().equals("市辖区")))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"county",filter.getHospital().getCounty()));
				
			}			
		}
		
		//conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"state",String.valueOf(UserStatusEnum.REGISTERED.getIntValue())));
	
		AbstractDataSource<Hospital> dataSource = new DataBaseSourceImpl<Hospital>(Hospital.class,conditionList);
		
		 
		return dataSource;
	}

	@Override
	public HospitalModel getHospitalByID(String id)
	{
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",id);
		
		HospitalModel hospitalModel = new HospitalModel();
		Hospital hospital = (Hospital) DaoContext.getInstance().getHospitalDao().getUniRecord(condition);
		hospitalModel.setHospital(hospital);
	  		
		return hospitalModel;
	}



	@SuppressWarnings("unchecked")
	public AbstractDataSource<Expert> getExpertList(ExpertModel filter, int accountType, String userName)
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		
		
		if(UserTypeEnum.getEnumByInt(accountType)==UserTypeEnum.HOSPITAL)
		{	
			
			List<String> expertList= new ArrayList<String>();
			List<QueryCondition> linkConditionList = new ArrayList<QueryCondition>();
			
			linkConditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"hospitalID", userName));
			linkConditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"linkState",String.valueOf(LinkStatusEnum.LINK_SUCCESS.getStatusValue())));
			List<Link> linkList = (List<Link>) DaoContext.getInstance().getLinkDao().getAll(linkConditionList);
			
			if(ValidatorUtil.isEmpty(linkList))
			{
				
			 
				conditionList.add(new QueryCondition(ConditionTypeEnum.FALSE,null));
				
			}
			else
			{
				for(int i=0;i<linkList.size();i++)
				{
					String linkExpertID = linkList.get(i).getExpertID();
					expertList.add(linkExpertID);
				}
				
				conditionList.add(new QueryCondition(ConditionTypeEnum.IN,"id",expertList));
				
			}

		}
			
 
		if (null != filter)
		{
			if (!ValidatorUtil.isEmpty(filter.getExpert().getId()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "id", filter.getExpert().getId()));
			}
			if (!ValidatorUtil.isEmpty(filter.getExpert().getName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "name", filter.getExpert().getName()));

			}
			if (!ValidatorUtil.isEmpty(filter.getExpert().getJobTitle()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "jobTitle", filter.getExpert().getJobTitle()));

			}
			if (!ValidatorUtil.isEmpty(filter.getExpert().getWorkPlace()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE, "workPlace", filter.getExpert().getWorkPlace()));

			}

		}
		 
		
		//conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL, "state", String.valueOf(UserStatusEnum.REGISTERED.getIntValue())));
		
		AbstractDataSource<Expert> dataSource = new DataBaseSourceImpl<Expert>(Expert.class,conditionList);
		
		 
		return dataSource;
	}

	@Override
	public ExpertModel getExpertByID(String id)
	{
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "id",id);
		
		ExpertModel expertModel = new ExpertModel();
		Expert expert=(Expert) DaoContext.getInstance().getExpertDao().getUniRecord(condition);
		
		expertModel.setExpert(expert);
	  		
		return expertModel;
	}
	@Override
	public void modifyHospitalInfo(HospitalModel hospitalModel,String operator)
	{
		hospitalValidator(hospitalModel);

		DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.MODIFY_HOSPITAL, hospitalModel.getHospital().getId(), MISPOperLogConsant.OPERATE_SUCCESS);
		
		
	}
	@Override
	public void saveHospitalInfo(HospitalModel hospitalModel,String operator)
	{
		HospitalModel oldInfo = getHospitalByID(hospitalModel.getHospital().getId());
		hospitalModel.getHospital().setState(oldInfo.getHospital().getState());
		
		hospitalValidator(hospitalModel);
		
		DaoContext.getInstance().getHospitalDao().update(hospitalModel.getHospital());
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.MODIFY_HOSPITAL, hospitalModel.getHospital().getId(), MISPOperLogConsant.OPERATE_SUCCESS);
		
	}
	private void hospitalValidator(HospitalModel hospitalModel)
	{
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.EQUAL, "name",hospitalModel.getHospital().getName());
		Hospital hos = (Hospital) DaoContext.getInstance().getHospitalDao().getUniRecord(condition);
		if(null != hos && !hos.getId().equals(hospitalModel.getHospital().getId()))
		{
			log.warn("hospital name is repeat. the hospital is " + hospitalModel.getHospital());
			throw new SystemOperateException(CommonExceptionMsg.HOSPITAL_NAME_REPEAT);
		}
	}

	@Override
	public void saveExpertInfo(ExpertModel expertModel,String operator)
	{
		ExpertModel old = getExpertByID(expertModel.getExpert().getId());
		if(expertModel.getSignPic()!=null)
		{
			if(expertModel.getSignPic().length()<1024*65)
			{
				expertModel.getExpert().setSignName(HibernateUtil.getBlobByFile(expertModel.getSignPic()));
			}
			else
			{
				throw new SystemOperateException(CommonExceptionMsg.SIGN_IMG_TOO_BIG);
			}

			
		}
		else
		{
			expertModel.getExpert().setSignName(old.getExpert().getSignName());
		}
		
		if(expertModel.getExPhoto()!=null)
		{
			if(expertModel.getExPhoto().length()<1024*65)
			{
				expertModel.getExpert().setExPhoto(HibernateUtil.getBlobByFile(expertModel.getExPhoto()));
			}
			else
			{
				throw new SystemOperateException(CommonExceptionMsg.EX_IMG_TOO_BIG);
			}
			
		}	
		else
		{
			expertModel.getExpert().setExPhoto(old.getExpert().getExPhoto());
		}
		DaoContext.getInstance().getExpertDao().update(expertModel.getExpert());
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.MODIFY_EXPERT, expertModel.getExpert().getId(), MISPOperLogConsant.OPERATE_SUCCESS);
		
	}



	@Override
	public AbstractDataSource<SystemUser> getUserList(UserFilterModel filter) throws ParseException
	{
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();

		     
		if(null != filter)
		{

			if(!ValidatorUtil.isEmpty(filter.getUserName()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.INCLUDLE,"userName",filter.getUserName()));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getAccountType()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"accountType",String.valueOf(UserTypeEnum.getEnumByStr(filter.getAccountType()).getTypeValue())));
				
			}
			if(!ValidatorUtil.isEmpty(filter.getStartDate()))
			{
				conditionList.add(new QueryCondition(ConditionTypeEnum.BIGER_EQ,"regDate",filter.getStartDate()));
			}
			if(!ValidatorUtil.isEmpty(filter.getEndDate()))
			{
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
				Calendar endDate=Calendar.getInstance(); 
				endDate.setTime(df.parse(filter.getEndDate())); 
				endDate.add(Calendar.DATE, 1);
				conditionList.add(new QueryCondition(ConditionTypeEnum.LOWER_EQ,"regDate",df.format(endDate.getTime())));
			}				

			
		}		

		AbstractDataSource<SystemUser> dataSource = new DataBaseSourceImpl<SystemUser>(SystemUser.class,conditionList);
 
		return dataSource;
	}

	@Override
	public void createUser(String userName, String accountType,String operator)
	{
		SystemUser oldUser = (SystemUser) MISPDaoContext.getInstance().getSystemUserDao().getUniRecord(new QueryCondition(ConditionTypeEnum.EQUAL, "userName", userName));
		if(null != oldUser)
		{
			log.error("create user failed,the user name "+ userName +" is existed." );
			throw new SystemOperateException(CommonExceptionMsg.USER_EXISTED);
		}
		SystemUser user = new SystemUser();
		user.setUserName(userName);
		user.setAccountType(UserTypeEnum.getEnumByStr(accountType).getTypeValue());
		user.setRegDate(DateUtil.getCurrentDate());
		user.setPassword(SystemConfigInfo.getDefaultPassword());
		
		switch(UserTypeEnum.getEnumByStr(accountType))
		{
		case EXPERT:
			Expert expert = new Expert();
			expert.setId(user.getUserName());
			expert.setState(UserStatusEnum.CREATED.getIntValue());
			DaoContext.getInstance().getExpertDao().create(expert);
			break;
		case HOSPITAL:
			Hospital hospital = new Hospital();
			hospital.setId(user.getUserName());
			hospital.setState(UserStatusEnum.CREATED.getIntValue());
			DaoContext.getInstance().getHospitalDao().create(hospital);
			break;
		default :break;
		}

		MISPDaoContext.getInstance().getSystemUserDao().create(user);
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.CREATE_USER, userName, MISPOperLogConsant.OPERATE_SUCCESS);
	}

	@Override
	public void deleteUserList(List<String> userIDList,String operator)
	{
		QueryCondition condition = new QueryCondition(ConditionTypeEnum.IN, "userID", userIDList);		

		List<SystemUser> userList = (List<SystemUser>) MISPDaoContext.getInstance().getSystemUserDao().getAll(condition);
		
		if(!ValidatorUtil.isEmpty(userList))
		{
			for(SystemUser user : userList)
			{
				if(user.getAccountType() != UserTypeEnum.LOW_ADMIN.getTypeValue())
				{
					throw new SystemOperateException(CommonExceptionMsg.DELET_LIMIT);
				}
				
			}

 		}
		else
		{
			throw new SystemOperateException(CommonExceptionMsg.SELECT_USER_EMPTY);
		}

 
		MISPDaoContext.getInstance().getSystemUserDao().delete(condition);
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.DELETE_USER, userIDList.toString(), MISPOperLogConsant.OPERATE_SUCCESS);

		
		
	}
	@Override
	public void addExpert(String hospitalID, String expertID,String operator)
	{
		if (!ValidatorUtil.isEmpty(expertID))
		{

			Link oldLink = getLinkByID(hospitalID, expertID).getLink();
			if (oldLink != null)
			{
				if (oldLink.getLinkState() == LinkStatusEnum.LINK_FAILED.getStatusValue())
				{
					throw new SystemOperateException(CommonExceptionMsg.LINK_APPROVING);
				} else
				{
					throw new SystemOperateException(CommonExceptionMsg.LINK_EXISTED);
				}

			} else
			{
				ExpertModel expert = this.getExpertByID(expertID);
				HospitalModel hopital = this.getHospitalByID(hospitalID);
				Link link = new Link();
				link.setHospitalID(hospitalID);
				link.setExpertID(expertID);
				link.setExpertName(expert.getExpert().getName());
				link.setHospitalName(hopital.getHospital().getName());
				
				link.setLinkState(LinkStatusEnum.LINK_FAILED.getStatusValue());
				link.setLinkTime(DateUtil.getCurrentDate());
				DaoContext.getInstance().getLinkDao().create(link);
				
			}
		} else
		{
			throw new SystemOperateException(CommonExceptionMsg.SELECTED_NULL);
		}
		
		MISPServiceContext.getInstance().getMISPOperLogService().recordLog(operator, MISPOperLogConsant.ADD_EXPERT,hospitalID+","+expertID, MISPOperLogConsant.OPERATE_SUCCESS);

		
	}
	@Override
	public LinkModel getLinkByID(String hospitalID, String expertID)
	{
		LinkModel linkModel= new LinkModel();
		List<QueryCondition> conditionList = new ArrayList<QueryCondition>();
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"hospitalID",hospitalID));
		conditionList.add(new QueryCondition(ConditionTypeEnum.EQUAL,"expertID",expertID));
		Link link = (Link) DaoContext.getInstance().getLinkDao().getUniRecord(conditionList);
		linkModel.setLink(link);
		return linkModel ;
	}


	 
 
}
