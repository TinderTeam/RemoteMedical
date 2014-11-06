<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageHeader">
	
	<s:form  id="pagerForm" action="user/HospitalManage" method="POST" onsubmit="return navTabSearch(this);">

		<input type="hidden" name="pageNum"  />
	    <input type="hidden" name="numPerPage"  />
	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					医院账号：<input type="text" name="filter.hospital.id" value="${filter.hospital.id}"/>
				</td>
				<td>
					医院名称：<input type="text" name="filter.hospital.name" value="${filter.hospital.name}" />
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
				<td>
				<s:submit  value="重 置" cssClass="mispButton primary"  onclick="resetForm(this.form) "></s:submit>
				</td>				    
			</tr>

		</table>

	</div>
	</s:form>
</div>
<div class="pageContent">

	<table class="table" width="100%" layoutH="88">
		<thead>
		
			<tr>
				<th width="100" align="center">医院账号</th>
				<th width="200" align="center">医院名称</th>
				<th width="100" align="center">规模</th>
				<th width="300" align="center">地点</th>
				<th width="100" align="center">联系人</th>
				<th width="100" align="center">联系电话</th>
				<th width="100" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${hospitalTable.currentPageData}"> 	
			<tr target="sid_user" rel="1">
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.rank}</td>
				<td>${e.address}</td>
				<td>${e.contacts}</td>
				<td>${e.contactsPhone}</td>
				<td>
					
					<a title="医院管理" target="navTab" href="HospitalManage!show.action?selectedID=${e.id}&operateType=edit&selectedMenuID=${selectedMenuID}" class="btnView" rel="Menu${selectedMenuID}">查看</a>

				
				</td>

			</tr>
		</c:forEach>			
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${hospitalTable.page}" scope="request"/>
			
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
