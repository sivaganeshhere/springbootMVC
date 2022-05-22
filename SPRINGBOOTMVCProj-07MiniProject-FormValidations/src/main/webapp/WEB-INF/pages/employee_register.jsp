<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <script lang="JavaScript" src="validations.js">
    </script>
    <noscript>
    <h1 style="color: red;text-align: center">Please Unable Java Script in browser</h1>
    </noscript>
    <h1 style="color: green;text-align: center">Employee Registration</h1>
    <form:form modelAttribute="emp" onsubmit="return validation(this)">
        <form:hidden path="vflag"/>
<!--     <p style="color: red;text-align: center"> -->
<%--     <form:errors path="*"/> --%>
<!--     </p> -->
    <table border="1" bgcolor="cyan" align="center">
    <tr>
    <td>Employee name ::</td>
    <td><form:input path="ename"/><form:errors cssStyle="color:red" path="ename"/></td><span id="enameErr"></span>
    </tr>
    <tr>
    <td>Employee job ::</td>
    <td><form:input path="job"/><form:errors cssStyle="color:red" path="job"/></td><span id="jobErr"></span>
    </tr>
    <tr>
    <td>Employee sal::</td>
    <td><form:input path="sal"/><form:errors cssStyle="color:red" path="sal"/></td><span id="salErr"></span>
    </tr>
    <tr>
   <td colspan="2" align="center"><input type="submit" value="register Employee"></td>
    </tr>
    </table>
    <br><br>
    
    </form:form>
