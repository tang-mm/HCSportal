<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<style>
.error {
	color: #ff0000;
}
</style>

<!-- login error message -->
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<div class="error">
		Login error: <br /> Invalid Username or Password!<br />
	</div>
</c:if>

<!-- logout message -->
<c:if test="${not empty logoutMsg}">
	<div class="error">
		Logout successfully!
		<c:out value="${logoutMsg}" />
	</div>
</c:if>

<c:url value="/j_spring_security_check" var="loginUrl" />
<form:form method="post" action="${loginUrl}" name="loginForm">
	<br />
	<label>Username: </label>
	<input type="text" name="j_username" />
	<form:errors cssClass="error" />
	<br />
	<label>Password: </label>
	<input type="password" name="j_password" />
	<form:errors cssClass="error" />
	<br />
	<input type="submit" value="Login" />
</form:form>

</body>
</html>