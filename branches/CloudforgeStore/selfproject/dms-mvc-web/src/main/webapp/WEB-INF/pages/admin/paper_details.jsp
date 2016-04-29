<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:if test="${status eq null}">
	<div class="alert alert-warning" style="text-align: center;">Search	results</div>
</c:if>
<c:if test="${status eq 'success'}">
	<div class="alert alert-success" style="text-align: center;"><c:out value="${statusmsg}" /></div>
</c:if>
<c:if test="${status eq 'error'}">
	<div class="alert alert-danger" style="text-align: center;"><c:out value="${statusmsg}" /></div>
</c:if>


<div class="container">
	<h3 style="text-align: center;"><small>Paper - ${paper.paperTitle}</small></h3>
	<div class="row">
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Number: ${paper.paperNumber}</p> 
		</div>
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Original file name: ${paper.originalFilename}</p> 
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Download: ${paper.paperData}</p> 
		</div>
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Creator: ${paper.createdByUserId}</p> 
		</div>	
	</div>
	<div class="row">
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Creation Time: ${paper.creationTime}</p> 
		</div>
		<div class="col-xs-6" style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			<p class="text-info">Comments: ${paper.paperStatusInfos.comments}</p> 
		</div>	
	</div>
</div>
