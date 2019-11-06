<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Donuts</title>
</head>
<body>
<table>
    <tr>
        <th>Shop ID</th>
        <th>Name</th>
        <th>Calories</th>
        <th>Date Added</th>
    </tr>
    <c:forEach var="tempDonut" items="${donuts}">
        <tr>
            <td>${tempDonut.shop.name}</td>
            <td>${tempDonut.name}</td>
            <td>${tempDonut.calories}</td>
            <td>${tempDonut.dateAdded}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
