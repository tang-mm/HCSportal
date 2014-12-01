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
					<th width="150px">Description</th>
					<th width="150px">Last Logged In</th>
					<th width="80px">Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>admin1</td>
					<td>admin1</td>
					<td>ADMIN1</td>
					<td>Administrator</td>
					<td>--</td>
					<td>2014-11-11 12:00:00</td>
					<td bgcolor="green">Active</td>
				</tr>
				<tr>
					<td>hyper1</td>
					<td>hyper1</td>
					<td>HYPER1</td>
					<td>Hypervisor</td>
					<td>Commercial Department</td>
					<td>2014-11-11 12:00:00</td>
					<td bgcolor="green">Active</td>
				</tr>
				<tr>
					<td>hyper2</td>
					<td>hyper2</td>
					<td>HYPER2</td>
					<td>Hypervisor</td>
					<td>--</td>
					<td>2014-02-02 12:00:00</td>
					<td bgcolor="red">Deactivated</td>
				</tr>
				<tr>
					<td>super1</td>
					<td>super1</td>
					<td>SUPER1</td>
					<td>Supervisor</td>
					<td>Engineering Team</td>
					<td>2014-11-11 12:00:00</td>
					<td bgcolor="green">Active</td>
				</tr>
			</tbody>
			</table>
			</br></br></br>
			</div>

	<div class="grc-application-list" style="margin: 0 auto;">
		<table>
			<thead>
				<tr>
					<th width="150px">Username</th>
					<th width="150px">Domain Name</th>
					<th width="150px">Parent Created By</th>
					<th width="150px">Creation Date</th>
					<th width="150px">Last Login</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<c:forEach items="${user}" var="elem">
							<td><c:out value="${not empty elem ? elem : '-' }" /></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>