<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>



<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<div style="height:200px !important;">
		<span style="font-size:1.2em;"><strong>个人信息</strong></span>
		<div class="divider"></div>
		<div style=" float:right; display:block; margin-top:5px; margin-right:420px; overflow:hidden; width:200px; height:180px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			<div align="center"><img src ="/uploads/img/头像.jpg" height="140" width="130" ></div>
			<div class="divider"></div>
<div class="file-box">
  <form action="" method="post" enctype="multipart/form-data">
 <input type='text' name='textfield' id='textfield' class='txt' />  
 <input type='button' class='btn' value='浏览' />
    <input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" />
 <input type="submit" name="submit" class="btn" value="上传" />
  </form>
</div>
		</div>
			<p>
				<label>专家编号：</label>			
				<input type="text" name=""  alt="" size="30" readonly="true" value="2000023"/>
			</p>			
		
			<p>
				<label>姓名：</label>
				<input type="text" size="30" class="required "/>
			</p>

			<p>
				<label>性别：</label>
				<select name="type" class="required combox">
					<option value="">请选择性别</option>
					<option value="M">男</option>
					<option value="W" >女</option>
					<option value="O" >O</option>
				</select>
			</p>
			<p>
				<label>年龄：</label>
				<input type="text" size="30" />
			</p>			
		</div>
		
		<div style="height:130px !important;">	
		<span style="font-size:1.2em;"><strong>联系方式</strong></span>
		<div class="divider"></div>
			<p>
				<label>手机号码：</label>			
				<input type="text" name="phone" class="phone" size="30"/>
			<p>
			<p>
				<label>座机号码：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>	
			<p>
				<label>电子邮箱：</label>			
				<input type="text" name="email" class="required email" size="30"/>
			</p>				
			
			<p>
				<label>QQ号码：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>			
			<p>
				<label>微信号：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>					
			</div>

		<div style="height:200px !important;">	
		<span style="font-size:1.2em;"><strong>工作信息</strong></span>
		<div class="divider"></div>

				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >专家简介：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="textarea1" cols="95" rows="7" ></textarea></dd>
				</dl>	

			<p>
				<label>职称：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>
			<p>
				<label>擅长专业技能：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>				
			<p>
				<label>工作医院：</label>			
				<input type="text" name=""  alt="" size="30"/>
			</p>
			<p >
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
			</p>
			
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >补充描述：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="textarea1" cols="95" rows="7" ></textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >上传签名：</dt>
					<dd style="float:left !important;padding-left:7px !important;">
						<div style=" float:left; display:block; margin-left:0px !important; overflow:hidden; width:170px; height:70px; border:solid 1px #CCC; line-height:21px; background:#FFF;"><img src ="/uploads/img/signature.png" height="50" width="150" ></div>
					</dd>
					<dd><div style="padding-top:30px !important;"><input name="file1" type="file" /></div>
					</dd>
				</dl>
			
		</div>
		


		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >
				<li style="padding:0px 30px 0px 10px;"><div class="buttonActive"><div class="buttonContent"><button type="submit">保 存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取 消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

