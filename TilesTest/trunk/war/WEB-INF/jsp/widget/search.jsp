<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<h2>Search Widgets</h2>

<tt:errors name="widgetSearchModel" />

<form:form method="post" action="" modelAttribute="widgetSearchModel" id="searchForm">
<table>
	<tr>
		<td class="form_label"><form:label path="name" cssErrorClass="errors">Name</form:label></td>
		
		<td class="form_input">
			<div id="myAutoComplete"> 
				<form:input path="name" size="50"/>
				<div id="myContainer"></div>
			</div>  
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="cool" cssErrorClass="errors">Cool</form:label></td>
		<td class="form_input">
			<form:select path="cool">
				<form:option value="" label="Both"/>
				<form:option value="true" label="True"/>
				<form:option value="false" label="False"/>
			</form:select>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="form_label">Initial Time Between</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="2">
		<table>
			<tr>		
				<td class="form_label"><form:label path="beginInitialTime" cssErrorClass="errors">Beginning</form:label></td>
				<td class="form_input"><form:input path="beginInitialTime" />&nbsp;
					<button type="button" id="calButtonBegin" title="Show Calendar"><img src="<c:url value='/images/calbtn.gif'/>" alt="Calendar" /></button>
						 <div id="containerBegin">
      						<div class="hd">Calendar</div>
      						<div class="bd">
			         			<div id="calBegin"></div>
      						</div>
   						</div> <!-- end #container -->
				</td>				
			</tr>
			<tr>
				<td class="form_label"><form:label path="endInitialTime" cssErrorClass="errors">Ending</form:label></td>
				<td class="form_input"><form:input path="endInitialTime" />&nbsp;
					<button type="button" id="calButtonEnd" title="Show Calendar"><img src="<c:url value='/images/calbtn.gif'/>" alt="Calendar" /></button>
			 		<div id="containerEnd">
      					<div class="hd">Calendar</div>
      					<div class="bd">
			         		<div id="calEnd"></div>
      					</div>
   					</div> <!-- end #container -->
				</td>				
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td class="form_label">Price Between</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="2">
		<table>
			<tr>
				<td class="form_label"><form:label path="beginPrice" cssErrorClass="errors">Beginning</form:label></td>
				<td class="form_input"><form:input path="beginPrice" /></td>				
			</tr>
			<tr>
				<td class="form_label"><form:label path="endPrice" cssErrorClass="errors">Ending</form:label></td>
				<td class="form_input"><form:input path="endPrice" /></td>				
			</tr>
		</table>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td><button id="buttonSubmit" name="buttonSubmit" type="submit">Search</button></td>
	</tr>
</table>
</form:form>

<button type="button" id="callWS" title=""><img src="<c:url value='/images/calbtn.gif'/>" width="18" height="18" alt="Calendar" /></button>

<c:if test="${not empty widgets}">
	<div class="form_table">
	<table>
	<thead>
		<tr>
		<th>Widget Name</th>
		<th>Price</th>
		<th>Initial Time</th>
		<th>Cool?</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
	<thead>
	<tbody>
	<c:forEach items="${widgets}" var="w" varStatus="st">
            <tr class="${st.index % 2 == 0 ? 'odd' : 'even'}">
                <td>${w.widgetName}</td>
                <td>$${w.price}</td>
                <td><joda:format value="${w.initialTime}" style="M-"/></td>
                <td>${w.cool}</td>
				<td><a href="<c:url value="/widget/edit.htm"/>?widgetId=${w.id}">Edit</a></td>
				<td><a href="<c:url value="/widget/delete.htm"/>?widgetId=${w.id}">Delete</a></td>
			</tr>
	</c:forEach>
	</tbody>
	</table>
	</div><!-- end .form_table -->
</c:if>
<script type="text/javascript">
	//var myAutoComp = new YAHOO.widget.AutoComplete("myInput","myContainer", myDataSource);
	var contextName = '<c:out value="${pageContext.request.contextPath}"/>';
	var url = contextName + '/api/helloworld.htm';
	
	var successHandler = function(r){
		alert('success: ' + r.responseText);
	}

	var failureHandler = function(r){
		alert('failure: ' + r.statusText);
	}
	
	var callback = {
		success: successHandler,
		failure: failureHandler
	};

	YAHOO.util.Event.on("callWS", "click", function() {
		console.log("calling transaction to /api/helloworld");
		var transaction = YAHOO.util.Connect.asyncRequest("GET", url, callback, null); 
	});
	

	
