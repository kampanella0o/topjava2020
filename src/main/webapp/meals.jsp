<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
    <head>
        <title>Meals</title>
    </head>
    <body>
        <h3><a href="index.html">Home</a></h3>
        <br>
        <h1>Meals</h1>
        <h4><a href="meal.jsp">Add meal</a></h4>
        <table border="1">
            <tr>
                <th>Date</th>
                <th>Description</th>
                <th>Calories</th>
            </tr>
            <c:forEach var="meal" items="${mealsList}">
                <c:set var = "color" value="${meal.isExcess() ? 'red' : 'green' }"/>
                <c:set var = "dateTime" value="${meal.getDateTime()}"/>
                <c:set var = "description" value="${meal.getDescription()}"/>
                <c:set var = "calories" value="${meal.getCalories()}"/>
                <c:set var = "id" value="${meal.getId()}"/>
                <tr style="color:${color}">
                    <td>${dateTime.toLocalDate()} ${dateTime.toLocalTime()}</td>
                    <td>${description}</td>
                    <td>${calories}</td>
                    <td>${id}</td>
                    <td><a href="meal.jsp?id=${id}&dateTime=${dateTime}&description=${description}&calories=${calories}">Update</a> </td>
                    <td><a href="meals?action=delete&id=${id}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>