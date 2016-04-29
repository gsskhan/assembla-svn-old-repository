<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Index page - Document Management System</title>
	<sj:head jqueryui="true" jquerytheme="redmond"/>
	<link rel="stylesheet" type="text/css" href="css/index.css" />	
</head>

<body background="images/fire.jpg" >
		<h2 align="justify">Document Management System</h2>
		
		<div id="homemenudiv" style="font-size: 11px;" >
			<sj:menu id="homePageMenuList" cssStyle="width:20%" >
				<sj:menuItem title="Home" href="index.jsp" />	
				<sj:menuItem title="System user">
					<sj:menu id="subMenuList" cssStyle="width:20%">
						<sj:menuItem title="General" href="#"/>
						<sj:menuItem title="Admin" href="admin/admin_login.jsp"/>
					</sj:menu>
				</sj:menuItem>
			</sj:menu>		
		</div>		
</body>
</html>