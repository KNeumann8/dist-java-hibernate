<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Oops! An Error Occurred</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Donut Reviews</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <p>${errorMessage}</p>
        </div>
    </div>
</body>
</html>
