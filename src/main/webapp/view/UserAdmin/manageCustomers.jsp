<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper> <!-- customized tag for template use -->
	 
<div class="grc-page-application">
		<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create New Customer</a>
		<br/><br/><br/>
		<div class="grc-application-list" style="margin-left: 30%;">
			<table>
				<thead>
					<tr>
						<th width="100px">Customer</th>
						<th width="80px">info</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listCustomer}" var="customer">
						<tr>
							<td><c:out value="${customer.name}" /></td>
							<td><c:out value="${customer.info}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h2 style="color: red;">show list of all customers here</h2>
	</div>

</t:wrapper> 