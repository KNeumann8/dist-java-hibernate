<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Donut</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-donut-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Donut Reviews</h2>
    </div>
</div>

<div id="container">
    <h3>Save Donut</h3>
    <div id="content">
        <form:form action="save" modelAttribute="donut">
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
                        <form:select path="shop" items="${donutShops}" itemLabel="name" itemValue="id">
                        </form:select>
                    </td>
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
