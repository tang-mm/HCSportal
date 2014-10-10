<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.mandatory{
	color: red;
}
</style>

<t:wrapper>
	<div class="grc-page-application">
		<div class="grc-form block" style="margin: 0 auto;">
			<form:form action="submitNewCustomer" id="newCustomerForm"
				name="newCustomerForm" commandName="newCustomerCmd"> 
				<div>
					<h1>Create New Customer</h1>
				</div>
				<div class="grc-form">
					<table>
						<tbody>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label path="name">Customer
										Name: </label></td>
								<td colspan="2"><form:input path="name" value="" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label path="geoLocation">Geographical
										Location: </label></td>
								<td><form:input path="geoLocation" value="" /></td>
							</tr>
							<tr class="grc-form-no-border">
								<td>&nbsp;</td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP Finesse Desktop: </label>
								</td>
								<td colspan="2"><form:input path="IPfinesseA"
										placeholder="Primary" /></td>
								<td colspan="3"><form:input path="IPfinesseB"
										placeholder="Secondary" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP CUIC: </label></td>
								<td colspan="2"><form:input path="IPcuicA"
										placeholder="Publisher" /></td>
								<td colspan="3"><form:input path="IPcuicB"
										placeholder="Subscriber" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP EIM / WIM: </label></td>
								<td colspan="2"><form:input path="IPeimwimA"
										placeholder="Side A" /></td>
								<td colspan="3"><form:input path="IPeimwimA"
										placeholder="Side B" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP MediaSense: </label></td>
								<td colspan="2"><form:input path="IPmediasenseA"
										placeholder="Side A" /></td>
								<td colspan="3"><form:input path="IPmediasenseB"
										placeholder="Side B" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP Internet Script
										Editor: </label></td>
								<td colspan="2"><form:input path="IPscriptEditorA"
										placeholder="Side A" /></td>
								<td colspan="3"><form:input path="IPscriptEditorB"
										placeholder="Side B" /></td>
							</tr>

							<tr class="grc-form-buttons grc-form-no-border">
								<td colspan="3"><input type="submit"
									class="grc-form-buttons-validate" value="Submit" name="Submit" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</t:wrapper>
