<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
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
		<h1>Edit an animal</h1>
		<form action ="editAnimalServlet" method="post">
			Animal Name: <input type ="text" name ="animalName" value="${animalToEdit.animalName}">
			<br>
			Type: <input type ="text" name ="type" value="${animalToEdit.animalType}">
			<br>
			Breed: <input type ="text" name ="breed" value="${animalToEdit.animalBreed}">
			<br>
			Color: <input type ="text" name ="color" value="${animalToEdit.animalColor}">
			<br>		
			Owner Name: <input type ="text" name ="ownerName" value="${animalToEdit.addedBy}">
			<br>
			<input type ="hidden" name ="id" value="${animalToEdit.animalId}">
			<input type ="submit" value="Save Edited Item">
		</form>
    </body>
</html>