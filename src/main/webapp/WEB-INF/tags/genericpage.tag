<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="menu" fragment="true"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<style>
html, body {
	height: 100%
}
</style>
</head>
<body>
	<div class="grc-wrapper">
		<div id="pageheader">
			<jsp:invoke fragment="header" />
		</div>
		<div id="pageMenu">
			<jsp:invoke fragment="menu" />
		</div>
		<div class="grc-page">
			<div id="body">
				<jsp:doBody />
			</div>
		</div>
		<div id="pagefooter">
			<jsp:invoke fragment="footer" />
		</div>
	</div>
</body>
</html>