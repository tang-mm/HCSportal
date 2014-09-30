<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>
 
  
<c:if test="${not empty pageContext.request.userPrincipal}">}">
	<div > HELLO: <br/>
	<c:out value="${pageContext.request.authType}" />
	<c:out value="${pageContext.request.userPrincipal.name}" />
	</div>
</c:if>

<!-- iframe: top level redirection disabled-->
<iframe name="iframe-main"
	sandbox="allow-forms allow-scripts allow-same-origin" height="100%"
	width="100%">fail</iframe>

<%@ include file="footer.jsp"%>