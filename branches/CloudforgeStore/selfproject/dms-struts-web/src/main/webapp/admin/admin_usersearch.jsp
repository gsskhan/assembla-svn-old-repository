<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertTemplate template="/layout/layout_one.jsp">
	<tiles:putAttribute name="title" value="User search - Document System Management" />
	<tiles:putAttribute name="header" value="/layout/header_one.jsp" />
	<tiles:putAttribute name="menu" value="/admin/admin_mainmenu.jsp" />
  	<tiles:putAttribute name="body" value="/admin/admin_usersearch_body.jsp" />
  	<tiles:putAttribute name="footer" value="/layout/footer_one.jsp" />
</tiles:insertTemplate>