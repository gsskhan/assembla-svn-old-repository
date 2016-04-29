<form method="post" class="form-horizontal" style="font-size: 10px;">
	<div class="form-group" style="width: 40%">
		<label for="uid" class="control-label">User Id:</label> 
		<input type="text" name="userid" id="uid" class="form-control" value="Ignore, will be system assigned" disabled="disabled"/>
		
		<label for="unameid" class="control-label">User name:</label> 
		<input type="text" name="uname" id="unameid" required="required" class="form-control" />	
		
		<label for="passwdid" class="control-label">Password:</label>
		<input type="password" name="passwd" id="passwdid" required="required" class="form-control" />

		<label for="addressid" class="control-label">Address:</label>
		<textarea name="addr" id="addressid" required="required" class="form-control"></textarea>

		<label for="emailid" class="control-label">Email:</label>
		<input type="email" name="email" id="emailid" required="required" class="form-control" />

		<label for="roleid" class="control-label">Role:</label>
		<select id="roleid" name="role" class="form-control" required="required">
			<option value="----">-- SELECT --</option>
		</select>
		<br/>
		<input type="button" value="Add User" class="btn btn-primary" id="addUserBtn" />
		<input type="button" value="Save Changes" class="btn btn-primary" id="saveChangesUserBtn" disabled="disabled" />
	</div>
</form>
<div class="alert alert-warning" id="addUserResultMsg" hidden="true">
</div>