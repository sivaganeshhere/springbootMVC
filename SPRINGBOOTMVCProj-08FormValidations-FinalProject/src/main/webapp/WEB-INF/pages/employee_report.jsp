<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
<div  class="container">
<c:choose>
<c:when test="${!empty empdata}">
<table border="1" bgcolor="cyan" align="center" class="table table-hover">
  <tr class="table-danger">
    <th>EmpNo</th>
    <th>EmpName</th>
    <th>Job</th>
    <th>Sal</th>
    <th>Operations</th>
  </tr>
  <c:forEach var="emp" items="${empdata}">
  <tr class="table-success">
  <td>${emp.empno}</td>
  <td>${emp.ename}</td>
  <td>${emp.job}</td>
  <td>${emp.sal}</td>
  <td><a href="edit?no=${emp.empno}">Edit</a>&nbsp;&nbsp;&nbsp;<a onclick="return confirm('Do You Want To Delete')"  href="delete?no=${emp.empno}">Delete</a></td>
  </tr>
  </c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center;">Records Are Not Found</h1>
</c:otherwise>
</c:choose>
</div>
<c:if test="${!empty resultMsg}">
<h3 style="color: green;text-align: center;">${resultMsg}</h3>
</c:if>
<hr>
<h1 style="text-align: center;"><a href="./">Home</a></h1>
<hr>
<br>
<br>
<h1 style="color:red;text-align:center;"><a href="addemployee">Add Employee</a></h1>