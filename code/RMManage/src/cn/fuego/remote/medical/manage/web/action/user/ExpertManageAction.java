package cn.fuego.remote.medical.manage.web.action.user;

import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;

public class ExpertManageAction extends TableAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService = ServiceContext.getInstance().getUserService();
	private ExpertModel expertModel;
	private ExpertModel filter;
	private TableDataModel<Expert> expertTable = new  TableDataModel<Expert>();
	
	public String execute()
	{

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

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
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

}
