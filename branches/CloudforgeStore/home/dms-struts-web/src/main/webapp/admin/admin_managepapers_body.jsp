<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html>

<div class="manage-paper-container ui-widget ui-widget-content ui-corner-all">
	<s:actionmessage theme="jquery" />
	<s:actionerror theme="jquery" />
	
	<sj:accordion id="managePaperAccordion" heightStyle="content" collapsible="true" active="false">		
		<!-- Form to find a paper -->
		<sj:accordionItem title="Search papers (Please enter paper number)" >
			<s:form action="searchPaperDetails">
				Paper Number:<s:textfield name="searchpapernumber" theme="simple"/>
				<s:submit value="Search Paper" theme="simple" />
			</s:form>		
		</sj:accordionItem>
		
		<!-- Form to upload new paper -->
		<sj:accordionItem title="Please fill-in the form and press 'Save' to upload new document.">
			<s:form action="addNewPaper" enctype="multipart/form-data" method="post" >
				<sj:textfield name="papertitle" label="Paper Title" labelposition="left" requiredLabel="true" required="true" />
				<s:file name="fileUpload" label="File" requiredLabel="true" labelposition="left" required="true" />
				<s:checkbox name="authrequired" label="Authorization Required" requiredLabel="true" fieldValue="true" value="true" labelposition="left" required="true" />
				<s:div>
					<s:url var="ajaxurl" action="getAuthorizerNamesList">
						<s:param name="creatorname">
							<s:property value="#session.uname" />
						</s:param>
					</s:url>
					<sj:select href="%{ajaxurl}" name="authorizerName" list="authorizersNameList" headerKey="-1"
						headerValue="-- SELECT --" required="true" labelposition="left" label="Authorizer's Name" />
				</s:div>
				<s:textfield name="ownername" label="Owner" labelposition="left" readonly="true" required="true">
					<s:param name="value">
						<s:property value="#session.uname" />
					</s:param>
				</s:textfield>
				<sj:submit value="Save" button="true" cssStyle="width:100px;" />
			</s:form>		
		</sj:accordionItem>
		
		<!-- To find pending workflow(s) -->
		<sj:accordionItem title="Workflow(s) pending for action">
			<div class="wf-container">
				<div class="workflow-link">
					<s:url id="pendingwfurl" value="pendingWorkflowActions" />
					<s:a href="%{pendingwfurl}" button="false">Find Workflows</s:a>
				</div>
				<table style="font-size: 10px; width: 100%">
					<thead class="ui-widget-header ui-corner-all">
						<tr align="center">
							<th>PAPER NUMBER</th>
							<th>PAPER TITLE</th>
							<th>PENDING FOR ACTION BY</th>
							<th>COMMENTS</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody class="ui-widget-content ui-corner-all">
						<s:iterator value="pendingActionWorkflowsList" var="wf">
							<tr align="center">
								<td><s:property value="paperNumber" /></td>
								<td><s:property value="paperTitle" /></td>
								<td><s:property value="pendingActionFromUsername" /></td>
								<td><s:property value="comments" /></td>
								<td><s:url id="url" action="launchWorkflow">
									<s:param name="wfid">
										<s:property value="workflowId" />
									</s:param>
									</s:url> <s:a href="%{url}">Launch</s:a></td>
								<td>
							<tr>
						</s:iterator>
					</tbody>
				</table>
			</div>			
		</sj:accordionItem>	
	
	</sj:accordion>
	
	<!-- To view Papers or work on launched workflow(s) -->
	<div class="paper-manage-body">		
		<s:if test="#request.paperstore != null">
		<h4 align="center">Section for viewing paper. Please enter a paper number on top and search.</h4>
		<hr />
			<div style="float: left; width: 50%;" align="left">
			<table class="view-paper">
				<thead class="ui-widget-header ui-corner-all">
					<tr align="center">
						<th>PROPERTY</th>
						<th>VALUE</th>
					</tr>
				</thead>
				   <tbody class="ui-widget-content ui-corner-all" align="left" style="font-size: 12px;">
				 	<tr><td>Paper Number</td><td><s:property value="#request.paperstore.number" /></td><tr>
					<tr><td>Paper Title</td><td><s:property value="#request.paperstore.title" /></td><tr>
					<tr><td>Uploaded Filename</td><td><s:property value="#request.paperstore.originalFilename" /></td><tr>
					<tr><td>Paper</td><td>
						<s:url id="paperurl" action="downloadPaper" >
							<s:param name="paperid"><s:property value="#request.paperstore.id"/></s:param>
						</s:url><s:a href="%{paperurl}" cssStyle="color: #2E6E9E;">Download</s:a>
					</td><tr>
					<tr><td>Creator</td><td><s:property value="#request.paperstore.createdByUser.username" /></td><tr>
					<tr><td>Creation Time</td><td><s:date name="#request.paperstore.creationTime" /></td><tr>					
					<tr><td>Authorized</td><td><s:property value="#request.paperstatus.authorized" /></td><tr>
					<tr><td>Authorizer</td><td><s:property value="#request.paperstatus.authorizedBy.username" /></td><tr>
					<tr><td>Authorization Time</td><td><s:date name="#request.paperstatus.authorizationTime" /></td><tr>
					<tr><td>Approved</td><td><s:property value="#request.paperstatus.approved" /></td><tr>
					<tr><td>Approver</td><td><s:property value="#request.paperstatus.approvedBy.username" /></td><tr>
					<tr><td>Approval Time</td><td><s:date name="#request.paperstatus.approvalTime" /></td><tr>
					<tr><td>Rejected</td><td><s:property value="#request.paperstatus.rejected" /></td><tr>
					<tr><td>Rejector</td><td><s:property value="#request.paperstatus.rejectedBy.username" /></td><tr>
					<tr><td>Rejection Time</td><td><s:date name="#request.paperstatus.rejectionTime" /></td><tr>
					<tr><td>Remarks</td><td><s:textarea theme="simple" readonly="true" cols="30" rows="5">
						<s:param name="value"><s:property value="#request.paperstatus.comments" /></s:param>
					</s:textarea></td><tr>				 
				  </tbody>
			</table>
			</div>
			<div style="float: right; width: 50%;">
			<div class="workflow-history">Workflow History</div>
			<table class="view-wf-table">
				<thead class="ui-widget-header ui-corner-all">
					<tr align="center">
						<th>ASSIGNMENT TIME</th>
						<th>ASSIGNED TO USER</th>
						<th>COMPLETION TIME</th>
						<th>COMPLETED BY USER</th>
						<th>STATUS</th>
					</tr>
				</thead>
				<tbody class="ui-widget-content ui-corner-all">
					<s:iterator value="#request.wflist" status="wflist">
						<tr align="center">
							<td><s:date name="assignedOnTime"/></td>
							<td><s:property value="assignedToUser.username" /></td>
							<td><s:property value="completionTime" /></td>
							<td><s:property value="completedByUser.username" /></td>
							<td><s:property value="comments" /></td>
						<tr>
					</s:iterator>
				</tbody>
			</table>
			</div>
			<div style="clear: both;"></div>
		</s:if>
		<s:elseif test="#request.wfLaunchId != null">
		<h4 align="center">Please launch pending workflows and complete</h4>
		<hr />
			<div align="left" style="margin-left: 2px;">
			<s:form action="processWorkflow">
				<s:textfield name="launchworkflowId" label="Launch Id (Internal Use Only)" labelposition="left" readonly="true">
					<s:param name="value"><s:property value="#request.wfLaunchId"/></s:param>
				</s:textfield>
				<s:textfield name="paperTitle" label="Paper Title" labelposition="left" requiredLabel="true" required="true" readonly="true" >
					<s:param name="value"><s:property value="#request.wfLaunchpapertitle"/></s:param>
				</s:textfield>
				<s:textfield name="paperNumber" label="Paper Number" labelposition="left" requiredLabel="true" required="true" readonly="true" >
					<s:param name="value"><s:property value="#request.wfLaunchpapernumber"/></s:param>
				</s:textfield>
				<s:div>
					<s:url var="actionurl" action="findWorkflowActionTextList" />
					<sj:select href="%{actionurl}" name="actionText" list="actiontextList" headerKey="NA" headerValue="- SELECT -"
						required="true" requiredLabel="true" labelposition="left" label="Action" />
					<s:url var="userslisturl" action="findUsersListToAssign" >
						<s:param name="workflowfid">
							<s:property value="#request.wfLaunchId" />
						</s:param>
					</s:url>
					<sj:select href="%{userslisturl}" name="assignedToUsername" list="usernamesListToAssign" headerKey="NA" headerValue="- SELECT -"
						required="true" requiredLabel="true" labelposition="left" label="Assign To" />
				</s:div>
				<sj:textarea name="remarks" cols="50" rows="3" label="Remarks"></sj:textarea>
				<s:textfield name="currentusername" label="Current Username" labelposition="left" readonly="true" required="true">
					<s:param name="value">
						<s:property value="#session.uname" />
					</s:param>
				</s:textfield>				
				<sj:submit value="Process" button="true" cssStyle="width:100px;" />		
			</s:form>
			</div>
		</s:elseif>
	</div>
</div>
