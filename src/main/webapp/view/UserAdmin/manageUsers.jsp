<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<div class="grc-page-application">
		<a href="createNewUser" class="btn-submit" style="margin: 0 auto;">Create New User</a>
		<br/><br/><br/>
		<div class="grc-application-list" style="margin-left: 30%;">
			<table>
				<thead>
					<tr>
						<th width="100px">Username</th>
						<th width="80px">Type</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUser}" var="user">
						<tr>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.userType}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> 
	</div>
	
	
</t:wrapper>
