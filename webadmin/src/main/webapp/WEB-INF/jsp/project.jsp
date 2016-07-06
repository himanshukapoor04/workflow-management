 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="well">
	<div class="container">
		<h3>Project Management</h3>
	</div>
</div>
 <div>
	<div class="container">
		<div id="tableContainer">
			<table class="table">
			<tr>
			<th><strong>Project Name</strong></th>
			<th><strong>Project Description</strong></th>
			<th><strong>Show Workflows</strong></th>
			</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>${project.name }</td>
				<td>${project.description}</td>
				<td><a class="btn btn-default" href="#" role="button" onClick="$.workflowManagement.getWorkflows(${project.id})">Show Workflows</a></td>
			</tr>
		</c:forEach>
		</table>
		</div>
		<div id="showHealth" style="display:none;"></div>
		<div id="showMessage"></div>
	</div>
</div>