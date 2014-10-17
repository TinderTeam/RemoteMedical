package cn.fuego.remote.medical.manage.service;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.remote.medical.domain.Approval;
import cn.fuego.remote.medical.manage.web.model.ApprovalFilterModel;

public interface ApprovalService
{

	AbstractDataSource<Approval> getApprovalList(ApprovalFilterModel filter);
	

}
