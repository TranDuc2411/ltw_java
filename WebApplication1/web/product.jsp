
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
        <a href="http://localhost:8080/WebApplication1/ProductManager">Click to refresh</a>
        <h3>Role Admin</h3>
        <h1>Product Manager</h1>
        <br>

        <form action="ProductManager" method="POST">
            <label for="productId">ID:</label>
            <input type="text" id="productId" name="productId">

            <label for="productName">Name:</label>
            <input type="text" id="productName" name="productName">

            <label for="productPrice">Price:</label>
            <input type="text" id="productPrice" name="productPrice"><br>

            <label for="productDescription">Description</label>
            <input type="text" id="productDescription" name="productDescription">

            <label for="productQuantity">Quantity</label>
            <input type="text" id="productQuantity" name="productQuantity">

            <label for="productCategoryID">Category ID</label>
            <input type="text" id="productCategoryID" name="productCategoryID"><br>
            <br/>

            <!-- Add more fields for other product information -->

            <button type="submit" name="addProduct" value="true">Add Product</button>

            <button type="submit" name="updateProduct" value="true">Update Product</button>

            <button type="submit" name="deleteProduct" value="true">Delete Product</button>

            <label for="nameSearchProduct">Search Product Name:</label>
            <input type="text" id="nameSearchProduct" name="nameSearchProduct">
            <button type="submit" name="searchProduct" value="true">Search Product</button>
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