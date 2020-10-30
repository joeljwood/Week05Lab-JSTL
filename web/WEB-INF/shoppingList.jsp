<%-- 
    Document   : shoppingList
    Created on : Oct 18, 2020, 3:05:39 PM
    Author     : 850223
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>
        <p>Hello, ${username}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        
        <br> 
        <h2>List</h2>
        <form method="post" action="">
            <label>Add item:</label>
            <input type="text" name="listInput" value="${listItem}">
            <input type="hidden" name="action" value="add">
            <input type="submit" name="submit" value="Add Item">
        </form>
        <form method="post" action="">
            <c:forEach items='${shopingItems}' var='item'>
            <ul>
                <li><input type="radio" name="item" value="${item}">${item}</li>
            </ul>
            </c:forEach>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete"
        </form>
    </body>
</html>
