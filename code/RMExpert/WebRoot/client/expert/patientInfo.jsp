<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

 
<!-- 自适应屏幕高度 -->
<script type="text/javascript">
    //初始化进入页面参数设定
    var flag=0;
	adaptCSS();


	function adaptCSS()
	{
	//版面布局自适应
	total = document.documentElement.clientHeight;
	colHeight = total - 74;//84
	$("#accordionL").height(colHeight - 15 + "px");
	$("#contentL").height(colHeight - 16 + "px");
	$("#panelImg").height(colHeight - 220 + "px");//230
	$("#panelDA").height(colHeight - 104 + "px");
	$("#contentDA").height(colHeight - 16 + "px");//16
	$("#contentDM").height(colHeight - 44 + "px");
	//文本域宽度自适应
	textAreaWidth = document.getElementById("panelDA").clientWidth;
	partW = textAreaWidth * 0.065;
	//$(".textWidth").attr("cols", partW);
	$(".textWidth").width(textAreaWidth*0.49+"px");
	//文本域高度自适应
	partH = document.getElementById("panelDA").clientHeight;
	 
	 var textAreaHeight1,textAreaHeight2;
	 textAreaHeight1=partH * 0.40;
	 textAreaHeight2=partH * 0.55;

	$("#textD1").height(textAreaHeight1 + "px");
	//$("#text1,#text2").attr("rows", partH * 0.02);
	$("#text1,#text2").height(textAreaHeight1-80 + "px");
	$("#textD2").height(textAreaHeight2 + "px");
	if(flag==0)//修正初始化进入页面和窗口大小改变高度值的差异
	 {
	 	$("#text3,#text4").height(textAreaHeight2-75 + "px");
	 	flag=1;
	 }
	 else{
	 	$("#text3,#text4").height(textAreaHeight2-62 + "px");
	 }
		
	}
    //当浏览器窗口大小改变时，设置显示内容的高度  
    window.onresize=function(){  
        adaptCSS(); 
    }; 
</script> 

  <link rel="stylesheet" href="<%=request.getContextPath()%>/client/lib/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="<%=request.getContextPath()%>/client/lib/zTree_v3/js/jquery.ztree.core-3.5.js"></script>

