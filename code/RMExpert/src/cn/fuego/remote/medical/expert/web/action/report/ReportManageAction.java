/**   
* @Title: ReportManageAction.java 
* @Package cn.fuego.remote.medical.expert.web.action.report 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午05:25:07 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.action.report;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.message.MispMessageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.service.ServiceContext;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportFilterModel;

/** 
 * @ClassName: ReportManageAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午05:25:07 
 *  
 */
 

public class ReportManageAction extends DWZTableAction
{
	private ExpertService expertService = ServiceContext.getInstance().getExpertService();
	private TableDataModel<ReportView> reportList = new TableDataModel<ReportView>();
	private MedicalReportModel medicalReport = new MedicalReportModel();
	private ReportFilterModel filter = new ReportFilterModel(); 

 
	public String execute()
	{
		
		reportList.setPage(this.getPage());
		reportList.setDataSource(expertService.getMedicalList(null, filter));
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
		this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		return MISP_DONE_PAGE;
	}
	public String cancel()
	{
		expertService.submitMedicalReport(ReportStatusEnum.CANCEL, this.medicalReport);
		return MISP_DONE_PAGE;
	}
	public String tranfer()
	{
		// TODO Auto-generated method stub
		return this.SHOW_INFO;
	}
	public String back()
	{
		execute();
		this.getOperateMessage().setCallbackType(MispMessageModel.CLOSE_CURENT_PAGE);
		return MISP_DONE_PAGE;
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

 


}
