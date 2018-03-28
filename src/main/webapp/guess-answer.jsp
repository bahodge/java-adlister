<%--
  Created by IntelliJ IDEA.
  User: benjaminhodge
  Date: 3/28/18
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess Answer</title>
</head>
<body>

    <h1>The Computer Number is: ${cpuNum}</h1>
    <h2>${answer}</h2>
    <form action="/guessinggame" method="GET">
        <button>Try Again</button>
    </form>
</body>
</html>
