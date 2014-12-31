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
<%-- 	<link href='${pageContext.servletContext.contextPath}/css/fullcalendar-year.css' rel='stylesheet' /> --%>
		media='print' />
	<script src='${pageContext.servletContext.contextPath}/js/moment.js'></script>
	<script src='${pageContext.servletContext.contextPath}/js/fullcalendar.min.js'></script>
<%-- 	<script src='${pageContext.servletContext.contextPath}/js/fullcalendar-year.js'></script> --%>

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
				defaultDate : '2014-11-12',
				editable : true,
				eventLimit : true, // allow "more" link when too many events
				events : [ {
					title : 'Holiday', /* 'All Day Event', */
					start : '2014-11-11',
					color: '#FF6600'
				}, {
					title : 'Exception',
					start : '2014-11-07',
					end : '2014-11-10'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-09T16:00:00'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-16T16:00:00'
				}/* , {
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
				} */ ]
			});
		}
	</script>

	<div class="grc-tab-div" style="margin: 0 auto;">
		<ul id="tabs">
			<li class="tab-selected"><a href="#"> <span>General
						Information</span>
			</a></li>
			<li><a href="#"><span>Opening Hours</span></a>
			<li><a href="#"><span>Calendar</span></a> 
		</ul>
	</div>

	<div class="grc-form block">
		<div>
			<h1>Site Details >> ${service.serviceCode}</h1>
			<br />
			<br />
			<h1>Time Schedule</h1>
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
									<td style="width: 40%;"><label>Site Code:</label></td>
									<td>${service.serviceCode}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Location:</label></td>
									<td>${site.location.city}, ${site.location.country }</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Time Zone:</label></td>
									<td>${site.location.timeZone}</td>
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
									<td colspan="2">${service.description }</td>
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
								<th>From</th>
								<th>To</th>
								<th>From (optional)</th>
								<th>To (optional)</th>
							</tr>
						</thead>
						<tbody>
							<!-- Monday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.mondayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.mondayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.mondayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.mondayClose2}</input></td>
							</tr>
							
							<!-- tuesday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.tuesdayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.tuesdayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.tuesdayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.tuesdayClose2}</input></td>
							</tr>
							
							<!-- wednesday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.wednesdayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.wednesdayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.wednesdayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.wednesdayClose2}</input></td>
							</tr>
							
							<!-- thursday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.thursdayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.thursdayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.thursdayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.thursdayClose2}</input></td>
							</tr>
							
							<!-- friday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.fridayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.fridayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.fridayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.fridayClose2}</input></td>
							</tr>
							
							<!-- saturday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.saturdayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.saturdayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.saturdayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.saturdayClose2}</input></td>
							</tr>
							
							<!-- sunday -->
							<tr class="grc-form-input-text">
								<td><label>${weekdayNames[status.index]}</label></td>
								<td><input type="text" placeholder="08:00" size="8">${site.schedule.sundayOpen1}</input></td>
								<td align="right"><input type="text" placeholder="12:00"
									size="8">${site.schedule.sundayClose1}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="13:00" size="8">${site.schedule.sundayOpen2}</input></td>
								<td style="text-align: center"><input type="text"
									placeholder="19:00" size="8">${site.schedule.sundayClose2}</input></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!------------- Tab: Calendar -------------------->
			<div id="tab-2" class="hidden">
				
				
				<div id='fullCalendar'>
				<p style="color:blue">Holidays</p>
				<p style="color:#FF6600">Exceptional Days</p>
				</div>
				
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
										class="grc-form-buttons-validate" value="Add New Date" name="Submit" /></td>

								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
				
			</div>

		</div>
	</div>
</t:wrapper>