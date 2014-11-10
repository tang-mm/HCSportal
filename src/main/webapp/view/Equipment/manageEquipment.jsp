<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
	<!-- list of all customers -->
	<a href="searchEquipment" class="btn-submit" style="margin: 0 auto;">Search
		Equipment</a>
		
	<a href="createNewEquipment" class="btn-submit" style="margin: 0 auto;">Add New
		Equipment</a>
	<br />
	<br />
	<div class="grc-application-list" style="margin-left: 30%;">
		<table>
			<thead>
				<tr>
					<th width="100px">Customer</th>
					<th width="80px">Total Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCustomer}" var="cust">
					<tr>
						<td><a
							href="listEquipment?custId=${cust[0]}&custName=${cust[1]}">
								${cust[1]} </a></td>
						<td>${cust[2]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:wrapper>