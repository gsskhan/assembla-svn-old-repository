<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="resources/js/manage_users.js"></script>
<script type="text/javascript" src="resources/js/manage_constants.js"></script>
<script type="text/javascript" src="resources/js/manage_paper.js"></script>

<c:if test="${status eq null}">
	<div class="alert alert-warning" style="text-align: center;">Administration Zone - changes performed are irreversible.</div>
</c:if>
<c:if test="${status eq 'success'}">
	<div class="alert alert-success" style="text-align: center;"><c:out value="${statusmsg}"/></div>
</c:if>
<c:if test="${status eq 'error'}">
	<div class="alert alert-danger" style="text-align: center;"><c:out value="${statusmsg}"/></div>
</c:if>

<div class="panel-group" id="accordion">
	<div class="panel panel-info">
		<div class="panel-heading" data-toggle="collapse"
			data-parent="#accordion" data-target="#collapseOne">
			<h3 class="panel-title">Manage System Users</h3>
		</div>
		<div id="collapseOne" class="panel-collapse collapse">
			<div class="panel-body">
				<div id="usermanagetabs">
					<ul>
						<li><a href="#usermanagetab-1"><span>Add</span></a></li>
						<li><a href="#usermanagetab-2"><span>Modify - Remove</span></a></li>
					</ul>
					<div id="usermanagetab-1">
						<!-- START: code to add new user form -->
						<jsp:include page="/WEB-INF/pages/admin/add_user.jsp"></jsp:include>
						<!-- END: code to add new user form -->
					</div>
					<div id="usermanagetab-2">
						<!-- START: code to edit or delete user-->
						<jsp:include page="/WEB-INF/pages/admin/edit_del_user.jsp"></jsp:include>
						<!-- END: code to edit or delete user -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading" data-toggle="collapse"
			data-parent="#accordion" data-target="#collapseTwo">
			<h3 class="panel-title">Manage Constants</h3>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse">
			<div class="panel-body">
				<div id="constmanagetabs">
					<ul>
						<li><a href="#constmanagetab-1"><span>Add</span></a></li>
						<li><a href="#constmanagetab-2"><span>Modify - Remove</span></a></li>
					</ul>
					<div id="constmanagetab-1">
						<!-- START: code to add new constant form -->
						<jsp:include page="/WEB-INF/pages/admin/add_constant.jsp"></jsp:include>
						<!-- END: code to add new user form -->
					</div>
					<div id="constmanagetab-2">
						<!-- START: code to edit or delete constant-->
						<jsp:include page="/WEB-INF/pages/admin/edit_del_constant.jsp"></jsp:include>
						<!-- END: code to edit or delete user -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading" data-toggle="collapse" data-parent="#accordion" data-target="#collapseThree">
			<h3 class="panel-title">Manage Papers</h3>
		</div>
		<div id="collapseThree" class="panel-collapse collapse">
			<div class="panel-body">
				<div id="papermanagetabs">
					<ul>
						<li><a href="#papermanagetab-1"><span>Add</span></a></li>
						<li><a href="#papermanagetab-2"><span>Download</span></a></li>
					</ul>
					<div id="papermanagetab-1">
						<!-- START: code to upload new paper form -->
						<jsp:include page="/WEB-INF/pages/admin/add_paper.jsp"></jsp:include>
						<!-- END: code to upload new paper form -->
					</div>
					<div id="papermanagetab-2">
						<!-- START: code to search new paper -->
						<jsp:include page="/WEB-INF/pages/admin/download_paper.jsp"></jsp:include>
						<!-- END: code to search new paper form -->						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
