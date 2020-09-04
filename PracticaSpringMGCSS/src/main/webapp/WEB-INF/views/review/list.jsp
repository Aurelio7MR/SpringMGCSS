<%@  page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>  <spring:message code="menu.reviews"/></title>
	</head>
	
	<body>
		<h1> <spring:message code="menu.reviews"/></h1>
		
		<table>
			<tr>
				<td>ID</td>
				<td><spring:message code="review.score"/></td>
				<td><spring:message code="review.description"/></td>
			</tr>
			
			<c:forEach items="${reviews}" var="review">
				<tr>
					<td>${review.id}</td>
					<td>${review.score}</td>
					<td>${review.description}</td>
					<td><a href="./delete?i=${review.id}"> <spring:message code="general.delete"/> </a> </td>
				</tr>
			</c:forEach>
			
			<c:forEach items="${Error}">
				<h1>${Error}</h1>	
			</c:forEach>
		</table>
		
		<a href="./create"><spring:message code="general.create"/><a/>
	</body>
</html>