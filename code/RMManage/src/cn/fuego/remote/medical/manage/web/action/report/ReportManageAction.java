/**   
* @Title: ReportManageAction.java 
* @Package cn.fuego.remote.medical.expert.web.action.report 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午05:25:07 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.web.action.report;

import cn.fuego.misp.web.action.basic.DWZTableAction;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.manage.service.ExpertService;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.web.model.ReportFilterModel;
import cn.fuego.remote.medical.manage.web.model.WorkStaticsModel;

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
 	private ReportFilterModel filter = new ReportFilterModel(); 
 
 	private WorkStaticsModel workStatics;
	public String execute()
	{
		
		reportList.setPage(this.getPage());
		reportList.setDataSource(expertService.getMedicalList(this.getLoginUser().getUserName(), filter));
		filter.setHospitalNameList(expertService.getLinkHosptialByExpert(this.getLoginUser().getUserName()));
		return SUCCESS;
	}
	
	public String costCount()
	{
		execute();
		return "cost";
	}
	
	public String workCount()
	{
		workStatics = expertService.getWorkStatics(this.getLoginUser().getUserName(), filter);
		filter.setHospitalNameList(expertService.getLinkHosptialByExpert(this.getLoginUser().getUserName()));
		filter.setExpertIDList(expertService.getLinkExpertByHosptial(this.getLoginUser().getUserName()));
		return "work";
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#show()
	 */
	@Override
	public String show()
	{
		// TODO Auto-generated method stub
		return null;
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
	@Override
	public String modify()
	{
		// TODO Auto-generated method stub
		return execute();
	}
	
	
	public TableDataModel<ReportView> getReportList()
	{
		return reportList;
	}
	public void setReportList(TableDataModel<ReportView> reportList)
	{
		this.reportList = reportList;
	}

	public ReportFilterModel getFilter()
	{
		return filter;
	}

	public void setFilter(ReportFilterModel filter)
	{
		this.filter = filter;
	}

	public WorkStaticsModel getWorkStatics()
	{
		return workStatics;
	}

	public void setWorkStatics(WorkStaticsModel workStatics)
	{
		this.workStatics = workStatics;
	}

 


}