</script>

<script>
YAHOO.util.Event.onDOMReady(function(){

    var dialogBegin, dialogEnd;
	var calendarBegin, calendarEnd;
	var calButtonBegin, calButtonEnd;


	calButtonBegin = new YAHOO.widget.Button("calButtonBegin");
	calButtonEnd = new YAHOO.widget.Button("calButtonEnd");

    calendarBegin = new YAHOO.widget.Calendar("calBegin", {iframe:true, hide_blank_weeks:true });
	calendarEnd = new YAHOO.widget.Calendar("calEnd", {iframe:true, hide_blank_weeks:true });

    function okHandlerBegin() {
        if (calendarBegin.getSelectedDates().length > 0) {
        	var selDateB = calendarBegin.getSelectedDates()[0];
            // Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
            //var wStr = cale	ndar.cfg.getProperty("WEEKDAYS_LONG")[selDate.getDay()];
            var dStrB = selDateB.getDate();
            if(dStrB < 10) { dStrB = "0" + dStrB;}
            var mStrB = selDateB.getMonth() + 1;
            if(mStrB < 10) { mStrB = "0" + mStrB;}
            var yStrB = selDateB.getFullYear();
            YAHOO.util.Dom.get("beginInitialTime").value = yStrB + "-" + mStrB + "-" + dStrB;
        } else {
            YAHOO.util.Dom.get("beginInitialTime").value = "";
        }
        this.hide();
    }

	function okHandlerEnd() {
        if (calendarEnd.getSelectedDates().length > 0) {
        	var selDate = calendarEnd.getSelectedDates()[0];

            // Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
            //var wStr = cale	ndar.cfg.getProperty("WEEKDAYS_LONG")[selDate.getDay()];
            var dStr = selDate.getDate();
            if(dStr < 10) { dStr = "0" + dStr;}
            var mStr = selDate.getMonth() + 1;
            if(mStr < 10) { mStr = "0" + mStr;}
            yStr = selDate.getFullYear();

            YAHOO.util.Dom.get("endInitialTime").value = yStr + "-" + mStr + "-" + dStr;
        } else {
            YAHOO.util.Dom.get("endInitialTime").value = "";
        }
        this.hide();
    }

    function cancelHandler() {
        this.hide();
    }

    dialogBegin = new YAHOO.widget.Dialog("containerBegin", {
        context:["calButtonBegin", "tl", "bl"],
        buttons:[ {text:"Select", isDefault:true, handler: okHandlerBegin}, 
                  {text:"Cancel", handler: cancelHandler}],
        width:"16em",  // Sam Skin dialog needs to have a width defined (7*2em + 2*1em = 16em).
        draggable:false,
        close:true
    });

	dialogEnd = new YAHOO.widget.Dialog("containerEnd", {
        context:["calButtonEnd", "tl", "bl"],
        buttons:[ {text:"Select", isDefault:true, handler: okHandlerEnd}, 
                  {text:"Cancel", handler: cancelHandler}],
        width:"16em",  // Sam Skin dialog needs to have a width defined (7*2em + 2*1em = 16em).
        draggable:false,
        close:true
    });

    calendarBegin.render();
	calendarEnd.render();
    dialogBegin.render();
	dialogEnd.render();
	 // Using dialog.hide() instead of visible:false is a workaround for an IE6/7 container known issue with border-collapse:collapse.
    dialogBegin.hide();
	dialogEnd.hide();

    calendarBegin.renderEvent.subscribe(function() {
        // Tell Dialog it's contents have changed, Currently used by container for IE6/Safari2 to sync underlay size
        dialogBegin.fireEvent("changeContent");
    });

	calendarEnd.renderEvent.subscribe(function() {
        // Tell Dialog it's contents have changed, Currently used by container for IE6/Safari2 to sync underlay size
        dialogEnd.fireEvent("changeContent");
    });

    YAHOO.util.Event.on("calButtonBegin", "click", function() {
		dialogBegin.show();
		if (YAHOO.env.ua.opera && document.documentElement) {
			// Opera needs to force a repaint
			document.documentElement.className += "";
		} 
	});
	
	YAHOO.util.Event.on("calButtonEnd", "click", function() {
		dialogEnd.show();
		if (YAHOO.env.ua.opera && document.documentElement) {
			// Opera needs to force a repaint
			document.documentElement.className += "";
		} 
	});

});

</script>
