<%-- 
    Document   : add
    Created on : 30.09.2019, 0:52:31
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
                <label>Name:
                    <input type="text" name="name" required placeholder="Dish name"><br />
                </label>
                <br>
                <label>Weight:
                    <input type="text" name="weight" required placeholder="Dish weight"><br />
                </label>   
                 <label>Price:
                    <input type="text" name="price" required placeholder="Dish price"><br />
                </label> 
                 <label>Is in sale list?:
                    <input type="text" name="sale" required placeholder="Dish is in sale list?(Yes/No)"><br />
                </label> 
                
                <br>
                <button type="submit">Submit</button>
            </form>            
        </div>
        <div>
            <button onclick="location.href = 'index.html'">Back to main</button>
        </div>
    </body>
</html>
