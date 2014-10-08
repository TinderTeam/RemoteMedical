<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>




<div class="pageHeader">
	<s:form action="user/ExpertManage" method="POST" onsubmit="return navTabSearch(this);">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					专家编号：<input type="text" name="filter.expert.id" />
				</td>
				<td>
					专家姓名：<input type="text" name="filter.expert.name" />
				</td>
				<td>			
					<select class="combox" name="filter.expert.jobTitle">
						<option value="">职称类型</option>
						<option value="职称a">职称a</option>
						<option value="职称b">职称b</option>
					</select>
				</td>
				<td>			
					<select class="combox" name="filter.expert.workPlace">
						<option value="">所在医院</option>
						<option value="医院a">医院a</option>
						<option value="医院b">医院b</option>

					</select>
				</td>
				
			</tr>

		</table>
		<div class="subBar ">
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
			<select class="combox" name="numPerPage"  onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${expertTable.page.count}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${expertTable.page.count}" numPerPage="${expertTable.page.pageSize}" pageNumShown="10" currentPage="${expertTable.page.currentPage}"></div>

	</div>
</div>

