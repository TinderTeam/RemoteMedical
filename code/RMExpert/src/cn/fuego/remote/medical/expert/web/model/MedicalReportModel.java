/**   
* @Title: MedicalReportModel.java 
* @Package cn.fuego.remote.medical.expert.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-9-23 下午06:30:57 
* @version V1.0   
*/ 
package cn.fuego.remote.medical.expert.web.model;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.remote.medical.domain.ReportView;

/** 
 * @ClassName: MedicalReportModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-9-23 下午06:30:57 
 *  
 */

public class MedicalReportModel
{

	private ReportView reportView;
	 
	
	private List<ImageModel> imageList = new ArrayList<ImageModel>();;


 

	public ReportView getReportView()
	{
		return reportView;
	}


	public void setReportView(ReportView reportView)
	{
		this.reportView = reportView;
	}


	public List<ImageModel> getImageList()
	{
		return imageList;
	}


	public void setImageList(List<ImageModel> imageList)
	{
		this.imageList = imageList;
	}
 


}
