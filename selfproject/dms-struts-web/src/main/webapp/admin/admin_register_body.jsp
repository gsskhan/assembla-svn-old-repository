<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<table class="ui-widget ui-widget-content ui-corner-all" style="width:100%;height:100%;min-height:700px;">
	<tr valign="top">
		<td align="center">
			<br/>
								
				<!-- Form for Adding a new User to the system. -->
				<strong>Please enter following details and Press 'Register'.</strong>
				<s:actionmessage theme="jquery" />
				<hr/>
				<div id="regForm" style="text-align: left;">
				<s:form labelposition="left" action="addUser">
					<sj:textfield label="User Name" required="true" labelposition="left" name="username"/>
					<s:password label="Password" required="true" labelposition="left" name="password"/>
					<sj:textarea label="Address" required="true" labelposition="left" name="address" rows="5" cols="50" />
					<sj:textfield label="Email" labelposition="left" name="email"/>
					<div id="selectOneAccessType">
						<s:url var="remoteurl" action="jsonsample"/>
						<sj:select  
									href="%{remoteurl}"
									name="accessType"
									list="accessTypeList"
									headerKey="-1"
									headerValue="-- SELECT --"
									required="true"
									labelposition="left"
									label="Access Type"
									/>
					</div>					
					<sj:submit value="Register" indicator="indicator" button="true" />				
					<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
				</s:form>
				</div>
			<br/>	
				<s:actionerror theme="jquery" />
				<s:fielderror theme="jquery" />
		</td>
	</tr>
</table>
