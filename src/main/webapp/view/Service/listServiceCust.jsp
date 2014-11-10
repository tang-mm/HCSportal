<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<script type="text/javascript">
		setInterval(function() {
			localTimer(), 1000
		});
		function localTimer() {
			var d = new Date($.now());
			var time = d.getHours() + ":" + (d.getMinutes() < 10 ? "0" : "")
					+ d.getMinutes() + ":" + (d.getSeconds() < 10 ? "0" : "")
					+ d.getSeconds();
			document.getElementById("localTimer").innerHTML = time;
		}
	</script>

	<div id="serviceList" class="grc-application-list ">
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
						<td id="localTimer"></td>
						<c:choose>
							<c:when test="${service.open}">
								<td class="status_open green">Open</td>
							</c:when>
							<c:otherwise>
								<td class="status_open red">Closed</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>