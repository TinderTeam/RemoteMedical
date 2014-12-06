<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<input type="hidden" id="currentAccount" value="${loginUser.accountType}" />
<script type="text/javascript">

	var accountType=$("#currentAccount").val();
	if(accountType!=99)
	{
		$(".accountCol").hide();
	}
function submitAccountManage2(type,id,name) 
{
	var msg=null;
	if(type=="logoff")
	{
		msg="确定需要注销账户：";
	}
	if(type=="logon")
	{
		msg="确定需要启用账户：";
	}
	alertMsg.confirm(msg+id+"("+name+")"+"？", {
		okCall: function(json){

         $.post("login/login!accountManage.action?accountOperate=" +type+"&user.userName="+id, reloadCurrentTab2(json), "json");
        
		}
	});

}
	//自定义重载tab方法
function reloadCurrentTab2(json)
{
   DWZ.ajaxDone(json);
   navTab.reload("user/HospitalManage");
}
</script>


<div class="pageHeader" style="overflow-x: hidden;overflow-y: auto;">
	
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
				<th width="10%" align="center">医院账号</th>
				<th width="15%" align="center">医院名称</th>
				<th width="10%" align="center">规模</th>
				<th width="15%" align="center">地点</th>
				<th width="10%" align="center">联系人</th>
				<th width="15%" align="center">联系电话</th>
				<th width="10%" align="center">账户状态</th>
				<th width="5%" align="center">查看详情</th>
				<th width="10%" align="center" class="accountCol">账户管理</th>
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
					<a title="医院管理" target="navTab" href="HospitalManage!show.action?selectedID=${e.id}&operateType=edit&selectedMenuID=${selectedMenuID}" class="btnView" rel="Menu${selectedMenuID}">查看</a>
				</td>
				<td class="accountCol">
				<c:choose>
					<c:when test="${e.state==2}">
						<a title="确定要启用该账户"   href="javascript:;"  mask="true" onclick="submitAccountManage2('logon','${e.id }','${e.name}')"
							class="mispButton " style="line-height:6px;">启用账户</a>
					</c:when>
					<c:when test="${e.state==3}">
						<a title="确定要注销该账户"  href="javascript:;" mask="true" onclick="submitAccountManage2('logoff','${e.id }','${e.name}')"
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
