<%--
  Created by IntelliJ IDEA.
  User: ROMIK
  Date: 26.05.2017
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form modelAttribute ="commodity" method="post">
        <form:input path="name"/>
        <button>save</button>
    </form:form>

    <ol>
        <c:forEach var="commodity" items="${commodities}">
            <li>${commodities.name}<a href="/deleteCommodity/${commodities.id}">delete</a></li>--%>
        </c:forEach>
    </ol>

</body>
</html>
