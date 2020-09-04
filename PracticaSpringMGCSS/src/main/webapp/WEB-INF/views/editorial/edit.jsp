<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><spring:message code="menu.editorials"/></title>
	</head>
	
	<body>
		<h1><spring:message code="menu.editorials"/></h1>
		
		<form:form action="edit" method="post" modelAttribute="editorial">
			<table>
				<tr>
					<td><spring:message code="editorial.name"/>:</td>
					<td> <form:input path="name" /> </td> 
					<td> <form:errors path="name" > </form:errors> </td>	
				</tr>
				<tr>
					<td><spring:message code="editorial.country"/>:</td>
					<td> <form:input path="country" /> </td>
					<td> <form:errors path="country" ></form:errors> </td>					
				</tr>
				<tr>
					<td><spring:message code="editorial.email"/>:</td>
					<td> <form:input path="email" /> </td> 
					<td> <form:errors path="email" ></form:errors> </td>	
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="<spring:message code="general.save"/>"  name="save"/> </td> 
				</tr>
			</table>
		</form:form>
	</body>
</html>