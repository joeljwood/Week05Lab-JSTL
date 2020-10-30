<%-- 
    Document   : register
    Created on : Oct 18, 2020, 3:05:18 PM
    Author     : 850223
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form method="post" action="ShoppingList">
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register">
            <input type="submit" name="submit" value="Register">
        </form>
            <p>${registerMessage}</p>
    </body>
</html>
