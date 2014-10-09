package cn.fuego.remote.medical.manage.web.model;

import java.io.File;

import cn.fuego.remote.medical.domain.Expert;

public class ExpertModel
{
	private Expert expert;
	private File signPic;
	private File exPhoto;

	
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


	
}
