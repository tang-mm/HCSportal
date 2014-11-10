<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<script type="text/javascript">
		// enable tabs
		$('document').ready(function() {
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
		});
		
		setInterval(function() {localTimer(), 1000});
		function localTimer() { 
			var d = new Date($.now()); 
			var time = d.getHours() + ":" + (d.getMinutes()<10 ? "0" : "") + d.getMinutes() +":"
						+ (d.getSeconds()<10 ? "0" : "") + d.getSeconds();
			document.getElementById("localTimer").innerHTML = time;
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
		</div>

		<div id="tabs-content">
			<div id="tab-0">
				<div id="serviceDetails" class="grc-form">
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
									<td id="localTimer"> [to be converted to Time Zone]</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Current State:</label></td>
									<td style="text-align: center; padding-right: 30%;"><c:choose>
										<c:when test="${service.open}">
											<div class="status_open green" >Open</div>
										</c:when>
										<c:otherwise>
											<div class="status_open red">Closed</div>
										</c:otherwise>
									</c:choose></td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Emergency:</label></td>
									<td><div class="info">
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
			<div id="tab-1"></div>
			<div id="tab-2"></div>
			<div id="tab-3"></div>
		</div>
	</div>
</t:wrapper>