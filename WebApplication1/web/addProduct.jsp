
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    </head>
    <body>
        <h3>Role Admin</h3>
        <h1>Product Manager</h1>
        <br/>
        <form action="ProductManager" method="GET">
        <button type="submit" name="addProduct" value="true">Add Product</button>
        <br/>
    </form>
        <button>Update Product</button>
        <button>Delete Product</button>
        <br/>
        
        <form action="ProductManager" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>
        
    </body>
</html>