<%-- 
    Document   : home
    Created on : Jul 31, 2023, 4:58:08 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1> name : <%= session.getAttribute("username") %></h1>
        <h1>pass : <%= session.getAttribute("password") %></h1>
        <h1>login status : <%= session.getAttribute("checklogin") %></h1>
        
    </body>
</html>
