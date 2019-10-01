<%-- 
    Document   : weight
    Created on : 30.09.2019, 0:53:01
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div>
            <form method="post">
        <label>Total weight:
            <input type="text" name="weight" required placeholder="Total weight"><br />
        </label>
        <br>
            
        <br>
        <button type="submit">Submit</button>
    </form>            
        </div>
        <div>
            <button onclick="location.href='index.html'">Back to main</button>
        </div>
    </body>
</html>
