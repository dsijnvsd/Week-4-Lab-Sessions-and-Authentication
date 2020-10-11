
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
         <form action="login" method="Post">
           
             Username: <input type="text" name="username" value="${username}"><br>   
            Password <input type="password" name="password" value="${password}">  
            <br>
            <input type="submit" value="Login">
        </form>
        
          <div>
            <c:if test="${invalid}">
            <p>Invalid username or password</p>
            </c:if>
        </div>
            
        ${message}
        
    </body>
</html>
