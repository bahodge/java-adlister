<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: benjaminhodge
  Date: 3/28/18
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp"/>
    <title>${ad.title}</title>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"/>

    <div class="container">
        <h1>${ad.title}</h1>
        <p>${ad.description}</p>
    </div>



</body>
</html>
