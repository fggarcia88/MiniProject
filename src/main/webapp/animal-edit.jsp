<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Animal Day Care Check-in System</title>
    </head>
<body>
	<h1>Animal Day Care</h1>
	<form action ="editAnimalServlet" method="post">
		Animal Name: <input type ="text" name ="name" value="${itemToEdit.name}">
		<br>
		Type: <input type ="text" name ="type" value="${itemToEdit.type}">
		<br>
		Breed: <input type ="text" name ="breed" value="${itemToEdit.breed}">
		<br>
		Color: <input type ="text" name ="color" value="${itemToEdit.color}">
		<br>		
		Owner Name: <input type ="text" name ="ownerName" value="${itemToEdit.ownerName}">
		<br>
		<input type ="hidden" name ="id" value="${itemToEdit.id}">
		<input type ="submit" value="Save Edited Item">
	</form>
    </body>
</html>