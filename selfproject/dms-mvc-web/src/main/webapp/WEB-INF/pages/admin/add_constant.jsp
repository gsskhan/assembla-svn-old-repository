<form method="post" class="form-horizontal" style="font-size: 10px;">
	<div class="form-group" style="width: 40%">
		<label for="cid" class="control-label">Constant Id:</label> 
		<input type="text" name="constantid" id="cid" class="form-control" value="Ignore, will be system assigned" disabled="disabled"/>
		
		<label for="cvar" class="control-label">Variable:</label> 
		<input type="text" name="variable" id="cvar" required="required" class="form-control" />	
		
		<label for="cvarid" class="control-label">Variable Id:</label>
		<input type="text" name="variableid" id="cvarid" required="required" class="form-control" />

		<label for="cvalueid" class="control-label">Value:</label>
		<input type="text" name="value" id="cvalueid" required="required" class="form-control" />

		<label for="cparid" class="control-label">Parent Variable Id:</label>
		<input type="text" name="parentvariableid" value="0" id="cparid" required="required" class="form-control" />

		<br/>
		<input type="button" value="Add Constant" class="btn btn-primary" id="addConstBtn" />
		<input type="button" value="Save Changes" class="btn btn-primary" id="saveChangesConstBtn" disabled="disabled" />
	</div>
</form>
<div class="alert alert-warning" id="addConstResultMsg" hidden="true">
</div>