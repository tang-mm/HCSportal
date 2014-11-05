<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>

	<!-- tabs: General Information; Opening hours; Holidays; Exceptional Days;  -->
	<div class="grc-page-application">
		<div class="grc-form block" style="margin: 0 auto;">
			<form:form action="submitNewService" id="newServiceForm"
				name="newServiceForm" commandName="newServiceCmd">
				<div>
					<h1>Create New Service</h1>
				</div>

				<div class="grc-form">
					<table>
						<tbody>
						
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</t:wrapper>