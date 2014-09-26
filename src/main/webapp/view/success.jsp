<%@page session="false" isElIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - success</title>
</head>
<body>
 	<h1>Welcome <c:out value="${name}"/></h1>
 	
 	<form:form action="/success" method="post" commandName="user">
 		<form:label path="name">Name: </form:label>${user.username}</br>
 		<form:label path="password">Password:</form:label>${password}</br>
 	</form:form>
</body>
</html>