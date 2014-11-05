<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>

<style>
.open {
	background-color: green;
}

.close {
	background-color: red;
}
</style>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#selectCustomer").click(function() {
				$("#selectCustomerForm").hide();
				loadData();
				$("serviceList").show();
			});
		});
		// 	document.getElementById("selectCustomerForm").style.display = "block"; 
		// 		document.getElementById("serviceList").style.display = "none";

		// refresh serviceList
		function loadData() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				// for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {
				// for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

		}
	</script>

	<div class="grc-page-application">
		<form action="" id="selectCustomerForm">
			<select><option value="">customer1</option>
				<option value="">customer2</option>
			</select> <input type="submit" value="Goto" id="selectCustomer">
		</form>

		<div id="serviceList" class="grc-application-list"
			style="display: block; margin-left: 30%;">
			<table>
				<thead>
					<tr>
						<th width="100px">Service Code</th>
						<th width="80px">Location</th>
						<th width="80px">Time Zone</th>
						<th width="80px">Local Time</th>
						<th width="80px">Current State</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listService}" var="service">
						<tr>
							<td><a href="serviceDetails?id=${service.serviceId}">
									${service.serviceCode} </a></td>
							<td>${service.location}</td>
							<td>${service.timeZone}</td>
							<td>[LOCAL TIME]</td>
							<td class="${service.isOpen ? 'open' : 'close'}">${service.isOpen ? Open : Close}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</t:wrapper>