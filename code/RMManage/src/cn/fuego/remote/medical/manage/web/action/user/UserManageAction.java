package cn.fuego.remote.medical.manage.web.action.user;

import java.text.ParseException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.domain.SystemUser;
import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.misp.web.model.user.UserModel;
import cn.fuego.remote.medical.constant.ApplyStatusEnum;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.service.impl.UserServiceImpl;
import cn.fuego.remote.medical.manage.web.model.UserFilterModel;

public class UserManageAction extends DWZTableAction

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PARENT_PAGE="user/UserManage";
	private Log log = LogFactory.getLog(UserManageAction.class);

	
	private UserService userService = ServiceContext.getInstance().getUserService();

	private UserFilterModel filter = new UserFilterModel();
	private TableDataModel<SystemUser> userTable = new  TableDataModel<SystemUser>();	
	
    private int approvalCount = 0;
    private boolean approvalRefuse = false;
    
    
    
	public int getApprovalCount()
	{
		return approvalCount;
	}
	public void setApprovalCount(int approvalCount)
	{
		this.approvalCount = approvalCount;
	}
 
	public boolean isApprovalRefuse()
	{
		return approvalRefuse;
	}
	public void setApprovalRefuse(boolean approvalRefuse)
	{
		this.approvalRefuse = approvalRefuse;
	}
	public String execute()
	{
		userTable.setPage(this.getPage());
		try
		{
			userTable.setDataSource(userService.getUserList(filter,this.getLoginUser().getAccountType()));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			log.error("excute user failed",e);
		}
		return SUCCESS;
	}
	@Override
	public String create()
	{
		
		try
		{
			userService.createUser(filter.getUserName(), filter.getAccountType(),this.getLoginUser().getUserName());
			this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		} catch (Exception e)
		{
			log.error("create user failed",e);
			this.getOperateMessage().setStatusCode(MispMessageModel.FAILURE_CODE);
			this.getOperateMessage().setMessage(e.getMessage());
		}

		return MISP_DONE_PAGE;

	}
	
	public String home()
	{
		this.approvalCount = ServiceContext.getInstance().getApprovalService().getApprovalCount(this.getLoginUser().getUserName());
		Approval approval = ServiceContext.getInstance().getApprovalService().getApprovalInfo(this.getLoginUser().getUserName());
		
		if( null != approval)
		{
			if(ApplyStatusEnum.REFUSED.getStatus().equals(approval.getStatus()))
			{
				this.approvalRefuse = true;
			}
		}
		 
		return "home";
	}

	@Override
	public String delete()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteList()
	{
		userService.deleteUserList(Arrays.asList(this.getSelectedIDList()),this.getLoginUser().getUserName());
		return  MISP_DONE_PAGE;

	}

	@Override
	public String modify()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String show()
	{
		// TODO Auto-generated method stub
		return null;
	}
	public String newUser()
	{
		return EDIT_INFO;
	}
	public TableDataModel<SystemUser> getUserTable()
	{
		return userTable;
	}
	public void setUserTable(TableDataModel<SystemUser> userTable)
	{
		this.userTable = userTable;
	}
	public UserFilterModel getFilter()
	{
		return filter;
	}
	public void setFilter(UserFilterModel filter)
	{
		this.filter = filter;
	}
	
	

}
