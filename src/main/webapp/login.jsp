<%--
  Created by IntelliJ IDEA.
  User: benjaminhodge
  Date: 3/27/18
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%--Check if valid login--%>
<%
    if (request.getMethod().equals("POST")){
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if ( user.equals("admin") && pass.equals("password")){
            response.sendRedirect("/profile.jsp");
        } else if ( !user.equals("admin") || !pass.equals("password")){
            response.sendRedirect("/login.jsp");
        }
    }
%>

<%!
    private int doMath(int x, int y){
        return x + y;
    }
%>

<jsp:include page="partials/navbar.jsp"/>

<h1>Please login</h1>
<h2>This is me doing some cool math!!! ::: <%= doMath(10, 5) + doMath(1000, -889)%></h2>

<form action="/login.jsp" method="POST">
    <input type="text" name="username" placeholder="Enter Username">
    <input type="password" name="password" placeholder="Enter Password">
    <button type="submit">Login</button>
</form>

</body>
</html>
