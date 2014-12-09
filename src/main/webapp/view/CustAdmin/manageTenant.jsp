<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<t:wrapper>

	<div class="grc-application-list" style="margin: 0 auto;">
		<table style="table-layout: fixed; width: 100%">
			<thead>
				<tr>
					<th width="150px">Tenant</th>
					<th width="250px">Description</th>
					<%-- 					<th width="150px">Creation Date</th> --%>
					<%-- 					<th width="150px">Last Modified</th> --%>
					<th width="150px">IP</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cust.listTenant}" var="tenant" varStatus="status">
					<tr>
						<td>${tenant.tenantName}</td>
						<td>${tenant.description}</td>
						<td>${tenant.ipMain}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>