<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
		<h1>Create a new owner list</h1>
		<form action = "createNewAnimalListServlet" method="post">
			List Name: <input type ="text" name = "listName">
			<br />
			List date: <input type ="text" name = "month" placeholder="mm" size="4"> 
			<input type ="text" name ="day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
			<br />
			Owner First Name: <input type ="text" name ="ownerFirstName">
			<br />
			Owner Last Name: <input type ="text" name ="ownerLastName">
			<br />
			Animals:
			<br />
			<select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
			<option value ="${currentitem.animalId}">${currentitem.animalName}, ${currentitem.animalType}, ${currentitem.animalBreed}, ${currentitem.animalColor}, ${currentitem.addedBy}</option>
			</c:forEach>
			</select>
			<br />
			<input type ="submit" value="Create List and Add Animals">
		</form>
	</body>
</html>