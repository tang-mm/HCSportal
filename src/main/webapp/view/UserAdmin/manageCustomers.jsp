<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<!-- customized tag for template use -->
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
					<tr>
						<c:forEach items="${customer}" var="elem">
							<td><c:out value="${not empty elem ? elem : '-' }" /></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>