package cn.fuego.remote.medical.manage.service;

import java.text.ParseException;
import java.util.List;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.misp.domain.SystemUser;
import cn.fuego.misp.service.MISPUserService;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;
import cn.fuego.remote.medical.manage.web.model.LinkModel;
import cn.fuego.remote.medical.manage.web.model.UserFilterModel;

public interface UserService extends MISPUserService
{
	 AbstractDataSource<Hospital> getHospitalList(HospitalModel filter);
	 
	 HospitalModel getHospitalByID(String id);
	 

	 
	 AbstractDataSource<Expert> getExpertList(ExpertModel filter, int accountType, String userName);
	 AbstractDataSource<SystemUser> getUserList(UserFilterModel filter, int accountType) throws ParseException ;
	 
	 ExpertModel getExpertByID(String id);
	 LinkModel getLinkByID(String hospitalID, String expertID);
		
	 
	void modifyHospitalInfo(HospitalModel hospitalModel,String operator);
	
	void saveHospitalInfo(HospitalModel hospitalModel,String operator);

	void saveExpertInfo(ExpertModel expertModel,String operator);

	
	void createUser(String userName,String accountType, String operator);

	void deleteUserList(List<String> userIDList,String operator);

	public void addExpert(String hospitalID, String expertID,String operator);
	
   
}
