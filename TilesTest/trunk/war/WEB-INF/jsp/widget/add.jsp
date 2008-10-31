<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Add Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
<table class="yui-skin-sam">
	<tr>
		<td class="form_label"><form:label path="widgetName" cssErrorClass="errors" >Name</form:label></td>
		<td class="form_input"><form:input path="widgetName" /></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
		<td class="form_input"><form:input path="price"/></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="initialTime" cssErrorClass="errors">Initial Time</form:label></td>
		<td class="form_input"><form:input path="initialTime"/>&nbsp; <img id="calPopup" src="<c:url value='/images/calendar_icon.gif'/>"/></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="cool" cssErrorClass="errors" >Is Cool?</form:label></td>
		<td class="form_imput"><form:checkbox path="cool"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" class="form_input" value="Save Widget"/></td>
	</tr>
</table>
</form:form>

<div class="yui-skin-sam" id="cal1Container" style="display: none;"></div> 

<script>
Event.onDOMReady(function () {
	var oCalendarMenu;
	// Create an Overlay instance to house the Calendar instance
	oCalendarMenu = new YAHOO.widget.Overlay("calendarmenu", { visible: false });
	// Create a Button instance of type "menu"
	var oButton = new YAHOO.widget.Button({ 
										type: "menu", 
										id: "calendarpicker", 
										label: "Choose A Date", 
										menu: oCalendarMenu, 
										container: "datefields" });
});

oButton.on("appendTo", function () {
	// Create an empty body element for the Overlay instance in order 
	// to reserve space to render the Calendar instance into.
	oCalendarMenu.setBody(" ");
	oCalendarMenu.body.id = "calendarcontainer";
});

var onButtonClick = function () {
	
	// Create a Calendar instance and render it into the body 
	// element of the Overlay.

	var oCalendar = new YAHOO.widget.Calendar("buttoncalendar", oCalendarMenu.body.id);

	oCalendar.render();


	// Subscribe to the Calendar instance's "select" event to 
	// update the month, day, year form fields when the user
	// selects a date.

	oCalendar.selectEvent.subscribe(function (p_sType, p_aArgs) {

		var aDate;

		if (p_aArgs) {
				
			aDate = p_aArgs[0][0];
				
			Dom.get("month-field").value = aDate[1];
			Dom.get("day-field").value = aDate[2];
			Dom.get("year-field").value = aDate[0];

		}
		
		oCalendarMenu.hide();
	
	});


	// Pressing the Esc key will hide the Calendar Menu and send focus back to 
	// its parent Button

	Event.on(oCalendarMenu.element, "keydown", function (p_oEvent) {
	
		if (Event.getCharCode(p_oEvent) === 27) {
			oCalendarMenu.hide();
			this.focus();
		}
	
	}, null, this);
	
	
	var focusDay = function () {

		var oCalendarTBody = Dom.get("buttoncalendar").tBodies[0],
			aElements = oCalendarTBody.getElementsByTagName("a"),
			oAnchor;

		
		if (aElements.length > 0) {
		
			Dom.batch(aElements, function (element) {
			
				if (Dom.hasClass(element.parentNode, "today")) {
					oAnchor = element;
				}
			
			});
			
			
			if (!oAnchor) {
				oAnchor = aElements[0];
			}


			// Focus the anchor element using a timer since Calendar will try 
			// to set focus to its next button by default
			
			YAHOO.lang.later(0, oAnchor, function () {
				try {
					oAnchor.focus();
				}
				catch(e) {}
			});
		
		}
		
	};


	// Set focus to either the current day, or first day of the month in 
	// the Calendar	when it is made visible or the month changes

	oCalendarMenu.subscribe("show", focusDay);
	oCalendar.renderEvent.subscribe(focusDay, oCalendar, true);


	// Give the Calendar an initial focus
	
	focusDay.call(oCalendar);


	// Re-align the CalendarMenu to the Button to ensure that it is in the correct
	// position when it is initial made visible
	
	oCalendarMenu.align();
	

	// Unsubscribe from the "click" event so that this code is 
	// only executed once

	this.unsubscribe("click", onButtonClick);

};
/*
	Add a "click" event listener that will render the Overlay, and 
	instantiate the Calendar the first time the Button instance is 
	clicked.
*/

oButton.on("click", onButtonClick);

	
	

function setInitTime(type, args, obj){
	 var dates = args[0]; 
	 var date = dates[0]; 
	 var year = date[0], month = date[1], day = date[2]; 
	$('initialTime').setValue(year + "-" + month + "-" + day);
}

function calClick(e){
	
}

var initTimeCal = new YAHOO.widget.Calendar("initTimeCal", "cal1Container", { "close": true, "navigator": true});
initTimeCal.selectEvent.subscribe(setInitTime, initTimeCal, true);
initTimeCal.render();
$('widgetName').activate();
YAHOO.util.Event.addListener("calPopup", "click", initTimeCal.show, initTimeCal, true);


</script>

