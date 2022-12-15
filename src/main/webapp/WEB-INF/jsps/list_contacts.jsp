<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts List</title>
</head>
<body>
	<h2>All Contacts</h2>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Source</th>
			<th>Billing</th>
		</tr>
		
		<c:forEach var = "contacts" items="${contacts}">
		<tr>
			<td><a href="contactInfo?id=${contacts.id}">${contacts.firstName}</a></td>
			<td>${contacts.lastName}</td>
			<td>${contacts.email}</td>
			<td>${contacts.mobile}</td>
			<td>${contacts.source}</td>
			<td><a href="billing?id=${contacts.id}">Billing</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>