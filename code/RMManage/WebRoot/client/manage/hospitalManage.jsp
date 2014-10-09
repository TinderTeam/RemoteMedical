<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageHeader">
	
	<s:form action="user/HospitalManage" method="POST" onsubmit="return navTabSearch(this);">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					医院编号：<input type="text" name="filter.hospital.id" />
				</td>
				<td>
					医院名称：<input type="text" name="filter.hospital.name" />
				</td>
				<td style="display:none;">

				<select id="manageProvince" name="filter.hospital.province" style="margin-left:0px;"></select>
				<select id="manageCity" name="filter.hospital.city"></select>
				<select id="manageArea" name="filter.hospital.county"></select>

				<script type="text/javascript">
					addressInit('manageProvince', 'manageCity', 'manageArea');
	
				</script>
				</td>
				<td><s:submit  value="查 询" cssClass="mispButton primary"></s:submit>
				</td>
				
			</tr>

		</table>
		<div class="subBar " style="display:none;">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查  询</button></div></div></li>
				<!-- <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> -->
			</ul>
		</div>
	</div>
	</s:form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除</span></a></li>

		</ul>
	</div>
	<table class="table" width="100%" layoutH="118">
		<thead>
		
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl" style="margin-top:5px;"></th>
				<th width="100" align="center">医院编号</th>
				<th width="200" align="center">医院名称</th>
				<th width="100" align="center">规模</th>
				<th width="300" align="center">地点</th>
				<th width="100" align="center">联系人</th>
				<th width="100" align="center">联系电话</th>
				<th width="100" align="center">查看详情</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${hospitalTable.currentPageData}"> 	
			<tr target="sid_user" rel="1">
				<td><input name="ids" value="xxx" type="checkbox" style="margin-top:5px;"></td>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.rank}</td>
				<td>${e.address}</td>
				<td>${e.contacts}</td>
				<td>${e.contactsPhone}</td>
				<td>
					
					<a title="医院管理" target="navTab" href="HospitalManage!show.action?selectedID=${e.id}" class="btnView" rel="Menu8">查看</a>

				
				</td>
		</c:forEach>
			</tr>
			
			
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
			<span>条，共${hospitalTable.page.count}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${hospitalTable.page.count}" numPerPage="${hospitalTable.page.pageSize}" pageNumShown="10" currentPage="${hospitalTable.page.currentPage}"></div>

	</div>
</div>
