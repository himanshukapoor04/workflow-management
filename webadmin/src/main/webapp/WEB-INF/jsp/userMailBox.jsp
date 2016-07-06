
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="well">
	<div class="container">
		<h3>Mail Box</h3>
	</div>
</div>
<div>
	<div class="container">
		<h4> Welcome ${user.userName}</h4>
		<c:if test="${empty mailMessages }">
			<div id="tableContainer">
				<table class="table">
					<tr>
						<th><strong>Message</strong></th>
						<th><strong>Approve</strong></th>
					</tr>
					<c:forEach items="${mailMessages}" var="mailMessage">
						<tr>
							<td>${mailMessage.message }</td>
							<td><a class="btn btn-default" href="#" role="button"
								onClick="$.workflowManagement.approveStep(${mailMessage.workflowId},${mailMessage.workflowInstanceId}, ${mailMessage.stepInstanceId}, ${user.id})">Approve</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${empty mailMessages }">
			<h3>You don't have no new messages!!</h3>
		</c:if>
		<div id="showHealth" style="display:none;"></div>
		<div id="showMessage"></div>
	</div>
</div>
