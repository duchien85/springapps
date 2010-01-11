<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Edit Widget</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/button/assets/skins/sam/button.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/container/assets/skins/sam/container.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/yui_2.6.0/build/calendar/assets/skins/sam/calendar.css' />"/>

<!-- Javascript -->
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/yahoo-dom-event/yahoo-dom-event.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/dragdrop/dragdrop-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/element/element-beta-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/button/button-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/container/container-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/yui_2.6.0/build/calendar/calendar-min.js'/>"></script>

<!-- Style -->
<style type="text/css">
    /* Clear calendar's float */
    #container .bd:after {content:".";display:block;clear:left;height:0;visibility:hidden; position: relative;}

    /* Have calendar squeeze upto bd bounding box */
    #container .bd {padding:0;}

    /* Remove calendar's border and set padding in ems instead of px, so we can specify an width in ems for the container */
    #cal {border:none;padding:1em}

    .datefield input,
    .datefield button,
    .datefield label  {vertical-align:middle}

    .datefield label  {font-weight:bold}
    .datefield input  {width:15em}
    .datefield button  {padding:0 5px 0 5px; margin-left:2px;}
    .datefield button img {padding:0;margin:0;vertical-align:middle}

</style>

</head>
<body>

<h2>Edit Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
  <table class="formTable">
    <tr>
      <td class="form_label"><form:label path="widgetName" cssErrorClass="errors">Name</form:label></td>
      <td class="form_input"><form:input path="widgetName" disabled="true" /></td>
    </tr>
    <tr>
      <td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
      <td class="form_input"><form:input path="price" /></td>
    </tr>
    <tr class="datefield">
      <td class="form_label"><form:label path="initialTime" cssErrorClass="errors">Initial Time</form:label></td>
      <td class="form_input"><form:input path="initialTime" /> &nbsp;
      <button type="button" id="showButton" title="Show Calendar"><img
        src="<c:url value='/images/calbtn.gif'/>" width="18" height="18" alt="Calendar" /></button>
      <div id="container">
      <div class="hd">Calendar</div>
      <div class="bd">
      <div id="cal"></div>
      </div>
      </div>
      <!-- end #container --></td>
    </tr>
    <tr>
      <td class="form_label"><form:label path="cool" cssErrorClass="errors">Is Cool?</form:label></td>
      <td class="form_imput"><form:checkbox path="cool" /></td>
    </tr>
    <tr class="formButtons">
      <td></td>
      <td><span id="cancelButton" class="yui-button yui-link-button"> <span class="first-child"> <a
        href="<c:url value='/widget/list.htm'/>">Cancel</a> </span> </span>
      <button id="submitButton" type="submit">Save Changes</button>
      </td>



    </tr>
  </table>
</form:form>

<script type="text/javascript">
	YAHOO.util.Event.onDOMReady(function() {

		var dialog, calendar, calButton;
		var submitButton, cancelButton;

		submitButton = new YAHOO.widget.Button("submitButton");
		submitButton.set("type", "submit");

		cancelButton = new YAHOO.widget.Button("cancelButton");

		calButton = new YAHOO.widget.Button("showButton");
		calendar = new YAHOO.widget.Calendar("cal", {
			iframe : true,
			hide_blank_weeks : true
		});

		function okHandler() {
			if (calendar.getSelectedDates().length > 0) {

				var selDate = calendar.getSelectedDates()[0];

				// Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
			//var wStr = cale	ndar.cfg.getProperty("WEEKDAYS_LONG")[selDate.getDay()];
			var dStr = selDate.getDate();
			if (dStr < 10) {
				dStr = "0" + dStr;
			}
			var mStr = selDate.getMonth() + 1;
			if (mStr < 10) {
				mStr = "0" + mStr;
			}
			var yStr = selDate.getFullYear();

			YAHOO.util.Dom.get("initialTime").value = yStr + "-" + mStr + "-"
					+ dStr;
		} else {
			YAHOO.util.Dom.get("initialTime").value = "";
		}
		this.hide();
	}

	function cancelHandler() {
		this.hide();
	}

	dialog = new YAHOO.widget.Dialog("container",
			{
				context : [ "showButton", "tl", "bl",
						[ "beforeShow", "windowResize" ] ],
				buttons : [ {
					text : "Select",
					isDefault : true,
					handler : okHandler
				}, {
					text : "Cancel",
					handler : cancelHandler
				} ],
				width : "16em", // Sam Skin dialog needs to have a width defined (7*2em + 2*1em = 16em).
				draggable : false,
				close : true
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

})	;
</script>
</body>
</html>