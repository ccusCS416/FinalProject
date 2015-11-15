<%-- 
    Document   : JPAAdmin
    Created on : Nov 3, 2015, 9:56:28 AM
    Author     : sabo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <form action="JPAAdUser" method="POST">
            user name:<input type="text" name="userName"/><br>
            &nbsp;password:<input type="password" name="password"/><br>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
