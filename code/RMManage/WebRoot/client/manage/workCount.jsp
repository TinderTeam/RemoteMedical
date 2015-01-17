<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
<div class="pageHeader" style="overflow-x: hidden;overflow-y: auto;">
	<form id="pagerForm"  onsubmit="return navTabSearch(this);" action="report/ReportManage!workCount.action" method="post">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${reportList.page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${reportList.page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
 
	<div class="searchBar">
 
		<table class="searchContent">
			<tr >

			  
				<td>
					<c:choose>
				    
				  <c:when test="${loginUser.accountType == 99 || loginUser.accountType==2}">  
				     
				    远程请求医院：<input type="text" name="filter.hospitalName" value="${filter.hospitalName}"/>
                  </c:when>
				   <c:otherwise> 
					远程请求医院： 
					<select name="filter.hospitalName"  >
					  <option value="">默认所有医院</option>
					  
					  <c:forEach var="name" items="${filter.hospitalNameList}">
					    <c:choose>
					        <c:when test="${name == filter.hospitalName}">  
	                             <option value="${name}" selected="selected">${name}</option>
							   </c:when>
							   <c:otherwise>  
							      <option value="${name}">${name}</option>
							</c:otherwise>
						 </c:choose>
 					  </c:forEach>
					</select>
					 </c:otherwise> 
				   </c:choose>	
				</td>
				<td class="dateRange">
				   
					<input id="startDate2" type="text" readonly="readonly" class="date" name="filter.startDate" value="${filter.startDate}" />
					<span class="limit">-</span>
					<input id="endDate2" type="text"  readonly="readonly" class="date" name="filter.endDate" value="${filter.endDate}" />
				</td>


				<td><span style="font-size:0.8em;color:red; font-style:italic;">*选择左侧日期查找条件</span>
				
                </td>
                <td>
               	    <div class="buttonActive" style="padding-right:30px;"><div class="buttonContent"><button type="submit" >查 询</button>	</div></div>
					<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="resetForm(this.form);">重 置</button></div></div>
				</td>
			 				
			</tr>
	 
		</table>

	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
 
	</div>

	<table class="table" id="tbCC" width="100%" layoutH="108">
		<thead>
			<tr>
				<th width="80" align="center">总数量</th>
				<th width="80" align="center">CR/DR数量</th>
				<th width="80" align="center">CT/数量</th>
				<th width="80" align="center">MR数量</th>
				<th width="80" align="center">专家费用</th>
				
			</tr>
		</thead>
		<tbody>

    
	        <tr target="sid_user" rel="1"  >
                <td>${workStatics.total}</td>
                <td>${workStatics.crCount}</td>
	            <td>${workStatics.ctCount}</td>
	            <td>${workStatics.mrCount}</td>
	            <td>${workStatics.cost}</td>
	            
	   
			</tr>
		 
			
		</tbody>
	</table>
	<div class="panelBar">
		 
	</div>
</div>
