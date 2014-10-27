package cn.fuego.remote.medical.manage.service;

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
	 
	 void modifyHospitalInfo(HospitalModel hospitalModel);
	 
	 AbstractDataSource<Expert> getExpertList(ExpertModel filter, int accountType, String userName);

	 ExpertModel getExpertByID(String id);

	void saveHospitalInfo(HospitalModel hospitalModel);

	void saveExpertInfo(ExpertModel expertModel);

	AbstractDataSource<SystemUser> getUserList(UserFilterModel filter);
 
	void createUser(String userName,String accountType, String operator);

	void deleteUserList(List<String> userIDList);

	void addExpert(String hospitalID, String expertID);
	
    LinkModel getLinkByID(String hospitalID, String expertID);
	
}
