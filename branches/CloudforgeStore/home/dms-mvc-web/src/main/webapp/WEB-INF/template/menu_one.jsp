<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		$("#mainmenu").menu();
	});
</script>
<div class="ui-widget-content ui-corner-all">
  <ul id="mainmenu">
	<li><a href="home">Home</a></li>
	<c:if test="${sUserName eq null}">
		<li><a href="loginview">Login</a></li>
	</c:if>
	
	<li><a href="#">News &amp; Info</a>
  		<ul>
  			<li><a href="#">About Us</a></li>
  			<li><a href="#">Contact Us</a></li>
  		</ul>
  	</li>
  	<li><a href="resources/demo.html">Bootstrap demo</a></li>
  	<li><a href="adminhome">Admin Home</a></li>
  </ul>
</div>