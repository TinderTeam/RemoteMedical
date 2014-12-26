/**   
* @Title: ReportManageAction.java 
* @Package cn.fuego.remote.medical.expert.web.action.report 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午05:25:07 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.action.report;

import org.apache.struts2.ServletActionContext;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Report;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.service.ServiceContext;
import cn.fuego.remote.medical.expert.web.model.ExpertModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportFilterModel;
import cn.fuego.remote.medical.expert.web.model.ReportTemplateModel;


/** 
 * @ClassName: ReportManageAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午05:25:07 
 *  
 */
 

public class ReportManageAction extends DWZTableAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PARENT_PAGE="/login/login";
	public static final String FRONT_PAGE="expert/ReportManage";
	private ExpertService expertService = ServiceContext.getInstance().getExpertService();
	private TableDataModel<ReportView> reportList = new TableDataModel<ReportView>();
	private MedicalReportModel medicalReport = new MedicalReportModel();
	private ReportFilterModel filter = new ReportFilterModel(); 
    //转换专家
	private ExpertModel expertModel;
	private ExpertModel expertFilter;
	private TableDataModel<Expert> expertTable = new  TableDataModel<Expert>();
	private Report report;
	//确定转换专家需要报告ID
	private String selectedReportID;
	private ReportTemplateModel reportModal;
	public String execute()
	{
		
		
		reportList.setPage(this.getPage());
		reportList.setDataSource(expertService.getMedicalList(this.getLoginUser().getUserName(), filter));
 
		filter.setHospitalNameList(expertService.getLinkHosptialByExpert(this.getLoginUser().getUserName()));
		
		return SUCCESS;
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#show()
	 */
	@Override
	public String show()
	{
		medicalReport = expertService.getImageByMedical(this.getSelectedID());
		return SHOW_INFO;
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#create()
	 */
	@Override
	public String create()
	{
		// TODO Auto-generated method stub
		
		
		return execute();
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#delete()
	 */
	@Override
	public String delete()
	{
		// TODO Auto-generated method stub
		return execute();
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#deleteList()
	 */
	@Override
	public String deleteList()
	{
		// TODO Auto-generated method stub
		return execute();
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#modify()
	 */
 
	public String modify()
	{
		expertService.submitMedicalReport(ReportStatusEnum.SAVE, this.medicalReport);
 
		 
		return MISP_DONE_PAGE;
	}
	public String submit()
	{
		expertService.submitMedicalReport(ReportStatusEnum.SUBMIT, this.medicalReport);
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl(FRONT_PAGE);
		return MISP_DONE_PAGE;
	}
	public String cancel()
	{
		expertService.submitMedicalReport(ReportStatusEnum.CANCEL, this.medicalReport);
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		this.getOperateMessage().setForwardUrl(FRONT_PAGE);
		return MISP_DONE_PAGE;
	}
    /**
     * 转换专家，初始查询
     * @return
     */
	public String showTransfer()
	{
		expertTable.setPage(this.getPage());
		expertTable.setDataSource(expertService.getExpertList(expertFilter,this.getLoginUser().getUserName(),this.getSelectedID()));
		selectedReportID=this.getSelectedID();
		return "showTransfer";
	}
	public String transferSure()
	{
		expertService.transferExpert(this.getSelectedID(),this.getSelectedReportID());
		this.getOperateMessage().setCallbackType(MispMessageModel.FORWARD);
		
 
		this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		this.getOperateMessage().setNavTabId("Home");
 
 		return MISP_DONE_PAGE;
	}
	public String back()
	{
		this.getOperateMessage().setCallbackType(MispMessageModel.CANCEL);
		this.getOperateMessage().setForwardUrl(FRONT_PAGE);
		return MISP_DONE_PAGE;
	}
	public String showModal()
	{
		
		reportModal =expertService.getReportModalById(this.getSelectedID());
		return "showModal";
		
	}
	
	public TableDataModel<ReportView> getReportList()
	{
		return reportList;
	}
	public void setReportList(TableDataModel<ReportView> reportList)
	{
		this.reportList = reportList;
	}
	public MedicalReportModel getMedicalReport()
	{
		return medicalReport;
	}
	public void setMedicalReport(MedicalReportModel medicalReport)
	{
		this.medicalReport = medicalReport;
	}
	public ReportFilterModel getFilter()
	{
		return filter;
	}
	public void setFilter(ReportFilterModel filter)
	{
		this.filter = filter;
	}
	public ExpertService getExpertService()
	{
		return expertService;
	}
	public void setExpertService(ExpertService expertService)
	{
		this.expertService = expertService;
	}
	public ExpertModel getExpertModel()
	{
		return expertModel;
	}
	public void setExpertModel(ExpertModel expertModel)
	{
		this.expertModel = expertModel;
	}
	public ExpertModel getExpertFilter()
	{
		return expertFilter;
	}
	public void setExpertFilter(ExpertModel expertFilter)
	{
		this.expertFilter = expertFilter;
	}
	public TableDataModel<Expert> getExpertTable()
	{
		return expertTable;
	}
	public void setExpertTable(TableDataModel<Expert> expertTable)
	{
		this.expertTable = expertTable;
	}
	public Report getReport()
	{
		return report;
	}
	public void setReport(Report report)
	{
		this.report = report;
	}
	public String getSelectedReportID()
	{
		return selectedReportID;
	}
	public void setSelectedReportID(String selectedReportID)
	{
		this.selectedReportID = selectedReportID;
	}
	/**
	 * @return the reportModal
	 */
	public ReportTemplateModel getReportModal()
	{
		return reportModal;
	}
	/**
	 * @param reportModal the reportModal to set
	 */
	public void setReportModal(ReportTemplateModel reportModal)
	{
		this.reportModal = reportModal;
	}

 


}
