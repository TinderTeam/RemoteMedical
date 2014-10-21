package cn.fuego.remote.medical.manage.web.action.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.ApplyTypeEnum;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.manage.service.ApprovalService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.web.model.ApprovalFilterModel;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

/** 
* @ClassName: ApprovalManageAction 
* @Description: TODO
* @author Aether
* @date 2014-10-17 上午11:36:48 
*  
*/ 
public class ApprovalManageAction extends DWZTableAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Log log = LogFactory.getLog(ApprovalManageAction.class);
	
	private ApprovalService approvalService = ServiceContext.getInstance().getApprovalService();
	private ApprovalFilterModel filter = new ApprovalFilterModel();
	private TableDataModel<Approval> approvalTable = new  TableDataModel<Approval>();
	private HospitalModel hospitalModel;
	private ExpertModel expertModel;
	public String execute()
	{
		approvalTable.setPage(this.getPage());
		approvalTable.setDataSource(approvalService.getApprovalList(filter));

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
		String applyID=this.getSelectedID();
		Approval approval = approvalService.getApprovalByID(applyID);

		String jumpPage =SUCCESS;//页面跳转
		
		switch(ApplyTypeEnum.getEnumByInt(approval.getApplyType()))
		{
			case MODIFY_EXPERT: 
				expertModel = ServiceContext.getInstance().getUserService().getExpertByID(approval.getExpertID());
				jumpPage="showModifyExpert";
				break;
			case MODIFY_HOSPITAL: 
				hospitalModel = ServiceContext.getInstance().getUserService().getHospitalByID(approval.getHospitalID());
							 
				jumpPage="showModifyHospital";
				break;
			case ADD_EXPERT:
				jumpPage =SUCCESS;
				break;
			default:
				break;
					
				
		}
		
		return jumpPage;
	}
	public Log getLog()
	{
		return log;
	}
	public void setLog(Log log)
	{
		this.log = log;
	}
	public ApprovalService getApprovalService()
	{
		return approvalService;
	}
	public void setApprovalService(ApprovalService approvalService)
	{
		this.approvalService = approvalService;
	}
	public ApprovalFilterModel getFilter()
	{
		return filter;
	}
	public void setFilter(ApprovalFilterModel filter)
	{
		this.filter = filter;
	}
	public TableDataModel<Approval> getApprovalTable()
	{
		return approvalTable;
	}
	public void setApprovalTable(TableDataModel<Approval> approvalTable)
	{
		this.approvalTable = approvalTable;
	}
	public HospitalModel getHospitalModel()
	{
		return hospitalModel;
	}
	public void setHospitalModel(HospitalModel hospitalModel)
	{
		this.hospitalModel = hospitalModel;
	}
	public ExpertModel getExpertModel()
	{
		return expertModel;
	}
	public void setExpertModel(ExpertModel expertModel)
	{
		this.expertModel = expertModel;
	}	

	
}
