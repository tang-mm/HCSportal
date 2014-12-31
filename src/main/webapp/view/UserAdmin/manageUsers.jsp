<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<a href="createNewUser" class="btn-submit" style="margin: 0 auto;">Create
		New User</a>
	<br />
	<br />
	<br />
	
	<div class="grc-application-list" style="margin: 0 auto;">
		<table>
			<thead>
				<tr>

					<th width="100px">Username</th>
					<th width="100px">First Name</th>
					<th width="100px">Last Name</th>
					<th width="100px">User Type</th>
					<th width="150px">Customer</th> 
					<th width="150px">Last Logged In</th>
					<th width="80px">Status</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td><a href="userDetails?user=${user.userId}">${user.username}</a></td>
						<td><c:out value="${not empty user.firstName ? user.firstName : '-'}"/></td>
						<td><c:out value="${not empty user.lastName ? user.lastName : '-'}"/></td>
						<td>${user.userType.userType}</td>
						<td>${user.customer.customerName}</td>
						<td>${user.lastLoggedIn}</td>
						<c:choose>
							<c:when test="${user.enabled}">
								<td bgcolor="green">Active</td>
							</c:when>
							<c:otherwise>
								<td bgcolor="red">Deactivated</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>