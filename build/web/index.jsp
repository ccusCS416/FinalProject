<%-- 
    Document   : index
    Created on : Nov 3, 2015, 9:50:32 AM
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
        <a href="DisplayUserNamesServlet">Remove User</a><br>
        <h1>Add User</h1>
        <form action="JPAAdmin.jsp" method="POST">
            user name:<input type="text" name="userName"/><br>
            &nbsp;password:<input type="password" name="password"/><br>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
