
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Java World</title>
</head>
<body>

	UserName: ${registerInfo.username}
<!-- 	<br /> Hobbies: -->
<%-- 	<c:forEach items="${registerInfo.hobbies}" var="hobby"> --%>
<%--       ${hobby} --%>
<%-- </c:forEach> --%>
	<br /> Password: ${registerInfo.password}
	<br /> User Type: ${registerInfo.userType}

</body>
</body>
</html>