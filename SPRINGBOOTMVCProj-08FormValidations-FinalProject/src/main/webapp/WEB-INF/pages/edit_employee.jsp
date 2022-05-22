<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <h1 style="color:red;text-align:center"> Employee</h1>
       <noscript>
    <h1 style="color: red;text-align: center"> Please Unable JavaScript Site Testing</h1>
    </noscript>
    <style media="all">
	body {
	background-color: pink;
   }span {
	color: red;
}
</style>
    <script type="text/javascript" src="js/validations.js">

</script>
<form:form modelAttribute="emp" onsubmit="return validation(this)">
<%-- <p style="color: red;text-align: center">
<form:errors path="*"/>
</p> --%>
<table border="1" align="center" bgcolor="pink">
  
  <tr>
    <td>Employee no ::</td>
    <td><form:input path="empno" readonly="true"/></td>
  </tr>
  <tr>
    <td>Employee name ::</td>
    <td><form:input path="ename"/><form:errors cssStyle="color:red" path="ename"/><span id="enameErr"></span></td>
  </tr>
    <tr>
    <td>Employee Job::</td>
    <td><form:input path="job"/><form:errors cssStyle="color:red" path="job"/><span id="jobErr"></span></td>
  </tr>
  <tr>
    <td>Employee salary::</td>
    <td><form:input path="sal"/><form:errors cssStyle="color:red" path="sal"/><span id="salErr"></span></td>
  </tr>
  <tr>
  <td colspan="2" align="center"><input type="submit" value="edit Employee"></td>
  </tr>
<form:hidden path="vflag"/>
</table>

</form:form>