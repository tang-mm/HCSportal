<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:wrapper>
<!-- list of all customers -->
<div class="grc-page-application">
		<a href="searchEquipment" class="btn-submit" style="margin: 0 auto;">Search Equipment</a>
		<br/><br/><br/>
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
							<td>${cust}</td> 
							<td>-</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> 
	</div>
</t:wrapper>