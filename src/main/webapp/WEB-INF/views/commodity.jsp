<%--
  Created by IntelliJ IDEA.
  User: ROMIK
  Date: 26.05.2017
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align:center;margin-top: 5%">
    <form:form modelAttribute ="commodity" method="post">
        <form:input path="name" placeholder="commodity name" disabled="false"/>
        <form:input  path ="price" placeholder ="commodity price"/>
        <form:input type="number" path="quantity" placeholder="commodity quantity"/>
        <form:input path="description" placeholder="commodity description"/>
        <button>save</button>
    </form:form>
        <table border="2"bgcolor="aqua">
        <thead>
        <tr>
            <th>
               name
            </th>
            <th>
               price
            </th>
            <th>
                quantity
           </th>
            <th style="-webkit-column-width: 350px;-moz-column-width: 350px;">
                description
            </th>
            <th>
               delete
            </th>
            <th>
                update
            </th>
        </tr>
        </thead>
            <tbody>
            <c:forEach var="commodity" items="${commodities}">
                <tr>
                    <td><c:out value="${commodity.name}"/></td>
                    <td><c:out value="${commodity.price}"/></td>
                    <td style="text-align: center"><c:out value="${commodity.quantity}"/></td>
                    <td style="word-wrap:break-word "><c:out value="${commodity.description}"/></td>
                    <td><a href="/deleteCommodity/${commodity.id}">delete</a></td>
                    <td><a href="/updateCommodity/${commodity.id}">update</a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
</div>
</body>
</html>
