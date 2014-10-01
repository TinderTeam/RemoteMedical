package cn.fuego.remote.medical.manage.service;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.misp.service.MISPUserService;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

public interface UserService extends MISPUserService
{
	 AbstractDataSource<Hospital> getHospitalList(HospitalModel filter);

}
