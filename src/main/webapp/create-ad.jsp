<%--
  Created by IntelliJ IDEA.
  User: benjaminhodge
  Date: 3/28/18
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Create Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />

<div class="container">


<h1 class="text-center">Create a new Listing</h1>
<form action="/create" method="POST">
    <div class="row">
        <div class="col-xs-12">
            <input class="center-block" type="text" name="title" placeholder="Title">
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <textarea class="center-block" name="description" cols="30" rows="5" placeholder="Description"></textarea>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-3 col-xs-offset-6">
            <button class="btn btn-success">Create</button>
        </div>

    </div>
</form>
</div>

</body>
</html>
