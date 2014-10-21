<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
   
   $(function () {
		$.pdialog.resizeDialog({style: {width: 800}}, $.pdialog.getCurrent(), "");
        });//dialog 宽度重新定义

</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="user/ExpertManage!addExpert.action" onsubmit="return dwzSearch(this, 'dialog');">
		<input type="hidden" name="pageNum"  />
	    <input type="hidden" name="numPerPage"  />	
	<div class="searchBar">
		
		<table class="searchContent">
			<tr>
				<td>
					专家编号：<input type="text" name="filter.expert.id" value="${filter.expert.id}"/>
				</td>
				<td>
					专家姓名：<input type="text" name="filter.expert.name" value="${filter.expert.name}"/>
				</td>
				<td>
					职称类型：<input type="text" name="filter.expert.jobTitle" value="${filter.expert.name}"/>
				</td>				
			</tr>

		</table> 
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查 询</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="javascript:$(this.form)[0].reset();">重 置</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
<s:form    method="POST"  name="expertAddForm" action="user/ExpertManage" >
	<table class="table" layoutH="85" targetType="dialog" width="100%">
		<thead>
				
			<tr>
			
				<th width="100" align="center">专家编号</th>
				<th width="120" align="center">姓名</th>
				<th width="100" align="center">职称</th>
				<th width="100" align="center">工作医院</th>
				<th width="100" align="center">手机号码</th>
				<th width="50" align="center">添加</th>
			</tr>
		</thead>
		<tbody>

		<c:forEach var="e" items="${expertTable.currentPageData}"> 
			<tr target="sid_user" rel="${e.id}">
			
				<td>${e.id }</td>
				<td>${e.name}</td>
				<td>${e.jobTitle}</td>
				<td>${e.workPlace}</td>
				<td>${e.phoneNo}</td>
				<td>
					<a class="btnSelect"  href="javascript:$.bringBack({id:'${e.id}', name:'${e.name}'})" title="添加专家">选择</a>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
</s:form>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${expertTable.page}" scope="request"/>
			
			<select class="combox"  onchange="dwzPageBreak({targetType:'dialog',rel:'',data:{numPerPage:this.value}})">
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
		<div class="pagination" targetType="dialog" totalCount="${page.count}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.currentPage}"></div>
	</div>
</div>
