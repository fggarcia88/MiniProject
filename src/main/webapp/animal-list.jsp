<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Animal List</title>
	</head>
	<body>
		<nav>
			<h2>Menu</h2>
			<a href="index.html">Add a new animal</a>
			<br>
			<a href="viewAllAnimalsServlet">View the animals in Day Care</a>
			<br>
			<a href="viewAllListsServlet">View all Owner Lists</a>
			<br>
			<a href="addAnimalsForListServlet">Create a Owner List</a>
		</nav>
		<br>
		<h1>Animal Day Care</h1>
		<form method="post" action="navigationServlet">
			<table>
				<tr class="tableheader">
					<th>Animal Name</th>
					<th>Type</th>
					<th>Breed</th>
					<th>Color</th>
					<th>Added By</th>
				</tr>                
				<c:forEach items="${requestScope.allAnimals}" var="currentitem">
					<tr>
						<td><input type="radio" name="id" value="${currentitem.animalId}">
						${currentitem.animalName}</td>
						<td>${currentitem.animalType}</td>
						<td>${currentitem.animalBreed}</td>
						<td>${currentitem.animalColor}</td>
						<td>${currentitem.addedBy}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Edit" name="doThisToItem">
			<input type="submit" value="Delete" name="doThisToItem">
		</form>	
	</body>
</html>