<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

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
colHeight = total-74;//84
$("#accordionL").height(colHeight-15+"px");
$("#contentL").height(colHeight-16+"px");
$("#panelImg").height(colHeight-220+"px");//230
$("#panelDA").height(colHeight-104+"px");
$("#contentDA").height(colHeight-16+"px");//16
$("#contentDM").height(colHeight-44+"px");
//文本域宽度自适应
textAreaWidth=document.getElementById("panelDA").clientWidth;
partW=textAreaWidth*0.065;
//$("#dis").innerText=textAreaWidth;
$(".textWidth").attr("cols",partW);
//文本域高度自适应
textAreaHeight=document.getElementById("panelDA").clientHeight;
partH=textAreaHeight;
//document.getElementById("dis").innerText=textAreaHeight;
$("#textD1").height(partH*0.4+"px");
$("#text1,#text2").attr("rows",partH*0.015);
$("#textD2").height(partH*0.55+"px");
$("#text3,#text4").attr("rows",partH*0.027);
//运行模板浮窗显示
	$(function (){ $(".treeMenu").popover({trigger:'hover'});});
</script> 


<input id="sessionID" value="<%=session.getId()%>" style="display:none;"/>
<input id="contextPath" value="<%=request.getContextPath()%>" style="display:none;"/>

	

<input type="button" value="删除" onclick="deleteFile('c:/target.txt');" style="display:none;" />

<div class="pageContent" >

