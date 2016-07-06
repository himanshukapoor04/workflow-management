jQuery(function($){
	$.workflowManagement = {
			createInstance : function(id) {
				$.ajax('./workflow/processWorkflowInstance/'+id , {
					success : function(data) {
						alert("Workflow Instance started successfully");
					}
				})
			},
			
			showHealth : function(id) {
				$.ajax('./workflow/getAllWorkflowInstanceHealth/'+id, {
					success : function(data) {
						$("#showHealth").html(data);
						$("#showHealth").show();
						$("#tableContainer").hide();
					}
				})
			},
			
			getWorkflows :function(id) {
				$.ajax('./workflow/allWorkflowsByProject/'+id , {
					success : function(data) {
						$("#content").html(data);
					}
				})
			},
			getProjects : function() {
				$.ajax('./project/showAll', {
					success :function(data) {
						$("#content").html(data);
					}
				})
			},
			showMailbox : function(userId) {
				$.ajax('./user/mailbox/'+userId, {
					success: function(data) {
						$("#content").html(data);
					}
				})
			},
			approveStep : function(workflowId, workflowInstanceId, stepInstanceId,userId) {
				$.ajax('./user/approveStep/'+workflowId+"/"+workflowInstanceId+"/"+stepInstanceId+"/"+userId, {
					success : function(data) {
						alert('Step is approved');
						$("#content").html(data);
					}
				})
			}
	}
})