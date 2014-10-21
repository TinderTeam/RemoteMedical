<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
 
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
 
  
    <c:forEach var="e" items="${templateList}">	
        <ul>
            <c:if test="${null !=e.childList}">
				 <li><a href="#" >${e.name}</a>
				     <c:set var="templateList" value="${e.childList}" scope="request"/>
		             <jsp:include page="template.jsp"/>
				 </li>
             </c:if>
	        <c:if test="${null==e.childList}">
			 
				 <li><a href="#" class="treeMenu"  data-container="body" data-toggle="popover"  data-content="这里输入模板内容!" data-original-title="${e.name}" data-placement="left">${e.name}</a></li>		
		    </c:if>
        </ul>	
    </c:forEach>  	
 


 

		
		