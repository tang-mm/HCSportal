<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.error {
	color: red;
}
</style>

<t:wrapper>
	<div class="grc-form block" style="margin: 0 auto;">
		<form:form method="POST" action="submitNewUser" id="newUserForm"
			name="newUserForm" commandName="newUserCmd">
			<div class="grc-form">
				<div>
					<h1>Create New User</h1>
				</div>
				<table>
					<tbody>
						<tr class="grc-form-input-text">
							<td style="width: 35%"><form:label path="username">Username: *</form:label></td>
							<td colspan="2"><form:input path="username" /></td>
							<td colspan="3"><form:errors path="username"
									cssClass="error" />test</td>
						</tr>

						<tr class="grc-form-input-select">
							<td><label>User Type: *</label></td>
							<td colspan="3"><select>
									<option value="-1" label="--Please select--" />
									<options items="${userTypes}" itemValue="userTypeId"
										itemLable="userType" />
								</select></td>
						</tr>

<!-- 					to add: choose customer -->

						<tr class="grc-form-input-text">
							<td><form:label path="password">Password: *</form:label></td>
							<td colspan="2"><form:input type="password" path="password" /></td>
							<td colspan="3"><form:errors path="password"
									cssClass="error" /></td>
						</tr>
						<tr class="grc-form-input-text">
							<td><label>Confirm Password: *</label></td>
							<td colspan="2"><form:input type="password"
									path="confirmedPassword" /></td>
							<td colspan="3"><form:errors path="confirmedPassword"
									cssClass="error" /></td>
						</tr>
						<tr class="grc-form-buttons grc-form-no-border">
							<td colspan="3"><input type="submit"
								class="grc-form-buttons-validate" value="Submit" name="Submit"></input></td>
						</tr>
						<tr class="error">${message }</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
</t:wrapper>