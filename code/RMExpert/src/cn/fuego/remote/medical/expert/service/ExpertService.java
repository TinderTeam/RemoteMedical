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

import cn.fuego.misp.web.model.page.PageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.web.model.ImageModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportQueryModel;

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
	TableDataModel<ReportView> getMedicalList(String userName,ReportQueryModel queryModel,PageModel page);
	

	/**
	 * 获取报告下的图片列表
	 * @param seralNo
	 * @param hospitalID
	 * @return
	 */
	List<ImageModel> getImageByMedical(String seralNo,String hospitalID);
	
	/**
	 * 提交修改报告
	 * @param status
	 * @param report
	 */
	void submitMedicalReport(ReportStatusEnum status,MedicalReportModel report);

}
