<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="grc-menu">
	<ul class="navigation-1">
		<c:if test="${not empty pageContext.request.userPrincipal}">

			<!-- User Roles -->
			<c:set var="isSuperAdmin" scope="session"
				value="${pageContext.request.isUserInRole('ROLE_SUPERADMIN')?  'true' : 'false'}" />
			<c:set var="isExpert" scope="session"
				value="${pageContext.request.isUserInRole('ROLE_EXPERT')?  'true' : 'false'}" />
			<c:set var="isAdmin" scope="session"
				value="${pageContext.request.isUserInRole('ROLE_ADMIN')?  'true' : 'false'}" />
			<c:set var="isSupervisor" scope="session"
				value="${pageContext.request.isUserInRole('ROLE_SUPERVISOR')?  'true' : 'false'}" />
			<c:set var="isAgent" scope="session"
				value="${pageContext.request.isUserInRole('ROLE_AGENT')?  'true' : 'false'}" />

			<!-- MENU -->
			<c:if test="${!isAgent}">
				<li><a class="" href="#"> <span>User Administration</span>
				</a>
					<ul class="navigation-2">
						<c:if test="${isSuperAdmin}">
							<li><a class="" href="#"> <span>Manage Customers</span></a></li></c:if>
						<li><a class="" href="#"> <span>Manage Users</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${isExpert}">
				<li><a class="" href="#"> <span>Equipment</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="#"> <span>General</span>
						</a></li>
						<li><a class="" href="#"> <span>Equipment Map</span>
						</a></li>
					</ul></li>
			</c:if>

			<c:if test="${isExpert || isAdmin || isSupervisor}">
				<li><a class="" href="https://172.31.14.195/Portal"
					target="iframe-main"> <span>CCDM Admin</span>
				</a></li>
			</c:if>

			<c:if test="${!isSuperAdmin}">
				<li><a class="" href="#" target="iframe-main"> <span>CUCDM
							Admin</span>
				</a></li>
			</c:if>

			<c:if test="${isExpert || isAdmin}">
				<li><a class="" href="#"> <span>Routing</span>
				</a>
					<ul class="navigation-2">
						<c:if test="${isExpert || isAdmin}">
							<li><a class="" href="#"> <span>Manage Sites</span></a></li>
							<li><a class="" href="#"> <span>PIN Codes</span></a></li>
						</c:if>
						<c:if test="${isAdmin}">
							<li><a class="" href="#"> <span>Internet Script
										Editor</span></a></li>
						</c:if>
					</ul></li>
			</c:if>

			<c:if test="${isExpert || isAdmin}">
				<li><a class="" href="#"> <span>Outbound</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="#"> <span>Campaign
									Management</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${isExpert}">
				<li><a class="" href="#"> <span>Support</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="#"> <span>Request Tracking</span></a>
							<ul class="navigation-3">
								<li><a class="" href="#"> <span>Incidents</span>
								</a></li>
								<li><a class="" href="#"> <span>Changes</span>
								</a></li>
							</ul></li>
						<li><a class="" href="https://172.31.14.200/emsam/index.html"
							target="iframe-main"> <span>PCA Supervision</span></a></li>
						<li><a class="" href="#"> <span>Billing</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${isExpert || isAdmin}">
				<li><a class=""
					href="https://172.31.14.71:8444/cuic/Login.htmx"
					target="iframe-main"> <span>Statistics</span>
						<ul class="navigation-2">
							<c:if test="${isExpert || isAgent}">
								<li><a class="" href="#"> <span>Global</span></a></li>
								<li><a class="" href="#"> <span>Customer</span></a></li>
							</c:if>
						</ul>
				</a></li>
			</c:if>

			<c:if test="${isSupervisor || isAgent}">
				<li><a class="" href="#"> <span>Finesse</span> <!--onclick='document.getElementByName("iframe-main").src="https://172.31.14.72/cfadmin"'   -->
				</a>
					<ul class="navigation-2">
						<li><a class="" href="https://172.31.14.72/desktop/"
							target="iframe-main"> <span>Finesse Desktop</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${isSupervisor || isAgent}">
				<li><a class="" href="#"> <span>EIM / WIM</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="#"> <span>EIM / WIM User</span></a></li>
					</ul></li>
			</c:if>
			
			<c:if test="${isExpert || isAdmin || isSupervisor }">
				<li><a class="" href="#"> <span>MediaSense</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="https://172.31.16.172:8440/mediasense"
							target="iframe-main"> <span>Search and Play</span></a></li>
					</ul></li>
			</c:if>

			<li><a class="" href="#"> <span>System Settings</span>
			</a></li>
	</ul>
</div>
</c:if>