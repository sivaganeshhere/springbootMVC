<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form  method="POST" modelAttribute="stud">
<table border="1" align="center" bgcolor="cyan">

<tr>
<td>Student number</td>
<td><form:input path="sno"/></td>
</tr>
<tr>
<td>Student name</td>
<td><form:input path="sname"/></td>
</tr>
<tr>
<td>Student adress</td>
<td><form:input path="sadd"/></td>
</tr>
<tr>
<td>Student average</td>
<td><form:input path="avg"/></td>
</tr>
<tr>
<td colpsan="2"><input type="submit" value="Register"></td>
</tr>
</table>
</form:form>

