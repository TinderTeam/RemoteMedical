<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">

function submitForm(url){
    var thisForm = document.userForm;
	thisForm.action="user/UserManage!"+url;
	return validateCallback(thisForm,navTabAjax);
}

</script>
<div class="pageHeader" style="overflow-x: hidden;overflow-y: auto;">
	<s:form  id="pagerForm"  onsubmit="return navTabSearch(this);" action="user/UserManage" method="post" name="userSearch">
		<input type="hidden" name="pageNum" value="${pageNum}" />
	    <input type="hidden" name="numPerPage" value="${numPerPage}" />
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>

				<td>
					用户名称：<input type="text" name="filter.userName" value="${filter.userName}" id="userName"/>
				</td>				
				<td>
					账户类型：
					<select  name="filter.accountType" id="mySelect">
						 <option value="">所有类型</option>

					 <c:forEach var="ut2" items="${filter.userTypeList}">
						  		 <c:choose>		       
							   		 <c:when test="${ut2.type == filter.accountType}">  
	                            		       <option value="${ut2.type}" selected='selected'> ${ut2.type}</option>
	                            		 
	                            	  </c:when>
							   		  <c:otherwise>  
							   	   			    <option value="${ut2.type}" > ${ut2.type}</option>
							   		   </c:otherwise>
							   
						   		 </c:choose>
						  </c:forEach>								
				 											

					</select>
				</td>

				<td class="dateRange">
					注册时间:
					<input type="text"  readonly="readonly" class="date" name="filter.startDate" value="${filter.startDate}"/>
					<span class="limit">-</span>
					<input type="text"  readonly="readonly" class="date" name="filter.endDate" value="${filter.endDate}"/>
				</td>
				<td>
					<s:submit  value="查 询" cssClass="mispButton primary"></s:submit>
				</td>
				<td>
					<s:submit  value="重 置" cssClass="mispButton primary"  onclick="resetForm(this.form) "></s:submit>
				</td>				
			</tr>
		</table>

	</div>
	</s:form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="UserManage!newUser.action" target="dialog" mask="true" title="新增用户"><span>新增用户</span></a></li>
			<li><a class="delete" href="UserManage!deleteList.action" onclick="submitForm('deleteList')" target="selectedTodo" rel="selectedIDList" title="确定要删除所选信息吗?"><span>删除用户</span></a></li>
		</ul>
	</div>
	<s:form  id="userForm"  method="POST"  name="userForm" >
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="5%" align="center"><input type="checkbox" group="selectedIDList" class="checkboxCtrl" style="margin:5px;"></th>
				<th width="20%" align="center">用户编号</th>
				<th width="25%" align="center">用户名称</th>
				<th width="20%" align="center">账号类型</th>
				<th width="30%" align="center">注册时间</th>
			</tr>
		</thead>
		
		<tbody>
		
		<c:forEach var="e" items="${userTable.currentPageData}"> 
			
			<tr target="sid_user" rel="${e.userID}">
				<td><input name="selectedIDList" value="${e.userID}" type="checkbox" style="margin:5px;"></td>
				<td>${e.userID}</td>
				<td>${e.userName}</td>
				<td>
						<c:forEach var="t" items="${filter.userTypeList}">
						  <c:choose>		       
							   <c:when test="${t.typeValue == e.accountType}">  
	                             ${t.type}
							   </c:when>
							   <c:otherwise>  
							   	   
							   </c:otherwise>
							   
						   </c:choose>
						   </c:forEach>
						
 				</td>
				<td>${e.regDate}</td>
			</tr>
		</c:forEach>	
	
		</tbody>
		
	</table>
	</s:form>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${userTable.page}" scope="request"/>
			
			<select class="combox" onchange="navTabPageBreak({numPerPage:this.value})">
				<c:forEach var="e" items="${page.pageSizeList}"> 	
			       <c:if test="${e==page.pageSize}">
			         <option value="${e}" selected>${e}</option>
				  </c:if>
                  <c:if test="${e!=page.pageSize}">
			         <option value="${e}">${e}</option>
				  </c:if>
				</c:forEach>
 
			</select>
			<span>条，共${page.count}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.count}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.currentPage}"></div>

	</div>
</div>


