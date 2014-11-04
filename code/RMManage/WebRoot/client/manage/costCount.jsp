<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageHeader">
	<form id="pagerForm"  onsubmit="return navTabSearch(this);" action="report/ReportManage!costCount.action" method="post">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${reportList.page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${reportList.page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
 
	<div class="searchBar">
				<script type="text/javascript">

					//$('#days').attr('checked',checked);
					var range1= $("#startDate").val();
					var range2= $("#endDate").val();
					//alert(range1);
					if((range1!='')||(range2!=''))
					{
						$("#ck4").attr("checked",true);
						$("#ck3").attr("checked",false);
						$("#days").attr("disabled",true);
					}else
					{	 $("#ck3").attr("checked","checked");
						 $("#startDate,#endDate").attr("disabled",true);
				   		 $("#days").attr("disabled",false);
					}

				</script>
		<table class="searchContent">
			<tr >

				<td>
					报告状态：
					<select  name="filter.exReportState"  >
					    <option value="">默认所有状态</option>
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
				<td>
					医院名称：<input type="text" name="filter.hospitalName" value="${filter.hospitalName}" />
				</td>
				<td>
					病人姓名：<input type="text" name="filter.patientName" value="${filter.patientName}"/>
				</td>					
			</tr>
			
			<tr>

				<td>
				 <span><input id="ck3" type="radio" name="r1" style="width:25px;"  onclick="$('#startDate,#endDate').attr('disabled',true);$('#days').attr('disabled',false);$('#startDate,#endDate').val('');"/>时间:</span>				   
					<select name="filter.days" id="days">
						<option value="">默认所有时间</option>
						<c:forEach var="d" items="${filter.dayList}">
						  <c:choose>
						       
							   <c:when test="${d.day == filter.days}">  
	                             <option value="${d.day}" selected="selected">${d.day}</option>
							   </c:when>
							   <c:otherwise>  
							      <option value="${d.day}">${d.day}</option>
							   </c:otherwise>
						   </c:choose>
						</c:forEach>
					</select>
				</td>
				<td class="dateRange">
					<span><input id="ck4" type="radio" name="r1" style="width:25px;" onclick="$('#startDate,#endDate').removeAttr('disabled');$('#days').attr('disabled',true);$('#days').attr('checked',false);$('#days').val('');"/>时间段:</span>
					<input id="startDate" type="text" readonly="readonly" class="date" name="filter.startDate" value="${filter.startDate}" />
					<span class="limit">-</span>
					<input id="endDate" type="text"  readonly="readonly" class="date" name="filter.endDate" value="${filter.endDate}" />
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
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="150px" align="center">检查设备</th>
				<th width="120px" align="center">病人编号</th>
				<th width="100px" align="center">病人姓名</th>
				<th width="120px" align="center">病人性别</th>
				<th width="100px" align="center">病人年龄</th>
				<th width="150px" align="center">检查部位</th>
				<th width="120px" align="center">申请医生</th>
				<th width="120px" align="center">报告状态</th>
				<th width="150px" align="center">报告回传时间</th>
				<th width="120px" align="center">专家编号</th>
				<th width="120px" align="center">专家姓名</th>
				<th width="100px" align="center">医院编号</th>
				<th width="150px" align="center">医院名称</th>
				<th width="120px" align="center">专家收费</th>
				<th width="120px" align="center">医生诊断收费</th>
				
			</tr>
		</thead>
		<tbody>
       <c:forEach var="e" items="${reportList.currentPageData}"> 		
	        <tr target="sid_user" rel="1"  >
                <td>${e.modality}</td>
                <td>${e.patientID}</td>
	            <td>${e.patientName}</td>
	            <td>${e.patientSex}</td>
	            <td>${e.patientAge}</td>
	            <td>${e.bodyPart}</td>
	            <td>${e.exApplyDoctor}</td>	
	            <td>
	            	<c:forEach var="t" items="${filter.reportStatusList}">
						  <c:choose>		       
							   <c:when test="${t.statusValue == e.exReportState}">  
	                             ${t.status}
							   </c:when>
							   <c:otherwise>  
							   	   
							   </c:otherwise>
							   
						   </c:choose>
					</c:forEach>
	            </td>
	            <td>${e.exReport}</td>
	            
	            <td>${e.exDoctor}</td>
	            <td>${e.expertName}</td>
	            
	            <td>${e.hospitalID}</td>
	            <td>${e.hospitalName}</td>
	            
	            <td>${e.expertCost}</td>
	            <td>${e.hospitalCost}</td>
	   
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
