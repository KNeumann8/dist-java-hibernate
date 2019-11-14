<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Donut</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-donut-style.css">
</head>
<body>
    <form:form action="save" modelAttribute="aDonut">
        <table>
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><label>Calories</label></td>
                <td><form:input path="calories"/></td>
            </tr>
            <tr>
                <td><label>Shop</label></td>
                <td><form:select items="${shops}" path="shop"
                itemLabel="name" itemValue="shopId">

                    </form:select></td>
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
</body>
</html>