<p id="dis" style="display:none;">
</p>
	<div class="accordion" style="width:83%;float:left;margin:0px;" id="accordionL">
 
		<div class="accordionContent" style="width:22%;float:left;" id="contentL" >
		
	<div class="panel" minH="110" >
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

		<div class="panel" minH="270" >
			<h1>图像下载区</h1>
			<div class="pageFormContent"  id="panelImg"> 
			      <input id="imageCount" value='${fn:length(medicalReport.imageList)}' style="display:none;"/> 
				 
				<c:forEach var="e" items="${medicalReport.imageList}" varStatus="status"> 	
				         
				         <input   id="url${status.index}"  value="${e.image.imageSavePath}" style="display:none;"></input>
				         <input   id="image${status.index}"  value="${e.image.imageSavePath}" style="display:none;"></input>
				         <input  id="md5Code${status.index}" value="${e.image.imageCode}" style="display:none;"></input>
				    
	                <dl style="width:98% !important;">
							<dt style="font-size:1.2em;width:68% !important;">
								<span style="margin:0px 5px;width:100%;"><u>${e.image.imgArchName}</u></span>
								<span style="margin:0px 5px;width:100%;">部位：<u>${e.image.bodyPart}</u></span>
							</dt>
						
						    <dd style="font-size:1.2em;width:27% !important;float:right;">
							
							    <span style="margin:0px 5px;"><input id="downBt${status.index}" type="button" onclick="StartDown(this.id)" value="下载"/></span>
						    </dd>
	
					</dl>	
					<dl style="width:98% !important;">
						<dt style="width:68% !important;">
					
				    	<div class="progress" style="padding-top:5px" id="downSize${status.index}">
							<span class="blue" style="width:0%;" ><span style="width:10% !important;text-align:center;" ></span></span>
						</div>

						</dt>
						<dd style="width:27% !important;float:right;">
							<span style="margin:0px 5px;"><input id="viewBt${status.index}" type="button" value="查看" disabled="disabled"></span>
						</dd>					

					</dl>					      
				 </c:forEach>
			 </div>	      

		</div>
		
		</div>
	   <s:form name="form1" action="expert/ReportManage" method="POST" theme="simple">
		 <div class="accordionContent" style="width:78%;float:right" id="contentDA">
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
					<dd ><textarea name="medicalReport.reportView.studyContent" cols="" rows="" readonly="true" id="text1" class="textWidth">${medicalReport.reportView.studyContent}</textarea></dd>
				</dl>
				<dl  style="width:50%;" >
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					<dd><textarea name="medicalReport.reportView.studyConclusion" cols="" rows="" readonly="true" id="text2" class="textWidth">${medicalReport.reportView.studyConclusion}</textarea></dd>
				</dl>
				</div>

				<div id="textD2">
				<p style="font-size:1.2em;">专家诊断</p>
				<div class="divider"></div>
				<dl style="width:50%;" id="text3dl">
					<dt style="text-align:left;width:80%;" >检查所见：</dt>
					<dd style="width:100%;"><textarea name="medicalReport.reportView.exStudyContent" cols="" rows="" id="text3" class="textWidth">${medicalReport.reportView.exStudyContent}</textarea></dd>
				</dl>
				<dl  style="width:50%;" id="text4dl">
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					<dd><textarea name="medicalReport.reportView.exStudyConclusion" cols="" rows="" id="text4" class="textWidth">${medicalReport.reportView.exStudyConclusion}</textarea></dd>
				</dl>
				</div>
			</div>
				<div class="panelBar" style="height:30px !important;overflow:hidden;">
				<ul class="toolBar" style="float:right;">
					 <c:choose>
							   <c:when test="${'已提交' == medicalReport.reportView.exReportState}">  
	                            <li> <input type="button" name="save" value="撤销报告" onclick="sumbitForm('cancel')"  /></li>
					           </c:when>
							   <c:otherwise>  
							   <li> <input type="button" name="modify" value="保存报告" onclick="submitForm('modify')" ></li>
					           <li> <input type="button" name="save" value="提交报告" onclick="submitForm('submit')"  /> </li>
							   <li> <input type="button" name="transfer" value="转换专家" onclick="submitForm('transfer')"  /></li>
							   <li> <input type="button" name="back" value="返回" onclick="submitForm('back')"/></li>
					           </c:otherwise>
					</c:choose>

				</ul>
			</div>		
			</div>
		
		</div>		
       </s:form>
	</div>


	<div class="accordion" style="width:16%;float:right;margin:0px;">
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
<script type="text/javascript">
 
        var sessionID = $("#sessionID").val();
	    var contextPath = $("#contextPath").val();
	    var hostURL = document.location.protocol +"//"+ document.location.host + contextPath;
        var imageURL =  new Array();
       
        var imageFileName =  new Array();
        var progressID =  new Array("downSize1","downSize2","downSize3");
       
        var imageCnt = $("#imageCount").val();
        var nowCnt = 0;
        
        var isStarted = false;
        var isStop=true;
        for(var i=0;i<imageCnt;i++)
        {
            imageURL[i]= $("#url"+i).val();
            imageFileName[i] = $("#image"+i).val();
            progressID[i] = "downSize" + i;
        }
 
	     window.onload= function()
	     { 
		   sessionID = $("#sessionID").val();
	       contextPath = $("#contextPath").val();
	       hostURL = document.location.protocol +"//"+ document.location.host + contextPath;
 
		 };

 
        
		function StartDown(id)
		{

		   sessionID = $("#sessionID").val();
	       contextPath = $("#contextPath").val();
	       hostURL = document.location.protocol +"//"+ document.location.host + contextPath;
 
 			if(isStop==true)
			{
				$("#"+id).attr("value","取消");
				if(isStarted == true)
				{
				   ReYoWebDownLoad.ReYoStartDownload();
				}
				
				isStop=false;
				updateProgress();
			}
			else
			{
			    $("#"+id).attr("value","下载");
				ReYoWebDownLoad.ReYoStopDownload();
				isStop=true;
			}

		}
 
		function updateProgress()
		{
		   if(isStarted == false)
		   {
		     ReYoWebDownLoad.copyright="锐洋软件拥有版权 www.interdrp.com";
			 ReYoWebDownLoad.url= hostURL+ "/DownloadImage?filePath=D:/down.pdf&sessionID="+sessionID;
			 ReYoWebDownLoad.url= hostURL+ "/" + imageURL[nowCnt];
			 //alert(ReYoWebDownLoad.url);
			 ReYoWebDownLoad.percent = 0;
		 	 ReYoWebDownLoad.path ="d:/temp/" + imageFileName[nowCnt];
			 ReYoWebDownLoad.ReYoStartDownload();
			 isStarted = true;
		   }
 
		 	if (ReYoWebDownLoad.cancle)
		    {
		
				alert("本次下载已取消！");
				isStarted = false;
				return;
		    }
		 	else
			{
				if (ReYoWebDownLoad.done) 
				{
 
		  			ReYoWebDownLoad.done=false;
				    $("#downBt"+nowCnt).attr("disabled",true);
			        $("#downBt"+nowCnt).attr("value","完成");
				    $("#viewBt"+nowCnt).attr("disabled",false);
			        		        
                    loading(progressID[nowCnt],100);
 			        //alert(nowCnt);
		  			nowCnt ++;
		  			isStarted = false;
		  			if(nowCnt<imageCnt)
		  			{
		  		   	  setTimeout("updateProgress()",500);	
		  			}
		  			else
		  			{
		  			 nowCnt = 0;
		  			 }
				}
				else
				{
					 if(isStop==false)
					 {
					 	setTimeout("updateProgress()",500);		
						//document.getElementById(progressID[nowCnt]).value = ReYoWebDownLoad.percent;
						loading(progressID[nowCnt],ReYoWebDownLoad.percent);
					 }


				}
			}
		
		}
		

	function loading(progressID,percent){

        var per = percent + "%";
	    $("#"+progressID).find("span:first-child").animate({width:per},30,function(){

			$(this).children().html(per);
			
            if(per=='100%'){
                $(this).children().html('下载完成!');

            }
			
		});
	}
	function deleteFile(target)
	{
      var   fso = new  ActiveXObject("Scripting.FileSystemObject");   
      if(fso.FileExists(target))
      {
      	fso.DeleteFile(target);
      	 alert("删除成功！");
      }
        
      else
      {
      	alert("删除对象不存在！");
      }   
       
		 
	}
	
	</script>

