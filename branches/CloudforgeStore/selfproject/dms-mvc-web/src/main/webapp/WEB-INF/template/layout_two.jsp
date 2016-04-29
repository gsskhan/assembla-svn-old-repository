<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>		
		<link href="resources/jquery/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
	    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">	    
	    <link href="resources/jquery/css/ui.jqgrid.css" rel="stylesheet" type="text/css">
	    <link href="resources/css/layout_two.css" rel="stylesheet" type="text/css">	    
		<script src="resources/jquery/scripts/jquery-1.10.2.js" type="text/javascript"></script>		
		<script src="resources/jquery/scripts/jquery-ui.js" type="text/javascript"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="resources/bootstrap/js/scrollspy.js" type="text/javascript"></script>
		<script src="resources/jquery/scripts/grid.locale-en.js" type="text/javascript"></script>
		<script src="resources/jquery/scripts/jquery.jqGrid.min.js" type="text/javascript"></script>
		<title>
			<t:insertAttribute name="title" defaultValue="Document Management System" ignore="true" />
		</title>	
	</head>
<body class="mainbody">
	<div id="topdiv" class="header ui-widget-header">		
		<t:insertAttribute name="header" ignore="true"/>
	</div>
	<div id="middlediv" class="middle">
		<t:insertAttribute name="middle" ignore="true" />
	</div>
	<div id="bottomdiv" class="footer ui-widget-header">		
		<t:insertAttribute name="footer" ignore="true"/>
	</div>
</body>
</html>