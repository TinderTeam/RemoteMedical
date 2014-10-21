package cn.fuego.remote.medical.manage.web.action.user;

import java.io.InputStream;
import java.sql.SQLException;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;

public class ExpertManageAction extends DWZTableAction
{

	private static final long serialVersionUID = 1L;
	
	private UserService userService = ServiceContext.getInstance().getUserService();
	private ApprovalService approvalService =ServiceContext.getInstance().getApprovalService();
	private ExpertModel expertModel;
	private ExpertModel filter;
	private TableDataModel<Expert> expertTable = new  TableDataModel<Expert>();

	private InputStream signNameStream;
	private InputStream expertStream;
	private String picid;
	public String execute()
	{
		expertTable.setPage(this.getPage());
		expertTable.setDataSource(userService.getExpertList(filter));
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

    public String infoEdit()
    {
    	expertModel = userService.getExpertByID(this.getSelectedID());
    	return EDIT_INFO;
    	
    }
    public String infoSave()
    {
    	userService.saveExpertInfo(expertModel);
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
    	 
    	signNameStream = userService.getExpertByID(picid).getExpert().getSignName().getBinaryStream();
    	this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
        return "signName";
    }
	//读取图片
    public String getPhotoImag() throws SQLException 
    {
    	 
    	this.expertStream = userService.getExpertByID(picid).getExpert().getExPhoto().getBinaryStream();
    	 

        return "expertPhoto";
    }
    //添加专家
    public String addExpert()
    {	
		expertTable.setPage(this.getPage());
		expertTable.setDataSource(userService.getExpertList(filter));
    	return "addExpert";
    	
    }
    public String addSure()
    {
		userService.addExpert(this.getLoginUser().getUserName(),this.getSelectedID());
		
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
	

}
