<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<table class="ui-widget ui-widget-content ui-corner-all" style="width:100%; height:100%; min-height: 700px;">
 <tr valign="top">
  <td align="left">
	<s:actionmessage theme="jquery"/>	
	<s:actionerror theme="jquery" />	
	<br/>
	<br/>
	<sj:tabbedpanel id="localtabs" selectedTab="2" show="'fold'" collapsible="true">
     	<sj:tab id="tab1" target="gridDiv"  label="View (All)" />
      	<sj:tab id="tab2" target="addConstantDiv" 	label="Add Constant"/>
      	<sj:tab id="tab3" target="editDelDiv" 	label="Search/Edit/Delete"/>
     		
     		<!-- GRID to view constants -->
     		<div id="gridDiv" align="center" >
     				
				<s:url var="remoteurl" action="gridConstantDataProvider" />
				<sjg:grid
					id="gridtable"
					caption="CONSTANTS"
					dataType="json"
					href="%{remoteurl}"
					pager="true"
					gridModel="gridConstantsList"
					rowList="10,15,20"
					rowNum="15"
					rownumbers="true"
					resizable="true"
					shrinkToFit="true"
					width="250"
					autowidth="true"
					loadingText="Please wait loading data..."	
					cssStyle="font: monospace; font-size: 9px"
				>
					<sjg:gridColumn name="id" index="id" title="CONSTANT ID" width="20" sortable="false" displayTitle="false" />
					<sjg:gridColumn name="variableName" index="variableName" title="VARIABLE NAME" width="50" sortable="true"/>
					<sjg:gridColumn name="variableId" index="variableId" width="20" title="VARIABLE ID" formatter="integer" sortable="false"/>
					<sjg:gridColumn name="variableValue" index="variableValue" width="50" title="VALUE" sortable="false"/>
					<sjg:gridColumn name="parentVariableId" index="parentVariableId" width="20" title="PARENT VARIABLE ID"  formatter="integer" sortable="false"/>
	                
				</sjg:grid>				
		    </div>
		    
		    <!-- Form to add new constants -->
     		<div id="addConstantDiv">
     			<p align="center">Please enter following details and Press 'Save'.</p>
				<hr/>
				<s:form action="addNewConstant" labelposition="left">
					<sj:textfield label="Variable Name" required="true" labelposition="left" 
								  name="varname" resizable="true" tooltip="enter alphabets" />
					<sj:textfield label="Variable Id" required="true" labelposition="left" 
								  name="varid" resizable="true" tooltip="enter numeric value" />
					<sj:textfield label="Value" required="true" labelposition="left" 
								  name="value" resizable="true" tooltip="enter alphabets"/>
					<sj:textfield label="Variable Parent Id" required="true" labelposition="left" 
								  name="varparentid" resizable="true" value="0" tooltip="enter numeric value"/>
					
					<sj:submit button="true" value="Save" />				
				</s:form>
     		</div>
     		
     		<!-- Form + Table to edit and delete Constants -->
      		<div id="editDelDiv" align="left" style="font-size: 12px">
      			<p align="center">Please enter/select a Variable Name and press "Search" to find matching records.</p>
      			<hr/>
				<div class="ui-widget report-download">
					<s:url id="ajax" value="downloadReportAllConstants"/>
					<s:a href="%{ajax}">Download Report (All Constants)</s:a>				
				</div>
      			<s:form action="searchConstants" labelposition="left">
      				<s:url id="getVarNamesURL" action="jsonVarNameAction"/> 
			    	<sj:select
			    			 	id="autocompSel"
			    		    	label="Enter/select Variable name"
			    		    	href="%{getVarNamesURL}"
			    		    	list="varNamesList"
			    		    	autocomplete="true"			    		    	
			    		    	name="searchkeyword"	 
			    		    	required="true"		
			    		    	value="x"    	
			    	/>
					<sj:submit value="Search" button="true" buttonIcon="ui-icon-search" />       			
      			</s:form>
      			<br/>      			
      			<br/>
      			<s:if test="searchResultList == null">
					<font class="ui-state-error" style="font-size: 12px;">No Records.</font>
				</s:if>
				<s:else>
      			  <table cellspacing="5" cellpadding="4" style="font-size: 10px">
				 	 <thead class="ui-widget-header ui-corner-all">
						<tr align="center">
							<th>CONSTANT ID</th> 
							<th>VARIABLE NAME</th>
							<th>VARIABLE</th>
							<th>VALUE</th>
							<th>PARENT VARIABLE ID</th>
							<th colspan="2">  Action  </th>
						</tr>
				  	</thead>
				  	<tbody class="ui-widget-content ui-corner-all">
						<s:iterator id="const" value="searchResultList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="variableName"/></td>
							<td><s:property value="variableId"/></td>
							<td><s:property value="variableValue"/></td>
							<td><s:property value="parentVariableId"/></td>	
							<td>
								<s:url id="url" action="setConstantRecordAction">
									<s:param name="constId"><s:property value="id"/></s:param>
								</s:url>
								<s:a href="%{url}">Edit</s:a>
							</td>
							<td>
								<s:url id="url" action="deleteConstantAction">
									<s:param name="constId"><s:property value="id"/></s:param>
								</s:url>
								<s:a href="%{url}">Delete</s:a>
							</td>					
						<tr>
				    	</s:iterator>
				  	</tbody>
			  	  </table>			  	  
			  	</s:else>
			  	<br/>
		  	  	<s:if test="#request.oldconstant != null">		
		  	  		<hr/><br/>  	  
		  	  		<s:form action="editConstantAction" labelposition="left">
		  	  			
		  	  			<s:textfield label="Constant Id" required="true" labelposition="left" name="constantId" readonly="true">
								<s:param name="value">
									<s:property value="#request.oldconstant.id"/>
								</s:param>	  
						</s:textfield>
						<s:textfield label="Variable Name" required="true" labelposition="left" name="varname" readonly="true" >
								<s:param name="value">
									<s:property value="#request.oldconstant.variableName"/>
								</s:param>	  
						</s:textfield>
						<s:textfield label="Variable Id" required="true" labelposition="left" name="varid" >
								<s:param name="value">
									<s:property value="#request.oldconstant.variableId"/>
								</s:param>	  
						</s:textfield>
						<s:textfield label="Value" required="true" labelposition="left" name="value" >
								<s:param name="value">
									<s:property value="#request.oldconstant.variableValue"/>
								</s:param>	  
						</s:textfield>
						<s:textfield label="Variable Parent Id" required="true" labelposition="left" name="varparentid" >
								<s:param name="value">
									<s:property value="#request.oldconstant.parentVariableId"/>
								</s:param>	  
						</s:textfield>
						<sj:submit button="true" value="Modify" />
										
					</s:form>
			  	  </s:if>
      		</div>
    </sj:tabbedpanel>				
	<br/>				
  </td>
 </tr>
</table>