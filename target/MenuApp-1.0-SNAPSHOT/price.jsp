<%-- 
    Document   : price
    Created on : 30.09.2019, 0:52:45
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Price</title>
    </head>
    <body>
        <div>
            <form method="post">
        <label>Min price:
            <input type="text" name="min" required placeholder="Min price"><br />
        </label>
        <br>
        <label>Max price:
            <input type="text" name="max" required placeholder="Max price"><br />
        </label>       
        <br>
        <button type="submit">Submit</button>
    </form>            
        </div>
        <div>
            <button onclick="location.href='index.html'">Back to main</button>
        </div>
           
    </body>
</html>
