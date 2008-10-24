<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Editing Widget</h2>

<form:form modelAttribute="widget">
<table>
	<tr>
		<td><form:label path="widgetName" cssErrorClass="errors" title="Name">Name</form:label></td>
		<td><form:input path="widgetName"/></td>
	</tr>
	<tr>
		<td><form:label path="price" cssErrorClass="errors" title="Price">Price</form:label></td>
		<td><form:input path="price"/></td>
	</tr>
	<tr>
		<td><form:label path="initialTime" cssErrorClass="errors" title="Initial Time">Initial Time</form:label></td>
		<td><form:input path="initialTime"/></td>
	</tr>
	<tr>
		<td><form:label path="cool" cssErrorClass="errors" title="Is Cool?">Cool</form:label></td>
		<td><form:checkbox path="cool"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update Widget"/></td>
	</tr>
</table>
</form:form>
