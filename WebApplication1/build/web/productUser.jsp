
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
        <h3>Role User</h3>
        <h1>Product Add</h1>
        <br>

        <form action="UserView" method="POST">
            <label for="nameSearchProduct">Search Product Name</label>
            <input type="text" id="nameSearchProduct" name="nameSearchProduct">
            <button type="submit" name="searchProduct" value="true">Search Product</button>
            <br>
        </form>
        
        <form action="CartProduct" method="POST">
            <button type="submit" name="showCart" value="true">Show Cart</button>
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
                    <td>
                        <form action="UserView" method="post">
                            <input type="hidden" name="productId" value="${product.id}">
                            <input type="submit" name="addCartProduct" value="Add to cart">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>