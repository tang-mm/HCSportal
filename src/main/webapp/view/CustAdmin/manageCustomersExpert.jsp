<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:wrapper>
<style>
.tr-hidden-no-border {
	display: none;
	border: 0px none;
	background-color: #DBFFD7;
}

.line-wrap {
	word-wrap: break-word;
	text-align: left;
	line-height: 150%;
}
</style> 

<script type="text/javascript"> 	
	function expandTenant(index) {
		$('#toBeToggled_Tenant_'+index).slideToggle('slow');
		return;
	}
	
	$(document).ready(function() {
		$('.toggle_Tenant').click(function (event) {
			var button_id = event.target.id;
			var array = button_id.split("_");
			var index = array[array.length-1];
			expandTenant(index);
		});
	});
		
</script>

	<!-- visible only to L3 Experts --> 
<%-- 	<c:if test="${isExpertL3}"> --%>
	<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create New Customer</a>
	<br />
	<br />
	<br />
<%-- 	</c:if> --%>
 
	<div class="grc-application-list" style="margin: 0 auto;">
		<table id="table-list-customer" style=" table-layout: fixed;">
			<thead>
				<tr>
					<th width="150px">Customer</th>
					<th width="250px">Description</th>
<%-- 					<th width="150px">Creation Date</th> --%>
<%-- 					<th width="150px">Last Modified</th> --%>
					<th width="150px">Number of Tenants</th>
					<th width="50px"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCustomer}" var="cust" varStatus="status">
					<tr>
						<td><a href="customerDetails?customer=${cust.customerName}">${cust.customerName}</a></td>
						<td class="line-wrap"><c:out value="${not empty cust.description ? cust.description : '-'}"/> </td>
						<td>${fn: length(cust.listTenant)}</td>
						<td><p>
								<span id="<c:out value="toggle_Tenant_${status.index}"/>"
									class="grc-icone-display toggle_Tenant"></span>
							</p></td>
					</tr>
					<tr id="<c:out value="toBeToggled_Tenant_${status.index}"/>"
						class="tr-hidden-no-border">
						<td colspan="4">
							<table id="table-list-tenant-in-customer">
								<thead>
									<tr>
										<th width="150px">Tenant Name</th>
										<th width="150px">Description</th>
<%-- 										<th width="150px">Creation Date</th> --%>
<%-- 										<th width="150px">Last Modified</th> --%>
										<th width="150px">IP</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cust.listTenant}" var="tenant" varStatus="status">
										<tr>
											<td><a href="tenantDetails?tenant=${tenant.tenantName}">${tenant.tenantName}</a></td>
											<td><c:out value="${not empty tenant.description ? tenant.description : '-'}"/></td>
											<td>${tenant.ipMain}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</t:wrapper>