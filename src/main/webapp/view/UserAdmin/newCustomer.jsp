<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.mandatory {
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
							<tr class="grc-form-no-border">
								<td>&nbsp;</td>
							</tr>


							<tr class="grc-form-no-border">
								<td colspan="1"><label>IP: </label></td>
								<td colspan="2"><form:input path="ipMain" /></td>
							</tr>
							<%-- 							<tr class="grc-form-no-border"> --%>
							<%-- 								<td colspan="1"><label>Prefix length: </label></td> --%>
							<%-- 								<td colspan="2"><form:input path="prefixLength" value="24"/></td> --%>
							<%-- 							</tr> --%>

							<tr class="grc-form-no-border">
								<td colspan="1"><label>Description: </label></td>
								<td colspan="2"><form:input type="text" path="description" /></td>
							</tr>
							<tr class="grc-form-buttons grc-form-no-border">
							
							<c:if test='${not empty message}'>
							<td colspan="1"></td>
									<td colspan="2"><div style="color: red; margin-left:auto;">${message}</div></td>
							</c:if>
								<td colspan="3"><input type="submit"
									class="grc-form-buttons-validate" value="Submit" name="Submit"></input></td>
							</tr>
						</tbody>
					</table>

					<table>
						<tbody>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP Finesse Desktop: </label>
								</td>
								<td colspan="2" id="IPfinesseA"></td>
								<td colspan="3" id="IPfinesseB"></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP CUIC: </label></td>
								<td colspan="2" id="IPcuicA"></td>
								<td colspan="3" id="IPcuicB"></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP EIM / WIM: </label></td>
								<td colspan="2" id="IPeimwimA" placeholder="Side A" /></td>
								<td colspan="3" id="IPeimwimA" placeholder="Side B" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP MediaSense: </label></td>
								<td colspan="2" id="IPmediasenseA" /></td>
								<td colspan="3" id="IPmediasenseB" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><label>IP Internet Script
										Editor: </label></td>
								<td colspan="2" id="IPscriptEditorA" /></td>
								<td colspan="3" id="IPscriptEditorB" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</t:wrapper>
