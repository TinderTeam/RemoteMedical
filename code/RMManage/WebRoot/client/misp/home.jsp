<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>远程诊断管理平台</title>

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
<!--[if lt IE 8]>        
<script src="http://ie7-js.googlecode.com/svn/version/2.0(beta)/IE8.js" type="text/javascript"></script>        
<![endif]-->  
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/client/lib/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/client/lib/dwz/bin/dwz.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/client/lib/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/client/lib/dwz/themes/css/progressbar.css" rel="stylesheet" type="text/css" media="screen"/>

<!-- button css -->
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


</script>


</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://www.szangell.com/">安健科技</a>
				<ul class="nav">
                    <li>欢迎您，用户：${loginUser.userName}</li>
	 
					<li><a href="<%=request.getContextPath()%>/client/manage/passwordModify.jsp" target="dialog" width="600" maxable="false" minable="false"
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
				<div class="toggleCollapse"><h2>管理平台</h2><div onclick="javascript:navTabPageBreak();"></div></div>

				<div class="accordion" fillSpace="sidebar">

					<div class="accordionContent">
					<ul class="tree treeFolder">
                           <jsp:include page="common/menu.jsp"/>
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
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p><a href="#"  style="line-height:19px"><span></span></a></p>
								<p><a href="#"  style="line-height:19px"></a></p>
							</div>
							<div class="right">
								<p style="color:red"> </p>
							</div>
							<p><span></span></p>
							<p></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							

<h2></h2>
<div class="unit"></div>
<div class="unit"></div>

<div class="divider"></div>
<h2></h2>
<pre style="margin:5px;line-height:1.4em">

</pre>

<div class="divider"></div>
<h2><span style="color:red;"></span></h2><br/>
<pre style="margin:5px;line-height:1.4em;">

</pre>
						</div>
						

					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer"> &copy; 2014  <a href="http://fuego.cn/" target="">Fuego</a>.All rights reserved.</div>
	

<!-- 省市三级联动js -->
<script  src="<%=request.getContextPath()%>/client/lib/newJS/jsAddress.js" type="text/javascript"></script>

<!-- 图片上传预览js -->

<script src="<%=request.getContextPath()%>/client/lib/newJS/uploadPreview.min.js" type="text/javascript"></script>
<script type="text/javascript">

	function resetForm(objForm) 
	{

		$(":input", objForm).not(":button, :submit, :reset, :hidden").val('')
				.removeAttr("selected");
		//$(':select',objForm).removeAttr('selected');//IE报错，jQuery冲突	  
	}
	//var screenWidth = document.documentElement.clientWidth;

	function reWidthTb(idVal, thWidthData) {

		var newWidth = 0;
		$(idVal).find("tr").each(function(trindex, tritem) {
			$(tritem).find("th").each(function(tdindex, tditem) {
				var curWidth = $(tditem).width();
				if (curWidth < thWidthData[tdindex]) {
					newWidth += thWidthData[tdindex];
				} else {
					newWidth += $(tditem).width();
				}

			});
		});
		//alert(newWidth);
		$(idVal).attr('width', newWidth);
	}
</script>
</body>
</html>