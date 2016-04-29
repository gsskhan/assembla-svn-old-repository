<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>		
		<link href="resources/jquery/themes/le-frog/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="resources/css/layout_one.css" rel="stylesheet">
	    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
		<script src="resources/jquery/scripts/jquery-1.10.2.js" type="text/javascript"></script>		
		<script src="resources/jquery/scripts/jquery-ui.js" type="text/javascript"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>	
	</head>
<body>
	<br/>
	<br/>
	<div class="alert alert-danger">
        <strong>Warning!</strong> There has been some error, please check with support.
        <p>Details: <c:out value="${exception}" default="-"></c:out></p>
	</div>
</body>	
