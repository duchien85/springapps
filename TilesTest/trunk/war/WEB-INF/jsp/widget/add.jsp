<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Add Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
<table class="formTable">
	<tr>
		<td class="form_label"><form:label path="widgetName" cssErrorClass="errors" >Name</form:label></td>
		<td class="form_input"><form:input path="widgetName" /></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
		<td class="form_input"><form:input path="price"/></td>
	</tr>
	<tr class="datefield">
		<td class="form_label"><form:label path="initialTime" cssErrorClass="errors" >Initial Time</form:label></td>
		<td class="form_input"><form:input path="initialTime"/>	&nbsp; 
			<button type="button" id="showButton" title="Show Calendar"><img src="<c:url value='/images/calbtn.gif'/>" width="18" height="18" alt="Calendar" /></button>
			 <div id="container">
      			<div class="hd">Calendar</div>
      			<div class="bd">
			         <div id="cal"></div>
      			</div>
   			</div> <!-- end #container -->
		</td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="cool" cssErrorClass="errors" >Is Cool?</form:label></td>
		<td class="form_imput"><form:checkbox path="cool"/></td>
	</tr>
	<tr class="formButtons">
		<td></td>
		<td>
			<span id="cancelButton" class="yui-button yui-link-button">
    			<span class="first-child">
        			<a href="<c:url value='/widget/list.htm'/>">Cancel</a>
    			</span>
			</span>
			<button id="submitButton" type="submit" >Add Widget</button>
		</td>
	</tr>
</table>
</form:form>

<script type="text/javascript">

YAHOO.util.Event.onDOMReady(function(){

	var dialog, calendar, calButton;

	var submitButton, cancelButton;
	
    
    submitButton = new YAHOO.widget.Button("submitButton");
    submitButton.set("type", "submit");
	submitButton.set("title", "Save new Widget");
	
    cancelButton = new YAHOO.widget.Button("cancelButton");

    calButton = new YAHOO.widget.Button("showButton");
    calendar = new YAHOO.widget.Calendar("cal", {iframe:true, hide_blank_weeks:true });

    function okHandler() {
        if (calendar.getSelectedDates().length > 0) {
            var selDate = calendar.getSelectedDates()[0];
            // Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
            //var wStr = cale	ndar.cfg.getProperty("WEEKDAYS_LONG")[selDate.getDay()];
            var dStr = selDate.getDate();
            if(dStr < 10) { dStr = "0" + dStr;}
            var mStr = selDate.getMonth() + 1;
            if(mStr < 10) { mStr = "0" + mStr;}
            var yStr = selDate.getFullYear();

            YAHOO.util.Dom.get("initialTime").value = yStr + "-" + mStr + "-" + dStr;
        } else {
            YAHOO.util.Dom.get("initialTime").value = "";
        }
        this.hide();
    }

    function cancelHandler() {
        this.hide();
    }

    dialog = new YAHOO.widget.Dialog("container", {
        context:["showButton", "tl", "bl", ["beforeShow", "windowResize"]],
        buttons:[ {text:"Select", isDefault:true, handler: okHandler}, 
                  {text:"Cancel", handler: cancelHandler}],
        width:"16em",  // Sam Skin dialog needs to have a width defined (7*2em + 2*1em = 16em).
        draggable:false,
        close:true
    });

    calendar.render();
    dialog.render();
	 // Using dialog.hide() instead of visible:false is a workaround for an IE6/7 container known issue with border-collapse:collapse.
    dialog.hide();

    calendar.renderEvent.subscribe(function() {
        // Tell Dialog it's contents have changed, Currently used by container for IE6/Safari2 to sync underlay size
        dialog.fireEvent("changeContent");
    });

    calButton.on("click", function() {
		dialog.show();
		if (YAHOO.env.ua.opera && document.documentElement) {
			// Opera needs to force a repaint
			document.documentElement.className += "";
		} 
	});
    
});

</script>

