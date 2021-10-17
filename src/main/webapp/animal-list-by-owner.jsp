<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="UTF-8">
		<title>Animal Day Care Check-in System</title>
	</head>
	<body>
		<nav>
			<h2>Menu</h2>
			<a href="index.html">Add a new animal</a>
			<br>
			<a href="viewAllAnimalsServlet">View the animals in Day Care</a>
			<br>
			<a href="viewAllListsServlet">View all Owner Animal lists</a>
			<br>
			<a href="addAnimalsForListServlet">Create a Owner Animal list</a>
		</nav>
		<br>
		<h1>List of Animals</h1>
		<form method ="post" action ="listNavigationServlet">
			<table>
				<c:forEach items="${requestScope.allLists}" var="currentlist">
					<tr><td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td>${currentlist.listName}</td></tr>
					<tr><td colspan="3">List Date: ${currentlist.listDate}</td></tr>
					<tr><td colspan="3">Owner First Name:${currentlist.owner.animalOwnerFirstName}</td></tr>
					<tr><td colspan="3">Owner Last Name:${currentlist.owner.animalOwnerLastName}</td></tr>
					<c:forEach var ="listVal" items ="${currentlist.listOfAnimals}">
						<tr><td></td><td colspan="3">${listVal.animalName}, ${listVal.animalType}, ${listVal.animalBreed}, ${listVal.animalColor}, ${listVal.addedBy}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
			<input type ="submit" value ="Edit" name="doThisToList">
			<input type ="submit" value ="Delete" name="doThisToList">
		</form>
	</body>
</html>