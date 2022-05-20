<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty prodData}">
<table bgcolor= "cyan" align="center" border="1">
<tr>
<th>PID</th><th>PNAME</th><th>PRICE</th><th>QUANTITY</th>
</tr>
<c:forEach var="prod" items="${prodData}">
<tr>
<td>${prod.pid}</td>
<td>${prod.pname}</td>
<td>${prod.price}</td>
<td>${prod.qty}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color: red;text-align: center">Records Not Found</h1>
</c:otherwise>
</c:choose>
