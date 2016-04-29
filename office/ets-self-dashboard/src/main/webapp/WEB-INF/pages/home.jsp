<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title>My Dashboard - Home</title>
<link rel="stylesheet" href="resources/css/home.css">
<script type="text/javascript" src="resources/script/home.js"></script>
<script type="text/javascript" src="resources/script/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="resources/script/jqplot.barRenderer.js"></script>
<script type="text/javascript" src="resources/script/jqplot.pieRenderer.min.js"></script>
<script type="text/javascript" src="resources/script/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="resources/script/jqplot.pointLabels.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/jquery.jqplot.min.css" />
</head>
<body>
	<jsp:include page="home_nav.jsp"></jsp:include>
	<div class="appStatuslist" id="appstatusdiv">
	</div>
	<div id="main-container">
		<div class="activity-board panel panel-info">
			<div class="panel-heading">Activity Board
				<div class="close">X</div>
			</div>
			<div class="panel-body">				
				<marquee id="marqee-home" direction="down" height="100%" scrollamount="6" onmouseover="this.stop();" onmouseout="this.start();">
				</marquee>
				<div class="right-activity-board well">
					<div id="status-chart" style="height: 100%; width: 100%;"></div>															
				</div>				
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
</body>
</html>