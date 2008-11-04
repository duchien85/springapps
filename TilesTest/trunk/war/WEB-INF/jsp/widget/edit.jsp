<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Editing Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
<table class="yui-skin-sam">
	<tr>
		<td class="form_label"><form:label path="widgetName" cssErrorClass="errors" >Name</form:label></td>
		<td class="form_input"><form:input path="widgetName" disabled="true" /></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
		<td class="form_input"><form:input path="price"/></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="initialTime" cssErrorClass="errors" >Initial Time</form:label></td>
		<td class="form_input"><form:input path="initialTime"/>	&nbsp; <span id="calButton"><img src="<c:url value='/images/calbtn.gif'/>" /></span></td>
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

<script>
//var cal1 = new YAHOO.widget.Calendar("cal1Container");
var clickCal = function(e){
	alert("clicked");
	calOverlay.render(document.body);
}
var calOverlay = new YAHOO.widget.Overlay("calOverlay", {context:["calButton","tl","bl", ["beforeShow", "windowResize"]], 
	                                                     visible:false, 
	                                                     width:"200px" });
 
YAHOO.util.Event.addListener("calButton", "click", clickCal);
//cal1.render(); 
</script>
