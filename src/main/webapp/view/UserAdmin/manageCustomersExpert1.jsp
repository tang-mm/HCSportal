<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
<style>
.tr-hidden-no-border {
	display:none;
	border: 0px none;
	background-color: #DBFFD7;
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
	<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create
		New Customer</a>
	<br />
	<br />
	<br />
<%-- 	</c:if> --%>
	<div class="grc-application-list" style="margin: 0 auto;">
		<table id="table-list-customer">
			<thead>
				<tr>
					<th width="120px">Service</th>
					<th width="120px">Description</th> 
					<th width="120px">Status</th>
					<th width="120px">Number of Sites</th>
				</tr>
			</thead>
			<tbody>
<%-- 				<c:forEach items="${listCustomer}" var="cust" varStatus="status"> --%>
					<tr>
<%-- 						<c:forEach items="${cust}" var="elem"> --%>
<%-- 							<td><c:out value="${not empty elem ? elem : '-' }" /></td> --%>
<%-- 						</c:forEach> --%>
						<td>Sale</td><td>Sale department</td><td><div class="info">
						
														<span>Non-emergency state</span>
														<img width="30px" height="30px"
															src="${pageContext.servletContext.contextPath}/images/off-Button-green.jpg" />
											 </div></td><td>1</td>
						<td><p>
								<span id="<c:out value="toggle_Tenant_${status.index}"/>"
									class="grc-icone-display toggle_Tenant">Details</span>
							</p></td>
					</tr><tr>
<%-- 						<c:forEach items="${cust}" var="elem"> --%>
<%-- 							<td><c:out value="${not empty elem ? elem : '-' }" /></td> --%>
<%-- 						</c:forEach> --%>
						<td>Finance</td><td>-</td><td><div class="info"> 
														<span>In Emergency</span>
														<img width="30px" height="30px"
															src="${pageContext.servletContext.contextPath}/images/on-Button.jpg" />
 
										</div></td><td>1</td>
						<td><p>
								<span id="<c:out value="toggle_Tenant_${status.index}"/>"
									class="grc-icone-display toggle_Tenant">Details</span>
							</p></td>
					</tr>
					<tr id="<c:out value="toBeToggled_Tenant_${status.index}"/>"
						class="tr-hidden-no-border">
						<td colspan="5">
							<table id="table-list-tenant-in-customer">
								<thead>
									<tr>
										<th width="80px">Site Code</th>
										<th width="80px">Location</th>
										<th width="80px">Time Zone</th>
										<th width="80px">Local Time</th>
										<th width="120px">Current Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listTenant}" var="tenant"
										varStatus="status">
										<tr>
											<c:forEach items="${tenant}" var="elem">
												<td><c:out value="${not empty elem ? elem : '-' }" /></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
<%-- 				</c:forEach> --%>
			</tbody>
		</table>

	</div>
</t:wrapper>