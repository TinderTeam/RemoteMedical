<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>




<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					操作人：&nbsp&nbsp <input type="text" name="" />
				</td>		
				<td>
					操作时间：<input type="text" class="date" readonly="true" />
				</td>			

				<td>
					操作：
					
					<select  name="" >
						<option value="">默认所有操作类型</option>
						<option value="1">用户登录</option>
						<option value="2">用户创建</option>
						<option value="3">用户密码修改</option>
						<option value="4">医院信息修改</option>
						<option value="5">医院添加专家</option>
						<option value="6">专家信息修改</option>
					</select>
	
				</td>

			</tr>
			<tr>
				<td>
					操作对象：<input type="text" name="" />
				</td>
					
				<td>
					操作结果：
					
					<select  name="" >
						<option value="">默认所有操作结果</option>
						<option value="1">成功</option>
						<option value="2">失败</option>
					</select>
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
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" style="width:100%;" layoutH="163">
		<thead>
			<tr>
				<th width="120px" align="center">操作人</th>
				<th width="120px" align="center">操作时间</th>
				<th width="100px" align="center">操作</th>
				<th width="120px" align="center">操作对象</th>
				<th width="100px" align="center">操作结果</th>
				<th width="200px" align="center">操作信息</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>AAA</td>
				<td>2014-09-28</td>
				<td>用户登录</td>
				<td>AAA</td>
				<td>成功</td>
				<td>成功登录2次</td>
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