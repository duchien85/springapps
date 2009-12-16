var payment_form;
var acceptDialog;

var handleSubmit = function(){
	var accepted= acceptDialog.getData().accepted; 
	if (accepted) {
		YAHOO.util.Event.removeListener(payment_form);
		this.hide();
		payment_form.submit();
	}
	else {
		this.hide();
	}
};

var handleCancel = function(e){
	this.cancel();
};

var payment_form_submit = function(e, simp_dialog){
	YAHOO.util.Event.stopEvent(e);		
	acceptDialog.show();
};

function init() {
	payment_form = document.getElementById("paymentForm");

	acceptDialog= new YAHOO.widget.Dialog("acceptDialog", 
							{ width : "900px",
							  postMethod: "none",
							  fixedcenter : true,
							  visible : false, 
						      draggable: false,
							  close: false,
							  modal: true,
							  constraintoviewport : true,
							  effect:{effect:YAHOO.widget.ContainerEffect.FADE,duration:0.3}, 							  
							  buttons : [ { text:"Submit", handler:handleSubmit, isDefault:true },
								      { text:"Cancel", handler:handleCancel } ]
							});

	acceptDialog.render();
	YAHOO.util.Event.addListener(payment_form, "submit", payment_form_submit, acceptDialog, false);
}

YAHOO.util.Event.onDOMReady(init);
