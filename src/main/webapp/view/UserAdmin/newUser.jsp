<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.error {
	color: red;
}
</style>

<t:wrapper>
	<div class="grc-page-application">
		<div class="grc-form block" style="margin: 0 auto;">
			<form:form method="POST" action="submitNewUser" id="newUserForm" name="newUserForm"
				commandName="newUserCmd">
				<div class="grc-form">
					<div>
						<h1>Create New User ${message}</h1>
					</div>
					<table>
						<tbody>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><form:label path="username">Username: *</form:label></td>
								<td colspan="2"><form:input path="username" /></td>
								<td colspan="3"><form:errors path="username" cssClass="error" />aaa</td>
							</tr>

							<tr class="grc-form-input-select">
								<td><form:label path="userTypeId">User Type: *</form:label></td>
								<td colspan="2"><form:select path="userTypeId">
										<form:option value="-1" label="--Please select--" />
										<form:options items="${userTypes}" itemValue="id"
											itemLable="type" />
									</form:select></td>
								<td colspan="3"><form:errors path="userTypeId" cssClass="error" /></td>
							</tr>


							<tr class="grc-form-input-text">
								<td><form:label path="password">Password: *</form:label></td>
								<td colspan="2"><form:input type="password" path="password" /></td>
								<td colspan="3"><form:errors path="password" cssClass="error" /></td>
							</tr>
							<tr class="grc-form-input-text">
								<td><form:label path="password">Confirm Password: *</form:label></td>
								<td colspan="2"><form:input type="password"
										path="confirmedPassword" /></td>
								<td colspan="3"><form:errors path="confirmedPassword" cssClass="error" /></td>
							</tr>
							<tr class="grc-form-buttons grc-form-no-border">
								<td colspan="3"><input type="submit"
									class="grc-form-buttons-validate" value="Submit" name="Submit"></input></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</t:wrapper>