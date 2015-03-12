/**   
* @Title: ExpertService.java 
* @Package cn.fuego.remote.medical.expert.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:27:49 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.manage.service;

import java.util.List;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.manage.web.model.ImageModel;
import cn.fuego.remote.medical.manage.web.model.MedicalReportModel;
import cn.fuego.remote.medical.manage.web.model.ReportFilterModel;
import cn.fuego.remote.medical.manage.web.model.WorkStaticsModel;

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

    List<String> getLinkHosptialByExpert(String expertID);
    
    /**
     * 获取医院关联的专家ID
     * @param hospitalID
     * @return
     */
    List<String> getLinkExpertByHosptial(String hospitalID);

    
	public WorkStaticsModel getWorkStatics(String userName,ReportFilterModel filter);

}
