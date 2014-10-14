<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>




<div class="pageHeader">
	<s:form  id="pagerForm" action="user/ExpertManage" method="POST" onsubmit="return navTabSearch(this);" name="exSearch">
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
				<td>
					所在医院：<input type="text" name="filter.expert.workPlace" value="${filter.expert.workPlace}"/>
				</td>
				<td>
				  <s:submit  value="查 询" cssClass="mispButton primary"></s:submit>
				  <button type="button" onclick="javascript:$('#pagerForm')[0].reset();">重置</button>
				
				</td>				
			</tr>

		</table>
		<div class="subBar" style="display:none;">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查  询</button></div></div></li>
			<!-- <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> -->
			</ul>
		</div>
	</div>
	</s:form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="108">
		<thead>
			<tr>
				<th width="100" align="center">专家编号</th>
				<th width="120" align="center">姓名</th>
				<th width="100" align="center">职称</th>
				<th width="100" align="center">工作医院</th>
				<th width="100" align="center">手机号码</th>
				<th width="100" align="center">座机号码</th>
				<th width="100" align="center">邮件地址</th>
				<th width="100" align="center">查看详情</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${expertTable.currentPageData}"> 
			<tr target="sid_user" rel="1">
				<td>${e.id }</td>
				<td>${e.name}</td>
				<td>${e.jobTitle}</td>
				<td>${e.workPlace}</td>
				<td>${e.phoneNo}</td>
				<td>${e.telephoneNo}</td>
				<td>${e.email}</td>
				<td>
					
				<a title="专家管理" target="navTab" href="ExpertManage!show.action?selectedID=${e.id}" class="btnView" rel="expert${e.id}">查看</a>
				
				</td>
			</tr>
		</c:forEach>	
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${expertTable.page}" scope="request"/>
			
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

