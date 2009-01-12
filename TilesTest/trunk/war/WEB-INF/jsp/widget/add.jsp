
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
#calDiv {position: relative; }
#container { display:none; position:absolute; left:10px; top:10px; z-index:2; min-width: 12em;} 
</style>

<h2>Add Widget</h2>

<tt:errors name="widget" />


<form:form modelAttribute="widget" method="post">
	<table class="formTable">
		<tr>
			<td class="form_label"><form:label path="widgetName"
				cssErrorClass="errors">Name</form:label></td>
			<td class="form_input"><form:input path="widgetName" /></td>
		</tr>
		<tr>
			<td class="form_label"><form:label path="price"
				cssErrorClass="errors">Price</form:label></td>
			<td class="form_input"><form:input path="price" /></td>
		</tr>
		<tr class="datefield">
			<td class="form_label"><form:label path="initialTime"
				cssErrorClass="errors">Initial Time</form:label></td>
			<td class="form_input">
				<form:input path="initialTime" />
			</td>
			<td>
				<div id="calDiv">
					<button type="button" id="showButton" title="Show Calendar">
					<img src="<c:url value='/images/calbtn.gif'/>" width="18" height="18" alt="Calendar" /></button>
					<div id="container"/>
				</div>
			</td>
		</tr>
		<tr>
			<td class="form_label"><form:label path="cool"
				cssErrorClass="errors">Is Cool?</form:label></td>
			<td class="form_imput"><form:checkbox path="cool" /></td>
		</tr>
		<tr class="formButtons">
			<td></td>
			<td><span id="cancelButton" class="yui-button yui-link-button">
			<span class="first-child"> <a
				href="<c:url value='/widget/list.htm'/>">Cancel</a> </span> </span>
			<button id="submitButton" type="submit">Add Widget</button>
			</td>
		</tr>
	</table>
</form:form>

<script type="text/javascript">
	( function() {
		var Event = YAHOO.util.Event, 
		Dom = YAHOO.util.Dom;

		Event.onDOMReady( function() {

			var calendar, calButton, submitButton;
			
			calButton = new YAHOO.widget.Button("showButton", {});
			submitBotton = new YAHOO.widget.Button("submitButton", {});

			calendar = new YAHOO.widget.Calendar("calendar", "container", {
				hide_blank_weeks :true,
				title: "Initial Time",
				close: true
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

				Dom.get("initialTime").value = yStr + "-" + mStr
						+ "-" + dStr;
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

