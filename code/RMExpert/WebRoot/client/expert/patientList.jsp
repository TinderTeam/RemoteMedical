<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--  form id="pagerForm" method="post" action="expert/ReportManage">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="3" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="reportList.page.pageSize" value="20" />
	<input type="hidden" name="reportList.page.currentPage" value="${reportList.page.currentPage}" />
</form>-->


<div class="pageHeader">
	<form id="pagerForm"  onsubmit="return navTabSearch(this);" action="expert/ReportManage" method="post">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${reportList.page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${reportList.page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
 
	<div class="searchBar">

		<table class="searchContent">
			<tr >
				<td>
					患者姓名：<input type="text" name="filter.patientName" value="${filter.patientName}"/>
				</td>
				<td>
				 报告状态：
				</td>
				<td>
					<select class="combox" name="filter.exReportState"  >
					    <option value="ALL">默认所有状态</option>
						<c:forEach var="e" items="${filter.reportStatusList}">
						  <c:choose>
						       
							   <c:when test="${e.status == filter.exReportState}">  
	                             <option value="${e.status}" selected="selected">${e.status}</option>
							   </c:when>
							   <c:otherwise>  
							      <option value="${e.status}">${e.status}</option>
							   </c:otherwise>
						   </c:choose>
						</c:forEach>
 
					</select>
				</td>
				<td>
					设备类型：<input type="text" name="filter.modality" value="${filter.modality}"/>
				</td>
	
			</tr>
			
			<tr>
				<td class="dateRange">
					时间段:
					<input type="text" value="" readonly="readonly" class="date" name="filter.startDate" value="${filter.startDate}"/>
					<span class="limit">-</span>
					<input type="text" value="" readonly="readonly" class="date" name="filter.endDate" value="${filter.endDate}"/>
				</td>
				<td>
				 时间：
				</td>
				<td>
				   
					<select class="combox" >
						<option value="ALL">默认所有时间</option>
						<option value="today">今天</option>
						<option value="last3">近三天</option>
						<option value="last7">近七天</option>
					</select>
				</td>
				<td>
					医院名称：<input type="text" name="filter.hospitalName" value="${filter.hospitalName}" />
				</td>


				<td>
				<div class="buttonActive"><div class="buttonContent"><button type="submit" >查 询</button>	</div></div>
				<div class="buttonActive"><div class="buttonContent"><button type="button" onclick="javascript:$('#pagerForm')[0].reset();">重 置</button>	</div></div>
				
				</td>
				 
				
			</tr>
		</table>

	</div>
	</form>
</div>
<div class="pageContent" >
	<div class="panelBar">

	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80" align="center">处理状态</th>
				<th width="80" align="center">患者姓名</th>
				<th width="80" align="center">性别</th>
				<th width="80" align="center">年龄</th>
				<th width="100" align="center">检查部位</th>
				<th width="80" align="center">报告状态</th>
				<th width="150" align="center">检查设备</th>
				<th width="80" align="center">远程请求时间</th>
				<th width="120" align="center">远程请求医院</th>
				<th width="80" align="center">操作</th>
			</tr>
		</thead>
	<tbody>
	    <c:forEach var="e" items="${reportList.currentPageData}"> 		
	        <tr target="sid_user" rel="1"  >
	        	<td>
 	        		<c:choose>
 	        			<c:when test="${e.statusColor=='red'}">
 	        			<span class="label label-danger" >请及时处理</span>
 	        			</c:when>
 	        			
 	        			<c:when test="${e.statusColor=='grey'}">
 	        				<span class="label label-default" >已处理</span>
 	        			</c:when>
 	        			<c:otherwise>
 	        			<span class="label label-success" >待处理</span>
 	        			</c:otherwise> 	        			
 	        		</c:choose>
	        		
	        	</td>
	            <td>${e.patientName}</td>
	            <td>${e.patientSex}</td>
	            <td>${e.patientAge}</td>
	            <td>${e.bodyPart}</td>
	            <td>${e.exReportState}</td>
	            <td>${e.modality}</td>
	            <td>${e.exApply}</td>
	            <td>${e.exApplyDoctor}</td>	
	            <td>
 					<span ><a title="查看病人报告详情" target="navTab" rel="report" href="ReportManage!show.action?selectedID=${e.id}&operateType=show" class="btnEdit"></a></span>
					
				</td>
			</tr>
		</c:forEach>
 

		
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${reportList.page}" scope="request"/>
			
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