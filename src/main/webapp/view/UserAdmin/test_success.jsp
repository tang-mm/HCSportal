
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Java World</title>
</head>
<body>

	UserName: ${newUserCmd.username}
	<br /> Hobbies:
<%-- 	<c:forEach items="${newUserCmd.hobbies}" var="hobby"> --%>
<%--       ${hobby} --%>
<%-- </c:forEach> --%>
	<br /> Gender: ${newUserCmd.userTypeId}
	<br /> State: ${newUserCmd.password}

</body>
</body>
</html>