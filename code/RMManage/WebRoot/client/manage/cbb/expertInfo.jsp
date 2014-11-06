<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<input id="operateType" value="${operateType}" style="display:none;"/>
<script type="text/javascript">
   
    $(function () {
            $("#up1").uploadPreview({ Img: "ImgPr1" });
            $("#up2").uploadPreview({ Img: "ImgPr2" });
        });//图片预览js
    var operateType =$("#operateType").val();
    if(operateType=='check')
    {
   		 $('input,textarea',$('form[name=exForm]')).prop('readonly',true);
		 $("select").prop('disabled', true);
    }        

	
</script> 

<div class="pageContent" >

	<s:form method="post" name="exForm" action="user/ExpertManage" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this,navTabAjaxDone);" >
		<input type="text" name="selectedID" value="${selectedID}"  style="display:none;"/>	
		<input type="text" name="accountType" value="${loginUser.accountType}"  style="display:none;"/>	
		<input type="text" name="expertModel.expert.state" value="${expertModel.expert.state}"  style="display:none;"/>
	<div class="pageFormContent" layoutH="66" style="padding:10px 180px 20px 180px;">
		<div style="height:200px !important;">
		<span style="font-size:1.2em;"><strong>个人信息</strong></span>
		<div class="divider"></div>
		<div style="float:right; margin-top:5px; margin-right:16%;" >
			<div style="margin-bottom:5px; width:120px; height:140px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				<div ><img id="ImgPr1" src ="user/ExpertManage!getPhotoImag.action?picid=${expertModel.expert.id}" height="140" width="120" alt="个人照片" ></div>

			</div>
			<div >
				<s:file name="expertModel.exPhoto" id="up1"></s:file>
			</div>
			<span class="info">上传图片大小不得超过65KB</span> 
		</div>
	
			<dl style="width:50%;">
				<dt>专家编号：</dt>
				<dd><input type="text" name="expertModel.expert.id"  size="30" readonly="true" value="${expertModel.expert.id}"/></dd>
			</dl>
		
		
			<dl style="width:50%;">
				<dt>姓名：</dt>
				<dd><input type="text" size="30" class="required " name="expertModel.expert.name" value="${expertModel.expert.name}"/></dd>
			</dl>

			<dl style="width:50%;">
				<dt>性别：</dt>
				<dd>
				<select name="expertModel.expert.sex" >

						 <c:forEach var="us" items="${expertModel.userSexList}">
						  		 <c:choose>		       
							   		 <c:when test="${us.typeValue == expertModel.expert.sex}">  
	                            		       <option value="${us.typeValue}" selected='selected'> ${us.type}</option>
	                            		 
	                            	  </c:when>
							   		  <c:otherwise>  
							   	   			    <option value="${us.typeValue}" > ${us.type}</option>
							   		   </c:otherwise>
							   
						   		 </c:choose>
						  </c:forEach>				
		
				</select>
				</dd>
			</dl>
			
			<dl style="width:50%;">
				<dt>年龄：</dt>
				<dd><input type="text" size="30" name="expertModel.expert.age" value="${expertModel.expert.age}" class="digits" maxlength="3"/></dd>
			</dl>			
		</div>
		
		<div style="height:130px !important;">	
		<span style="font-size:1.2em;"><strong>联系方式</strong></span>
		<div class="divider"></div>
			<dl style="width:50%;">
				<dt>手机号码：</dt>			
				<dd><input type="text" name="expertModel.expert.phoneNo" class="phone" size="30"  value="${expertModel.expert.phoneNo}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>座机号码：</dt>			
				<dd><input type="text" name="expertModel.expert.telephoneNo"  class="telephone" size="30" value="${expertModel.expert.telephoneNo}"/></dd>
			</dl>	
			<dl style="width:50%;">
				<dt>电子邮箱：</dt>			
				<dd><input type="text" name="expertModel.expert.email" class="email" size="30" value="${expertModel.expert.email}"/></dd>
			</dl>				
			
			<dl style="width:50%;">
				<dt>QQ号码：</dt>			
				<dd><input type="text" name="expertModel.expert.qq" class="QQ"  size="30" value="${expertModel.expert.qq}"/></dd>
			</dl>			
			<dl style="width:50%;">
				<dt>微信号：</dt>			
				<dd><input type="text" name="expertModel.expert.weixin"  class="alphanumeric"  size="30" value="${expertModel.expert.weixin}"/></dd>
			</dl>					
			</div>

		<div style="height:200px !important;">	
		<span style="font-size:1.2em;"><strong>工作信息</strong></span>
		<div class="divider"></div>

				<dl  class="nowrap">
					<dt >专家简介：</dt>
					<dd ><textarea name="expertModel.expert.resume" cols="100" rows="7" maxlength="800">${expertModel.expert.resume}</textarea></dd>
				</dl>	

			<dl style="width:50%;">
				<dt>职称：</dt>			
				<dd><input type="text" name="expertModel.expert.jobTitle"  alt="" size="30" value="${expertModel.expert.jobTitle}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>擅长专业技能：</dt>			
				<dd><input type="text" name="expertModel.expert.expertise"  alt="" size="30" value="${expertModel.expert.expertise}"/></dd>
			</dl>				
			<dl  class="nowrap" >
				<dt >工作医院名称：</dt>			
				<dd><input type="text" name="expertModel.expert.workPlace"  alt="" size="98" value="${expertModel.expert.workPlace}"/></dd>
			</dl>


			
			<dl style="width:100%;">
				<dt>工作医院地点：</dt>
				<dd style="width:70%;"><input type="hidden" id="currentEProvince" value="${expertModel.expert.province}"/>
				<input type="hidden" id="currentECity" value="${expertModel.expert.city}"/>
				<input type="hidden" id="currentECounty" value="${expertModel.expert.county}"/>

				<select id="EeProvince" name="expertModel.expert.province" style="margin-left:0px;"></select>
				<select id="EeCity" name="expertModel.expert.city"></select>
				<select id="EeArea" name="expertModel.expert.county"></select>

				<script type="text/javascript">
					addressInit('EeProvince', 'EeCity', 'EeArea', document.getElementById("currentEProvince").value, document.getElementById("currentECity").value, document.getElementById("currentECounty").value);
	
				</script>
				</dd>
			</dl>
			
				<dl class="nowrap">
					<dt>补充描述：</dt>
					<dd><textarea name="expertModel.expert.remark" cols="100" rows="7" maxlength="800">${expertModel.expert.remark}</textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt>上传签名：</dt>
					<dd >
						<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:200px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
						<img id="ImgPr2" src ="user/ExpertManage!getSignNameImag.action?picid=${expertModel.expert.id}" height="70" width="200" id="img1" alt="签名照片">
						</div>	
						<span class="info">上传图片大小不得超过65KB</span>                           
					</dd>									
					<dd>
					<div style="padding-top:30px !important;">
					<s:file name="expertModel.signPic" id="up2"></s:file>
					</div>
					</dd>
				</dl>

			</div>
		
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >
				<c:choose>
					<c:when test="${operateType =='check'}">
						<li style="padding:0px 30px 0px 10px;"><s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit></li>
						<li style="padding:0px 30px 0px 10px;"><s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit></li>						
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${expertModel.expert.state == 0}">
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSubmit" value="提 交 " cssClass="mispButton primary"></s:submit></li>	
							</c:when>
							<c:otherwise>
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>
							</c:otherwise>
						
						</c:choose>
							<c:choose>
								<c:when test="${loginUser.accountType==1}">
									<li><input type="button" class="mispButton primary close" value="关 闭"/></li>
								</c:when>
								<c:otherwise>
									<li><s:submit method="cancel" value="返 回" cssClass="mispButton primary"></s:submit></li>
								</c:otherwise>
							</c:choose>
								
					</c:otherwise>
						
				</c:choose>	

				
			</ul>
		</div>
	</s:form>
	
</div>

