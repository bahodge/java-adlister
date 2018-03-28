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
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
</head>
<body>

<%--Check if valid login--%>
<%! private int loginAttempts = 0; %>

<%
    if (request.getMethod().equals("POST")){
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if ( user.equals("admin") && pass.equals("password")){
            response.sendRedirect("/profile.jsp");
        } else if ( !user.equals("admin") || !pass.equals("password")){
            loginAttempts++;
            response.sendRedirect("/login.jsp");

        }
    }
%>

<jsp:include page="partials/navbar.jsp"/>
<div class="container">
    <h1>Please login</h1>
    <h2>Login Attempts: <%= loginAttempts %></h2>
    <form action="/login.jsp" method="POST">
        <input type="text" name="username" placeholder="Enter Username">
        <input type="password" name="password" placeholder="Enter Password">
        <button type="submit">Login</button>
    </form>
</div>

<jsp:include page="partials/scripts.jsp"/>
</body>
</html>
