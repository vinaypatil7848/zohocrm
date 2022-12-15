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
			<th>Product</th>
			<th>Amount</th>
		</tr>
		
		<c:forEach var = "bills" items="${bills}">
		<tr>
			<td>${bills.firstName}</td>
			<td>${bills.lastName}</td>
			<td>${bills.email}</td>
			<td>${bills.mobile}</td>
			<td>${bills.product}</td>
			<td>${bills.amount}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>