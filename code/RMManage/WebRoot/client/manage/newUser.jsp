<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<s:form method="post" action="user/UserManage!create.action" class="pageForm required-validate" name="newForm" onsubmit="return iframeCallback(this,dialogAjaxDone);"  >
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>用户名称：</label>
				<input type="text" size="30" name="filter.userName" maxlength="64" class="required alphanumeric"/>
				<span class="info" >*字母、数字、下划线中的一种或几种组合格式</span>
			</div>
			<div class="divider"></div>
			<div class="unit">
				<label>账户类型：</label>
				<select  name="filter.accountType" >
						 <c:forEach var="ut2" items="${filter.userTypeList}">
						  		 <c:choose>		       
							   		 <c:when test="${ut2.type=='超级管理员'}">  

	                            	  </c:when>
							   		  <c:otherwise>  
							   	   			    <option value="${ut2.type}" > ${ut2.type}</option>
							   		  </c:otherwise>
							   
						   		 </c:choose>
						  </c:forEach>								

					</select>
			</div>		

		
			<div id="errorMsg" style="color:red;"></div>
		</div>
		<div class="formBar">
			<ul style="margin-right:200px !important;" >
				<li ><div class="buttonActive"><div class="buttonContent"><button type="submit">提 交</button></div></div></li>
				<li style="padding:0px 30px 0px 10px;"><div class="button"><div class="buttonContent"><button type="button" class="close">取 消</button></div></div></li>			
<!--  	<li style="padding:0px 30px 0px 10px;"><s:submit method="create" value="保 存" cssClass="mispButton primary"></s:submit></li>					
-->
			</ul>
		</div>
	</s:form>
</div>
