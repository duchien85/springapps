<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Add Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
<table>
	<tr>
		<td class="form_label"><form:label path="widgetName" cssErrorClass="errors" >Name</form:label></td>
		<td class="form_input"><form:input path="widgetName"/></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="price" cssErrorClass="errors">Price</form:label></td>
		<td class="form_input"><form:input path="price"/></td>
	</tr>
	<tr>
		<td class="form_label"><form:label path="initialTime" cssErrorClass="errors" >Initial Time</form:label></td>
		<td class="form_input"><form:input path="initialTime"/></td>
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
