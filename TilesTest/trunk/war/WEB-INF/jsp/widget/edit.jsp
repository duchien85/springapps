<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Editing Widget</h2>

<form:form modelAttribute="widget">
<table>
	<tr>
		<td><form:label path="widgetName" cssErrorClass="error" title="Name"></form:label></td>
		<td><form:input path="widgetName"/></td>
	</tr>
	<tr>
		<td><form:label path="price" cssErrorClass="error" title="Price"></form:label></td>
		<td><form:input path="price"/></td>
	</tr>
	<tr>
		<td><form:label path="initialTime" cssErrorClass="error" title="Initial Time"></form:label></td>
		<td><form:input path="initialTime"/></td>
	</tr>
	<tr>
		<td><form:label path="cool" cssErrorClass="error" title="Is Cool?"></form:label></td>
		<td><form:checkbox path="cool"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update Widget"/></td>
	</tr>
</table>
</form:form>
