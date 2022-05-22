<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="stylesheet" 
    	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
    	<div class="container">
    <c:choose>
    <c:when test="${!empty empData}">
   <!-- <table border="1" align="center" bgcolor="cyan" class="table table-striped"> --> 
    <table border="1" align="center" bgcolor="cyan" class="table table-hover">
    <tr class="table-danger">
    <th>EmpNo</th>
    <th>EmpName</th>
    <th>Job</th>
    <th>Salary</th>
    <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${empData}" >
    <tr class="table-success">
    <td>${emp.empno}</td>
    <td>${emp.ename}</td>
    <td>${emp.job}</td>
    <td>${emp.sal}</td>
    <td><a href="edit?no=${emp.empno}">Edit</a>&nbsp&nbsp<a onclick="return confirm ('do you want to delete')" href="delete?no=${emp.empno}">Delete</a></td>
    </tr>
    </c:forEach>
    
    </table>
    </c:when>
    <c:otherwise>
    <h1 style="color: red;text-align: center">Records Not Found</h1>
    </c:otherwise>
    </c:choose>
    <c:if test="${!empty resultMsg}">
    <p style="color: green;text-align: center">${resultMsg}</p>
    </c:if>

     
    <br><br>
    <hr>
    <hr>
    <h1 style="color: blue;text-align: center"><a href="add">AddEmployee</a></h1>
</div>