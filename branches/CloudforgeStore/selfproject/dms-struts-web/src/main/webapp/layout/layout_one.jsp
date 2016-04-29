<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
	<sj:head jquerytheme="redmond" jqueryui="true" />
	<title><tiles:insertAttribute name="title" defaultValue="Document Management System" /></title>
</head>
<body style="font-family: Courier New; font-size: 12px; background-color: #E1F0FF;">
	<table style="border: 1; width: 1024px; padding: 1px;">
		<tr>
			<td colspan="2" height="50"><tiles:insertAttribute name="header" />
			</td>
		</tr>

		<tr height="800">
			<td width="20%" valign="top"><tiles:insertAttribute name="menu" />
			</td>
			<td width="80%" align="center" valign="top"><tiles:insertAttribute
					name="body" /></td>
		</tr>

		<tr height="25">
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>