
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
	<div class="container">
		<h3>Workflow Management</h3>
	</div>
</div>
<div>
	<div class="container">
		<div id="tableContainer">
			<table class="table">
			<tr>
			<th><strong>Workflow Name</strong></th>
			<th><strong>Workflow Description</strong></th>
			<th><strong>Start Instance</strong></th>
			<th><Strong>Check Health</Strong></th>
			</tr>
		<c:forEach items="${workflows}" var="workflow">
			<tr>
				<td>${workflow.name }</td>
				<td>${workflow.description}</td>
				<td><a class="btn btn-default" href="#" role="button" onClick="$.workflowManagement.createInstance(${workflow.id})">Start Instance</a></td>
				<td><a class="btn btn-default" href="#" role="button" onClick="$.workflowManagement.showHealth(${workflow.id})">Check Health</a></td>
			</tr>
		</c:forEach>
		</table>
		</div>
		<div id="showHealth" style="display:none;"></div>
		<div id="showMessage"></div>
	</div>
</div>
