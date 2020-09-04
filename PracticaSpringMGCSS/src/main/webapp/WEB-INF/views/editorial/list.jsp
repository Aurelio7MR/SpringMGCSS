<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> <spring:message code="menu.editorials"/></title>
	</head>
	
	<body>
		<h1><spring:message code="menu.editorials"/></h1>
		
		<table>
			<tr>
				<td>ID</td>
				<td><spring:message code="editorial.name"/></td>
				<td><spring:message code="editorial.country"/></td>
				<td><spring:message code="editorial.url"/></td>
			</tr>
			
			<c:forEach items="${editorialslist}" var="editorial">
				<tr>
					<td>${editorial.id}</td>
					<td>${editorial.name}</td>
					<td>${editorial.country}</td>
					<td>${editorial.email}</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="./create"> <spring:message code="general.crear"/><a/>
	</body>
</html>