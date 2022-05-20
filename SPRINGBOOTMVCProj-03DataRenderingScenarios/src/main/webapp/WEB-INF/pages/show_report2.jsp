<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- MAP Collection -->
<b> Array Details::</b>
favorite Colors::
<c:if test="${!empty prodData}">

Product id ::${prodData.pid},
Product name :: ${prodData.pname},
Product price :: ${prodData.price},
Product Quantity ::${prodData.qty}<br>

</c:if><br>
