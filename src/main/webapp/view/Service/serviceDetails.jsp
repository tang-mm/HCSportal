<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>

	<!-- tabs: General Information; Opening hours; Holidays; Exceptional Days;  -->
	<div class="grc-form block">
		<form:form action="submitNewService" id="newServiceForm"
			name="newServiceForm" commandName="newServiceCmd">
			<div>
				<h1>Details ></h1>
			</div>

			<div class="grc-form">
				<table>
					<tbody>

					</tbody>
				</table>
			</div>
		</form:form>
	</div>
</t:wrapper>