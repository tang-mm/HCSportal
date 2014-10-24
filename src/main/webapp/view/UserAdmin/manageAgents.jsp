<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<div class="grc-page-application" style="margin: 0 auto;">
		<a href="createNewAgent" class="btn-submit" style="margin: 0 auto;">Create
<<<<<<< HEAD
			New Agent</a> <br /> <br /> <br />
=======
			New Agent</a> <br />
		<br />
		<br />
>>>>>>> cc1a1ece732c69d16e80a63a1f6bcffdc8897bc1
		<div class="grc-application-list" style="margin: 0 auto;">
			<!-- 		<h2>Customer Name</h2> -->
			<table>
				<thead>
					<tr>
						<th width="200px">Username</th>
						<th width="150px">Last Name</th>
						<th width="150px">First Name</th>
						<th width="80px">isSupervisor</th>
						<th width="150px">Customer</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listAgent}" var="agent">
						<tr>
							<c:forEach items="${agent}" var="elem">
<<<<<<< HEAD
								<td><c:out value="${not empty elem ? elem : '-' }" /></td>
=======
								<c:choose>
									<c:when test="${not empty elem}">
										<td>${elem}</td>
									</c:when>
									<c:otherwise>
										<td>-</td>
									</c:otherwise>
								</c:choose>
>>>>>>> cc1a1ece732c69d16e80a63a1f6bcffdc8897bc1
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</t:wrapper>
