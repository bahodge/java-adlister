<%--
  Created by IntelliJ IDEA.
  User: benjaminhodge
  Date: 4/4/18
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>

<form class="form-group" action="/register" method="POST">
    <input class="form-control" type="text" name="username" placeholder="Username" required>
    <input class="form-control" type="email" name="email" placeholder="Email" required>
    <input class="form-control" type="password" name="password" placeholder="Password" required>
    <button type="submit">Submit</button>
</form>

</body>
</html>
