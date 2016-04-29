/* Start: To activate constant manage Tabs */
$(function() {
	$("#papermanagetabs").tabs();
});
/* End: To activate constant manage Tabs */

/* Start: To create dropdown of usernames for authorization */
$(document).ready(function() {
	var dropdown = '#select-auth-name-id';
	var uploaderNameTextbox = '#uploader-name-id';
	$(dropdown).click(function() {
		window.alert('Fetching list of possible authorizing users. Please be patient while data loads.');
		var uploadername = $(uploaderNameTextbox).val();
		//send request
		$.getJSON("authorizerslist/"+ uploadername,function(jd){
			$(dropdown).empty();
			$(dropdown).html('<option value="NONE">-- SELECT --</option>');
			for (var i = 0; i < jd.length; i++) {
				$(dropdown).append('<option value="'+jd[i]+'">'+jd[i]+'</option>');				
			}
			$(dropdown).unbind('click');
		});
	});	
});
/* End: To create dropdown of usernames for authorization */