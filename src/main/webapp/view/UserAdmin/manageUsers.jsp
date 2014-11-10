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