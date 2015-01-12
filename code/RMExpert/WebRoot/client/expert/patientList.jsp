<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<div class="pageHeader" style="overflow-x: hidden;overflow-y: auto;">
	<form id="pagerForm"  onsubmit="return navTabSearch(this);" action="expert/ReportManage" method="post">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="${reportList.page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${reportList.page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
 
	<div class="searchBar">
				<script type="text/javascript">

					function changeMode(mode)
					{ 
					   if(mode== 0)
					   {
					      $('#startDate,#endDate').attr('disabled',true);
                          $('#days').attr('disabled',false);
                          $('#startDate,#endDate').val('');		
					   }
					   else
					   {
					      $('#startDate,#endDate').removeAttr('disabled');
					      $('#days').attr('disabled',true);
					      $('#days').attr('checked',false);$('#days').val('');
					   } 
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
					设备类型： 
					<select name="filter.modality">
						<option value="">默认所有类型</option>
						<c:forEach var="e" items="${filter.deviceTypeList}">
						  <c:choose>
						       
							   <c:when test="${e == filter.modality}">  
	                             <option value="${e}" selected="selected">${e}</option>
							   </c:when>
							   <c:otherwise>  
							      <option value="${e}">${e}</option>
							   </c:otherwise>
						   </c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
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
				</td>
				<td>
					病人姓名：<input type="text" name="filter.patientName" value="${filter.patientName}"/>
				</td>					
			</tr>
			
			<tr>

				<td>
				 
				 
				   <c:if test="${filter.mode == 0}">
				   		<span><input id="ck1" type="radio" name="filter.mode" style="width:25px;" value="0" checked="checked" onclick="changeMode(0);"/>远程请求医时间:</span>	
				   </c:if>
				   <c:if test="${filter.mode == 1}">
				   		<span><input id="ck1" type="radio" name="filter.mode" style="width:25px;" value="0" onclick="changeMode(0);"/>远程请求医时间:</span>	
				   </c:if>
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
				   <c:if test="${filter.mode == 0}">
					<span><input id="ck2" type="radio" name="filter.mode" style="width:25px;" value="1"  onclick="changeMode(1);"/>时间段:</span>
					  <script>
                          changeMode(0);			  
                       </script>
				   </c:if>	
				   <c:if test="${filter.mode == 1}">
					<span><input id="ck2" type="radio" name="filter.mode" style="width:25px;" value="1"  checked="checked" onclick="changeMode(1);"/>时间段:</span>
					  <script>
					      changeMode(1);			
					  </script>
				   </c:if>	
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
				<th width="100" align="center">远程请求时间</th>
				<th width="120" align="center">远程请求医院</th>
				<th width="120" align="center">远程请求医生</th>
				<th width="80" align="center">操作</th>
			</tr>
		</thead>
	<tbody>
	    <c:forEach var="e" items="${reportList.currentPageData}"> 		
	        <tr target="sid_user" rel="1"  >
	        	
 	        		<c:choose>
 	        			<c:when test="${e.statusColor=='red'}">
 	        		      <td bgcolor="red" style="color:white;">	
 	        		        请尽快处理
 	        		      </td>
 	        			</c:when>
 	        			
 	        			<c:when test="${e.statusColor=='grey'}">
 	        		<td bgcolor="green" style="color:white;">	
 	        		     已处理    </td>
 	        			</c:when>
 	        			<c:otherwise>
 	        		<td bgcolor="green" style="color:white;">	        		      
 	        			 待处理 	        			  
 	        	     </td>
 	        			</c:otherwise> 	        			
 	        		</c:choose>
	        		
	        	
	            <td>${e.patientName}</td>
	            <td>${e.disPatientSex}</td>
	            <td>${e.patientAge}</td>
	            <td>${e.bodyPart}</td>
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
	            <td>${e.modality}</td>
	            <td> 
	            <fmt:formatDate value="${e.exApply}" pattern="yyyy-MM-dd HH:mm:ss"/> 
	            </td>
	            <td>${e.hospitalName}</td>
	            
	            <td>${e.exApplyDoctor}</td>	
	            <td>
	           	 	<a href="#" >&nbsp;</a>
 					<a class="btnView" title="查看病人报告详情" target="navTab" rel="report" href="ReportManage!show.action?selectedID=${e.id}&operateType=show" ></a>
				 <c:if test="${0 == e.exReportState}">
				    <a style="margin-left:10px;" class="btnAssign"  title="转换专家" target="dialog" href="ReportManage!showTransfer.action?selectedID=${e.id}" ></a>
				  </c:if>
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