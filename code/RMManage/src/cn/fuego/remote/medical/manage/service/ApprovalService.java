package cn.fuego.remote.medical.manage.service;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.domain.Hospital;
import cn.fuego.remote.medical.manage.web.model.ApprovalFilterModel;
import cn.fuego.remote.medical.manage.web.model.ExpertModel;
import cn.fuego.remote.medical.manage.web.model.HospitalModel;

public interface ApprovalService
{

	AbstractDataSource<Approval> getApprovalList(ApprovalFilterModel filter);

	Approval getApprovalByID(String approvalID);

	
	void createHospitalApply(HospitalModel hospital);
	void createExpertApply(ExpertModel expert);

	void createAddExpertApply(String hospitalID,String expertID);

	void handleAgree(String handleUser,String approvalID);

	void handleRefuse(String handleUser, String approvalID);	
	public int getApprovalCount(String userName);
	public Approval getApprovalInfo(String userName);

	

}
