<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String userName=request.getParameter("userName");
String operate=request.getParameter("operate");
 %> 
<script type="text/javascript">

	var operateType=$("#accountOperate").val();
	if(operateType=="logoff")
	{
		$("#logoff").css('display', 'block');
	}
	if(operateType=="logon")
	{
		$("#logon").css('display', 'block');
	}
</script>  
<div class="pageContent">
	
	<s:form method="post" action="login/login!accountManage.action" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
           <input type="hidden" size="30"  id="accountOperate" name="accountOperate" maxlength="64"  readonly="readonly" value="<%=operate%>"/>
			<div class="unit">
				<label>用户账号：</label>
				<input type="text" size="30" name="user.userName" maxlength="64"  readonly="readonly" value="<%=userName%>"/>
			</div>
			<div class="divider"></div>
			<div class="unit" style="text-align:center;">
			 <p  id="logoff" style="color:red;font-size:1.5em;display:none;">确定注销该账户？</p>
			 <p  id="logon" style="color:red;font-size:1.5em;display:none;">确定启用该账户？</p>
<!-- 				<label>用户状态：</label>
					<input id="logoff" type="text" size="30" name="" maxlength="64" readonly="readonly"  value="已注销" style="display:none;"/>
					<input id="logon" type="text" size="30" name="" maxlength="64" readonly="readonly"  value="已创建" style="display:none;"/>
	 -->
			</div>		

		
			<div id="errorMsg" style="color:red;"></div>
			
		</div>
		<div class="formBar">
			<ul>
				<li style="padding:0px 10px 0px 10px;"><div class="buttonActive"><div class="buttonContent"><button type="submit">确  定</button></div></div></li>
				<li style="padding:0px 10px 0px 10px;"><div class="button"><div class="buttonContent"><button type="button" class="close">取 消</button></div></div></li>
			</ul>
		</div>
	</s:form>
	
</div>