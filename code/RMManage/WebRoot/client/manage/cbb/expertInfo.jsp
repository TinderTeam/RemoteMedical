<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="pageContent">

		<s:form method="post" name="exForm" action="user/ExpertManage" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this);" >
		<div class="pageFormContent" layoutH="56">
		<div style="height:200px !important;">
		<span style="font-size:1.2em;"><strong>个人信息</strong></span>
		<div class="divider"></div>
		<div style=" float:right; display:block; margin-top:5px; margin-right:420px; overflow:hidden; width:200px; height:180px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			<div align="center"><img src ="user/ExpertManage!getPhotoImag.action?picid=${expertModel.expert.id}" height="140" width="130" ></div>
			<div class="divider"></div>
			<s:file name="expertModel.exPhoto" ></s:file>
		</div>
	
			<dl>
				<dt>专家编号：</dt>
				<dd><input type="text" name="expertModel.expert.id"  alt="" size="30" readonly="true" value="${expertModel.expert.id}"/></dd>
			</dl>
		
		
			<dl>
				<dt>姓名：</dt>
				<dd><input type="text" size="30" class="required " name="expertModel.expert.name" value="${expertModel.expert.name}"/></dd>
			</dl>

			<dl>
				<dt>性别：</dt>
				<dd>
				<select name="expertModel.expert.sex" class="required combox">
         	<c:choose>
                <c:when test="${expertModel.expert.sex!=NULL}">
						<option value="${expertModel.expert.sex}">${expertModel.expert.sex}</option>
                </c:when>
                <c:otherwise>
                    <option value="NULL">请选择性别</option>
                </c:otherwise>
         	</c:choose>	
         			<option value="M">男</option>
					<option value="W" >女</option>
					<option value="O" >O</option>				
				</select>
				</dd>
			</dl>
			
			<dl>
				<dt>年龄：</dt>
				<dd><input type="text" size="30" name="expertModel.expert.age" value="${expertModel.expert.age}"/></dd>
			</dl>			
		</div>
		
		<div style="height:130px !important;">	
		<span style="font-size:1.2em;"><strong>联系方式</strong></span>
		<div class="divider"></div>
			<dl>
				<dt>手机号码：</dt>			
				<dd><input type="text" name="expertModel.expert.phoneNo" class="phone" size="30"  value="${expertModel.expert.phoneNo}"/></dd>
			</dl>
			<dl>
				<dt>座机号码：</dt>			
				<dd><input type="text" name="expertModel.expert.telephoneNo"  alt="" size="30" value="${expertModel.expert.telephoneNo}"/></dd>
			</dl>	
			<dl>
				<dt>电子邮箱：</dt>			
				<dd><input type="text" name="expertModel.expert.email" class="required email" size="30" value="${expertModel.expert.email}"/></dd>
			</dl>				
			
			<dl>
				<dt>QQ号码：</dt>			
				<dd><input type="text" name="expertModel.expert.qq"  alt="" size="30" value="${expertModel.expert.qq}"/></dd>
			</dl>			
			<dl>
				<dt>微信号：</dt>			
				<dd><input type="text" name="expertModel.expert.weixin"  alt="" size="30" value="${expertModel.expert.weixin}"/></dd>
			</dl>					
			</div>

		<div style="height:200px !important;">	
		<span style="font-size:1.2em;"><strong>工作信息</strong></span>
		<div class="divider"></div>

				<dl  class="nowrap">
					<dt >专家简介：</dt>
					<dd ><textarea name="expertModel.expert.resume" cols="95" rows="7" >${expertModel.expert.resume}</textarea></dd>
				</dl>	

			<dl>
				<dt>职称：</dt>			
				<dd><input type="text" name="expertModel.expert.jobTitle"  alt="" size="30" value="${expertModel.expert.jobTitle}"/></dd>
			</dl>
			<dl>
				<dt>擅长专业技能：</dt>			
				<dd><input type="text" name="expertModel.expert.expertise"  alt="" size="30" value="${expertModel.expert.expertise}"/></dd>
			</dl>				
			<dl style="width:100%;" >
				<dt >工作医院名称：</dt>			
				<dd><input type="text" name="expertModel.expert.workPlace"  alt="" size="30" value="${expertModel.expert.workPlace}" readonly="true"/></dd>
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
					<dd><textarea name="expertModel.expert.remark" cols="95" rows="7" >${expertModel.expert.remark}</textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt>上传签名：</dt>
					<dd >
						<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:170px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
						<img src ="user/ExpertManage!getSignNameImag.action?picid=${expertModel.expert.id}" height="50" width="150" id="img1">
						</div>	                           
					</dd>									
					<dd>
					<div style="padding-top:30px !important;">
					<s:file name="expertModel.signPic" ></s:file>
					</div>
					</dd>
				</dl>

			</div>
		
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >

				<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>			
				<li><input type="button" class="mispButton primary close" value="关 闭" /></li>
				
			</ul>
		</div>
	</s:form>
</div>

