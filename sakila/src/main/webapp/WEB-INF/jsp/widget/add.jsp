<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Add a Widget</title>
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

<style>
#calDiv {
	position: relative;
}

#container {
	display: none;
	position: absolute;
	left: 10px;
	top: 10px;
	z-index: 2;
	min-width: 12em;
}
</style>

</head>
<body>


<h2>Add Widget</h2>

<tt:errors name="widget" />


<form:form modelAttribute="widget" method="post">
  <table class="formTable">
    <tr>
      <td class="form_label"><form:label path="widgetName" cssErrorClass="errors">Name</form:label></td>
      <td class="form_input"><form:input path="widgetName" /></td>
    </tr>
    <tr>
      <td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
      <td class="form_input"><form:input path="price" /></td>
    </tr>
    <tr class="datefield">
      <td class="form_label"><form:label path="initialTime" cssErrorClass="errors">Initial Time</form:label></td>
      <td class="form_input"><form:input path="initialTime" /></td>
      <td>
      <div id="calDiv">
      <button type="button" id="showButton" title="Show Calendar"><img
        src="<c:url value='/images/calbtn.gif'/>" width="18" height="18" alt="Calendar" /></button>
      <div id="container"></div>
      </div>
      </td>
    </tr>
    <tr>
      <td class="form_label"><form:label path="cool" cssErrorClass="errors">Is Cool?</form:label></td>
      <td class="form_imput"><form:checkbox path="cool" /></td>
    </tr>
    <tr class="formButtons">
      <td></td>
      <td><span id="cancelButton" class="yui-button yui-link-button"> <span class="first-child"> <a
        href="<c:url value='/widget/list.htm'/>">Cancel</a> </span> </span>
      <button id="submitButton" type="submit">Add Widget</button>
      </td>
    </tr>
  </table>
</form:form>

<script type="text/javascript">
	(function() {
		var Event = YAHOO.util.Event, Dom = YAHOO.util.Dom;

		Event.onDOMReady(function() {

			var calendar, calButton, submitButton;

			calButton = new YAHOO.widget.Button("showButton", {});
			submitBotton = new YAHOO.widget.Button("submitButton", {});

			calendar = new YAHOO.widget.Calendar("calendar", "container", {
				hide_blank_weeks : true,
				title : "Initial Time",
				close : true
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

				Dom.get("initialTime").value = yStr + "-" + mStr + "-" + dStr;
			} else {
				Dom.get("initialTime").value = "";
			}
			calendar.hide();
		}

		function cancelHandler() {
			calendar.hide();
		}

		calendar.selectEvent.subscribe(okHandler);

		calendar.render();
		calendar.hide();

		calButton.on("click", function() {
			calendar.show();
			if (YAHOO.env.ua.opera && document.documentElement) {
				// Opera needs to force a repaint
				document.documentElement.className += "";
			}
		});

		/*Event.on(dialog.element, "keydown", function(p_oEvent) {

			if (Event.getCharCode(p_oEvent) === 27) {
				dialog.hide();
				this.focus();
			}

		}, null, this)*/

	})	;
	}());
</script>

</body>
</html>