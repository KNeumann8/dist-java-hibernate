<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Donuts</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Donut Reviews</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <button class="add-button"
                onclick="window.location.href='showAddDonutForm'; return false;">Add Donut</button>

        <form:form action="search" method="GET">
            <input type="search" name="searchTerm">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <table>
            <tr>
                <th></th>
                <th>Shop</th>
                <th>Name</th>
                <th>Calories</th>
                <th>Date Added</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempDonut" items="${donuts}">
                <c:url var="updateLink" value="/donut/showUpdateDonutForm">
                    <c:param name="donutId" value="${tempDonut.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/donut/delete">
                    <c:param name="donutId" value="${tempDonut.id}"/>
                </c:url>
                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/img/${tempDonut.imagePath}"
                             alt="${tempDonut.name}">
                    </td>
                    <td>${tempDonut.shop.name}</td>
                    <td>${tempDonut.name}</td>
                    <td>${tempDonut.calories}</td>
                    <td>${tempDonut.formattedDate}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
                        <a href="${deleteLink}"
                        onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
