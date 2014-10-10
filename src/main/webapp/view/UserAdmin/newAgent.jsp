<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:wrapper>  
	<div class="grc-page-application">
		<div class="grc-form block" style="margin: 0 auto;">
			<form:form action="submitNewAgent" id="newAgentForm"
				name="newAgentForm" commandName="newAgentCmd">
				<div class="grc-form">
					<div>
						<h1>Create New Agent</h1>
					</div>
					<table>
						<tbody>
							<tr class="grc-form-input-text">
								<td style="width: 35%"><form:label path="username">Username: </form:label></td>
								<td colspan="2"><form:input path="username" /></td>
							</tr>

<%-- 							<tr class="grc-form-input-select"> --%>
<%-- 								<td><form:label path="customer">Tenant: </form:label></td> --%>
<%-- 								<td colspan="2"> --%>
<%-- 								<form:select path="userType"> --%>
<%-- 										<form:options items="${userTypes}" /> --%>
<%-- 									</form:select></td> --%>
<%-- 							</tr> --%>
<%-- 							<tr class="grc-form-input-text"> --%>
<%-- 								<td><form:label path="password">Password: </form:label></td> --%>
<%-- 								<td colspan="2"><form:input type="password" path="password" /></td> --%>
<%-- 							</tr>  --%>
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