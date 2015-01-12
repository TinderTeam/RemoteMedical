<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function submitLiForm(url)
	{
    	var thisForm = document.linkForm;
		thisForm.action="user/ApprovalManage!"+url;
		return iframeCallback(thisForm,dialogAjaxDone);
	}		   
</script>
<div class="pageContent">
	<s:form method="post" action="user/ApprovalManage" class="pageForm required-validate" name="linkForm"   >
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
									
			<div id="errorMsg" style="color:red;"></div>
		</div>
		<div class="formBar">
			<ul style="margin-right:200px !important;" >
				<li style="padding:0px 30px 0px 10px;">
				<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitLiForm('applyAgree')">同 意</button></div></div>
				</li>
				<li style="padding:0px 30px 0px 10px;">
						<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitLiForm('applyRefuse')">拒 绝</button></div></div>
				</li>
			</ul>
		</div>
	</s:form>
</div>
