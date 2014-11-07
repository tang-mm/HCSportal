<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<t:wrapper>

	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.tablesorter.js"></script>
	<script type="text/javascript"> 
	
		$(document).ready(function() {
			//enable table sorting and pagination
			$("#listEquipment").tablesorter().tablesorterPager({
				container : $("#pager"),
				// use this url format "http:/mydatabase.com?page={page}&size={size}" 
				ajaxUrl : null,

				// process ajax so that the data object is returned along with the
				// total number of rows; example:
				// {
				//   "data" : [{ "ID": 1, "Name": "Foo", "Last": "Bar" }],
				//   "total_rows" : 100 
				// } 
				ajaxProcessing : function(ajax) {
					if (ajax && ajax.hasOwnProperty('data')) {
						// return [ "data", "total_rows" ]; 
						return [ ajax.data, ajax.total_rows ];
					}
				},

				// output string - default is '{page}/{totalPages}';
				// possible variables:
				// {page}, {totalPages}, {startRow}, {endRow} and {totalRows}
				output : '{startRow} to {endRow} (Total: {totalRows})',

				// apply disabled classname to the pager arrows when the rows at
				// either extreme is visible - default is true
				updateArrows : true,

				// starting page of the pager (zero based index)
				page : 0,
				// Number of visible rows - default is 10
				size : 10,

				// if true, the table will remain the same height no matter how many
				// records are displayed. The space is made up by an empty 
				// table row set to a height to compensate; default is false 
				fixedHeight : true,

				// remove rows from the table to speed up the sort of large tables.
				// setting this to false, only hides the non-visible rows; needed
				// if you plan to add/remove rows with the pager enabled.
				removeRows : false,

			});
		});
	</script>

	<a href="createNewEquipment" class="btn-submit" style="margin: 0 auto;">Add New Equipment</a>

	<div class="grc-form block">
		<div>
			<h1>List >> ${custName}</h1>
		</div>
		<p>TODO: add table sort, pagination</p>
		<br />
		<div class="grc-table">
			<!-- </div> style="margin-left: 30%;"> -->
			<table  id="listEquipment" class="tablesorter">
				<thead>
					<tr>
						<th width="80px" id="headCol1">Name</th>
						<th width="80px" id="headCol2">Machine Type</th>
						<th width="80px" id="headCol3">OS</th>
						<th width="80px" id="headCol4">Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listEquip}" var="equip" varStatus="loopStatus">
						<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
							<td><a href="equipmentDetails?id=equip.equipmentId">${equip.equipmentName}</a></td>
							<td>${equip.machineType}</td>
							<td>${equip.operatingSystem}</td>
							<td>${equip.geoLocation}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="1">
						<select class="pagesize" title="Page Size">
								<option value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option>
						</select><span>Items per page </span></td>

						<td colspan="2"><span class="pagedisplay"></span></td>
						<td colspan="4">
							<input type="button" value="&gt;&gt;|" class="first"> 
							<input type="button" value="&gt;" class="next">
							<input type="button" value="&lt;" class="prev">
							<input type="button" value="|&lt;&lt;" class="last">
        <select class="gotoPage" title="Select page number"></select></td>
					</tr>  
      
					
				</tfoot>
			</table>
		</div>
	</div>
</t:wrapper>