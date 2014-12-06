<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<input id="operateType" value="${operateType}" style="display:none;" />
<script type="text/javascript">
   
    $(function () 
    {
    	//图片预览js
        $("#up1").uploadPreview({ Img: "ImgPr1" });
        $("#up2").uploadPreview({ Img: "ImgPr2" });
        
        var text_width=$("#textW").width();
        //alert(text_width);
        $(".field").width(text_width+75 + "px");
        
        });
    var operateType =$("#operateType").val();
    if(operateType=='check')
    {
   		 $('input,textarea',$('form[name=exForm]')).prop('readonly',true);
		 $("select").prop('disabled', true);
    }        

	
</script>

<div class="pageContent">

	<s:form method="post" name="exForm" action="user/ExpertManage" class="pageForm required-validate" enctype="multipart/form-data"	onsubmit="return iframeCallback(this,navTabAjaxDone);">
		<input type="text" name="selectedID" value="${selectedID}"	style="display:none;" />
		<input type="text" name="accountType" value="${loginUser.accountType}"	style="display:none;" />
		<input type="text" name="expertModel.expert.state"	value="${expertModel.expert.state}" style="display:none;" />
		<div class="pageFormContent" layoutH="78"	style="padding:0px 20px 40px 80px;">
			<div style="margin-top:20px;">
				<fieldset class="field">
					<legend style="font-size:1.2em;"><strong>个人信息</strong></legend>
					<div style="float:right; margin-top:5px; margin-right:16%;">
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
					<p>
						<label>专家编号：</label> 
						<input name="expertModel.expert.id" type="text" size="30" value="${expertModel.expert.id}" readonly="readonly" />
					</p>
					<p>
						<label>姓名：</label> 
						<input type="text" size="30" class="required" name="expertModel.expert.name" value="${expertModel.expert.name}" />
					</p>
					<p>
						<label>性别：</label> <select name="expertModel.expert.sex">

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
					</p>
					<p>
						<label>年龄：</label>
						<input type="text" size="30" name="expertModel.expert.age" value="${expertModel.expert.age}" class="digits" maxlength="3" />
					</p>
				</fieldset>
			</div>

			<div style="margin-top:20px;">
				<fieldset class="field">
					<legend style="font-size:1.2em;"><strong>联系方式</strong></legend>
					<p>
						<label>手机号码：</label> 
						<input type="text" name="expertModel.expert.phoneNo" class="phone" size="30" value="${expertModel.expert.phoneNo}" />
					</p>
					<p>
						<label>座机号码：</label> 
						<input type="text"	name="expertModel.expert.telephoneNo" class="telephone" size="30" value="${expertModel.expert.telephoneNo}" />
					</p>
					<p>
						<label>电子邮箱：</label> 
						<input type="text"	name="expertModel.expert.email" class="email" size="30"	value="${expertModel.expert.email}" />
					</p>
					<p>
						<label>QQ号码：</label>
						 <input type="text" name="expertModel.expert.qq" class="QQ" size="30" value="${expertModel.expert.qq}" />
					</p>
					<p>
						<label>微信号：</label>
						<input type="text"	name="expertModel.expert.weixin" size="30" value="${expertModel.expert.weixin}" />
					</p>
				</fieldset>
			</div>

			<div style="margin-top:20px; margin-bottom:40px;">
				<fieldset  class="field">
					<legend style="font-size:1.2em;margin:0 -7px;"><strong>工作信息</strong></legend>
					<dl class="nowrap">
						<dt>专家简介：</dt>
						<dd>
						<textarea name="expertModel.expert.resume" cols="100" rows="7" maxlength="2000" id="textW">${expertModel.expert.resume}</textarea>
						<span class="info" >*最多可输入2000个字符</span>
						</dd>
					</dl>
					<p>
						<label>职称：</label> 
						<input type="text" name="expertModel.expert.jobTitle"  size="30"	alue="${expertModel.expert.jobTitle}" />
					</p>
					<p>
						<label>擅长专业技能：</label>
						<input type="text" name="expertModel.expert.expertise" size="30" value="${expertModel.expert.expertise}" />
					</p>
					<p class="nowrap">
						<label>工作医院名称：</label> 
						<input type="text" name="expertModel.expert.workPlace" size="98"	value="${expertModel.expert.workPlace}" />
					</p>
					<p class="nowrap">
						<label>工作医院地点：</label> 
						<input type="hidden" id="currentEProvince" value="${expertModel.expert.province}" />
						<input type="hidden" id="currentECity" value="${expertModel.expert.city}" /> 
						<input type="hidden" id="currentECounty" value="${expertModel.expert.county}" />
						
						<select id="EeProvince" name="expertModel.expert.province" style="margin-left:0px;"></select>
						
						<select id="EeCity" name="expertModel.expert.city"></select> 
						
						<select id="EeArea" name="expertModel.expert.county"></select>

				<script type="text/javascript">
					addressInit('EeProvince', 'EeCity', 'EeArea', document.getElementById("currentEProvince").value, document.getElementById("currentECity").value, document.getElementById("currentECounty").value);
	
				</script>
					</p>

					<dl class="nowrap">
						<dt>补充描述：</dt>
						<dd>
						<textarea name="expertModel.expert.remark" cols="100" rows="7" maxlength="2000">${expertModel.expert.remark}</textarea>
						<span class="info" >*最多可输入2000个字符</span>
						</dd>
					</dl>
					<dl style="height:110px !important;width:100%;">
						<dt>上传签名：</dt>
						<dd>
							<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:200px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
								<img id="ImgPr2" src="user/ExpertManage!getSignNameImag.action?picid=${expertModel.expert.id}" height="70" width="200" id="img1" alt="签名照片">
							</div>
							<span class="info">上传图片大小不得超过65KB</span>
						</dd>
						<dd>
							<div style="padding-top:30px !important;">
								<s:file name="expertModel.signPic" id="up2"></s:file>
							</div>
						</dd>
					</dl>
				</fieldset>
			</div>

		</div>
		<div class="formBar" style="padding-bottom:10px;">
			<ul style="float:none!important;margin-left:35%">
				<c:choose>
					<c:when test="${operateType =='check'}">
						<li style="padding:0px 30px 0px 10px;">
						<s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit>
						</li>
						<li style="padding:0px 30px 0px 10px;">
						<s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit>
						</li>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${expertModel.expert.state == 0}">
								<li style="padding:0px 30px 0px 10px;">
								<s:submit method="infoSubmit" value="提 交 " cssClass="mispButton primary"></s:submit>
								</li>
							</c:when>
							<c:otherwise>
								<li style="padding:0px 30px 0px 10px;">
								<s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit>
								</li>
							</c:otherwise>

						</c:choose>
							<li><s:submit method="cancel" value="返 回" cssClass="mispButton primary"></s:submit></li>
		<%-- 				<c:choose>
							<c:when test="${loginUser.accountType==1}">
								<li><input type="button" class="mispButton primary close" value="关 闭" /></li>
							</c:when>
							<c:otherwise>
								<li><s:submit method="cancel" value="返 回" cssClass="mispButton primary"></s:submit></li>
							</c:otherwise>
						</c:choose> --%>

					</c:otherwise>

				</c:choose>


			</ul>
		</div>
	</s:form>

</div>

