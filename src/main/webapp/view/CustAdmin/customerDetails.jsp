<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper>

<style>
.mandatory {
	color: red;
}  
</style>

<script type="text/javascript"> 	
	function showForm() {
		$('#newTenantForm').slideToggle('slow');
		return;
	}
		
	function concatenateIP() { 
		ip = $('#ip1').val() + '.' + $('#ip2').val() + '.' +$('#ip3').val() + '.' + $('#ip4').val(); 
		return ip;
	}
	
	$(document).ready(function() { 
		$('#newTenant').click(function() {
			showForm();
			$('html, body').animate({scrollTop: $('#newTenant').offset().top});
		});
		
		$('#SubmitNewTenant').click(function() {
			document.getElementById('ipFull').value = concatenateIP();
		});
		
		$('.deleteRow').click(function(event) {
			var button_id = event.target.id;
			window.alert(button_id);
			var array = button_id.split("_");
			var index = array[array.length-1];
			window.alert(index);
			document.getElementById('table-list-tenant').deleteRow(index + 1);
		});
	});
</script>

	<div class="grc-form block" style="margin: 0 auto;">
		<form:form action="customerDetails" id="customerDetailsForm"
			name="customerDetailsForm" commandName="customerCmd">
			<div>
				<h1>Customer Details</h1>
			</div>

			<div class="grc-form">
				<table>
					<tbody>
						<tr class="grc-form-input-text grc-form-no-border">
							<td style="width: 35%"><label>Customer Name: </label></td>
							<td colspan="2"><div>${customerName}</div>  	//TODO modify button: div -> input 
							<form:input path="customerName" value="" /></td>
						</tr>
						<tr class="grc-form-no-border">
							<td colspan="1"><label>Description: </label></td>
							<td colspan="2"><form:textarea path="description" value="" rows="5"
									cols="30" /></td>
						</tr>
						<tr class="grc-form-buttons grc-form-no-border">

							<c:if test='${not empty messageCustomer}'>
								<td colspan="1"></td>
								<td colspan="2"><div style="color: red; margin-left: auto;">${messageCustomer}</div></td>
							</c:if>
							<td colspan="3"><input type="submit"
								class="grc-form-buttons-validate" value="Submit" name="Submit"></input></td>
						</tr>
					</tbody>
				</table>

				<div class="grc-application-list" style="margin: 0 auto;">
				<p><h2>Number of Tenants: ${fn:length(newCustomerCmd.listTenant)}</h2></p>
					<table id="table-list-tenant">
						<thead>
							<tr>
								<th width="100px">Tenant Name</th>
								<th width="100px">IP Domain</th>
								<th width="150px">Description</th> 
								<th width="50px"></th>
							</tr>
						</thead>
						<tbody>
							<c:if test='${not empty newCustomerCmd.listTenant}'>
								<c:forEach items="${newCustomerCmd.listTenant}" var="tenant" varStatus="status">
									<tr>
										<td>${tenant.tenantName}</td>
										<td>${tenant.ipMain}</td>
										<td>${tenant.description}</td> 
										<td> <a id="<c:out value="deleteTenant_${status.index}"/>" href="removeTenantFromList?name=${tenant.tenantName}" class="deleteRow">Delete</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div> 
			</div>
		</form:form>

	<a href="#newTenant" class="btn-submit" id="newTenant">Add New Tenant</a>

		<form:form action="addNewTenantToList" id="newTenantForm"
			name="newTenantForm" commandName="newTenantCmd" style="display: none;">
			<div class="grc-form">
				<table>
					<tbody>
						<tr class="grc-form-input-text grc-form-no-border">
							<td style="width: 35%"><label>Tenant Name: </label></td>
							<td colspan="2"><form:input path="tenantName" value="" /></td>
						</tr>
						<tr class="grc-form-no-border">
							<td colspan="1"><label>IP: </label></td>
							<td colspan="2"><input id="ip1" size="1" maxlength="3"><input id="ip2" size="1" maxlength="3"><input id="ip3" size="1" maxlength="3" class="ipInput"><input id="ip4" size="1" maxlength="3"></td>
							<form:input type="hidden" id="ipFull" path="ipMain" maxlength="15" value=""/> 
						</tr>
<%-- 						<tr class="grc-form-no-border"> --%>
<%-- 							<td colspan="1"><label>Prefix length: </label></td> --%>
<%-- 							<td colspan="2"><form:input path="prefixLength" value="24" /></td> --%>
<%-- 						</tr> --%>

						<tr class="grc-form-no-border">
							<td colspan="1"><label>Description: </label></td>
							<td colspan="2"><form:textarea path="description" rows="5"
									cols="30" /></td>
						</tr>
						
						<tr class="grc-form-buttons grc-form-no-border">

							<c:if test='${not empty messageTenant}'>
								<td colspan="1"></td>
								<td colspan="2"><div style="color: red; margin-left: auto;">${messageTenant}</div></td>
							</c:if>
							<td colspan="3"><input type="submit"
								class="grc-form-buttons-validate" value="Add" name="SubmitNewTenant" id="SubmitNewTenant"></input></td> 
			</tbody>
				</table>
			</div>
		</form:form> 
	</div>
</t:wrapper>
