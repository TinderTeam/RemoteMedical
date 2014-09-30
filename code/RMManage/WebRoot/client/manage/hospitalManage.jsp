<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>




<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					医院编号：<input type="text" name="keyword" />
				</td>
				<td>
					医院名称：<input type="text" name="keyword" />
				</td>
				<td>			
				<select class="combox" name="province" ref="w_combox_city" refUrl="demo/combox/city_{value}.html"  >
					<option value="all">所在省市</option>
					<option value="bj">北京</option>
					<option value="sh">上海</option>
				</select>
				<select class="combox" name="city" id="w_combox_city" ref="w_combox_area" refUrl="demo/combox/area_{value}.html">
					<option value="all">所在城市</option>
				</select>
				<select class="combox" name="area" id="w_combox_area">
					<option value="all">所有在区县</option>
				</select>
				</td>
				
			</tr>

		</table>
		<div class="subBar ">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查  询</button></div></div></li>
				<!-- <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> -->
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="108">
		<thead>
			<tr>
				<th width="100" align="center">医院编号</th>
				<th width="120" align="center">医院名称</th>
				<th width="100" align="center">规模</th>
				<th width="300" align="center">地点</th>
				<th width="100" align="center">联系人</th>
				<th width="100" align="center">联系电话</th>
				<th width="100" align="center">查看详情</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>2000023</td>
				<td>医院a</td>
				<td>12000</td>
				<td>xx省xx市xx县（区）****路**号</td>
				<td>吴先生</td>
				<td>027-22335566</td>
				<td>
					
					<a title="医院介绍" target="navTab" href="hospitalInfo.html?id=xxx" class="btnView">查看</a>
<!-- 					<a title="拒绝" target="ajaxTodo" href="demo/common/ajaxDone.html?id=xxx" class="btnDel">拒绝</a> -->
				
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
