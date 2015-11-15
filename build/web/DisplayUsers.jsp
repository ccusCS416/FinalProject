<%-- 
    Document   : PersonDisplay
    Created on : Nov 4, 2011, 2:32:56 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${empty param.forward}">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
            </head>
            <body>

     </c:when>
</c:choose>
        <h1>Matching People</h1>
        <table border="1">
            <tr>
                <th>User Name</th>
            </tr>
            <c:forEach var="user" items="${userNames}">
                <tr>
                    <td><c:out value="${user.username}" /></td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.jsp">Back to Index</a><br/>
<c:choose>
    <c:when test="${empty param.forward}">
    </body>
</html>

     </c:when>
</c:choose>

