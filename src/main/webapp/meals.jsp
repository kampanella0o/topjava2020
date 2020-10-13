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
        <table border="1">
            <tr>
                <th>Date</th>
                <th>Description</th>
                <th>Calories</th>
            </tr>
            <c:forEach var="meal" items="${mealsList}">
                <c:set var = "color" value="${meal.isExcess() ? 'red' : 'green' }"/>
                <tr style="color:${color}">
                    <td>${meal.getDateTime().toLocalDate()} ${meal.getDateTime().toLocalTime()}</td>
                    <td>${meal.getDescription()}</td>
                    <td>${meal.getCalories()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>