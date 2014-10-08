<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
		<s:form method="post" name="exForm" action="user/ExpertManage" class="pageForm required-validate"  >
		<div class="pageFormContent" layoutH="56">
		<div style="height:200px !important;">
		<span style="font-size:1.2em;"><strong>个人信息</strong></span>
		<div class="divider"></div>
		<div style=" float:right; display:block; margin-top:5px; margin-right:420px; overflow:hidden; width:150px; height:160px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			<div align="center" style="margin-top:10px;"><img src ="<%=basePath%>/client/uploads/img/head.jpg" height="140" width="130" ></div>

		</div>
			<p>
				<label>专家编号：</label>			
				<input type="text" name="expertModel.expert.id"  alt="" size="30" readonly="true" value="${expertModel.expert.id}"/>
			</p>			
		
			<p>
				<label>姓名：</label>
				<input type="text" size="30"  name="expertModel.expert.name" value="${expertModel.expert.name}" readonly="true"/>
			</p>

			<p>
				<label>性别：</label>
				<select name="sex" style="margin-left:0px;">
					<option value="${expertModel.expert.sex}">${expertModel.expert.sex}</option>

				</select>
			</p>
			<p>
				<label>年龄：</label>
				<input type="text" size="30" value="${expertModel.expert.age}" readonly="true"/>
			</p>			
		</div>
		
		<div style="height:130px !important;">	
		<span style="font-size:1.2em;"><strong>联系方式</strong></span>
		<div class="divider"></div>
			<p>
				<label>手机号码：</label>			
				<input type="text" name=""  size="30" value="${expertModel.expert.phoneNo}" readonly="true"/>
			<p>
			<p>
				<label>座机号码：</label>			
				<input type="text" name=""  size="30" value="${expertModel.expert.telephoneNo}" readonly="true"/>
			</p>	
			<p>
				<label>电子邮箱：</label>			
				<input type="text" name="email"  size="30" value="${expertModel.expert.email}" readonly="true"/>
			</p>				
			
			<p>
				<label>QQ号码：</label>			
				<input type="text" name=""   size="30" value="${expertModel.expert.qq}" readonly="true"/>
			</p>			
			<p>
				<label>微信号：</label>			
				<input type="text" name=""  size="30" value="${expertModel.expert.weixin}" readonly="true"/>
			</p>					
			</div>

		<div style="height:200px !important;">	
		<span style="font-size:1.2em;"><strong>工作信息</strong></span>
		<div class="divider"></div>

				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >专家简介：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="textarea1" cols="95" rows="7" readonly="true" >${expertModel.expert.resume}</textarea></dd>
				</dl>	

			<p>
				<label>职称：</label>			
				<input type="text" name=""  alt="" size="30" value="${expertModel.expert.jobTitle}" readonly="true"/>
			</p>
			<p>
				<label>擅长专业技能：</label>			
				<input type="text" name=""  alt="" size="30" value="${expertModel.expert.expertise}" readonly="true"/>
			</p>				
			<p style="width:700px !important;float:left;">
				<label>工作医院名称：</label>			
				<input type="text" name=""  alt="" size="30" value="${expertModel.expert.workPlace}" readonly="true"/>
			</p>
			<p style="width:700px !important;float:left;" >
				<label>工作医院地点：</label>	
				<select class="combox" name="province"  >
					<option value="0">${expertModel.expert.province}</option>

				</select>
				<select class="combox" name="city" >
					<option value="0">${expertModel.expert.city}</option>
				</select>
				<select class="combox" name="area">
					<option value="0">${expertModel.expert.county}</option>
				</select>
			</p>
			
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >补充描述：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="" cols="95" rows="7" readonly="true">${expertModel.expert.remark}</textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >签名：</dt>
					<dd style="float:left !important;padding-left:7px !important;">
						<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:170px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;"><img src ="<%=basePath%>/client/uploads/img/signature.png" height="50" width="150" ></div>
					</dd>

				</dl>
			
		</div>
		


		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >

				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关 闭</button></div></div></li>
			</ul>
		</div>
	</s:form>
</div>

