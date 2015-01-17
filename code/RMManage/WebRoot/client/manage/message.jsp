<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 


</head>

<body scroll="no">
	 
		 
				<div class="navTab-panel  ">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p><a href="#"  style="line-height:19px"><span> </span></a></p>
								<p><a href="#"  style="line-height:19px"></a></p>
							</div>
							<div class="right">
								<p style="color:red">  </p>
							</div>
							<p><span></span></p>
							<p></p>
						</div>
						<div class="pageFormContent"  style="margin-right:230px">
						    <c:if test="${approvalCount!=0}"> 
						      <div style="font-size:1.8em;">
						         您有${approvalCount}项待审批事项,请及时处理！
						      </div> 
						     </c:if>
						     <c:if test="${approvalRefuse==true}"> 
						      <div style="font-size:1.8em;">
						         信息修改申请被拒绝，请重新提交！
						      </div> 
						     </c:if>
						</div>
							

 
<h2></h2>
<pre style="margin:5px;line-height:1.4em">

</pre>

 
<h2><span style="color:red;"></span></h2><br/>
 
 
						</div>
						

					</div>
					
 

	<div id="footer"> &copy; 2014  <a href="http://fuego.cn/" target="">Fuego</a>.All rights reserved.</div>
 
</body>
</html>