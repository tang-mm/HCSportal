<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:wrapper> 
<div class="grc-page-application">
		<a href="createNewEquipment" class="btn-submit" style="margin: 0 auto;">Add New Equipment</a>
		
		<div class="grc-form block" style="margin: 0 auto;">
			<div>
				<h1>List >> ${custName}</h1>
			</div>
			<br />
			<br/>
		<div id="list-equipment" class="grc-table"> <!-- </div> style="margin-left: 30%;"> -->
				<table>
					<thead>
						<tr>
							<th colspan="4"><select style="float: right;">
									<option value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option>
							</select><span>Items per page</span></th>
						</tr>
						<tr>
							<th class="grc-table-header" width="80px">Name</th>
							<th class="grc-table-header" width="80px">Machine Type</th>
							<th class="grc-table-header" width="80px">OS</th>
							<th class="grc-table-header" width="80px">Location</th>
						</tr>
					</thead>
					<tbody> 
						<c:forEach items="${listEquip}" var="equip" varStatus="loopStatus">
							<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
								<td>${equip.equipmentName}</td>
								<td>${equip.machineType}</td>
								<td>${equip.operatingSystem}</td>
								<td>${equip.geoLocation}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr><td colspan="4"><span>Result XX of YY</span>
						<input type="button" value="&gt;&gt;">
						<input type="button" value="&lt;&lt;">
						</td></tr>
					</tfoot>
				</table>
			</div> 
	</div>
</t:wrapper>