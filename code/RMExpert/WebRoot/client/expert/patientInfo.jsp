<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
function submitForm(url) 
{
 document.form1.action = "expert/ReportManage!" +url;
 return validateCallback(document.form1,navTabAjaxDone);
}
</script>
<!-- 自适应屏幕高度 -->
<script type="text/javascript">

//版面布局自适应
 total = document.documentElement.clientHeight;
colHeight = total-84;
document.getElementById("accordionL").style.height=colHeight-15+"px";
document.getElementById("contentL").style.height=colHeight-16+"px";
document.getElementById("panelImg").style.height=colHeight-230+"px";
document.getElementById("panelDA").style.height=colHeight-104+"px";
document.getElementById("contentDA").style.height=colHeight-16+"px";
document.getElementById("contentDM").style.height=colHeight-44+"px";
//文本域宽度自适应
textAreaWidth=document.getElementById("panelDA").clientWidth;
partW=textAreaWidth*0.065;
document.getElementById("dis").innerText=textAreaWidth;
document.getElementById("text1").cols=partW;
document.getElementById("text2").cols=partW;
document.getElementById("text3").cols=partW;
document.getElementById("text4").cols=partW;
//文本域高度自适应
textAreaHeight=document.getElementById("panelDA").clientHeight;
partH=textAreaHeight;
//document.getElementById("dis").innerText=textAreaHeight;
document.getElementById("textD1").style.height=partH*0.4+"px";
document.getElementById("text1").rows=partH*0.015;
document.getElementById("text2").rows=partH*0.015;
document.getElementById("textD2").style.height=partH*0.55+"px";
document.getElementById("text3").rows=partH*0.027;
document.getElementById("text4").rows=partH*0.027;
</script>

<script>
$(function ()
{ $(".treeMenu").popover({trigger:'hover'});
});
</script>

<input type="button" value="下载测试文件" onclick="StartDown()" />


    <script type="text/javascript" language="javascript">
    	var downer = new FileDownloaderMgr();
    	downer.Config["Folder"] = "D:\\temp";//设置默认下载路径。
    	downer.LoadTo("downDiv");

    	$(document).ready(function ()
    	{
    	    downer.Init();

    	    //alert(downer.Browser.GetMacs());
    	});
		
		function StartDown()
		{
		    alert(<%=session.getId()%>);
			downer.AddFile("http://localhost:8080/RMExpert/DownloadImage?filePath=D:/down.pdf& sessionID=<%=session.getId()%>" );
			downer.PostFirst();
			//downer.AddFile("http://localhost:8080/New/RM1100.pdf");
		 
			downer.AddFile("http://localhost:8080/New/RM1100.pdf");
		 
			//downer.AddFile("http://www.lingoes.cn/download/lingoes_2.9.1_cn.exe");
			//downer.AddFile("http://wsdl2.yunpan.cn/share.php?method=Share.download&fhash=2946b3b85abb80b3392014aad8db8aedad5921e9&xqid=19044811&fname=XproerIM.exe&fsize=2434536&nid=13636671072534451&cqid=61d5fd74b63cf66070ebe072f46ac8c4&st=015fb1af5a4c2cbe1430f8e786d4e601&e=1374829813");
			//downer.AddFile("http://www.ncmem.com/images/ico-ftp.jpg","test.jpg");
//			downer.AddFile("http://www.ncmem.com/images/ico-up.jpg");
//			downer.AddFile("http://www.ncmem.com/images/ico-capture.jpg");
//			downer.AddFile("http://www.ncmem.com/images/ico-imageuploader.gif");
//			downer.AddFile("http://www.ncmem.com/images/ico-wordpaster.gif");
			//downer.PostFirst();
		 

		}
 
		function copyFile()
		{
			var obj = new ActiveXObject(downer.ActiveX["Part"]);
			obj.CopyFile("f:\\ftp\\test.gif","f:\\ftp\\test1.gif");
		}

		function copyFolder()
		{
			var obj = new ActiveXObject(downer.ActiveX["Part"]);
			obj.CopyFile("f:\\ftp\\test.gif","f:\\ftp\\ftp1");
		}
		
		function moveFile()
		{
			var obj = new ActiveXObject(downer.ActiveX["Part"]);
			obj.MoveFile("f:\\ftp\\test.gif","f:\\ftp\\test2.gif");
		}
		
		function moveFolder()
		{
			var obj = new ActiveXObject(downer.ActiveX["Part"]);
			obj.MoveFile("f:\\ftp\\test2.gif","f:\\ftp\\ftp1");
		}
		
	</script>
<div class="pageContent" >