<script type="text/javascript">
function submitForm(url) 
{
 if(url == "submit")
 {
    if ($.trim($("#text3").val()).length<=0)
    {
        alert("检查所见不能为空");
        return;
    }
    if($.trim($("#text4").val()).length<=0)
    {
         alert("诊断意见不能为空");
        return;
    }
  }
  if(url == "back")
  {
     closeDown();
  }
 document.form1.action = "expert/ReportManage!" +url;
 return validateCallback(document.form1,navTabAjaxDone);
}
</script>
<input id="sessionID" value="<%=session.getId()%>" style="display:none;"/>
<input id="contextPath" value="<%=request.getContextPath()%>" style="display:none;"/>
<input id="hospitalID" name="hospitalID"  value="${medicalReport.reportView.hospitalID}" style="display:none;"/>
	

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
					<dd>${medicalReport.reportView.disPatientSex}</dd>
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
				 
				 <div style="float:left;">
					<div style="margin-left:10px;"  class="buttonActive"><div class="buttonContent"><button id="downAllBt" type="button" onclick="StartAll()" >下 载</button></div></div>		
					<div style="margin-left:10px;" class="buttonActive"><div class="buttonContent"><button id="viewAllBt" type="button" disabled="disabled" onclick="viewAllDoc();" >查 看</button></div></div>	
                       <!-- <input id="downAllBt" type="button" onclick="StartAll()" value="下载" class="button"/>  -->
					   <!-- <input  id="viewAllBt" type="button" value="查看" disabled="disabled" onclick="viewAllDoc();" /> -->
                 </div>
						    
				<c:forEach var="e" items="${medicalReport.imageList}" varStatus="status"> 	
				         
				         <input   id="url${status.index}"  value="${e.image.imageSavePath}" style="display:none;"></input>
				         <input   id="image${status.index}"  value="${e.image.imgArchName}" style="display:none;"></input>
				         <input  id="md5Code${status.index}" value="${e.image.imageCode}" style="display:none;"></input>
				    
	                <dl style="width:98% !important;">
							<dt style="font-size:1.2em;width:70% !important;">
								<span style="margin:0px 5px 0px 0px;width:100%;"><u>${e.image.imgArchName}</u></span>
								<br>
								<span style="margin:0px 5px 0px 0px;">部位：<u>${e.image.bodyPart}</u></span>
							</dt>
						
						    
	
					</dl>	
					<dl style="width:98% !important;">
						<dt style="width:90% !important;">
					
				    	    <div class="progress" style="padding-top:5px" id="downSize${status.index}">
							<span class="blue" style="width:0%;" ><span style="width:10% !important;text-align:center;" ></span></span>
						     </div>

						</dt>
				 					

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
				 <input type="hidden" id="reportModality" name="medicalReport.reportView.modality" value="${medicalReport.reportView.modality}" />
			
				<input type="hidden" id="reportViewId" name="medicalReport.reportView.id" value="${medicalReport.reportView.id}" />
				<input type="hidden" name="medicalReport.reportView.hospitalID" value="${medicalReport.reportView.hospitalID}" />
				<input type="hidden" name="medicalReport.reportView.serialNo" value="${medicalReport.reportView.serialNo}" />
				<input type="hidden" name="medicalReport.reportView.exReportState" value="${medicalReport.reportView.exReportState}" />
				
				<div id="textD1">
				<p style="font-size:1.2em;">医生诊断</p>
				<div class="divider" ></div>				
				<dl style="width:50%;">
					<dt style="text-align:left;width:80%;" >检查所见：</dt>
					<dd  class="textWidth"><textarea name="medicalReport.reportView.studyContent" cols="" rows="" readonly="true" id="text1" style="width:95%;">${medicalReport.reportView.studyContent}</textarea></dd>
				</dl>
				<dl  style="width:50%;" >
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					<dd class="textWidth"><textarea name="medicalReport.reportView.studyConclusion" cols="" rows="" readonly="true" id="text2" style="width:95%;">${medicalReport.reportView.studyConclusion}</textarea></dd>
				</dl>
				</div>

				<div id="textD2">
				<p style="font-size:1.2em;">专家诊断</p>
				<div class="divider"></div>
				<dl style="width:50%;" id="text3dl">
					<dt style="text-align:left;width:80%;" >检查所见：</dt>
				   <c:choose>
					 <c:when test="${1 == medicalReport.reportView.exReportState}">
					    <dd class="textWidth" ><textarea name="medicalReport.reportView.exStudyContent" cols="" rows="" id="text3"   readonly="true"  style="width:95%;">${medicalReport.reportView.exStudyContent}</textarea></dd>
					 </c:when>
					 <c:otherwise>  
					    <dd class="textWidth" ><textarea name="medicalReport.reportView.exStudyContent" cols="" rows="" id="text3" style="width:95%;">${medicalReport.reportView.exStudyContent}</textarea></dd>
					 </c:otherwise>
					</c:choose>
				</dl>
				<dl  style="width:50%;" id="text4dl">
					<dt style="text-align:left;width:80%;">诊断意见：</dt>
					 <c:choose>
					 <c:when test="${1 == medicalReport.reportView.exReportState}">
					    <dd class="textWidth"><textarea name="medicalReport.reportView.exStudyConclusion" cols="" rows=""   readonly="true"  id="text4" style="width:95%;">${medicalReport.reportView.exStudyConclusion}</textarea></dd>
					 </c:when>
					 <c:otherwise>  
					    <dd class="textWidth"><textarea name="medicalReport.reportView.exStudyConclusion" cols="" rows="" id="text4" style="width:95%;">${medicalReport.reportView.exStudyConclusion}</textarea></dd>
					 </c:otherwise>
					</c:choose>
				</dl>
				</div>
			</div>
				<div class="panelBar" style="height:30px !important;overflow:hidden;">
				<ul style="float:right;">
					 <c:choose>
							   <c:when test="${1 == medicalReport.reportView.exReportState}"> 
	                            <li style="padding-bottom:5px;">
	                            <div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitForm('cancel')">撤销报告</button></div></div> 
	                            </li>
							   </c:when>
							   <c:otherwise>  
							   <li style="padding-bottom:5px;"> 
							   <!-- <input class="mispButton primary" type="button" name="modify" value="保存报告" onclick="submitForm('modify')" > -->
							   <div class="buttonActive"><div class="buttonContent"><button type="button" onclick="submitForm('cancel')">保存报告</button></div></div>
							   </li>
					           <li style="padding-bottom:5px;">
					            <!-- <input class="mispButton primary" type="button" name="save" value="提交报告" onclick="submitForm('submit')"  /> -->
					             <div class="buttonActive"><div class="buttonContent"><button type="button" onclick="submitForm('submit')">提交报告</button></div></div>
					           </li>
							   <!--  <li> <input type="button" name="transfer" value="转换专家" onclick="submitForm('showTransfer')"  /></li>-->
							   
 							  </c:otherwise>
					</c:choose>
                    <li style="padding-bottom:5px;"> 
                    <!-- <input class="mispButton primary" type="button"  name="back" value="返回"  onclick="submitForm('back')" /> -->
                    <div class="buttonActive"><div class="buttonContent"><button type="button" onclick="submitForm('back')" name="back" >返回</button></div></div>
                    </li>
					          
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
       	      	
		   <ul id="tree" class="ztree" >

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
        var progressID =  new Array();
        var imageCode =  new Array();
       
        var imageCnt = $("#imageCount").val();
        var nowCnt = 0;
        
        var fileRootPath = "D:/";
        
        var isStarted = false;
        var isStop=true;
        for(var i=0;i<imageCnt;i++)
        {
            imageURL[i]= $("#url"+i).val();
            imageFileName[i] = $("#image"+i).val();
            imageCode[i] = $("#md5Code"+i).val();
            
            progressID[i] = "downSize" + i;
        }
 
 var reportViewId = $("#reportModality").val();
 
 var setting = {
 callback: {
				onClick:showTemplateValue
			}
        };
 
   $(document).ready(function(){
           $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType:"json",  
        url: "expert/ReportManage!showTemplate.action?selectedID="+reportViewId,//请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。    
           
            //var treeNodes =eval('([' + data + '])');  //把后台封装好的简单Json格式赋给treeNodes   
          
            try
            {
             
               $.fn.zTree.init($("#tree"), setting, data);   
              }
              catch(e)
              {
                alert(e);
              }
             }  
    });  
   });       
 
     var treeObj = $.fn.zTree.getZTreeObj("tree");
	 var nodes = treeObj.getNodes();
	 
	 for(var i=0;i<nodes.length;i++) 
	 {
	    treeObj.expandNode(nodes[i], true, false, true);
	   
	    if (nodes[i].children != undefined)
	    {
	      var childs = nodes[i].children;
	      for(var i=0;i<childs.length;i++)
	       {
	        treeObj.expandNode(childs[i], true, false, true);
	       }
	    }
 
	 }
	 
	 function showTemplateValue(event, treeId, treeNode) 
	 {
 
       var options = {mask:true,maxable:false,minable:true,resizable:true,drawable:true,fresh:true};
      // window.showModalDialog ('ReportManage!showModal.action?selectedID='+treeNode.id); 
        if(treeNode.name=='检查所见')
         {
            $.pdialog.open("ReportManage!showModal.action?selectedID="+treeNode.id,"","aaaa",options);
         }
         else if(treeNode.name=='诊断意见')
        {
            $.pdialog.open("ReportManage!showModal.action?selectedID="+treeNode.id,"","aaaa",options);
         }
       
     };
	</script>

