<%-- 
    Document   : create
    Created on : Mar 13, 2021, 12:29:39 AM
    Author     : ADmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Food</title>
    </head>
    <body>
        <c:set value="${requestScope.ERROR}" var="error"/>
        <form action="MainController" method="POST">
            ID: <input type="text" name="id" required="true"/></br>
            <c:if test="${error != null}">
                ${error.idErr} </br>
            </c:if>
            Name: <input type="text" name="name" required="true"/></br>
            <c:if test="${error != null}">
                ${error.nameErr} </br>
            </c:if>
            Description:<input type="text" name="description" required="true"/></br>
            <c:if test="${error != null}">
                ${error.descriptionErr} </br>
            </c:if>
            Price: <input type="text" name="price" required="true"/></br>
            <c:if test="${error != null}">
                ${error.priceErr} </br>
            </c:if>
            CookingTime:    <input type="text" name="cookingTime" required="true"/></br>
            <c:if test="${error != null}">
                ${error.cookingTimeErr} </br>
            </c:if>
            <input type="submit" value="Create" name="action" />
            <input type="reset" value="Reset" />
        </form>
        <a href="home.jsp">Back To Shopping</a>
    </body>
</html>