<p id="dis" style="display:none;">
</p>
	<div class="accordion" style="width:82%;float:left;margin:10px 5px 0px 10px;" id="accordionL">
 
		<div class="accordionContent" style="width:20%;float:left;" id="contentL" >
		
	<div class="panel" minH="120" >
			<h1>病人基本信息</h1>
			<div class="pageFormContent"  style="overflow:hidden;" >

				<dl>
					<dt style="text-align:center;width:20%;" >姓名：</dt>
					<dd >${medicalReport.reportView.patientName}</dd>
				</dl>
				
				<dl>
					<dt style="text-align:center;width:20%; ">性别：</dt>
					<dd>${medicalReport.reportView.patientSex}</dd>
				</dl>
				<dl>
					<dt style="text-align:center;width:20%;">年龄：</dt>
					<dd>${medicalReport.reportView.patientAge}</dd>
				</dl>

			</div>
		</div>

		<div class="panel" minH="293" >
			<h1>图像下载区</h1>
			<div id="downDiv"></div>
			<div class="pageFormContent" id="panelImg">

                  <c:forEach var="e" items="${medicalReport.imageList}"> 
                     <input name="imageUrl" value="e.imageUrl"></input>	
           
	              </c:forEach>
			</div>
		</div>
		
		</div>
	   <s:form name="form1" action="expert/ReportManage" method="POST" theme="simple">
		 <div class="accordionContent" style="width:80%;float:right" id="contentDA">
			<div class="panel" >
			<h1>病症诊断区</h1>

			<div class="pageFormContent"  id="panelDA" minH="420" >
				<input type="hidden" name="medicalReport.reportView.id" value="${medicalReport.reportView.id}" />
				<input type="hidden" name="medicalReport.reportView.hospitalID" value="${medicalReport.reportView.hospitalID}" />
				<input type="hidden" name="medicalReport.reportView.serialNo" value="${medicalReport.reportView.serialNo}" />
				<input type="hidden" name="medicalReport.reportView.exReportState" value="${medicalReport.reportView.exReportState}" />
				
				<div id="textD1">
				<p style="font-size:1.2em;">医生诊断</p>
				<div class="divider"></div>				
				<dl style="width:50%;">
					<dt style="text-align:left;width:80%;" >检查所见：</dt>
					<dd ><textarea name="medicalReport.reportView.studyContent" cols="" rows="" readonly="true" id="text1">${medicalReport.reportView.studyContent}</textarea></dd>
				</dl>
				<dl  style="width:50%;" >
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					<dd><textarea name="medicalReport.reportView.studyConclusion" cols="" rows="" readonly="true" id="text2">${medicalReport.reportView.studyConclusion}</textarea></dd>
				</dl>
				</div>

				<div id="textD2">
				<p style="font-size:1.2em;">专家诊断</p>
				<div class="divider"></div>
				<dl style="width:50%;" id="text3dl">
					<dt style="text-align:left;width:80%;" >检查所见：</dt>
					<dd style="width:100%;"><textarea name="medicalReport.reportView.exStudyContent" cols="" rows="" id="text3" >${medicalReport.reportView.exStudyContent}</textarea></dd>
				</dl>
				<dl  style="width:50%;" id="text4dl">
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					<dd><textarea name="medicalReport.reportView.exStudyConclusion" cols="" rows="" id="text4" >${medicalReport.reportView.exStudyConclusion}</textarea></dd>
				</dl>
				</div>
			</div>
				<div class="panelBar" style="height:30px !important;overflow:hidden;">
				<ul class="toolBar">
					 <c:choose>
							   <c:when test="${'已提交' == medicalReport.reportView.exReportState}">  
	                             <input type="button" name="save" value="撤销报告" onclick="sumbitForm('cancel')"  align="left" />
					           </c:when>
							   <c:otherwise>  
							    <input type="button" name="modify" value="保存报告" onclick="submitForm('modify')" align="left"   />
					            <input type="button" name="save" value="提交报告" onclick="submitForm('submit')"  align="left"  />
							    <input type="button" name="transfer" value="转换专家" onclick="submitForm('transfer')" align="left"   />
							    <input type="button" name="back" value="返回" onclick="submitForm('back')" align="left"   />
					           </c:otherwise>
					</c:choose>
					
					
 
				</ul>
			</div>		
			</div>
		
		</div>		
       </s:form>
	</div>


	<div class="accordion" style="width:16%;float:right;margin:10px 5px 10px 0px;">
		<div class="accordionHeader">
			<p style="font-size:1.5em;padding:7px;"><strong>诊断模板</strong></p>
		</div>
		<div class="accordionContent" id="contentDM" >
       	      	
		   <ul class="tree treeFolder collapse">

       	      <li>
       	      <a href="tabsPage.html" target="navTab"  >${medicalReport.template.name}</a>
       	           <c:set var="templateList" value="${medicalReport.template.childList}" scope="request"/>
			       <jsp:include page="template.jsp"/>
       	      </li>
       	   </ul> 

		</div>


	</div>
	

		


</div>


