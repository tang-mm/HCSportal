<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<!-- customized tag for template use -->

	<div class="grc-page-application">
		<a href="createNewCustomer" class="btn-submit" style="margin: 0 auto;">Create
			New Customer</a> <br /> <br /> <br />
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
