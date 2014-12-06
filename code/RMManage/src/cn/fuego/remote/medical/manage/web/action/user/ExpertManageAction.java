package cn.fuego.remote.medical.manage.web.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.UserStatusEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.LinkModel;

public class ExpertManageAction extends DWZTableAction
{

	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(UserManageAction.class);
	public static final String PARENT_PAGE="user/ExpertManage";	
	
	private UserService userService = ServiceContext.getInstance().getUserService();
	private ApprovalService approvalService =ServiceContext.getInstance().getApprovalService();
	private ExpertModel expertModel;
	private ExpertModel filter;
	private Expert targetExpert;
	private LinkModel linkModel;
	private TableDataModel<Expert> expertTable = new  TableDataModel<Expert>();

	private InputStream signNameStream;
	private InputStream expertStream;
	private String picid;
	public String execute()
	{
		expertTable.setPage(this.getPage());
		expertTable.setDataSource(userService.getExpertList(filter,this.getLoginUser().getAccountType(),this.getLoginUser().getUserName()));
	
		return SUCCESS;
	}	
	
	@Override
	public String create()
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		expertModel = userService.getExpertByID(this.getSelectedID());
		return SHOW_INFO;
	}
	/*
	 * 取消/返回页面不做任何参数改变
	 */
    public String cancel()
    
    {
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);

		this.getOperateMessage().setForwardUrl(PARENT_PAGE);
		
    	return MISP_DONE_PAGE;
    	
    }
    public String infoEdit()
    {
    	expertModel = userService.getExpertByID(this.getSelectedID());
    	return SHOW_INFO;
    	
    }
    public String infoSave()
    {
    	try
		{
			userService.saveExpertInfo(expertModel,this.getLoginUser().getUserName());
		} catch (Exception e)
		{
			log.error("save user failed",e);
			this.getOperateMessage().setStatusCode(MispMessageModel.FAILURE_CODE);
			this.getOperateMessage().setMessage(e.getMessage());
		}
    	//this.getOperateMessage().setCallbackType("closeCurrent");
    	return MISP_DONE_PAGE;
    }
/* 申请修改，状态改变*/	
    public String infoSubmit()
    {
 
		approvalService.createExpertApply(expertModel);
		
		this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
    	return MISP_DONE_PAGE;
    	
    }	
	public String applyAgree()
	{
		approvalService.handleAgree(this.getLoginUser().getUserName(),this.getSelectedID());
		//this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl("user/ApprovalManage");
		
		return MISP_DONE_PAGE;
	}
	public String applyRefuse()
	{
		approvalService.handleRefuse(this.getLoginUser().getUserName(),this.getSelectedID());
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl("user/ApprovalManage");		
		return MISP_DONE_PAGE;
				
	}
	//读取图片
    public String getSignNameImag() throws SQLException 
    {
    	 
    	signNameStream = new ByteArrayInputStream(userService.getExpertByID(picid).getExpert().getSignName()); 
    	this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
        return "signName";
    }
	//读取图片
    public String getPhotoImag() throws SQLException 
    {
    	 
    	this.expertStream = new ByteArrayInputStream(userService.getExpertByID(picid).getExpert().getExPhoto());
    	 

        return "expertPhoto";
    }
    /**
     * 添加专家，初始查询
     * @return
     */
    public String addExpert()
    {	if(null == filter)
        {
    	   filter = new ExpertModel();
    	   filter.setExpert(new Expert());
        }
    	filter.getExpert().setState(UserStatusEnum.REGISTERED.getIntValue());
    	expertTable.setPage(this.getPage());
		expertTable.setDataSource(userService.getExpertList(filter,UserTypeEnum.ADMIN.getTypeValue(),null));
    	return "addExpert";
    	
    }
    /**
     * 添加专家，确认添加
     * @return
     */
    public String addSure()
    {

    	try
		{
			userService.addExpert(this.getLoginUser().getUserName(),this.getTargetExpert().getId(),this.getLoginUser().getUserName());
			approvalService.createAddExpertApply(this.getLoginUser().getUserName(), this.getTargetExpert().getId());
		} catch (Exception e)
		{
			this.getOperateMessage().setStatusCode(MispMessageModel.FAILURE_CODE);
			this.getOperateMessage().setMessage(e.getMessage());
			log.error("add expert failed",e);
			
		}
	
		return MISP_DONE_PAGE;
    	
    }
	public ExpertModel getExpertModel()
	{
		return expertModel;
	}

	public void setExpertModel(ExpertModel expertModel)
	{
		this.expertModel = expertModel;
	}

	public ExpertModel getFilter()
	{
		return filter;
	}

	public void setFilter(ExpertModel filter)
	{
		this.filter = filter;
	}

	public TableDataModel<Expert> getExpertTable()
	{
		return expertTable;
	}

	public void setExpertTable(TableDataModel<Expert> expertTable)
	{
		this.expertTable = expertTable;
	}

	public InputStream getSignNameStream()
	{
		return signNameStream;
	}

	public void setSignNameStream(InputStream signNameStream)
	{
		this.signNameStream = signNameStream;
	}

	public InputStream getExpertStream()
	{
		return expertStream;
	}

	public void setExpertStream(InputStream expertStream)
	{
		this.expertStream = expertStream;
	}

	public String getPicid()
	{
		return picid;
	}

	public void setPicid(String picid)
	{
		this.picid = picid;
	}

	public Expert getTargetExpert()
	{
		return targetExpert;
	}

	public void setTargetExpert(Expert targetExpert)
	{
		this.targetExpert = targetExpert;
	}

	public LinkModel getLinkModel()
	{
		return linkModel;
	}

	public void setLinkModel(LinkModel linkModel)
	{
		this.linkModel = linkModel;
	}


	

}
