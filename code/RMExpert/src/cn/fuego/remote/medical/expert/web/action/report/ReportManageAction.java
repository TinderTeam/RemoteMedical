/**   
* @Title: ReportManageAction.java 
* @Package cn.fuego.remote.medical.expert.web.action.report 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午05:25:07 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.action.report;

import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.model.page.PageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.service.ServiceContext;

/** 
 * @ClassName: ReportManageAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午05:25:07 
 *  
 */

public class ReportManageAction extends TableAction
{
	private ExpertService expertService = ServiceContext.getInstance().getExpertService();
	private TableDataModel<ReportView> reportList;
 
	public String execute()
	{
		reportList = expertService.getMedicalList(null, null, new PageModel()); 

		return SUCCESS;
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

 


}
