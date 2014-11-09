<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
	<!-- customized tag for template use -->
<<<<<<< HEAD

	<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create
		New Customer</a>
	<br />
	<br />
	<br />
	<div class="grc-application-list" style="margin: 0 auto;">
		<table>
			<thead>
				<tr>
					<th width="150px">Customer</th>
					<th width="150px">ParentOwnerName</th>
					<th width="150px">Creation Date</th>
					<th width="150px">Last Modified</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCustomer}" var="customer">
=======
	<div class="grc-page-application">
		<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create
			New Customer</a> <br /> <br /> <br />
		<div class="grc-application-list" style="margin: 0 auto;">
			<table>
				<thead>
>>>>>>> 42657ca5ad8edd558a36736f6a579f74caf79ffa
					<tr>
						<c:forEach items="${customer}" var="elem">
							<td><c:out value="${not empty elem ? elem : '-' }" /></td>
						</c:forEach>
					</tr>
<<<<<<< HEAD
				</c:forEach>
			</tbody>
		</table>
=======
				</thead>
				<tbody>
					<c:forEach items="${listCustomer}" var="customer">
						<tr>
							<c:forEach items="${customer}" var="elem">
								<td><c:out value="${not empty elem ? elem : '-' }" /></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
>>>>>>> 42657ca5ad8edd558a36736f6a579f74caf79ffa
	</div>
</t:wrapper>