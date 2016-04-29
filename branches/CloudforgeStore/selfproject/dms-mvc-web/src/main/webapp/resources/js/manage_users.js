/* Start: To activate user manage Tabs */
$(function() {
	$("#usermanagetabs").tabs();	
});
/* End: To activate user manage Tabs */

/* Start: To load user roles in add user form*/
$(document).ready(function(){
	$("#roleid").click(function(){
		$.getJSON('usermanage/rolelist',function(jd){
			$("#roleid").empty();
			$("#roleid").html('<option value="NONE">-- SELECT --</option>');
			for (var i = 0; i < jd.length; i++) {
				$("#roleid").append('<option value="'+jd[i]+'">'+jd[i]+'</option>');				
			}
		});
		$("#roleid").unbind('click');
	});		
});
/* End: To load user roles in add user form*/

/* Start: To add new user.*/
$(document).ready(function(){
	$("#addUserBtn").click(function(){
		var username = $('#unameid').val();
		var password = $('#passwdid').val();
		var address = $('#addressid').val();
		var email = $('#emailid').val();
		var role = $('#roleid').val();
		var inparam = {};
		inparam.uname=username;	
		inparam.passwd=password;
		inparam.addr=address;
		inparam.email=email;
		inparam.role=role;
		// Send the request
		$.post('usermanage/add', inparam, function(jd) {
			$('#addUserResultMsg').text(jd.msg);
			$('#addUserResultMsg').attr('hidden', false);
			// reload the edit user table and remove any previous message there.
			$('#editDelUserTable').click();
			$('#editDelUserResultMsg').attr('hidden', true);
		}, 'json');		
	});
});
/* End: To add new user.*/

/*************** NOT IN USE (Kept here for knowledge purpose only) **************

  Start: To load user names in delete user form for auto complete.
$(document).ready(function(){
	$("#delnameid").click(function(){
		$.getJSON('usermanage/usernamelist',function(jd){
			var namelist = [];
			for (var i = 0; i < jd.length; i++) {
				namelist.push(jd[i]);				
			}
			$("#delnameid").autocomplete({
				source:namelist
			});
		});		
	});
});
   End: To load user names in delete user form for auto complete.

   Start: To delete user. 
$(document).ready(function(){
	$("#deleteUserBtn").click(function(){
		var username = $('#delnameid').val();
		var inparam = {};
		inparam.delusername=username;
		// Send the request
		$.post('usermanage/delete', inparam, function(jd) {
			$('#delUserResultMsg').text(jd.msg);
			$('#delUserResultMsg').attr('hidden', false);
		}, 'json');		
	});	
});
  End: To delete user.
************************************************************************************/

/* Start: To load users in edit user table.*/
$(document).ready(function(){
	$('#editDelUserTable').click(function() {
		$.getJSON('usermanage/allusers',function(jd){
			$('#editDelUserTableBody').empty();
			for (var i = 0; i < jd.length; i++) {
				$('#editDelUserTableBody').append('<tr>');
				$('#editDelUserTableBody').append('<td>'+jd[i].userId+'</td>');
				$('#editDelUserTableBody').append('<td>'+jd[i].username+'</td>');
				$('#editDelUserTableBody').append('<td>'+jd[i].password+'</td>');
				$('#editDelUserTableBody').append('<td>'+jd[i].address+'</td>');
				$('#editDelUserTableBody').append('<td>'+jd[i].email+'</td>');
				$('#editDelUserTableBody').append('<td>'+jd[i].role+'</td>');
				$('#editDelUserTableBody').append('<td>'
						+'<div style="height: auto" class="btn btn-warning btn-sm" onclick="editThisUser('+jd[i].userId+')">edit</div>'
						+'<div style="height: auto" class="btn btn-danger btn-sm" onclick="deleteThisUser('+jd[i].userId+')">delete</div>'
						+'</td>');				
				$('#editDelUserTableBody').append('</tr>');
			}
		});
	});	
});
/* End: To load users in edit user table.*/

/* Start: Function to get user details for edit by REST.*/
function editThisUser(id) {
	// Hide messages in 'Edit/remove' tab and set focus on 'Add' tab and show edit message there.
	$('#editDelUserResultMsg').attr('hidden', true);
	$('#usermanagetabs' ).tabs( "option", "active", 0 );
	$('#addUserResultMsg').attr('hidden', false);
	$('#addUserResultMsg').text('Editing user id= '+ id+'. Please fill in the changes and Save.');
	// Enable 'Save changes' button, and disable 'Add user' Button.
	$('#saveChangesUserBtn').removeAttr('disabled');
	$('#addUserBtn').attr('disabled','disabled');
	// Reload the user roles drop down.
	$("#roleid").click();
	// Get the user details to edit and fill the form.
	$.getJSON('usermanage/user/'+id,function(jd){
		$('#uid').val(jd.userId);
		$('#unameid').val(jd.username);
		$('#passwdid').val(jd.password);
		$('#addressid').val(jd.address);
		$('#emailid').val(jd.email);
		$('#roleid').val(jd.role);
	});
};
/* End: Function to get user details for edit by REST.*/

/* Start: To save changes for an old user.*/
$(document).ready(function(){
	$("#saveChangesUserBtn").click(function(){
		var userid = $('#uid').val();
		var username = $('#unameid').val();
		var password = $('#passwdid').val();
		var address = $('#addressid').val();
		var email = $('#emailid').val();
		var role = $('#roleid').val();
		var inparam = {};
		inparam.userid=userid;
		inparam.uname=username;	
		inparam.passwd=password;
		inparam.addr=address;
		inparam.email=email;
		inparam.role=role;
		// Send the request
		$.post('usermanage/savechanges', inparam, function(jd) {
			$('#addUserResultMsg').text(jd.msg);
			$('#addUserResultMsg').attr('hidden', false);
			// Disable 'Save changes' button, and enable 'Add user' Button.
			$('#saveChangesUserBtn').attr('disabled','disabled');
			$('#addUserBtn').removeAttr('disabled');
			// reload the edit user table and remove any previous message there.
			$('#editDelUserTable').click();
			$('#editDelUserResultMsg').attr('hidden', true);
			// Clear the form
			clearAddUserForm();
		}, 'json');		
	});
});
/* End: To save changes for an old user.*/

/* Start: Function to delete user by REST.*/
function deleteThisUser(id) {
	$.getJSON('usermanage/delete/'+id ,function(jd){
		$('#editDelUserResultMsg').text(jd.msg);
		$('#editDelUserResultMsg').attr('hidden', false);
		// reload the edit user table and remove any previous message from add user section.
		$('#editDelUserTable').click();
		$('#addUserResultMsg').attr('hidden', true);
	});	
};
/* End: Function to delete user by REST.*/

/* Start: Function to clear add user form.*/
function clearAddUserForm() {
	$('#uid').val("Ignore...");
	$('#unameid').val("");
	$('#passwdid').val("");
	$('#addressid').val("");
	$('#emailid').val("");
	$('#roleid').val("");
}
/* End: Function to clear add user form.*/
