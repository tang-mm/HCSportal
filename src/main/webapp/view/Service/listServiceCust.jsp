<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper> 
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
</t:wrapper>