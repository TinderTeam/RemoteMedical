<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
   
   $(function () {
		$.pdialog.resizeDialog({style: {width: 800}}, $.pdialog.getCurrent(), "");
        });//dialog 宽度重新定义

</script>
<script type="text/javascript">
function submitForm2(url,id,name) 
{
	
	alertMsg.confirm("确定要将报告移交给专家"+id+"("+name+")"+"！", {
		okCall: function(){
		 document.expertTransForm.action = "expert/ReportManage!" +url;
 		return validateCallback(document.expertTransForm,navTabAjaxDone);

		}
	});


}
</script>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="expert/ReportManage!showTransfer.action?selectedID=${selectedID}" onsubmit="return dwzSearch(this, 'dialog');" >
		<input type="hidden" name="pageNum" value="${pageNum}" />
        <input type="hidden" name="numPerPage" value="${numPerPage}" />
	    
	<div class="searchBar">
		
		<table class="searchContent">
			<tr>
				<td>
					专家账号：<input type="text" name="expertFilter.expert.id" value="${expertFilter.expert.id}"/>
				</td>
				<td>
					专家姓名：<input type="text" name="expertFilter.expert.name" value="${expertFilter.expert.name}"/>
				</td>
				<td>
					工作医院：<input type="text" name="expertFilter.expert.workPlace" value="${expertFilter.expert.workPlace}"/>
				</td>				
			</tr>

		</table> 
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查 询</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="resetForm(this.form);">重 置</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
<s:form    method="POST"  name="expertTransForm" action="expert/ReportManage"  >

	<table class="table" layoutH="85" targetType="dialog" width="100%">
		<thead>
				
			<tr>
			
				<th width="100" align="center">专家账号</th>
				<th width="120" align="center">姓名</th>
				<th width="100" align="center">职称</th>
				<th width="100" align="center">工作医院</th>
				<th width="100" align="center">手机号码</th>
				<th width="50" align="center">操作</th>
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
				<td align="center">
					<a class="btnSelect"  href="javascript:;" onclick="submitForm2('transferSure?selectedID=${e.id}&selectedReportID=${selectedReportID}','${e.id}','${e.name}')" 
					 style="display:block;" >转换</a>
								
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

