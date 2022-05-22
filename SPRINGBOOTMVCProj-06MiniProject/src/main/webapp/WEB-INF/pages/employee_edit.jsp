<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <h1 style="color: green;text-align: center">Edit Employee Details </h1>
    <form:form modelAttribute="emp">
    <table border="1" bgcolor="cyan" align="center">
    <tr>
    <td>Employee no ::</td>
    <td><form:input path="empno" readonly="true"/></td>
    </tr>
    <tr>
    <td>Employee name ::</td>
    <td><form:input path="ename"/></td>
    </tr>
    <tr>
    <td>Employee job ::</td>
    <td><form:input path="job"/></td>
    </tr>
    <tr>
    <td>Employee sal::</td>
    <td><form:input path="sal"/></td>
    </tr>
    <tr>
   <td colspan="2" align="center"><input type="submit" value="Edit Employee"></td>
    </tr>
    </table>
    <br><br>
    
    </form:form>
