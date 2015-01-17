<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
	
 
	<c:forEach var="menuItem" items="${menuTreeItem}">	
	   <c:if test="${menuItem.menu.selected == true}">
 
			<!---一级标题--->
			<c:if test="${null!=menuItem.childMenuList}"> 
				<!----有子标题--->
				<li>
					<a>${menuItem.menu.value}</a>
					
					<!----迭代--->
					<c:set var="menuTreeItem" value="${menuItem.childMenuList}" scope="request"/>
					<ul>
					<c:forEach var="childMenuItem" items="${menuTreeItem}">	
					 <c:if test="${childMenuItem.menu.selected == true}">
						 <c:if test="${childMenuItem.menu.name !='我的首页'}">
						  <li><a href="<%=request.getContextPath()%>/client/${childMenuItem.menu.url}?selectedID=${loginUser.userName}&selectedMenuID=${childMenuItem.menu.menuID}" target="navTab" rel="Menu${childMenuItem.menu.menuID}">${childMenuItem.menu.value}</a></li>
						  </c:if>
						 <c:if test="${childMenuItem.menu.name =='我的首页'}">
						   <li><a href="<%=request.getContextPath()%>/client/${childMenuItem.menu.url}?selectedID=${loginUser.userName}&selectedMenuID=${childMenuItem.menu.menuID}" target="navTab" rel="main">${childMenuItem.menu.value}</a></li>
						 
						 </c:if>
 					</c:if>	
					</c:forEach>
					 
					</ul>								
				</li>
			</c:if>
			<c:if test="${null==menuItem.childMenuList}"> 
				<!----无子标题--->
				<li><a href="<%=request.getContextPath()%>/client/${menuItem.menu.url}?selectedID=${loginUser.userName}&selectedMenuID=${menuItem.menu.menuID}" target="navTab" rel="Menu${menuItem.menu.menuID}">${menuItem.menu.value}</a></li>
									
		    </c:if>
 
	 </c:if>	
   </c:forEach>
 
 

		
		