<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<h3>Show Health status</h1>
<h4> Workflow: ${workflow.name }</h4>
<table class="table">
<tr> 
<th>Instance Id</th>
<th>Instance health status</th>
</tr>
<c:forEach var="entry" items="${instanceHealthStatus}">
	<tr>
		<td><c:out value="${entry.key }"/></td>
		<td><c:out value="${entry.value }"> </c:out> </td>  
	</tr>
</c:forEach>
</table>

