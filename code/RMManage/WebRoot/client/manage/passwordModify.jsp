<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div class="pageContent">
	
	<s:form method="post" action="login/login!modifyPwd.action" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>输入旧密码：</label>
				<input type="password" name="pwdModel.oldPassword" size="30" minlength="4" maxlength="20" class="required" />
			</div>
			<div class="unit">
				<label>输入新密码：</label>
				<input type="password" id="cp_newPassword" name="pwdModel.newPassword" size="30" minlength="4" maxlength="20" class="required alphanumeric"/>
			</div>
			<div class="unit">
				<label>再次确认新密码：</label>
				<input type="password" name="rnewPassword" size="30" equalTo="#cp_newPassword" class="required alphanumeric"/>
			</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提 交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取 消</button></div></div></li>
			</ul>
		</div>
	</s:form>
	
</div>