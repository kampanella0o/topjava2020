<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Add new meal</title>
</head>
<body>

<form method="POST" action='meals'>
    ID : <input
        type="text" readonly="readonly" name="id"
        value="<%= request.getParameter("id") == null ? "" : request.getParameter("id") %>"/> <br/>
    DateTime : <input
        type="datetime-local" name="dateTime"
        value="<%= request.getParameter("dateTime") == null ? "" : request.getParameter("dateTime") %>"/> <br/>
    Description : <input
        type="text" name="description"
        value="<%= request.getParameter("description") == null ? "" : request.getParameter("description") %>"/> <br/>
    Calories : <input
        type="text" name="calories"
        value="<%= request.getParameter("calories") == null ? "" : request.getParameter("calories") %>"/> <br/>
    <input type="submit" value="Submit"/>
</form>
<form method="GET" action="meals"><input type="submit" value="Cancel"></form>
</body>
</html>