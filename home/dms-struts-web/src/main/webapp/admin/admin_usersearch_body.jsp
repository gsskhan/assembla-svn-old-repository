<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<table class="ui-widget ui-widget-content ui-corner-all" style="width:100%;height:100%;min-height:700px;">
	<tr valign="top">
		<td align="center">
			<s:actionmessage theme="jquery"/>
			<br/>
			<!-- Form to search the user and display their details -->
			<strong>Please enter a keyword and press "Search" to find matching system users.</strong>
			<hr/>
			<div class="ui-widget report-download">
				<s:url id="ajax" value="downloadReportAllUsers"/>
				<s:a href="%{ajax}">Download Report (All Users)</s:a>				
			</div>
			<div id="searchFormDiv" style="text-align: left;">
				<s:form id="searchUserForm" action="searchUserAction" labelposition="left" >
					<sj:textfield name="searchkeyword" required="true" 
						 	labelposition="left" label="Keyword: "/>
					<sj:submit value="Search" indicator="indicator" 
						 	button="true" buttonIcon="ui-icon-search" />					
				</s:form>			
			</div>			
			
			<br/>
			<div id="listdiv" style="text-align: left;font-size: 10px;vertical-align: top;" >
			<s:set name="users" value="usersList" />
			<s:if test="usersList==null">
				<font class="ui-state-error" style="font-size: 12px;">No Records.</font>
			</s:if>
			<s:else>
			<table cellspacing="6" cellpadding="4">
				<thead class="ui-widget-header ui-corner-all">
					<tr align="center">
						<th>User Id</th> 
						<th>User Name</th>
						<th>Password</th>
						<th>Address</th>
						<th>Email</th>
						<th>Access Type</th>
						<th colspan="2"> Action </th>
					</tr>
				</thead>
				<tbody class="ui-widget-content ui-corner-all">
					<s:iterator id="user" value="users">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="username"/></td>
						<td><s:property value="password"/></td>
						<td><s:property value="address"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="role"/></td>
						<td>
							<s:url id="url" action="putUserRecord">
								<s:param name="userid"><s:property value="id"/></s:param>
							</s:url>
							<s:a href="%{url}">Edit</s:a>
						</td>
						<td>
							<s:url id="url" action="delUser">
								<s:param name="userid"><s:property value="id"/></s:param>
							</s:url>
							<s:a href="%{url}">Delete</s:a>
						</td>
					<tr>
				</s:iterator>
				</tbody>
			</table>			
			</s:else>			
			</div>
			<br/>
			
			<!-- Form to display details of user being edited. -->
			<s:if test="#request.moduser.id!=null">
				<div id="editUserDiv" style="text-align: left;vertical-align: top;" >
					<table width="500">
						<thead class="ui-widget-header ui-corner-all">
							<tr align="center" style="height: 50; font-size: 15px;">
								<th>Edit System user</th> 
							</tr>
						</thead>
						<tbody class="ui-widget-content ui-corner-all">
						<tr align="left">
							<td>
								<s:form labelposition="left" action="modifyUser">
									<s:textfield label="User Id" required="true" labelposition="left" name="userId" readonly="true"  >
										<s:param name="value">
											<s:property value="#request.moduser.id"/>
										</s:param>			  
									 </s:textfield>
									<s:textfield label="User Name" required="true" labelposition="left" name="username" readonly="true"  >
										<s:param name="value">
											<s:property value="#request.moduser.username"/>
										</s:param>			  
							 		</s:textfield>
									<s:password label="Password " required="true" labelposition="left" name="password" showPassword="true">
										<s:param name="value">
											<s:property value="#request.moduser.password"/>
										</s:param>
									</s:password>
									<s:textarea label="Address" required="true" labelposition="left" name="address" rows="5" cols="50" >
										<s:param name="value">
											<s:property value="#request.moduser.address"/>
										</s:param>
									</s:textarea>
									<s:textfield label="Email" labelposition="left" name="email">
										<s:param name="value">
											<s:property value="#request.moduser.email"/>
										</s:param>
									</s:textfield>
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
										>
											<s:param name="value">
												<s:property value="#request.moduser.role"/>
											</s:param>	
										</sj:select>
									</div>					
									<sj:submit value="Save" indicator="indicator" button="true" />				
									<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
								</s:form>
							</td>
						</tr>
					</tbody>
					</table>				
			</div>			
			</s:if>				
				
			<br/>
				<s:actionerror theme="jquery" />
				<s:fielderror  theme="jquery"/>	
				
		</td>
	</tr>
</table>