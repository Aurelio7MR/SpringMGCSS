<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HOME</title>
	</head>
	
	<body>
		<div>
			<nav style="text-align: center;margin-top:20px; margin-bottom: 10px;   height: 35px;">
				<a style =" color :black;" href="editorial/list"><spring:message code="menu.editorials"/></a> |
				<a style =" color :black;" href="customer/list"><spring:message code="menu.customers"/> </a>|
				<a style =" color :black;" href="book/list"><spring:message code="menu.books"/> </a>|
				<a style =" color :black;" href="address/list"><spring:message code="menu.addresses"/> </a>|
				<a style =" color :black;" href="review/list"><spring:message code="menu.reviews"/> </a>
			</nav>
		</div> 
		
		<br><br>
		
		<div style="text-align: center">
			<a href="./?locale=en">English</a>
			<a href="./?locale=es">Español</a><br>
		</div>
	</body>
</html>