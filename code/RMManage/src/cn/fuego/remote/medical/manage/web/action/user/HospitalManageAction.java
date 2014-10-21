package cn.fuego.remote.medical.manage.web.action.user;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

/** 
* @ClassName: HospitalManageAction 
* @Description: TODO
* @author Aether
* @date 2014-10-18 下午6:59:11 
*  
*/ 
public class HospitalManageAction extends DWZTableAction
{
	/**
	 * 
	 */
	public static final String PARENT_PAGE="user/HospitalManage";
	private static final long serialVersionUID = 1L;

	private UserService userService = ServiceContext.getInstance().getUserService();
	private ApprovalService approvalService =ServiceContext.getInstance().getApprovalService();
	private HospitalModel hospitalModel;
	private HospitalModel filter;

	private TableDataModel<Hospital> hospitalTable = new  TableDataModel<Hospital>();
	public String execute()
	{
		hospitalTable.setPage(this.getPage());
		hospitalTable.setDataSource(userService.getHospitalList(filter));
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

		
		userService.modifyHospitalInfo(hospitalModel);
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);

		this.getOperateMessage().setForwardUrl(PARENT_PAGE);

		return MISP_DONE_PAGE;
	}
	

    public String cancel()
    
    {
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);

		this.getOperateMessage().setForwardUrl(PARENT_PAGE);
		
    	return MISP_DONE_PAGE;
    	
    }
     
    public String infoEdit()
    {
    	
    	hospitalModel= userService.getHospitalByID(this.getSelectedID());
    	return EDIT_INFO;
    }
    public String infoSave()
    {
    	userService.saveHospitalInfo(hospitalModel);
    	
    	return MISP_DONE_PAGE;
    }
    
    public String infoSubmit()
    {
 
		approvalService.createHospitalApply(hospitalModel);
		
		this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
    	return MISP_DONE_PAGE;
    	
    }
	@Override
	public String show()
	{
		hospitalModel = userService.getHospitalByID(this.getSelectedID());
		return SHOW_INFO;
	}
	
/* 申请修改，状态改变*/	
	
	public String applyAgree()
	{
		approvalService.handleAgree(this.getOperator(),this.getSelectedID());
		//this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl("user/ApprovalManage");
		
		return MISP_DONE_PAGE;
	}
	public String applyRefuse()
	{
		approvalService.handleRefuse(this.getOperator(),this.getSelectedID());
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl("user/ApprovalManage");		
		return MISP_DONE_PAGE;
				
	}
	public TableDataModel<Hospital> getHospitalTable()
	{
		return hospitalTable;
	}
	public void setHospitalTable(TableDataModel<Hospital> hospitalTable)
	{
		this.hospitalTable = hospitalTable;
	}
	public HospitalModel getHospitalModel()
	{
		return hospitalModel;
	}
	public void setHospitalModel(HospitalModel hospitalModel)
	{
		this.hospitalModel = hospitalModel;
	}
	public HospitalModel getFilter()
	{
		return filter;
	}
	public void setFilter(HospitalModel filter)
	{
		this.filter = filter;
	}
 
}
