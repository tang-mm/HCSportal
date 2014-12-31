<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<t:wrapper>
	<!-- list of all customers -->
	<a href="searchEquipment" class="btn-submit" style="margin: 0 auto;">Search
		Equipment</a>
		
	<a href="createNewEquipment" class="btn-submit" style="margin: 0 auto;">Add New
		Equipment</a>
	<br />
	<br />
	<div class="grc-application-list" style="margin-left: 30%;">
		<table>
			<thead>
				<tr>
					<th width="100px">Customer</th>
					<th width="100px">Tenant</th>
					<th width="80px">Total Number</th>
				</tr>
			</thead>
			<tbody> 
				<c:forEach items="${listTenant}" var="tenant">
					<tr>
						<td>${tenant.customer.customerName}</td>
						<td><a
							href="listEquipment?tenantId=${tenant.tenantId}&tenantName=${tenant.tenantName}">
								${tenant.tenantName} </a></td>
						<td>N/A
<%-- 						<c:if test="${not empty tenant.listEquipment}">${fn: length(tenant.listEquipment)}</c:if>-->--%></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>