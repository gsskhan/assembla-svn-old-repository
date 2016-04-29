<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/login.js"></script>
<div class="container theme-showcase">
	<div class="panel panel-info loginpanel">
		<div class="panel-heading" id="pheaderid">
			<h3 class="panel-title">Login Form</h3>
		</div>
		<div class="panel-body" id="pbodyid">
			<sf:form cssClass="form-horizontal" commandName="user" method="POST">
				<sf:errors element="div" path="*" cssClass="alert alert-danger" />
				<div class="form-group">
					<label for="unameid" class="control-label">User name:</label>
					<sf:input path="username" id="unameid" />
				</div>
				<div class="form-group">
					<label for="passwdid" class="control-label">Password:</label>
					<sf:password path="password" id="passwdid" />
				</div>
				<div class="form-group">
					<label for="roleid" class="control-label">Role:</label>
					<sf:select path="role" id="roleid">
						<sf:option value="NONE" label="-- SELECT --" />
						<sf:options items="${roleList}" />
					</sf:select>
				</div>
				<div class="form-group">
					<input type="submit" value="Login" class="btn btn-primary">
				</div>
			</sf:form>
			<div class="alert alert-info">
				<c:out value="${msg}" default="Please fill the details and login."></c:out>
			</div>
		</div>
	</div>
</div>






