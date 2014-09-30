<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<div class="pageContent">
	<form method="post" action="" class="pageForm" onsubmit="">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>用户编号：</label>
				<input type="text" size="30" readonly="true" value="10000023"/>
			</div>
			<div class="divider"></div>
			<div class="unit">
				<label>用户名称：</label>
				<input type="text" size="30" name="name"/>
			</div>
			<div class="divider"></div>
			<div class="unit">
				<label>账户类型：</label>
				<label class="radioButton"><input name="name" type="radio" />专家</label>
				<label class="radioButton"><input name="name" type="radio" />医院</label>
				<label class="radioButton"><input name="name" type="radio" />管理员</label>
			</div>

		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确 定</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset">重 置</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
