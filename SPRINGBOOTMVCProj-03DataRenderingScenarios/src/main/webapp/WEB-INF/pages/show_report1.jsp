<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- MAP Collection -->
<b> Array Details::</b>
favorite Colors::
<c:if test="${!empty favColors}">
<c:forEach var="color" items="${favColors}">
${color},
</c:forEach>
</c:if><br>
<b>List  Details::</b>
nickNames::
<c:if test="${empty nickNames}">
<c:forEach var="names" items="${nickNames}"></c:forEach>
${names},
</c:if><br>
<b>Set Details::</b>
phone numbers ::
<c:if test="${!empty phoneNumbers}">
<c:forEach var="phone" items="${phoneNumbers}">
${phone},
</c:forEach>
</c:if><br>
<b>Map Details::</b>
iD Details ::
<c:if test="${!empty idDetails}">
	${idDetails.aadhar},
	${idDetails.voterId},
	${idDetails.bankAc}<br>
</c:if><br>
<c:if test="${!empty idDetails}">
	<c:forEach var="id" items="${idDetails}">
	${id.key}---------------->${id.value}<br>
	</c:forEach>
</c:if>