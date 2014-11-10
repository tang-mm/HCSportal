<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<t:wrapper>
	<script type="text/javascript">
		// $('#button_Machine').click(function() {
		// $('#toBeToggle_Machine').toggle();
		// $('this').toggleClass('.collpse');
		// });
		$(document).ready(function() {
			$('#toBeToggle_Machine').css('display', 'none');
			$('#button_Machine').click(function() {
				$('#toBeToggle_Machine').slideToggle('slow');
				// $(this).toggleClass('slideSign');
				return false;
			});
		});
		$(document).ready(function() {
			$('#toBeToggle_Localisation').css('display', 'none');
			$('#button_Localisation').click(function() {
				$('#toBeToggle_Localisation').slideToggle('slow');
				// $(this).toggleClass('slideSign');
				return false;
			});
		});
	</script>
	<div class="grc-form block" style="margin: 0 auto;">
		<form:form action="searchEquipment" id="searchEquipmentForm"
			name="searchEquipmentForm" commandName="searchEquipmentCmd">
			<div class="grc-form">
				<div>
					<h1>Search equipment</h1>
				</div>
				<table>
					<tbody>
						<tr class="grc-form-input-text">
							<td style="width: 35%;"><label>By IP :</label></td>
							<td colspan="2"><input name="globalIP" id="globalIP"
								value="" type="text"></td>
						</tr>
						<tr class="grc-form-input-text">
							<td><label>By name :</label></td>
							<td colspan="2"><input name="name" id="name" value=""
								type="text"></td>
						</tr>
						<tr class="grc-form-input-text">
							<td><label>Serial number :</label></td>
							<td colspan="2"><input name="numSerie" id="numSerie"
								value="" type="text"></td>
						</tr>
						<tr class="grc-form-input-select grc-form-no-border">
							<td><label>Type of machine :</label></td>
							<td><select name="strEquipement" id="strEquipement">
									<!-- LIST of options here -->
							</select></td>
							<td><p>
									<span id="button_Machine" class="grc-icone-display">additional
										filters</span>
								</p></td>
						</tr>
						<!-- expand / collapse -->
						<tr class="grc-form-input-select grc-form-no-border"
							id="toBeToggle_Machine">
							<td colspan="3">
								<table>
									<tbody>
										<tr class="grc-form-input-select grc-form-no-border">
											<td style="width: 40%;"><label>OS :</label></td>
											<td><select name="os" id="os">
													<option value="" label=""></option>
													<!-- LIST of options here -->
											</select></td>
										</tr>
										<tr class="grc-form-input-select grc-form-no-border">
											<td><label>Hardware :</label></td>
											<td><select name="hardware" id="hardware">
													<!-- LIST of options here -->
											</select></td>
										</tr>
										<tr class="grc-form-input-select grc-form-no-border">
											<td><label>Application version :</label></td>
											<td><select name="appVersion" id="appVersion">
													<option value="" label=""></option>
													<!-- LIST of options here -->
											</select></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr class="grc-form-input-select grc-form-no-border">
							<td><label>Virtualized on host :</label></td>
							<td colspan="2"><select name="id_parent" id="id_parent">
									<option value="" label=""></option>
									<!-- LIST of options here -->
							</select> <span id="erreurParent"></span></td>
						</tr>
						<tr class="grc-form-input-select">
							<td><label>Connected to the switch :</label></td>
							<td colspan="2"><select name="id_switch" id="id_switch">
									<option value="" label=""></option>
							</select> <span id="erreurId_switch0"></span></td>
						</tr>
						<tr class="grc-form-input-select grc-form-no-border">
							<td><label>Customer :</label></td>
							<td><select name="id_localisation" id="id_localisation">
									<option value="" label=""></option>
									<!-- LIST of options here -->
							</select></td>
							<td><p>
									<span id="button_Localisation" class="grc-icone-display">additional
										filters</span>
								</p></td>
						</tr>
						<!-- expand / collapse -->
						<tr>
							<td colspan="3">
								<table id="toBeToggle_Localisation" style="">
									<tbody>
										<tr class="grc-form-input-select grc-form-no-border">
											<td style="width: 40%;"><label>Room :</label></td>
											<td><select name="salle" id="salle"
												style="background-color: #DBFFD7">
											</select></td>
										</tr>
										<tr class="grc-form-input-select grc-form-no-border">
											<td><label>Rack :</label></td>
											<td><select name="bay" id="bay"
												style="background-color: #DBFFD7">
											</select></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr class="grc-form-input-select grc-form-no-border">
							<td><label>Project :</label></td>
							<td colspan="2"><select name="projet" id="projet">
									<option value="" label=""></option>
									<!-- LIST of options here -->
							</select></td>
						</tr>
						<tr class="grc-form-input-select grc-form-no-border">
							<td><label>Platform :</label></td>
							<td colspan="2"><select name="plateforme" id="plateforme">
									<option value="" label=""></option>
									<!-- LIST of options here -->
							</select></td>
						</tr>
						<tr class="grc-form-input-text">
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr class="grc-form-buttons grc-form-no-border">
							<td colspan="3"><input value="Validate"
								class="grc-form-buttons-validate" type="submit"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
</t:wrapper>