<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${pageContext.servletContext.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">	
	// 	 send request for retrieving data and display table
	$(document).ready(function() {
		$('#selectCustomerBtn').click(function() {  
			var custId = document.getElementById('selectCust').value; 
			retrieveList(custId);
			$("#serviceList").find('tbody').remove();	// clear current list
			$("#serviceList").show();  // display table
			return false;
		});
	});   
	
	// retrieve serviceList
	function retrieveList(custId) {
		$.getJSON("listServices?custId=" + custId, function(result, textStatus, jqXHR) {
			var d = new Date($.now()); 
			var time = d.getHours() + ":" + (d.getMinutes()<10 ? "0" : "") + d.getMinutes() +":"
						+ (d.getSeconds()<10 ? "0" : "") + d.getSeconds();
			$.each(result,
					function(i, elem) {
						if (elem.open == true) {
							var $state = $('<td>').append($('<div>').text('Open').addClass("status_open green"));
						}else {
							var $state = $('<td>').append($('<div>').text('Closed').addClass("status_open red"));							
						}

						var ref = "serviceDetails?id=" + elem.serviceId ;
						var $tr = $('<tr>').append(
								$('<td>').append($('<a>').attr('href', ref).text(elem.serviceCode)),
								$('<td>').text(elem.location),
								$('<td>').text(elem.timeZone),
								$('<td>').text(time),
								$state);
						$tr.appendTo('#serviceList');
					}); 
			}) .fail(function(jqXHR, textStatus, errorThrown) {
				// handle error here***************
			}); 
	}
</script>

<style>
#selectCust {
	min-width : 150px;
}
#selectCust option {
	min-width : 150px;
}

.hidden {
	display: none;
}

.table-col1 {
	width: 100px;
}

.table-col2 {
	width: 80px;
}
</style>

<t:wrapper>
	<div class="grc-page">  
		<form action="" id="selectCustomerForm" style="margin-left: 30%">
			<h1>Please select a tenant:</h1><br/>
			<select id="selectCust" >
				<option value="">--</option>
				<c:forEach items="${listCustomer}" var="tenant">
					<option value="${tenant.tenantId}">${tenant.tenantName}</option>
				</c:forEach>
			</select> <input type="submit" value="Confirm" id="selectCustomerBtn"></input>
		</form> 

<br/><br/><br/>
		<div  class="grc-application-list">
			<table id="serviceList" class="hidden">
				<thead>
					<tr>
						<th class="table-col1" >Site Code</th>
						<th class="table-col2" >Location</th>
						<th class="table-col2" >Time Zone</th>
						<th class="table-col2" >Local Time</th>
						<th class="table-col2" >Current State</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
</t:wrapper>