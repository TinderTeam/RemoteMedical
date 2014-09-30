<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					检查设备：<input type="text" name="" />
				</td>		
				<td>
					病人姓名：<input type="text" name="" />
				</td>				
				<td>
					检查部位：<input type="text" name="" />
				</td>

				<td>
					报告状态：
					
					<select  name="" >
						<option value="">默认所有状态</option>
						<option value="1">新建</option>
						<option value="2">处理中</option>
						<option value="3">处理完毕</option>
						<option value="4">存档</option>

					</select>
	
				</td>

			</tr>
			<tr>
				<td>
					医生名称：<input type="text" name="" />
				</td>		
				<td>
					专家名称：<input type="text" name="" />
				</td>				
				<td>
					医院名称：<input type="text" name="" />
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
	<table class="table" style="width:1500px !important;" layoutH="163">
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
			<tr target="sid_user" rel="1">
				<td>心电图机</td>
				<td>0000001</td>
				<td>AAA</td>
				<td>男</td>
				<td>33</td>
				<td>心、胸、肺</td>
				<td>医生A</td>
				<td>处理中</td>
				<td>2014-09-28</td>
				<td>200003</td>
				<td>专家A</td>
				<td>3460</td>
				<td>医院A</td>
				<td>2000</td>
				<td>800</td>
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
