<form action="upload-new-paper" method="post" enctype="multipart/form-data"
		class="form-horizontal" style="font-size: 10px;">
	<div class="form-group" style="width: 40%">	
		<label for="paper-title-id" class="control-label">Paper Title:</label> 
		<input type="text" name="paper-title" id="paper-title-id" required="required" class="form-control" />	
		
		<label for="file-upload-id" class="control-label">Select file:</label> 
		<input id="file-upload-id" type="file" name="new-file" class="form-control" required="required">
		
		<div class="checkbox">
		<label><input type="checkbox" required="required" name="assign-for-authorization" />Assign for authorization</label>
		</div>
		
		<label for="select-auth-name-id" class="control-label">Select authorizer's name:</label>
		<select id="select-auth-name-id" name="auth-username" required="required" class="form-control" >
			<!-- <option value="----">-- SELECT --</option> -->
		</select>
				
		<input id="uploader-name-id" type="text" name="uploader-name" value="${sUserName}" hidden="true" />
		<br>			
		<input type="submit" value="Upload" class="btn btn-primary btn-sm" />
	</div>
</form>