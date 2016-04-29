<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header style="font-size: 24px">Document Management System</header>
<div class="subheader">
	Welcome ! <c:out value="${sUserName}" default="Guest"/>
	&nbsp; Role: <c:out value="${sUserRole}" default="None"/>
	<br/><c:if test="${sUserName ne null}">
		<a href="logout">Sign out</a>
	</c:if>
</div>
