<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
<<<<<<< HEAD

	<a href="createNewAgent" class="btn-submit" style="margin: 0 auto;">Create
		New Agent</a>
	<br />
	<br />
	<br />
	<div class="grc-application-list" style="margin: 0 auto;">
		<!-- <h2>Customer Name</h2> -->
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
=======
	<div class="grc-page-application" style="margin: 0 auto;">
		<a href="createNewAgent" class="btn-submit" style="margin: 0 auto;">Create
			New Agent</a> <br /> <br /> <br />
		<div class="grc-application-list" style="margin: 0 auto;">
			<!-- <h2>Customer Name</h2> -->
			<table>
				<thead>
>>>>>>> 42657ca5ad8edd558a36736f6a579f74caf79ffa
					<tr>
						<c:forEach items="${agent}" var="elem">
							<td><c:out value="${not empty elem ? elem : '-' }" /></td>
						</c:forEach>
					</tr>
<<<<<<< HEAD
				</c:forEach>
			</tbody>
		</table>
	</div>

=======
				</thead>
				<tbody>
					<c:forEach items="${listAgent}" var="agent">
						<tr>
							<c:forEach items="${agent}" var="elem">
								<td><c:out value="${not empty elem ? elem : '-' }" /></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
>>>>>>> 42657ca5ad8edd558a36736f6a579f74caf79ffa
</t:wrapper>