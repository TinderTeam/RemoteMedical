/**   
* @Title: ExpertServiceImpl.java 
* @Package cn.fuego.remote.medical.expert.service.impl 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-28 下午03:00:53 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.service.impl;

import java.util.List;

import cn.fuego.common.dao.datasource.AbstractDataSource;
import cn.fuego.common.dao.datasource.DataBaseSourceImpl;
import cn.fuego.misp.web.model.page.PageModel;
import cn.fuego.misp.web.model.page.TableDataModel;
import cn.fuego.remote.medical.constant.ReportStatusEnum;
import cn.fuego.remote.medical.dao.DaoContext;
import cn.fuego.remote.medical.dao.ReportDao;
import cn.fuego.remote.medical.domain.ReportView;
import cn.fuego.remote.medical.expert.service.ExpertService;
import cn.fuego.remote.medical.expert.web.model.ImageModel;
import cn.fuego.remote.medical.expert.web.model.MedicalReportModel;
import cn.fuego.remote.medical.expert.web.model.ReportQueryModel;

/** 
 * @ClassName: ExpertServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-28 下午03:00:53 
 *  
 */

public class ExpertServiceImpl implements ExpertService
{

	private ReportDao repertDao = DaoContext.getInstance().getReportDao();
	
	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#getMedicalList(java.lang.String, cn.fuego.remote.medical.expert.web.model.ReportQueryModel, cn.fuego.misp.web.model.page.PageModel)
	 */
	@Override
	public TableDataModel<ReportView> getMedicalList(String userName, ReportQueryModel queryModel, PageModel page)
	{
		TableDataModel<ReportView> reportTableData = new TableDataModel<ReportView>();
		
		reportTableData.setPage(page);
		
		AbstractDataSource<ReportView> dataSource = new DataBaseSourceImpl<ReportView>(ReportView.class);
		reportTableData.setDataSource(dataSource);
		
		
 		return reportTableData;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#getImageByMedical(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ImageModel> getImageByMedical(String seralNo, String hospitalID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.remote.medical.expert.service.ExpertService#submitMedicalReport(cn.fuego.remote.medical.constant.ReportStatusEnum, cn.fuego.remote.medical.expert.web.model.MedicalReportModel)
	 */
	@Override
	public void submitMedicalReport(ReportStatusEnum status, MedicalReportModel report)
	{
		// TODO Auto-generated method stub

	}

}
