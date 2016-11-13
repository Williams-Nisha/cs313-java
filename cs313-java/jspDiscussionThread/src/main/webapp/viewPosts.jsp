<%-- 
    Document   : viewPosts
    Created on : Nov 11, 2016, 9:02:57 PM
    Author     : Nisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Posts</title>
    </head>
    <body>
        
        <h1>Discussion Board Posts</h1>
                <c:forEach var="post" items="${posts}">
                    ${post}
                </c:forEach>
                      
        <p>Add another <a href="newPosts.jsp"> Post.</a></p>
    </body>
</html>
