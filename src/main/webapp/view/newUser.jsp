<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper> <!-- customized tag for template use -->

<form:form action="submitNewUser" id="registerForm"
		name="registerForm" commandName="registerView">
		<table>
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="userType">User Type: </form:label></td>
				<td><form:select path="userType">
						<form:options  items="${userTypes}" />
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>
<%-- 			<tr> --%>
<%-- 				<td><form:label path="gender">Gender: </form:label></td> --%>
<%-- 				<td><form:radiobutton path="gender" value="Male" />  --%>
<%-- 				<form:label path="gender">Male</form:label>  --%>
<%-- 				<form:radiobutton path="gender" value="Female" />  --%>
<%-- 				<form:label path="gender">Female</form:label></td>  --%>
<%-- 			</tr>   --%>
			<tr>
				<td><form:button value="Submit" name="Submit">Submit</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	
</t:wrapper>