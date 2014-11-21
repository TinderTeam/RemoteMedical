/**   
* @Title: ExpertService.java 
* @Package cn.fuego.remote.medical.expert.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:27:49 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service;

import java.util.List;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.misp.web.model.page.PageModel;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.domain.Expert;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.web.model.ExpertModel;
import cn.fuego.remote.medical.expert.web.model.ImageModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportFilterModel;
import cn.fuego.remote.medical.expert.web.model.ReportTemplateModel;


/** 
 * @ClassName: ExpertService 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:27:49 
 *  
 */

public interface ExpertService
{

	/**
	 * 获取专家名下的报告列表
	 * @param userName
	 * @param queryModel
	 * @return
	 */
	AbstractDataSource<ReportView> getMedicalList(String userName,ReportFilterModel queryModel);
	

	/**
	 * 根据报告视图唯一编号，获取报告具体信息
	 * @param reportViewID
	 * @return
	 */
	MedicalReportModel getImageByMedical(String reportViewID);
	
	/**
	 * 提交修改报告
	 * @param status
	 * @param report
	 */
	void submitMedicalReport(ReportStatusEnum status,MedicalReportModel report);
	
	AbstractDataSource<Expert> getExpertList(ExpertModel ExpertFilter,  String userName,String reportViewID);
	
	void transferExpert(String expertID,String reportViewID);


	ReportTemplateModel getReportModalById(String modalID);

}
