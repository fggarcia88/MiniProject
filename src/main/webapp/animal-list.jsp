<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Animal Day Care Check-in System</title>
	</head>
<body>
<h1>Animal Day Care</h1>
<form method="post" action="navigationServlet">
	<table>
		<tr class="tableheader">
			<th>Animal Name</th>
			<th>Type</th>
			<th>Breed</th>
			<th>Color</th>
			<th>Owner Name</th>
		</tr>                
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.id}">${currentitem.animalName} </td>
				<td>${currentitem.type}</td>
				<td>${currentitem.breed}</td>
				<td>${currentitem.color}</td>
				<td>${currentitem.ownerName}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Edit" name="doThisToItem">
	<input type="submit" value="Delete" name="doThisToItem">
	<input type="submit" value="Return" name ="doThisToItem">
	</form>
</body>
</html>