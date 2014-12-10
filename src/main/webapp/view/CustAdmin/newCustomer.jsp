<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:wrapper>

<style>
.mandatory {
	color: red;
}
</style>

<div class="grc-form block" style="margin: 0 auto;">
	<form:form action="submitNewCustomer" id="newCustomerForm" name="newCustomerForm"
		commandName="newCustomerCmd">
		<div>
			<h1>Create New Customer</h1>
		</div>

		<div class="grc-form">
			<table>
				<tbody>
					<tr class="grc-form-input-text grc-form-no-border">
						<td style="width: 35%"><label>Customer Name: </label></td>
						<td colspan="2"><form:input path="customerName" value="" /></td>
					</tr>
					<tr class="grc-form-no-border">
						<td colspan="1"><label>Description: </label></td>
						<td colspan="2"><form:textarea path="description" value="" rows="5" cols="30" /></td>
					</tr>
					<tr class="grc-form-buttons grc-form-no-border">
							<c:if test='${not empty messageCustomer}'>
								<td colspan="1"></td>
								<td colspan="2"><div style="color: red; margin-left: auto;">${messageCustomer}</div></td>
							</c:if>
							<td colspan="3"><input type="submit" class="grc-form-buttons-validate" value="Submit"
							name="Submit"></input></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form:form>
</div>
</t:wrapper>