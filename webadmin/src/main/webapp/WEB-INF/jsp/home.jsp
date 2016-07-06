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
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="./home">Centralized Workflow Managment System</a>
		</div>
	</div>
	<ul class="nav navbar-nav">
		<li class="active"><a href="./home">Home</a></li>
		<li><a href="#" onClick="$.workflowManagement.getProjects()">Projects</a></li>
		<li><a href="#">Workflow</a></li>
		<li><a href="#">Activities</a></li>
		<li><a href="#">Master Data</a></li>
		<li><a href="#" onClick="$.workflowManagement.showMailbox(1)">Mail Box</a></li>
	</ul>
</nav>
<div id="content">
Welcome Admin!!
</div>

</body>
</html>