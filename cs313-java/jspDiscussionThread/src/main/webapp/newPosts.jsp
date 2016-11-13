<%-- 
    Document   : newPosts
    Created on : Nov 11, 2016, 9:02:46 PM
    Author     : Nisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discussion Board</title>
    </head>
    <body>
        <h1>Discussion Board</h1>
        <p>Click to <a href="viewPosts.jsp">View Posts.</a></p>
        <form action="CreatePosts" method="POST">
            <strong>Add a Post:</strong><br/><br/>
            <textarea name="newPost" rows="4" cols="20">
Start Typing...
            </textarea><br/>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
