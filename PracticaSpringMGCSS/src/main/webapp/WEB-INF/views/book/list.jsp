<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> <spring:message code="menu.books"/></title>
	</head>
	
	<body>
		<h1><spring:message code="menu.books"/></h1>
		<table>
			<tr>
				<td>ID</td>
				<td><spring:message code="book.title"/></td>
				<td><spring:message code="book.year"/></td>
				<td><spring:message code="book.price"/></td>
			</tr>
			
			<c:forEach items="${bookslist}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.year}</td>
					<td>${book.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>