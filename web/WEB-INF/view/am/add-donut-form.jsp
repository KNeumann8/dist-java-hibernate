<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Donut</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-donut-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>New Donut</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form:form action="save" modelAttribute="aDonut" enctype="multipart/form-data">
            <form:hidden path="id" value="${aDonut.id}"/>
            <form:hidden path="imageFilename" value="${aDonut.imageFilename}"/>
            <form:hidden path="dateAdded" value="${aDonut.dateAdded}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Calories</label></td>
                    <td><form:input path="calories"/>
                        <form:errors path="calories" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Shop</label></td>
                    <td>
                        <form:select path="shop" items="${shops}" itemLabel="name" itemValue="id">
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td><input type="file" name="donutImage"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>
    </div>
</div>
</body>
</html>
