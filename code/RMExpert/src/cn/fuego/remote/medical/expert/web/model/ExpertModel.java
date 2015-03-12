package cn.fuego.remote.medical.expert.web.model;

import java.io.File;

import cn.fuego.remote.medical.constant.UserSexEnum;
import cn.fuego.remote.medical.constant.UserTypeEnum;
import cn.fuego.remote.medical.domain.Expert;

/**
 * 
* @ClassName: ExpertModel 
* @Description: 专家相关信息
* @date 2015-3-9 上午10:40:25 
*
 */
public class ExpertModel
{
	private Expert expert;
	private File signPic;
	private File exPhoto;
	private UserSexEnum[] userSexList = UserSexEnum.values();
	
	public Expert getExpert()
	{
		return expert;
	}

	public void setExpert(Expert expert)
	{
		this.expert = expert;
	}

	public File getSignPic()
	{
		return signPic;
	}

	public void setSignPic(File signPic)
	{
		this.signPic = signPic;
	}

	public File getExPhoto()
	{
		return exPhoto;
	}

	public void setExPhoto(File exPhoto)
	{
		this.exPhoto = exPhoto;
	}

	public UserSexEnum[] getUserSexList()
	{
		return userSexList;
	}

	public void setUserSexList(UserSexEnum[] userSexList)
	{
		this.userSexList = userSexList;
	}


	
}
