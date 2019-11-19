<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<html>
<head>
    <title>Oops! An error occurred</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h3>Oops! An error occurred</h3>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <p>${errorMessage}</p>
        </div>
    </div>
</body>
</html>
