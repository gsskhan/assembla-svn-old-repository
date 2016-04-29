<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<script type="text/javascript" src="../js/admin.js"></script>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />

<div style="position: relative;z-index: 9999;">  
  	<sj:menu id="mainMenuList" cssStyle="width:100%; font-size: 12px;" >	
	
	<s:if test="#session.uname==null">
		<sj:menuItem title="Back to Home" href="../index.jsp"/>
		<sj:menuItem title="Login" href="admin_login.jsp" menuIcon="ui-icon-gear" />
	</s:if>
	<s:else>
		<sj:menuItem title="Admin Home" href="admin_home.jsp" menuIcon="ui-icon-gear"/>	
		<sj:menuItem title="Manage Users" menuIcon="ui-icon-carat-4-e">
			<sj:menu cssStyle="width:100%;">
				<sj:menuItem title="Add User" href="admin_register.jsp" menuIcon="ui-icon-arrowstop-1-e"/>
				<sj:menuItem title="Search/Edit/Delete User" href="admin_usersearch.jsp" menuIcon="ui-icon-arrowstop-1-e"/>
			</sj:menu>			
		</sj:menuItem>
		<sj:menuItem title="Manage Constants" href="admin_manageconstants.jsp" menuIcon="ui-icon-arrow-4-diag"/>			
		<sj:menuItem title="Manage Paper" href="admin_managepapers.jsp" menuIcon="ui-icon-arrow-4-diag"/>
	</s:else>	
	</sj:menu>	

</div>
