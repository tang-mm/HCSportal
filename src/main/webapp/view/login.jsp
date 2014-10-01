<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:genericpage>
	<jsp:attribute name="header">
    	<%@ include file="/view/header.jsp"%>
	</jsp:attribute>
	<jsp:attribute name="footer">
	    <%@ include file="/view/footer.jsp"%>
	</jsp:attribute>

	<jsp:body>  
	
		<div class="grc-form">
	
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
		<form:form method="post" action="${loginUrl}" name="loginForm" class="grc-form-auth-800px">
			<div class="boxTop-800px"/>	
			<div class="boxMid-800px">
 <!-- 		<div class="boxMidImg-800px"
						style="background: transparent url('${pageContext.request.contextPath}/images/.png') no-repeat center bottom;" /> 
 -->
				<div class="boxMidInner-800px">
					<h2>Identification</h2><p/>
					<div class="row-800px">
						<label>Username: </label>
						<input type="text" name="j_username" class="grc-form-auth-username" />
						<form:errors cssClass="error" />
						</div> 
					<div class="row-800px">
						<label>Password: </label>
						<input type="password" name="j_password" />
						<form:errors cssClass="error" />
					</div> 
					<input type="submit" value="Login"
								class="btn submit-800px btn-submit" />
				</div> 
			</div>
			<div class="boxBot-800px"/>
			</form:form> 

		</div>
    </jsp:body>
</t:genericpage>