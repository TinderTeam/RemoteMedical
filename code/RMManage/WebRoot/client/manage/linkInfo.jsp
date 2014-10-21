<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<s:form method="post" action="user/ApprovalManage" class="pageForm required-validate" name="linkForm" onsubmit="return iframeCallback(this,dialogAjaxDone);"  >
		<input type="text" name="selectedID" value="${selectedID}"  style="display:none;"/>	
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>医院账户：</label>
				<input type="text" size="30" name="linkModel.link.hospitalID" class="readonly" readonly="true" value="${linkModel.link.hospitalID}"/>
			</div>
			<div class="unit">
				<label>专家账户：</label>
				<input type="text" size="30" name="linkModel.link.expertID" class="readonly" readonly="true" value="${linkModel.link.expertID}"/>
			</div>	
			<div class="unit">
				<label>关联申请时间：</label>
				<input type="text" size="30" name="linkModel.link.linkTime" class="readonly" readonly="true" value="${linkModel.link.linkTime}"/>
			</div>
<!--  		<div class="unit">
				<label>关联状态：</label>
				<input type="text" size="30" name="linkModel.link.linkState" class="readonly" readonly="true" value="${linkModel.link.linkState}"/>
			</div>	
-->											
			<div id="errorMsg" style="color:red;"></div>
		</div>
		<div class="formBar">
			<ul style="margin-right:200px !important;" >
					<li style="padding:0px 30px 0px 10px;"><s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit></li>
					<li style="padding:0px 30px 0px 10px;"><s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit></li>			
			</ul>
		</div>
	</s:form>
</div>
