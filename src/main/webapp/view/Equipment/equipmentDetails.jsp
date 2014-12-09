<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	</script>

	<div class="grc-tab-div" style="margin: 0 auto;">
		<ul id="tabs">
			<li class="tab-selected"><a href="#"> <span>General Information</span>
			</a></li>
			<li><a href="#"><span>Access</span></a>
		</ul>
	</div>

	<div class="grc-form block">
		<div>
			<h1>Equipment Details >> ${equip.equipmentName}</h1>
		</div>

		<div id="tabs-content">
			<div id="tab-0">
				<div id="equipDetails" class="grc-form">
					<form:form id="equipmentDetailsForm" name="equipmentDetailsForm" action="" commandName="">
						<table>
							<tbody>
								<tr class="grc-form-input-text">
									<td style="width: 40%;"><label>Equipment Name:</label></td>
									<td>${equip.equipmentName}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Machine Type:</label></td>
									<td>${equip.machineType }</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Virtualized:</label></td>
									<td><if test="${not empty equip.isVirtualized}">${equip.isVirtualized ? 'YES' : 'NO'}</if></td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Operation System :</label></td>
									<td>${equip.operatingSystem }</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Application Version:</label></td>
									<td>${equip.appVersion}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Hardware:</label></td>
									<td>${equip.hardware}</td>
								</tr>
								<tr class="grc-form-input-text">
									<td><label>Serial number :</label></td>
									<td>${equip.serialNumber}</td>
								<tr class="grc-form-input-text">
									<td><label>Location :</label></td>
									<td>${equip.geoLocation}</td>
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

			<div id="tab-1" style="display: none;">
				<div class="grc-form">
					<table>
						<tbody>
							<tr class="grc-form-input-text">
								<td width="40%"><label>IP Address :</label></td>
								<td>${equip.ipAddress}</td>
							</tr>
							<tr class="grc-form-input-text grc-form-no-border">
								<td></td>
							</tr>
							<tr class="grc-form-buttons grc-form-no-border" bgcolor="white">
								<td colspan="2" align="right"><input value="Open Terminal" type="button"
									class="grc-form-buttons-validate" onclick="#" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!--end tabs -->

		<div id="action-buttons" class="grc-form">
			<table>
				<tbody>
					<tr class="grc-form-buttons grc-form-no-border">
						<td align="right"><input value="Back" type="button" class="grc-form-buttons-cancel"
							onclick="history.back()" /></td>
						<td align="right"><input value="Modify" type="button" class="grc-form-buttons-validate"
							onclick="modifyEquiment?id=" +${equip.equipmentId} /> <input value="Delete" type="button"
							class="grc-form-buttons-validate" style="margin-right: 10px;" onclick="deleteEquipment?id="
							+${equip.equipmentId} /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</t:wrapper>
