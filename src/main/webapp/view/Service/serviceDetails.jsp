<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>

	<style>
.hidden {
	display: none
}
</style>


	<link href='${pageContext.servletContext.contextPath}/css/fullcalendar.css' rel='stylesheet' />
	<link href='${pageContext.servletContext.contextPath}/css/fullcalendar.print.css' rel='stylesheet'
		media='print' />
	<script src='${pageContext.servletContext.contextPath}/js/moment.min.js'></script>
	<script src='${pageContext.servletContext.contextPath}/js/jquery-1.11.1.min.js'></script>
<%-- 	<script src='${pageContext.servletContext.contextPath}/js/fullcalendar.min.js'></script> --%>
	<script src='${pageContext.servletContext.contextPath}/js/fullcalendar.js'></script>	

	<!-- datepicker -->
	<script type="text/javascript"
		src='${pageContext.servletContext.contextPath}/js/jquery-ui-1.11.2.js'></script>
	<link rel="stylesheet"
		href='${pageContext.servletContext.contextPath}/css/jquery-ui-1.8.4.custom.css'>

	<script type="text/javascript">
	$(document).ready(function() { 
		loadTabs();
		loadCalendar(); 
		loadDatepicker();
	});
	 
		// enable tabs
		function loadTabs() {
			$('#tabs li a').each(function() {
				$(this).click(function() {
					$('#tabs li').each(function() {
						$(this).removeClass('tab-selected');
					});
					$(this).parent().addClass('tab-selected');
					//show new tab and hide others
					var index = $(this).parent().index();
					$("#tab-" + index).show().siblings().hide();
					return false;
				});
			});
		}

		function loadDatepicker() {
			$("#datepicker").datepicker(
							{
								changeMonth : true, /* select month and year */
								changeYear : true,
								showButtonPanel : true, /* "Today" button */
								showOn : "button", /* "calendar" image */
								buttonImage : "${pageContext.servletContext.contextPath}/images/calendar.gif",
								buttonImageOnly : true,
								buttonText : "Select date"
							});
		}

		setInterval(function() {
			localTimer(), 1000
		});
		function localTimer() {
			var d = new Date($.now());
			var time = d.getHours() + ":" + (d.getMinutes() < 10 ? "0" : "")
					+ d.getMinutes() + ":" + (d.getSeconds() < 10 ? "0" : "")
					+ d.getSeconds();
			document.getElementById("localTimer").innerHTML = time;
		}
		

		function loadCalendar() {
			$('#fullCalendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'year, month, agendaWeek'
				},
				defaultDate : '2014-09-12',
				editable : true,
				eventLimit : true, // allow "more" link when too many events
				events : [ {
					title : 'All Day Event',
					start : '2014-09-01',
					color: '#FF6600'
				}, {
					title : 'Long Event',
					start : '2014-09-07',
					end : '2014-09-10'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-09T16:00:00'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-16T16:00:00'
				}, {
					title : 'Conference',
					start : '2014-09-11',
					end : '2014-09-13'
				}, {
					title : 'Meeting',
					start : '2014-09-12T10:30:00',
					end : '2014-09-12T12:30:00'
				}, {
					title : 'Lunch',
					start : '2014-09-12T12:00:00'
				}, {
					title : 'Meeting',
					start : '2014-09-12T14:30:00'
				}, {
					title : 'Happy Hour',
					start : '2014-09-12T17:30:00'
				}, {
					title : 'Dinner',
					start : '2014-09-12T20:00:00'
				}, {
					title : 'Birthday Party',
					start : '2014-09-13T07:00:00'
				}, {
					title : 'Click for Google',
					url : 'http://google.com/',
					start : '2014-09-28'
				} ]
			});
		}
	</script>

	<div class="grc-tab-div" style="margin: 0 auto;">
		<ul id="tabs">
			<li class="tab-selected"><a href="#"> <span>General
						Information</span>
			</a></li>
			<li><a href="#"><span>Opening Hours</span></a>
			<li><a href="#"><span>Holidays</span></a>
			<li><a href="#"><span>Exceptional Days</span></a>
		</ul>
	</div>

	<div class="grc-form block">
		<div>
			<h1>Service Details >> ${service.serviceCode}</h1>
			<br />
		</div>

		<div id="tabs-content">
			<div id="tab-0">
				<div id="serviceDetails">
					<form:form id="serviceDetailsForm" name="serviceDetailsForm"
						action="" commandName="">
						<table>
							<tbody>
								<tr class="grc-form-input-text">
									<td style="width: 40%;"><label>Service Code:</label></td>
									<td>${service.serviceCode}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Location:</label></td>
									<td>${service.location}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Time Zone:</label></td>
									<td>${service.timeZone}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Local Time:</label></td>
									<td id="localTimer">[to be converted to Time Zone]</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Current State:</label></td>
									<td style="text-align: center; padding-right: 30%;"><c:if
											test="${not empty service.open }">
											<c:choose>
												<c:when test="${service.open}">
													<div class="status_open green">Open</div>

												</c:when>
												<c:otherwise>
													<div class="status_open red">Closed</div>
												</c:otherwise>
											</c:choose>
										</c:if></td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Emergency:</label></td>
									<td><div class="info">
											<c:if test="${not empty service.emergency}">
												<c:choose>
													<c:when test="${service.emergency}">
														<span>In Emergency</span>
														<img width="30px" height="30px"
															src="${pageContext.servletContext.contextPath}/images/on-Button.jpg" />

													</c:when>
													<c:otherwise>
														<span>Non-emergency state</span>
														<img width="30px" height="30px"
															src="${pageContext.servletContext.contextPath}/images/off-Button-green.jpg" />
													</c:otherwise>
												</c:choose>
											</c:if>
										</div></td>
								</tr>
								<tr class="grc-form-input-text grc-form-no-border">
									<td></td>
								</tr>
								<tr class="grc-form-no-border" bgcolor="white">
									<td colspan="2"><h2>Description:</h2></td>
								</tr>
								<tr class="grc-form-no-border" bgcolor="white">
									<td colspan="2">${equip.description }</td>
								</tr>
							</tbody>
						</table>
					</form:form>

				</div>

			</div>

			<!------------- Tab: Opening Hours -------------------->
			<div id="tab-1" class="hidden">
				<div id="openingHours" class="grc-table">
					<table>
						<thead>
							<tr>
								<th>Day</th>
								<th>Opening Time 1</th>
								<th>Closing Time 1</th>
								<th>Opening Time 2</th>
								<th>Closing Time 2</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${weekdayHours}" var="entry" varStatus="status">
								<trclass="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td style="text-align: center"><c:out
										value="${not empty entry.openingTime1 ?  entry.openingTime1 : '-'}" /></td>
								<td style="text-align: center"><c:out
										value="${not empty entry.closingTime1 ?  entry.closingTime1 : '-'}" /></td>
								<td style="text-align: center"><c:out
										value="${not empty entry.openingTime2 ?  entry.openingTime2 : '-'}" /></td>
								<td style="text-align: center"><c:out
										value="${not empty entry.closingTime2 ?  entry.closingTime2 : '-'}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!------------- Tab: Holidays -------------------->
			<div id="tab-2" class="hidden">
				<div id="">
					<form:form id="serviceDetailsForm" name="serviceDetailsForm"
						action="" commandName="">
						<table>
							<tbody>
								<tr class="grc-form-input-text grc-form-no-border">
									<td>Add New Date:</td>
									<td><input type="text" id="datepicker"
										placeholder="mm/dd/yyyy" /></td>
								</tr>
								<tr class="grc-form-buttons grc-form-no-border">
									<td colspan="2"><input type="submit"
										class="grc-form-buttons-validate" value="Submit" name="Submit" /></td>

								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
				
				<div id='fullCalendar'>here</div>
			</div>

			<!------------- Tab: Exceptional days -------------------->
			<div id="tab-3" class="hidden">testtest</div>
		</div>
	</div>
</t:wrapper>