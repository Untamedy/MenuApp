<%-- 
    Document   : index
    Created on : Oct 2, 2019, 7:06:27 PM
    Author     : YBolshakova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello</h1>
         <button onclick="location.href = 'all'">Show all dish</button>
         <br>
        <button onclick="location.href = 'add.jsp'">Add new dish</button>        
        <br>
        <button onclick="location.href = 'prise.jsp'">Find by price</button>
        <br>
        <button onclick="location.href = 'sale'">Show sale</button>        
        <br>
        <button onclick="location.href = 'weight.jsp'">Select by weight</button>
       
    </body>
</html>
