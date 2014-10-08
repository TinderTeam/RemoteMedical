<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					申请编号：<input type="text" name="keyword" />
				</td>
				<td>			
					<select class="combox" name="">
						<option value="">申请类型</option>
						<option value="1">专家信息修改</option>
						<option value="2">医院信息修改</option>
						<option value="2">医院添加专家</option>
					</select>
				</td>
				<td>			
					<select class="combox" name="">
						<option value="">用户状态</option>
						<option value="1">待审批</option>
						<option value="2">已同意</option>
						<option value="3">已拒绝</option>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>
					申请专家：<input type="text" name="keyword" />
				</td>
				<td>
					申请医院：<input type="text" name="keyword" />
				</td>				
				<td>
					申请时间：<input type="text" class="date" readonly="true" />
				</td>
				<td>
					操作时间：<input type="text" class="date" readonly="true" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查  询</button></div></div></li>
				<!-- <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> -->
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100" align="center">申请编号</th>
				<th width="120" align="center">申请类型</th>
				<th width="100" align="center">申请专家</th>
				<th width="100" align="center">申请医院</th>
				<th width="100" align="center">用户状态</th>
				<th width="100" align="center">申请时间</th>
				<th width="100" align="center">描述</th>
				<th width="100" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>0000001</td>
				<td>专家信息修改</td>
				<td>专家A</td>
				<td>医院a</td>
				<td>待审批</td>
				<td>2014-09-28</td>
				<td>AAAAAAAAAAAA</td>
				<td>
					
					<a title="同意" target="navTab" href="demo_page4.html?id=xxx" class="btnSelect">同意</a>
					<a title="确定要拒绝该申请要求吗?" target="ajaxTodo" href="demo/common/ajaxDone.html?id=xxx" class="btnDel">拒绝</a>
				
<!-- 				<a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要拒绝该申请要求吗?"><span>拒绝</span></a>
				<a class="add" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="用户申请修改成功"><span>同意</span></a> -->
				</td>
			</tr>
			
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
