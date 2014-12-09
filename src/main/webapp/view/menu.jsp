<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="grc-status-box">
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>
			<!-- Print User Role -->
			<span>
				Current User: <c:out value="${pageContext.request.userPrincipal.name}" /> (
				<c:if test="${isSuperAdmin}">SuperAdministrator</c:if> 
				<c:if test="${isExpertL3}">Expert L3</c:if> 
				<c:if test="${isExpertL2}">Expert L2</c:if> 	
				<c:if test="${isCustAdmin}">Administrator</c:if>
				<c:if test="${isHypervisor}">Hypervisor</c:if>
				<c:if test="${isSupervisor}">Supervisor</c:if>)
			</span> 
			<span><a href="login?logout">Logout</a></span>
		</p>
	</c:if>
</div>

<div class="grc-menu">
	<ul class="navigation-1">
		<c:if test="${not empty pageContext.request.userPrincipal}">
			<c:if test="${!isSupervisor}">
				<li><a class="" href="#"> <span>Administration</span>
				</a>
					<ul class="navigation-2">
						<c:if test="${ isExpertL2 || isExpertL3}">
							<li><a class="" href="manageCustomers"> <span>Manage Customers</span></a></li>
						</c:if>
						<c:if test="${ isCustAdmin}">
							<li><a class="" href="manageTenants"> <span>Manage Tenants</span></a></li>
						</c:if>
						<li><a class="" href="manageUsers"> <span>Manage Users</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${isExpertL3 || isExpertL2 || isCustAdmin}">
			<li><a class="" href="manageEquipment"> <span>Equipment</span>
			</a> <!-- <ul class="navigation-2"> 
				<li><a class="" href="searchEquipment"> <span>Search Equipment</span> searchEquipment
				</a></li>
			</ul> --></li></c:if>

			<c:if test="${!isSupervisor && !isSuperAdmin}">
				<li><a class="" href="#"><span>Applications</span></a>
					<ul class="navigation-2">
						<li><a class="" href="ccdmApp" target="_blank"> <span>CCDM Admin</span></li>
						<li><a class="" href="cucdmApp" target="_blank"> <span>CUCDM Admin</span></li>
						<li><a class="" href="mediaSenseApp" target="iframe-main"> <span>Search and
									Play</span>
						</a></li>
					</ul></li>
			</c:if>

			<c:if test="${!isSuperAdmin}">
				<li><a class="" href="#"> <span>Service Management</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="manageServices"> <span>Services & Sites</span></a></li>
						<li><a class="" href="manageMessages"> <span>Audio Messages</span></a></li>
						<li><a class="" href="managePinCodes"> <span>PIN Codes</span></a></li>
						<c:if test="${!isSupervisor}">
							<li><a class="" href="scriptEditorApp"> <span>Internet Script Editor</span></a></li>
						</c:if>
					</ul></li>
			</c:if>
			
			<c:if test="${!isSuperAdmin && !isSupervisor}">
			<li><a class="" href="#"> <span>Outbound</span>
			</a>
				<ul class="navigation-2">
					<li><a class="" href="manageCampaigns"> <span>Campaign Management</span></a></li>
				</ul></li>
			</c:if>

			<c:if test="${isExpertL3 || isExpertL2 || isCustAdmin}">
				<li><a class="" href="#"> <span>Support</span>
				</a>
					<ul class="navigation-2">
						<li><a class="" href="pcaApp" target="iframe-main"> <span>PCA Supervision</span></a></li>
						<li><a class="" href="#"> <span>Request Tracking</span></a>
							<ul class="navigation-3">
								<li><a class="" href="#"> <span>Incidents</span>
								</a></li>
								<li><a class="" href="#"> <span>Changes</span>
								</a></li>
							</ul></li>
						<li><a class="" href="#"> <span>Billing</span></a></li>
					</ul></li>
			</c:if>

			<c:if test="${!isSuperAdmin}">
				<li><a class="" href="cuicApp" target="iframe-main"> <span>Statistics</span>
				</a></li>
			</c:if>
			
			<li><a class="" href="settings"> <span>System Settings</span>
			</a></li>
		</c:if>
	</ul>
</div>