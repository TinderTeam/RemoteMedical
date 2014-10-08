package cn.fuego.remote.medical.manage.service;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.misp.service.MISPUserService;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

public interface UserService extends MISPUserService
{
	 AbstractDataSource<Hospital> getHospitalList(HospitalModel filter);
	 
	 HospitalModel getHospitalByID(String id);
	 
	 void modifyHospitalInfo(HospitalModel hospitalModel);
	 
	 AbstractDataSource<Expert> getExpertList(ExpertModel filter);

	 ExpertModel getExpertByID(String id);
	
	
	
}
