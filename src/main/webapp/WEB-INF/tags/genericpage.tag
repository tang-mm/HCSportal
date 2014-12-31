<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="menu" fragment="true"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MCC Web</title>
<link type="text/css"
	href="${pageContext.servletContext.contextPath}/css/main.css"
	rel="stylesheet">
<!-- path = "webapp/css" -->
<!-- path = "webapp/WEB-INF/css" -->
<style>
html, body {
	height: 100%
}
</style>


<script src="${pageContext.servletContext.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function changeAppliTitle(myTitle) {
		document.getElementById("application_title").innerHTML = myTitle;
	}
</script>

</head>
<body>
	<div class="grc-wrapper">
		<div id="pageheader">
			<jsp:invoke fragment="header" />
		</div>
		<div id="pageMenu">
			<jsp:invoke fragment="menu" />
		</div>
		<div id="body" style="min-height: 80%">
			<div class="grc-page-appli">
				<label id="application-title" onload="changeAppliTitle('${pageContext.servletContext.contextPath}')">[Title here]</label>
			</div>
			<div class="grc-page">
				<jsp:doBody />
			</div>
		</div>
		<div id="pagefooter">
			<jsp:invoke fragment="footer" />
		</div>
	</div>
</body>
</html>