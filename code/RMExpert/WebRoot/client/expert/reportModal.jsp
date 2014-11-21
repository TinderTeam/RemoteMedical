<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
      $(function () 
      {
			$.pdialog.resizeDialog({style: {width: 600,height:300,}}, 				
			$.pdialog.getCurrent(), "");
        });//dialog 宽度重新定义
      function addModal(){
      var text=document.getElementById('reportModal').value;
      var modalType=document.getElementById('modalName').value;
      if(modalType=="检查所见")
      {
      	document.getElementById('text3').innerText=text;
      }
      if(modalType=="诊断意见")
      {
      	document.getElementById('text4').innerText=text;
      }
      $.pdialog.closeCurrent();
      }
</script>
<input type="hidden" id="modalName" value="${reportModal.name}"/>
<textarea style="width:98%;height:210px;font-size:1.2em;overflow:auto;" id="reportModal">${reportModal.value}</textarea>
<div class="divider" ></div>
		<div class="formBar">
			<ul style="margin-right:240px !important;" >
					<li style="padding:0px 30px 0px 10px;"><a  class="mispButton primary" onclick="addModal()">添加模板</a></li>
							
			</ul>
		</div>
