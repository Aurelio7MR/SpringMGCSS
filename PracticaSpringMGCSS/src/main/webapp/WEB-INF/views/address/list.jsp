<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><spring:message code="menu.addresses"/></title>
	</head>
	
	<body>
		<h1><spring:message code="menu.addresses"/></h1>
		<table>
			<tr>
				<td><spring:message code="address.direction"/></td>
				<td><spring:message code="address.number"/></td>
				<td><spring:message code="address.city"/></td>
			</tr>
			
			<c:forEach items="${addresseslist}" var="address">
				<tr>
					<td>${address.direction}</td>
					<td>${address.number}</td>
					<td>${address.city}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>