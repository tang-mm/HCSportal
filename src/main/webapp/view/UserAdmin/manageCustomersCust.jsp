<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<div class="grc-application-list" style="margin: 0 auto;">
	<table id="table-list-tenant-in-customer">
		<thead>
			<tr>
				<th width="150px">Tenant Name</th>
				<th width="150px">Description</th>
				<th width="150px">Creation Date</th>
				<th width="150px">Last Modified</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listTenant}" var="tenant" varStatus="status">
				<tr>
					<c:forEach items="${tenant}" var="elem">
						<td><c:out value="${not empty elem ? elem : '-' }" /></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</t:wrapper>