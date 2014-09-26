<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<style>
.error {
	color: #ff0000;
}
</style>

<!-- login error message -->
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>

<!--  -->
<c:url value="/j_spring_security_check" var="loginUrl" />
<form:form method="post" action="${loginUrl}">
	<br />
	<label>Username: <label> 
	<input type="text" name="j_username" /> 
	<form:errors cssClass="error" /> <br /> 
	<label>Password: </label>
	<input type="password" name="j_password" /> 
	<form:errors cssClass="error" /> <br /> 
	<input type="submit" value="Login" />
</form:form>

</body>
</html>