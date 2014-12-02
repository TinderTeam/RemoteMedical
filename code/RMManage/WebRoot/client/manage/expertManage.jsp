<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<input type="hidden" id="currentAccount" value="${loginUser.accountType}" />
<script type="text/javascript">

	var accountType=$("#currentAccount").val();
	if(accountType==2)
	{
		$("#addEx").css('display', 'block');
		$("#exTable").attr("layoutH", '130');
	}
	if(accountType!=99)
	{
		$(".accountCol").hide();
	}

</script>

<div class="pageHeader">
	<div  style="height:40px;overflow:hidden;display:none;" id="addEx" >
		<s:form  name="exAdd" action="user/ExpertManage" method="POST"  onsubmit="return iframeCallback(this,dialogAjaxDone);"  >
		<div class="searchBar">
			<table class="searchContent">
			<tr>
				<td>专家账号：<input  name="targetExpert.id" type="text"  readonly="readonly"/>
				</td>
				<td>专家姓名：<input  name="targetExpert.name" readonly="readonly" type="text"/>
				</td>
				<td ><a class="btnLook" href="user/ExpertManage!addExpert.action" lookupGroup="targetExpert">专家列表</a>	
					<label style="color:grey;font-size:0.5em;">(点击图标查找专家)</label>
				</td>
				<td>&nbsp;&nbsp;</td>
				<td><s:submit  value="添加专家" cssClass="mispButton primary" method="addSure"></s:submit> 
				</td>
				<td><s:submit  value="取 消" cssClass="mispButton primary"  onclick="resetForm(this.form)" method="cancel"></s:submit>
				
				</td>
		 			
			</tr>

			</table>
		</div>
		</s:form>
		<div class="divider"></div>		
	</div>

	<s:form  id="pagerForm" action="user/ExpertManage" method="POST" onsubmit="return navTabSearch(this);" name="exSearch">
		<input type="hidden" name="pageNum" value="${pageNum}" />
	    <input type="hidden" name="numPerPage" value="${numPerPage}" />
	<div class="searchBar">
		
		<table class="searchContent">
			<tr>
				<td>
					专家账号：<input type="text" name="filter.expert.id" value="${filter.expert.id}"/>
				</td>
				<td>
					专家姓名：<input type="text" name="filter.expert.name" value="${filter.expert.name}"/>
				</td>
				<td>
					职称类型：<input type="text" name="filter.expert.jobTitle" value="${filter.expert.jobTitle}"/>
				</td>				
				<td>
					所在医院：<input type="text" name="filter.expert.workPlace" value="${filter.expert.workPlace}"/>
				</td>
				<td>
				  <s:submit  value="查 询" cssClass="mispButton primary"></s:submit> 
				</td>
				<td>
				<s:submit  value="重 置" cssClass="mispButton primary"  onclick="resetForm(this.form)" ></s:submit>
				</td>
				
			</tr>

		</table>
		
	</div>
	</s:form>
</div>
<div class="pageContent">

	<table class="table" width="100%" layoutH="88" id="exTable">
		<thead>
			<tr>		
				<th width="10%" align="center">专家账号</th>
				<th width="10%" align="center">姓名</th>
				<th width="10%" align="center">职称</th>
				<th width="20%" align="center">工作医院</th>
				<th width="10%" align="center">手机号码</th>
				<th width="10%" align="center">座机号码</th>
				<th width="10%" align="center">邮件地址</th>
				<th width="5%" align="center">账户状态</th>
				<th width="5%" align="center">查看详情</th>
				<th width="10%" align="center" class="accountCol">账户管理</th>
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
				<td>${e.telephoneNo}</td>
				<td>${e.email}</td>
				<td>
					<c:forEach var="us" items="${userStatusList}">
						  <c:choose>		       
							   <c:when test="${us.intValue==e.state}">  
	                             ${us.strValue}
							   </c:when>
							   <c:otherwise></c:otherwise>					   
						   </c:choose>
					</c:forEach>
				</td>
				<td>				
				<a title="专家管理" target="navTab" href="ExpertManage!show.action?selectedID=${e.id}" class="btnView" rel="Menu${selectedMenuID}">查看</a>	
				</td>
				<td class="accountCol">
				<c:choose>
					<c:when test="${e.state==2}">
						<a title="启用确认" target="dialog" href="<%=request.getContextPath()%>/client/manage/logoff.jsp?userName=${e.id}&operate=logon"   mask="true" 
							class="mispButton " style="line-height:6px;">启用账户</a>
					</c:when>
					<c:when test="${e.state==3}">
							<a title="注销确认" target="dialog" href="<%=request.getContextPath()%>/client/manage/logoff.jsp?userName=${e.id}&operate=logoff"   mask="true" 
							class="mispButton danger" style="line-height:6px;">注销账户</a>					
				
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

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

