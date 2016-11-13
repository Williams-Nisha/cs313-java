<%-- 
    Document   : signin
    Created on : Nov 11, 2016, 9:01:42 PM
    Author     : Nisha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
    </head>
    <body>
                 <span class="error" style="color:red;">${error}</span>
         <form action="signIn" method="POST">
              Username: <input type="text" name="username" /><br />
              Password: <input type="password" name="password" /><br />
              <input type="submit" value="Sign In" />
         </form>
    </body>
</html>
