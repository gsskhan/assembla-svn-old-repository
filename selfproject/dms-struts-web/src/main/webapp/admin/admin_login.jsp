<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertTemplate template="/layout/layout_one.jsp">
	<tiles:putAttribute name="title" value="Login for Administrator - Document System Management" />
	<tiles:putAttribute name="header" value="/layout/header_one.jsp" />
	<tiles:putAttribute name="menu" value="/admin/admin_mainmenu.jsp" />
  	<tiles:putAttribute name="body" value="/admin/admin_login_form.jsp" />
  	<tiles:putAttribute name="footer" value="/layout/footer_one.jsp" />
</tiles:insertTemplate>
