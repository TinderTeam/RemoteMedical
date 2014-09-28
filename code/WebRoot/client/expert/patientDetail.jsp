<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>


<div class="pageContent" >

	<div class="accordion" style="width:82%;float:left;margin:10px 5px 0px 10px;">
 
		<div class="accordionContent" style="height:510px;width:30%;float:left;overflow:hidden;">
		<div class="panel" defH="120" >
			<h1>病人基本信息</h1>
			<div class="pageFormContent"  style="overflow:hidden;">

				<dl>
					<dt style="text-align:center;">姓名：</dt>
					<dd >张三</dd>
				</dl>
				
				<dl>
					<dt style="text-align:center;">性别：</dt>
					<dd>男</dd>
				</dl>
				<dl>
					<dt style="text-align:center;">年龄：</dt>
					<dd>23</dd>
				</dl>

			</div>
		</div>
		<div class="panel" defH="293" >
			<h1>图像下载区</h1>
			<div class="pageFormContent" >

				<dl style="width:100% !important;">
					<dt style="font-size:1.2em;width:75% !important;">
					<span style="margin:0px 5px;"><u>图像名称1</u></span>
					<span style="margin:0px 5px;"><u>部位名称1</u></span>
					</dt>
					
					<dd style="font-size:1.2em;width:20% !important;float:right;">
						
						<span style="margin:0px 5px;"><button type="submit" onclick="loading('100%')">下载</button></span>
					</dd>

				</dl>
				<dl style="width:100% !important;">
					<dt style="width:75% !important; ">
				    <div class="progress" style="padding-top:5px" >
						<span class="blue" style="width:0px;" ><span style="width:85% !important;" id="disp"></span></span>
					</div>

					</dt>
					<dd style="width:20% !important;float:right;vertical-align:middle;">
							<span style="margin:0px 5px;"><button type="button" class="close">查看</button></span>
					</dd>					

				</dl>

				<div class="divider"></div>
				<dl style="width:100% !important;">
					<dt style="font-size:1.2em;width:75% !important;">
					<span style="margin:0px 5px;"><u>图像名称2</u></span>
					<span style="margin:0px 5px;"><u>部位名称2</u></span>
					</dt>
					
					<dd style="font-size:1.2em;width:20% !important;float:right;">
						
						<span style="margin:0px 5px;"><button type="submit" onclick="loading('100%')">下载</button></span>
					</dd>

				</dl>
				<dl style="width:100% !important;">
					<dt style="width:75% !important;">
				    <div class="progress" style="padding-top:5px">
						<span class="blue" style="width:0px;" ><span style="width:85% !important;" id="disp"></span></span>
					</div>

					</dt>
					<dd style="width:20% !important;float:right;">
							<span style="margin:0px 5px;"><button type="button" class="close">查看</button></span>
					</dd>					

				</dl>

				<div class="divider"></div>
				<dl style="width:100% !important;">
					<dt style="font-size:1.2em;width:75% !important;">
					<span style="margin:0px 5px;"><u>图像名称3</u></span>
					<span style="margin:0px 5px;"><u>部位名称3</u></span>
					</dt>
					
					<dd style="font-size:1.2em;width:20% !important;float:right;">
						
						<span style="margin:0px 5px;"><button type="submit" onclick="loading('100%')">下载</button></span>
					</dd>

				</dl>
				<dl style="width:100% !important;">
					<dt style="width:75% !important;">
				    <div class="progress" style="padding-top:5px" >
						<span class="blue" style="width:0px;" ><span style="width:85% !important;" id="disp"></span></span>
					</div>

					</dt>
					<dd style="width:20% !important;float:right;">
							<span style="margin:0px 5px;"><button type="button" class="close">查看</button></span>
					</dd>					

				</dl>
				<div class="divider"></div>
				<dl style="width:100% !important;">
					<dt style="font-size:1.2em;width:75% !important;">
					<span style="margin:0px 5px;"><u>图像名称4</u></span>
					<span style="margin:0px 5px;"><u>部位名称4</u></span>
					</dt>
					
					<dd style="font-size:1.2em;width:20% !important;float:right;">
						
						<span style="margin:0px 5px;"><button type="submit" onclick="loading('100%')">下载</button></span>
					</dd>

				</dl>
				<dl style="width:100% !important;">
					<dt style="width:75% !important;">
				    <div class="progress" style="padding-top:5px">
						<span class="blue" style="width:0px;" ><span style="width:85% !important;" id="disp"></span></span>
					</div>

					</dt>
					<dd style="width:20% !important;float:right;">
							<span style="margin:0px 5px;"><button type="button" class="close">查看</button></span>
					</dd>					

				</dl>
				<div class="divider"></div>
				<dl style="width:100% !important;">
					<dt style="font-size:1.2em;width:75% !important;">
					<span style="margin:0px 5px;"><u>图像名称5</u></span>
					<span style="margin:0px 5px;"><u>部位名称5</u></span>
					</dt>
					
					<dd style="font-size:1.2em;width:20% !important;float:right;">
						
						<span style="margin:0px 5px;"><button type="submit" onclick="loading('100%')">下载</button></span>
					</dd>

				</dl>
				<dl style="width:100% !important;">
					<dt style="width:75% !important;">
				    <div class="progress" style="padding-top:5px">
						<span class="blue" style="width:0px;" ><span style="width:85% !important;" id="disp"></span></span>
					</div>

					</dt>
					<dd style="width:20% !important;float:right;">
							<span style="margin:0px 5px;"><button type="button" class="close">查看</button></span>
					</dd>					

				</dl>
				<div class="divider"></div>				

			</div>
		</div>
		
		</div>
		
		<div class="accordionContent" style="height:510px;width:70%;float:right">
			<div class="panel" defH="420">
			<h1>病症诊断区</h1>

			<div class="pageFormContent"  >
				<p style="font-size:1.2em;">医生诊断</p>
				<div class="divider"></div>
				
				<dl style="height:110px !important;width:50%;">
					<dt style="text-align:left;width:80%;" >症状描述：</dt>
					<dd><textarea name="textarea1" cols="45" rows="7" readonly="true">三尖瓣畸形、下移和右心室房化一般于显影的右心房室下缘可见两个切迹，其一在脊柱中线附近，为固有的三尖瓣环;其二位于脊柱左侧为下移之三尖瓣的反映.</textarea></dd>
				</dl>
				<dl  style="height:110px !important;width:50%;">
					<dt style="text-align:left;width:80%;">诊断结论：</dt>
					<dd><textarea name="textarea1" cols="45" rows="7" readonly="true" >选择性右心系统造影</textarea></dd>
				</dl>

				<p style="font-size:1.2em;margin-top:30px;">专家诊断</p>
				<div class="divider"></div>
				
				<dl style="height:110px !important;width:50%;">
					<dt style="text-align:left;width:80%;" >症状描述：</dt>
					<dd><textarea name="textarea1" cols="45" rows="9" ></textarea></dd>
				</dl>
				<dl  style="height:110px !important;width:50%;">
					<dt style="text-align:left;width:80%;">诊断结论：</dt>
					<dd><textarea name="textarea1" cols="45" rows="9"  ></textarea></dd>
				</dl>
			</div>
				<div class="panelBar" style="height:30px !important;overflow:hidden;">
				<ul class="toolBar">
					<li><a class="add" href="#" ><span>保存报告</span></a></li>
					
					<li><a class="edit" href="#" ><span>发送报告</span></a></li>
					
					<li><a class="delete" href="#" ><span>撤销报告</span></a></li>
					
					<li><a class="icon" href="dialogMove.html" target="dialog" mask="true" ><span>转换专家</span></a></li>
				</ul>
			</div>		
			</div>
		
		</div>		
	</div>


	<div class="accordion" style="width:16%;float:right;margin:10px 5px 10px 0px;">
		<div class="accordionHeader">
			<p style="font-size:1.5em;padding:7px;"><strong>诊断模板</strong></p>
		</div>
		<div class="accordionContent" style="height:483px">
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">A模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">B模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">C模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">D模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">E模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li><a href="tabsPage.html" target="navTab">F模板库</a>
					<ul>
						<li><a href="#" >模板1</a></li>
						<li><a href="#" >模板2</a></li>
						<li><a href="#" >模板3</a></li>
						<li><a href="#" >模板4</a></li>
						
					</ul>
				</li>
			</ul>			
		</div>


	</div>
	

		


</div>


