
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Java World</title>

</head>
<body>
	<form:form action="submitRegistration" id="registerForm"
		name="registerForm" commandName="registerView">
		<table>
			<tr>
				<td><form:label path="userName">User Name: </form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="hobbies">Hobbies: </form:label></td>
				<td><form:checkboxes items="${hobbies}" path="hobbies" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender: </form:label></td>
				<td><form:radiobutton path="gender" value="Male" /> <form:label
						path="gender">Male</form:label> <form:radiobutton path="gender"
						value="Female" /> <form:label path="gender">Female</form:label></td>
			</tr>
			<tr>
				<td><form:label path="state">State: </form:label></td>
				<td><form:select path="state">
						<form:options items="${states}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:button value="Submit" name="Submit">Submit</form:button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>