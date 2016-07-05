jQuery(function($){
	$.workflowManagement = {
			createInstance : function(id) {
				$.ajax('./processWorkflowInstance/'+id , {
					success : function(data) {
						alert("Workflow Instance started successfully");
					}
				})
			},
			
			showHealth : function(id) {
				$.ajax('./getAllWorkflowInstanceHealth/'+id, {
					success : function(data) {
						$("#showHealth").html(data);
						$("#showHealth").show();
						$("#tableContainer").hide();
					}
				})
			}
	}
})