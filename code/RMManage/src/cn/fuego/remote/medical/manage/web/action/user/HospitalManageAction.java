package cn.fuego.remote.medical.manage.web.action.user;

import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.service.ServiceContext;
import cn.fuego.remote.medical.manage.service.UserService;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

public class HospitalManageAction extends TableAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = ServiceContext.getInstance().getUserService();
	private HospitalModel hospital;
	private TableDataModel<Hospital> hospitalTable = new  TableDataModel<Hospital>();
	public String execute()
	{

		hospitalTable.setDataSource(userService.getHospitalList(hospital));
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
		// TODO Auto-generated method stub
		return null;
	}
	public TableDataModel<Hospital> getHospitalTable()
	{
		return hospitalTable;
	}
	public void setHospitalTable(TableDataModel<Hospital> hospitalTable)
	{
		this.hospitalTable = hospitalTable;
	}
	public HospitalModel getHospital()
	{
		return hospital;
	}
	public void setHospital(HospitalModel hospital)
	{
		this.hospital = hospital;
	}

}
