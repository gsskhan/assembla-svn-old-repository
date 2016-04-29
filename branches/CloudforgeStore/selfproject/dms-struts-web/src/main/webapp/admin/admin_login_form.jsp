<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<table class="ui-widget ui-widget-content ui-corner-all" style="width:100%;height:100%; min-height:700px;">
	<tr valign="top">
		<td width="40%" align="center">
			<br/>
			<br/>			
			<ul>
			 <li>Unused space for Advertisements/Newsletters - To be added later.</li>
			</ul>
		</td>
		
		<!-- Login form used by administrator to gain login to system. -->
		<td width="60%" align="center">
			<br/>
			<br/>
			<h5>Please enter following details and press "Login".</h5>
			<br/>
			<s:form action="adminlogin" method="POST">
				<br/>
				<sj:textfield name="username" label="User name " required="true"/> 
				<s:password name="password" label="Password " required="true"/>
				<sj:textfield name="accesstype" label="Access Type " value="ADMINISTRATOR" required="true"/>
				<sj:submit value="Login" button="true"/>	
			</s:form>
			<br/>
			<br/>
			<h6>Messages:</h6>
				<s:actionerror theme="jquery" />
				<s:actionmessage theme="jquery" />
				<s:fielderror theme="jquery"/>				
		
		<!-- Login form used by administrator to gain login to system. -->	
			<br/>			
			<br/>
			<br/>
			<h5 align="justify" style="font-style: italic;">
			If you don't have username and password, Please first create an administrator account using 'Registration' link.</h5>
			<br/>
		
		</td>
	</tr>
</table>
