<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
    	<%@ include file="/view/header.jsp"%>  <!-- path = "webapp/view" -->
	</jsp:attribute>
	<jsp:attribute name="menu">
<%-- 	    <%@ include file="../view/menu.jsp"%> --%> <!-- path = "webapp/WEB-INF/view" -->
<%-- 		<%@ include file="/view/menu_full.jsp"%> --%>
		<%@ include file="/view/menu.jsp"%>
	</jsp:attribute>
	<jsp:attribute name="footer">
	    <%@ include file="/view/footer.jsp"%>
	</jsp:attribute>
	<jsp:body> 
		<jsp:doBody />
    </jsp:body>
</t:genericpage>