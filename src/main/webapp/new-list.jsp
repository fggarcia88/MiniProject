<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewAnimalListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
List date: <input type ="text" name = "month" placeholder="mm" size="4"> 
<input type ="text" name ="day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4"><br />
Owner Name: <input type ="text" name ="ownerName"><br />
Animals:
<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value ="${currentitem.animalId}">${currentitem.animalName}, ${currentitem.animalType}, ${currentitem.animalBreed}, ${currentitem.animalColor}, ${currentitem.animalOwnerName}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Create List and Add Items">
</form>
<h2>Menu</h2>
<a href="index.html">Add a new animal</a>
<br>
<a href="viewAllAnimalsServlet">View the animals in Day Care</a>
<br>
<a href="viewAllListsServlet">View all Owner Animal lists</a>
<br>
<a href="addAnimalsForListServlet">Create a Owner Animal list</a>
</body>
</html>