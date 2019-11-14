<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donut List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Donut Reviews</h2>

            <button class="add-button" onclick="window.location.href='showAddDonutForm';return false;">
                Add Donut</button>

        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th></th>
                    <th>Shop</th>
                    <th>Name</th>
                    <th>Calories</th>
                    <th>Date Added</th>
                </tr>

                <c:forEach var="tempDonut" items="${donuts}">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/resources/img/${tempDonut.imagePath}"
                                 alt="${tempDonut.name}">
                        </td>
                        <td>${tempDonut.shop.name}</td>
                        <td>${tempDonut.name}</td>
                        <td>${tempDonut.calories}</td>
                        <td>${tempDonut.formattedDate}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</body>
</html>