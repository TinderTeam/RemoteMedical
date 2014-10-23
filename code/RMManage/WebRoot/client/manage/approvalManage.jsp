<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageHeader">
<s:form  id="pagerForm" action="user/ApprovalManage" method="POST" onsubmit="return navTabSearch(this);">
		<input type="hidden" name="pageNum"  />
	    <input type="hidden" name="numPerPage"  />	
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					申请人：<input type="text" name="filter.applyName" value="${filter.applyName}"/>
				</td>
				<td>			
					<select class="combox" name="filter.applyType" >
						 <option value="">申请类型</option>
						 <c:forEach var="at" items="${filter.applyTypeList}">
						  		 <c:choose>		       
							   		 <c:when test="${at.type == filter.applyType}">  
	                            		       <option value="${at.type}" selected='selected'> ${at.type}</option>
	                            		 
	                            	  </c:when>
							   		  <c:otherwise>  
							   	   			    <option value="${at.type}" > ${at.type}</option>
							   		   </c:otherwise>
							   
						   		 </c:choose>
						  </c:forEach>						
					</select>
				</td>
				<td class="dateRange">
					申请时间:
					<input type="text"  readonly="readonly" class="date" name="filter.startDate" value="${filter.startDate}"/>
					<span class="limit">-</span>
					<input type="text"  readonly="readonly" class="date" name="filter.endDate" value="${filter.endDate}"/>
				</td>
				
			</tr>

		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查  询</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="javascript:$('#pagerForm')[0].reset();">重 置</button>	</div></div></li>
				<!-- <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> -->
			</ul>
		</div>
	</div>
	</s:form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="100" align="center">申请编号</th>
				<th width="120" align="center">申请类型</th>
				<th width="100" align="center">申请人</th>
				<th width="100" align="center">申请时间</th>
				<th width="100" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="e" items="${approvalTable.currentPageData}">

			<tr target="sid_user" rel="1">
				<td>${e.id}</td>
				<td>
						<c:forEach var="t" items="${filter.applyTypeList}">
						  <c:choose>		       
							   <c:when test="${t.typeValue == e.applyType}">  
	                             ${t.type}
							   </c:when>
							   <c:otherwise>  
							   	   
							   </c:otherwise>
							   
						   </c:choose>
						   </c:forEach>
						
 				</td>
				<td>${e.applyUser}</td>

				<td>${e.applyTime}</td>
				<td>
					<c:if test="${(e.applyType=='1')||(e.applyType=='2')}">
					<a title="修改申请" target="navTab" href="ApprovalManage!show.action?selectedID=${e.id}&operateType=check" class="btnView" rel="Menu${selectedMenuID}">查看</a>
					</c:if>
					<c:if test="${e.applyType=='3'}">
					<a title="修改申请" target="dialog" href="ApprovalManage!show.action?selectedID=${e.id}" class="btnView" rel="Menu${selectedMenuID}">查看</a>					
					</c:if>

<!--					<a title="同意" target="navTab" href="demo_page4.html?id=xxx" class="btnSelect">同意</a>
					<a title="确定要拒绝该申请要求吗?" target="ajaxTodo" href="demo/common/ajaxDone.html?id=xxx" class="btnDel">拒绝</a>
				
 				<a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要拒绝该申请要求吗?"><span>拒绝</span></a>
				<a class="add" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="用户申请修改成功"><span>同意</span></a> -->
				</td>
			</tr>
		
		</c:forEach>			
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
	        <c:set var="page" value="${approvalTable.page}" scope="request"/>
			
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
