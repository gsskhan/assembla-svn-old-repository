/* Start: To activate constant manage Tabs */
$(function() {
	$("#constmanagetabs").tabs();
});
/* End: To activate constant manage Tabs */

/* Start: To create grid for constants */
$(document).ready(function(){
	$('#editDelConstTable').click(function() {
		$.getJSON('constant/all/json',function(jd){
			$('#editDelConstTableBody').empty();
			for (var i = 0; i < jd.length; i++) {
				$('#editDelConstTableBody').append('<tr>');
				$('#editDelConstTableBody').append('<td>'+jd[i].constantId+'</td>');
				$('#editDelConstTableBody').append('<td>'+jd[i].variable+'</td>');
				$('#editDelConstTableBody').append('<td>'+jd[i].variableId+'</td>');
				$('#editDelConstTableBody').append('<td>'+jd[i].value+'</td>');
				$('#editDelConstTableBody').append('<td>'+jd[i].parentVariableId+'</td>');
				$('#editDelConstTableBody').append('<td>'
						+'<div style="height: auto" class="btn btn-warning btn-sm" onclick="editThisConstant('+jd[i].constantId+')">edit</div>'
						+'<div style="height: auto" class="btn btn-danger btn-sm" onclick="deleteThisConstant('+jd[i].constantId+')">delete</div>'
						+'</td>');				
				$('#editDelConstTableBody').append('</tr>');
			}
		});
	});	
});
/* End: To create grid for constants */

/* Start: To add new constant*/
$(document).ready(function(){
  $('#addConstBtn').click(function() {
	var variable = $('#cvar').val();
	var variableId = $('#cvarid').val();
	var value = $('#cvalueid').val();
	var parVarId = $('#cparid').val();
	var inparam = {};
		inparam.variable=variable;
		inparam.variableid=variableId;
		inparam.value=value;
		inparam.parentvariableid=parVarId;
		// send the request
		$.post('constant/add', inparam, function(jd) {
			$('#addConstResultMsg').text(jd.msg);
			$('#addConstResultMsg').attr('hidden', false);
			// reload the edit user table and remove any previous message there.
			$('#editDelConstTable').click();
			$('#editDelConstResultMsg').attr('hidden', true);
			// Clear the form.
			clearAddConstantForm();
		}, 'json');
  });
});
/* End: To add new constant*/

/* Start: Function to delete constant by REST.*/
function deleteThisConstant(id) {
	$.getJSON('constant/delete/'+id ,function(jd){
		$('#editDelConstResultMsg').text(jd.msg);
		$('#editDelConstResultMsg').attr('hidden', false);
		// reload the edit user table and remove any previous message from add user section.
		$('#editDelConstTable').click();
		$('#addConstResultMsg').attr('hidden', true);
		// Clear the form.
		clearAddConstantForm();
	});	
};
/* End: Function to delete constant by REST.*/

/* Start: Function to get constant details for edit by REST.*/
function editThisConstant(id) {
	// Hide messages in 'Edit/remove' tab and set focus on 'Add' tab and show edit message there.
	$('#editDelConstResultMsg').attr('hidden', true);
	$('#constmanagetabs' ).tabs( "option", "active", 0 );
	$('#addConstResultMsg').attr('hidden', false);
	$('#addConstResultMsg').text('Editing constant id= '+ id+'. Please fill in the changes and Save.');
	// Enable 'Save changes' button, and disable 'Add constant' Button.
	$('#saveChangesConstBtn').removeAttr('disabled');
	$('#addConstBtn').attr('disabled','disabled');
	// Get the user details to edit and fill the form.
	$.getJSON('constant/edit/'+id,function(jd){
		$('#cid').val(jd.constantId);
		$('#cvar').val(jd.variable);
		$('#cvarid').val(jd.variableId);
		$('#cvalueid').val(jd.value);
		$('#cparid').val(jd.parentVariableId);
	});
};
/* End: Function to get constant details for edit by REST.*/

/* Start: To save changes for an old constant.*/
$(document).ready(function(){
	$("#saveChangesConstBtn").click(function(){
		var constId = $('#cid').val();
		var variable = $('#cvar').val();
		var variableId = $('#cvarid').val();
		var value = $('#cvalueid').val();
		var parVarId = $('#cparid').val();
		var inparam = {};
			inparam.constId = constId;
			inparam.variable=variable;
			inparam.variableid=variableId;
			inparam.value=value;
			inparam.parentvariableid=parVarId;
		// Send the request
		$.post('constant/update', inparam, function(jd) {
			$('#addConstResultMsg').text(jd.msg);
			$('#addConstResultMsg').attr('hidden', false);
			// Disable 'Save changes' button, and enable 'Add Constant' Button.
			$('#saveChangesConstBtn').attr('disabled','disabled');
			$('#addConstBtn').removeAttr('disabled');
			// reload the edit constant table and remove any previous message there.
			$('#editDelConstTable').click();
			$('#editDelConstResultMsg').attr('hidden', true);
			// Clear the form
			clearAddConstantForm();
		}, 'json');		
	});
});
/* End: To save changes for an old constant.*/

/* Start: Function to clear add constant form.*/
function clearAddConstantForm() {
	$('#cid').val("Ignore...");
	$('#cvar').val("");
	$('#cvarid').val("");
	$('#cvalueid').val("");
	$('#cparid').val("");
}
/* End: Function to clear add constant form.*/
