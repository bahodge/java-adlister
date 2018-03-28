<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Current Advertisements" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />



<%--Ads go here--%>
<div class="container">
    <h1>Current Ads</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="col-xs-6">
            <h3><a href="/ad-page?id=${ad.id}">${ad.title}</a></h3>
        </div>
    </c:forEach>

</div>



</body>
</html>
