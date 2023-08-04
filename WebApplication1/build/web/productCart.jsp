
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Cart</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    </head>
    <body>
        <h3>Role User</h3>
        <h1>Product List</h1>
        <br>

        <form action="CartProduct" method="POST">
            <button type="submit" name="deleteCart" value="true">Delete Cart</button>
            <button type="submit" name="payment" value="true">Payment</button>
            <br>
        </form>

        <br/>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Category ID</th>
            </tr>
            <%-- Loop through the listProduct and display each product --%>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.quantity}</td>
                    <td>${product.categoryId}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>