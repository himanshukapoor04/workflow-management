<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workflow Details</title>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/js/jquery-3.0.0.min.js" var="jQueryJS" />
<spring:url value="/resources/js/jquery-ui1.11.0.min.js" var="jQueryUIJS" />
<spring:url value="/resources/js/jquery-ui1.11.0.min.css" var="jQueryUICSS" />
<spring:url value="/resources/js/workflow.js" var="workflowJS" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${jQueryUICSS}" rel="stylesheet" />
<script type="text/javascript" src="${jQueryJS}"></script>
<script type="text/javascript" src="${jQueryUIJS}"></script>
<script type="text/javascript" src="${workflowJS}"></script>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Centralized Workflow Managment System</a>
	</div>
  </div>
</nav>
<div class="jumbotron">
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

</body>
</html>