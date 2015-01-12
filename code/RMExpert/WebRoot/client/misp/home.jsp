<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>远程诊断专家平台</title>


	 <OBJECT
	   classid="clsid:67134AD0-705A-4CD6-B520-56435E59EDE6"
 	   id="ReYoWebDownLoad"
	   name="ReYoWebDownLoad"
	   width=119
	   height=0
	   align=center
	   hspace=0
	   vspace=0 >   
	 
	</OBJECT>  

<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/azure/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=request.getContextPath()%>/client/lib/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/client/lib/dwz/favicon.ico" rel="shortcut icon"  />

<!--[if IE]>
<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>



<script src="<%=request.getContextPath()%>/client/lib/dwz/bin/dwz.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/client/lib/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/css/progressbar.css" rel="stylesheet" type="text/css" media="screen"/>
<!-- 浮动窗口显示css&js -->
<link href="<%=request.getContextPath()%>/client/lib/newCSS/BS.css" rel="stylesheet" type="text/css" media="screen"/> 
<script src="<%=request.getContextPath()%>/client/lib/newJS/bootstrap-tooltip.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/newJS/bootstrap-popover.js" type="text/javascript"></script>
<!-- 统一按钮样式 -->
<link href="<%=request.getContextPath()%>/client/lib/newCSS/gh-buttons.css" rel="stylesheet" type="text/css" media="screen"/>  

    
	
	
<script type="text/javascript">
$(function()
{
    var localObj = window.location;
    var contextPath = localObj.pathname.split("/")[1];
	DWZ.init("dwz.frag.xml", {
		//loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
       		 loginUrl:"<%=request.getContextPath()%>/client/misp/login.jsp",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
		 //当浏览器窗口大小改变时，tab内容自适应
    window.onresize=function(){  

       navTabPageBreak(); 

    }; 
});


function resetForm(objForm){

    $(":input",objForm).not(":button, :submit, :reset, :hidden").val('').removeAttr("selected");
    }
</script>

</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://www.szangell.com/">安健科技</a>
				<ul class="nav">
                    <li>欢迎您，用户：${loginUser.userName}</li>
	 
					<li><a href="<%=request.getContextPath()%>/client/expert/passwordModify.jsp" target="dialog" width="600" maxable="false" minable="false"
					 mask="true" resizable="false">密码修改</a></li> 
 
					<li><a href="login/login!logout.action">退出</a></li>
				</ul>
				
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					 
					 
					<div class="accordionHeader">
						<h2><span>Folder</span>典型页面</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder treeCheck">
							<li><a href="<%=request.getContextPath()%>/expert/ReportManage" target="navTab" rel="Home" id="home">待办事项</a></li>

						</ul>
					</div>
					 
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
 
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="Home" class="selected"><a href="javascript:;"><span><span class="home_icon">首页</span></span></a></li>
						</ul>
					</div>

				</div>
				<div class="navTab-panel tabsPageContent layoutBox" >
					<div class="page unitBox">
 

						
			 
					</div>
					
				</div>
			</div>
		</div>

	</div>

 
	<div id="footer"> &copy; 2014  <a href="http://fuego.cn/" target="">Fuego</a>.All rights reserved.</div>

<script type="text/javascript">
// 进入首页准备
 $(document).ready(function(){
 	setTimeout(function() {
	// IE
	if(document.all) {
		document.getElementById("home").click();
	}
	// 其它浏览器
	else {
		var e = document.createEvent("MouseEvents");
		e.initEvent("click", true, true);
		document.getElementById("home").dispatchEvent(e);
	}
	}, 1000);
 });

       function disableDown(disable)
       {
          $("#downAllBt").attr("disabled",disable);
          if(disable)
          {
            $("#allDownClass").attr("class","buttonDisabled");
          }
          else
         {
            $("#allDownClass").attr("class","buttonActive");
          }
       }
	   function disableView(disable)
       {
          $("#downAllBt").attr("disabled",disable);
          alert(disable);
          
          if(disable)
          {
            $("#viewClass").attr("class","buttonDisabled");
          }
          else
         {
            $("#viewClass").attr("class","buttonActive");
          }
          alert( $("#viewAllBt").attr("class"));
          $("#viewAllBt").attr("disabled",disable);
          
       }

			function StartAll()
		{
		   sessionID = $("#sessionID").val();
	       contextPath = $("#contextPath").val();
	       hostURL = document.location.protocol +"//"+ document.location.host + contextPath;

              closeDown();
           isStop=false;
		   updateProgress();
          disableDown(true);
                   
		}

                function closeDown()
                {

                   try
                 {
                   ReYoWebDownLoad.CloseDown();
                   }
                   catch(e)
                   {
                   }
                   
                 }
        
	 
 
		function updateProgress()
		{
                  

		   if(isStarted == false && ReYoWebDownLoad.stopDown == true)
		   {
		   
		     //create path
		      createPath(imageURL[nowCnt]);
		     //ReYoWebDownLoad.debug = true;
             ReYoWebDownLoad.url= hostURL+ "/"+imageURL[nowCnt] + imageFileName[nowCnt];
            
             ReYoWebDownLoad.md5Code = imageCode[nowCnt];
		 	 ReYoWebDownLoad.path =fileRootPath+   imageURL[nowCnt] + imageFileName[nowCnt];
			 ReYoWebDownLoad.StartDown();
			 isStarted = true;
                         
		   }
 
		 	if (ReYoWebDownLoad.cancle)
		    {
		        $("#downAllBt").attr("disabled",false);
				alert("本次下载已取消！");
				isStarted = false;
                               
				return;
		    }
		 	else
			{
			    if (ReYoWebDownLoad.failed)
			    {  
                               
			       alert("下载失败");
			       $("#downAllBt").attr("disabled",false);
			    } 
			    else
			   {
				   	if (ReYoWebDownLoad.done) 
					{
	 
			  			ReYoWebDownLoad.done=false;
					    
				        		        
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
			  			  disableDown(true);
				          $("#downAllBt").attr("value","完成");
				          disableView(false);
					     
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
		
		}
		

	function loading(progressID,percent){

        var per = percent + "%";
	    $("#"+progressID).find("span:first-child").animate({width:per},30,function(){

			$(this).children().html(per);
			
            if(per=='100%'){
                $(this).children().html('100%');

            }
			
		});
	}

	
	function viewAllDoc()
	{
     
           var cmd ='WebView://';
         
         for(var i=0;i<imageCnt;i++)
        {
            var path = fileRootPath + imageURL[i] + imageFileName[i];
            if(i == 0)
            {
              cmd += path;
            }
            else
           {
              cmd += "|" + path;
            };
            
            
        };
        window.location.href = cmd;

	}
	function viewDoc(nowCnt)
    {
           
           window.location.href='WebView://' + fileRootPath + imageURL[nowCnt] + imageFileName[nowCnt]; 
    }
    
     function createPath(path)
    {
           window.location.href='WebView://create:' + path;
    }

</script>


</body>
</html>
