<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	$(document).ready(function() {
		$("#selectCustomer").click(function() {
			$("#selectCustomerForm").hide();
			loadServiceList();
			$("serviceList").show();
		});
	});
	/* 	document.getElementById("selectCustomerForm").style.display = "block"; 
	 	document.getElementById("serviceList").style.display = "none"; 
	 */

	// retrieve serviceList
	function loadServiceList(custId) {
		var xmlhttp;

		if (custId == "") {// no Customer selected
			return;
		}
		if (window.XMLHttpRequest) {
			// for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {
			// for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("serviceList").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "usr?custId=" + custId, true);
		xmlhttp.send();
	}
</script>

<t:wrapper>
	<div class="grc-page-application">
		<form action="" id="selectCustomerForm">
			<h1>Please select a customer:</h1>
			<select>
				<option value="">--</option>
				<c:forEach items="${listCustomer}" var="cust">
					<option value="${cust.customerId}">${cust.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Confirm" id="selectCustomer">
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
							<td>[show LOCAL TIME]</td>
							<c:choose>
								<c:when test="${service.isOpen}">
									<td style="background-color: green;">Open</td>
								</c:when>
								<c:otherwise>
									<td style="background-color: red;">Close</td>
								</c:otherwise>
							</c:choose>

							<%-- 	<td class="${service.isOpen ? 'open' : 'close'}">${service.isOpen ? Open : Close}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</t:wrapper>