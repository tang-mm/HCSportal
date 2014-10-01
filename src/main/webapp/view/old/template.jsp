<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link type="text/css"
			href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
		<style>
		html, body {
			height: 100%
		}
		</style>
	</head>
	<body>
		<jsp:include page="/view/header1.jsp"/>
		<jsp:indlude page="/view/menu_full.jsp"/>
		<jsp:include page="/view/${param.content}.jsp"/>
		<jsp:include page="/view/footer1.jsp"/>	
	</body>
</html>