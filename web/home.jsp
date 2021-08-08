<%-- 
    Document   : home
    Created on : Mar 12, 2021, 8:30:44 PM
    Author     : ADmin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Food</h1>
        <form action="MainController" method="POST">
            Status <select name="cboStatus" >
                <option >Avaiable</option>
                <option >Delete</option>
            </select></br>
            <input type="submit" value="Search" name="action" />
            <c:set value="${param.cboStatus}" var="search" />
            <c:if test="${not empty search}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>ID</th>
                            <th>FoodName</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>CookingTime</th>
                            <th>Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LIST_FOOD}" var="search" varStatus="counter">

                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    <input type="text" value="${search.id}" /> 
                                </td>
                                <td>
                                    <input type="text" value="${search.name}"/>
                                </td>
                                <td>
                                      <input type="text" value="${search.description}"/>
                                    
                                </td>
                                <td>
                                      <input type="text" value=" ${search.price}"/>
                                   
                                </td>
                                <td>
                                      <input type="text" value="${search.cookingTime}"/>
                                    
                                </td>
                                <td>
                                    ${search.date}
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Delete" />
                                    <input type="hidden" name="id" value="${search.id}" />
                                    <input type="hidden" name="cboStatus" value="${search}" />
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Update" />
                                    <input type="hidden" name="id" value="${search.id}" />
                                    <input type="hidden" name="cboStatus" value="${search}" />
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:if>
        </form>
            <a href="create.jsp">Create Food</a>
    </body>
</html>
