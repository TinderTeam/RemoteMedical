<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>


<script type="text/javascript">
   
    $(function () 
    {
        
        var text_width=$("#extextW").width();

        $(".exfield").width(text_width+120 + "px");
        });

   		 $('input,textarea',$('form[name=exForm2]')).prop('readonly',true);
		 $("select").prop('disabled', true);
    
function submitExForm2(url){
    var thisForm = document.exForm2;
	thisForm.action="user/ExpertManage!"+url;
	return iframeCallback(thisForm,navTabAjaxDone);
	
}	
</script>

<div class="pageContent">

	<s:form method="post" name="exForm2" action="user/ExpertManage" class="pageForm required-validate" enctype="multipart/form-data">
		<input type="text" name="selectedID" value="${selectedID}"	style="display:none;" />
		<input type="text" name="accountType" value="${loginUser.accountType}"	style="display:none;" />
		<input type="text" name="expertModel.expert.state"	value="${expertModel.expert.state}" style="display:none;" />
		<div class="pageFormContent" layoutH="78"	style="padding:0px 20px 40px 80px;"> 
				
			<div style="margin-top:20px;margin-bottom:20px;">
				<fieldset class="exfield">
					<legend style="font-size:1.2em;"><strong>个人信息</strong></legend>
					
					<div style="float:right; margin-top:5px; margin-right:6%;width:40%;">
						<div
							style="margin-bottom:5px; width:120px; height:140px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
							<div>
								<img id="ImgPr1" src="user/ExpertManage!getPhotoImag.action?picid=${expertModel.expert.id}" height="140" width="120" alt="个人照片">
							</div>

						</div>
						<div>
							<s:file name="expertModel.exPhoto" id="up1"></s:file>
						</div>
						<span class="info">上传图片大小不得超过65KB</span>
					</div>
					<div style="float:left; margin-top:5px;width:45%; " class="pageFormContent nowrap"  >
					<dl style="clear:none;">
						<dt style="width:20%;">专家编号：</dt> 
						<dd style="width:70%;"><input name="expertModel.expert.id" type="text" size="30" value="${expertModel.expert.id}" readonly="readonly" />
						</dd>
					</dl>
					<dl style="clear:none;">
						<dt style="width:20%;">姓名：</dt> 
						<dd style="width:70%;"><input type="text" size="30" class="required" name="expertModel.expert.name" value="${expertModel.expert.name}" maxlength="32" />

						</dd>
					</dl>
					<dl style="clear:none;">
						<dt style="width:20%;">性别：</dt>
						<dd style="width:70%;">
						 <select name="expertModel.expert.sex">

							<c:forEach var="us" items="${expertModel.userSexList}">
								<c:choose>
									<c:when test="${us.typeValue == expertModel.expert.sex}">
										<option value="${us.typeValue}" selected='selected'>${us.type}</option>
									</c:when>
									<c:otherwise>
										<option value="${us.typeValue}">${us.type}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>

						</select>
						</dd>
					</dl>
					<dl style="clear:none;">
						<dt style="width:20%;">年龄：</dt>
						<dd style="width:70%;"><input type="text" size="30" name="expertModel.expert.age" value="${expertModel.expert.age}" class="digits" maxlength="3" />
						</dd>
					</dl>
					</div>
				</fieldset>
			</div>

			
				<fieldset class="exfield">
					<legend style="font-size:1.2em;"><strong>联系方式</strong></legend>
					<div style="height:140px;overflow:hidden !important;" class="pageFormContent nowrap"  >
					<dl style="width:45%;clear:none;">
						<dt style="width:20% ">手机号码：</dt> 
						<dd style="width:75% "><input type="text" name="expertModel.expert.phoneNo" class="mobilephone required"  maxlength="16" size="30" value="${expertModel.expert.phoneNo}" />
						</dd>
					</dl>
					<dl style="width:45%;clear:none; ">
						<dt style="width:20% ">座机号码：</dt> 
						<dd style="width:75% "><input type="text"	name="expertModel.expert.telephoneNo" class="telephone" maxlength="32" size="30" value="${expertModel.expert.telephoneNo}" />
						</dd>
					</dl>
					<dl style="width:45%;clear:none; ">
						<dt style="width:20% ">电子邮箱：</dt> 
						<dd style="width:75% "><input type="text"	name="expertModel.expert.email" class="email" maxlength="64" size="30"	value="${expertModel.expert.email}" />
						</dd>
					</dl>
					<dl style="width:45%;clear:none; ">
						<dt style="width:20% ">QQ号码：</dt>
						<dd style="width:75% "><input type="text" name="expertModel.expert.qq" class="QQ" maxlength="16" size="30" value="${expertModel.expert.qq}" />
						</dd>
					</dl>
					<dl style="width:45%;clear:none; ">
						<dt style="width:20% ">微信号：</dt>
						<dd style="width:75% "><input type="text" 	name="expertModel.expert.weixin"  maxlength="32" size="30" value="${expertModel.expert.weixin}" />
						</dd>
					</dl>
					</div>
				</fieldset>
			

			<div style="margin-top:20px; margin-bottom:40px;">
				<fieldset  class="exfield">
					<legend style="font-size:1.2em;margin:0 -7px;"><strong>工作信息</strong></legend>
					<div style="height:500px;overflow:hidden !important;" class="pageFormContent nowrap"  >
					<dl class="nowrap">
						<dt style="width:10%;">专家简介：</dt>
						<dd>
						<textarea name="expertModel.expert.resume" cols="100" rows="7" maxlength="2000" id="extextW">${expertModel.expert.resume}</textarea>
						<span class="info" >*最多可输入2000个字符</span>
						</dd>
					</dl>
					<dl style="width:45%;clear:none;">
						<dt style="width:22%;">职称：</dt> 
						<dd style="width:70%;"><input type="text" name="expertModel.expert.jobTitle" maxlength="32" size="30"	value="${expertModel.expert.jobTitle}" />
						</dd>
					</dl>
					<dl style="width:45%;clear:none;">
						<dt style="width:25%;">擅长专业技能：</dt>
						<dd style="width:70%;"><input type="text" name="expertModel.expert.expertise" maxlength="128" size="30" value="${expertModel.expert.expertise}" />
						<dd>
					</dl>
					<dl class="nowrap">
						<dt style="width:10%;">工作医院名称：</dt> 
						<dd><input type="text" name="expertModel.expert.workPlace" size="111"	value="${expertModel.expert.workPlace}" maxlength="64"/>
						</dd>
					</dl>
					<dl class="nowrap">
						<dt style="width:10%;">工作医院地点：</dt> 
						<dd><input type="hidden" id="currentCEProvince" value="${expertModel.expert.province}" />
						<input type="hidden" id="currentCECity" value="${expertModel.expert.city}" /> 
						<input type="hidden" id="currentCECounty" value="${expertModel.expert.county}" />
						
						<select id="CEeProvince" name="expertModel.expert.province" style="margin-left:0px;"></select>
						
						<select id="CEeCity" name="expertModel.expert.city"></select> 
						
						<select id="CEeArea" name="expertModel.expert.county"></select>

				<script type="text/javascript">
					addressInit('CEeProvince', 'CEeCity', 'CEeArea', document.getElementById("currentCEProvince").value, document.getElementById("currentCECity").value, document.getElementById("currentCECounty").value);
	
				</script>
						</dd>
					</dl>

					<dl class="nowrap">
						<dt style="width:10%;">补充描述：</dt>
						<dd>
						<textarea name="expertModel.expert.remark" cols="100" rows="7" maxlength="2000">${expertModel.expert.remark}</textarea>
						<span class="info" >*最多可输入2000个字符</span>
						</dd>
					</dl>
					<dl class="nowrap" style="height:110px !important;">
						<dt style="width:10%;">上传签名：</dt>
						<dd style="width:30%;clear:none;">
							<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:200px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
								<img id="ImgPr2" src="user/ExpertManage!getSignNameImag.action?picid=${expertModel.expert.id}" height="70" width="200" id="img1" alt="签名照片">
							</div>
							
						</dd>
						<dd style="width:40%;clear:none;">
							<div style="padding-top:30px !important;">
								<s:file name="expertModel.signPic" id="up2"></s:file>
							</div>
							<span class="info">上传图片大小不得超过65KB</span>
						</dd>
					</dl>
					</div>
				</fieldset>
			</div>

		</div>
		<div class="formBar" style="padding-bottom:10px;">
			<ul style="float:none!important;margin-left:35%">

				<li style="padding:0px 30px 0px 10px;"><!-- <s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit> -->
				<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitExForm2('applyAgree')">同 意</button></div></div>
				</li>
				<li style="padding:0px 30px 0px 10px;"><!-- <s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit> -->
						<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitExForm2('applyRefuse')">拒 绝</button></div></div>
				</li>



			</ul>
		</div>
	</s:form>

</div>