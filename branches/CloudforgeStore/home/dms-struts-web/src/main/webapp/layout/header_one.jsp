<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
/* Auto update date time*/
jQuery(document).ready(function() {
    var datediv = jQuery('#current-datetime');  
    function updateTime() {
        var now = new Date();
        datediv.text(now.toString());        
    }  
    updateTime();
    setInterval(updateTime, 1000); // 1 * 1000 miliseconds
});
</script>

<table class="ui-widget ui-widget-header" style="width:100%;height:100%">
	<tr>
		<td align="left" valign="bottom" class="text" width="20%">
			<%-- <s:date name="new java.util.Date()" format="dd MMMM yyyy hh:mm:ss" /> --%>
			<div id="current-datetime" style="font-size: 10px;"></div>
		</td>
	
	<td align="center" valign="bottom" width="20%" style="font-size: 10px">
		
			<br/><p>Welcome! <s:property value="#session.uname" default="Guest" /><br/>
			<s:if test="#session.role!=null">
				<br/>Access Type : <s:property value="#session.role" default="None"/>		
				<br/>
			</s:if></p>
			
			<s:if test="#session.uname!=null">
				<s:url id="logout" action="logout" />
				<s:a href="%{logout}">Logout</s:a>		
			</s:if>
			<br/>		
	</td>
	
	<td align="right" width="70%">
		<h1 style="font-family:Courier New">Document Management System</h1></td>
	</tr>
</table>