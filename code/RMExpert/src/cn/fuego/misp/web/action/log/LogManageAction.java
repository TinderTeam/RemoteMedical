/**   
* @Title: LogManageAction.java 
* @Package cn.fuego.misp.web.action.log 
* @Description: TODO
* @author Tang Jun   
* @date 2014-10-8 上午10:46:17 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.log;

import cn.fuego.misp.domain.OperLog;
import cn.fuego.misp.service.MISPOperLogService;
import cn.fuego.misp.service.MISPServiceContext;
import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.model.log.LogFilterModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;

/** 
 * @ClassName: LogManageAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-10-8 上午10:46:17 
 *  
 */

public class LogManageAction extends TableAction
{
	private MISPOperLogService service = MISPServiceContext.getInstance().getMISPOperLogService();
	private TableDataModel<OperLog> logList = new TableDataModel<OperLog>();
 	private LogFilterModel filter = new LogFilterModel(); 
	public String execute()
	{
		logList.setDataSource(service.getOperLogList(filter));
		return SUCCESS;
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#create()
	 */
	@Override
	public String create()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#delete()
	 */
	@Override
	public String delete()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#deleteList()
	 */
	@Override
	public String deleteList()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.web.action.basic.TableAction#modify()
	 */
	@Override
	public String modify()
	{
		// TODO Auto-generated method stub
		return null;
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

}
