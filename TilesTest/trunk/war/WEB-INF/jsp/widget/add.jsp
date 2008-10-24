<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Add Widget</h2>

<tt:errors name="widget" />

<form:form modelAttribute="widget" method="post">
<table>
	<tr>
		<td><form:label path="widgetName" cssErrorClass="errors" >Name</form:label></td>
		<td><form:input path="widgetName"/></td>
	</tr>
	<tr>
		<td><form:label path="price" cssErrorClass="errors">Price</form:label></td>
		<td><form:input path="price"/></td>
	</tr>
	<tr>
		<td><form:label path="initialTime" cssErrorClass="errors" >Initial Time</form:label></td>
		<td><form:input path="initialTime"/></td>
	</tr>
	<tr>
		<td><form:label path="cool" cssErrorClass="errors" >Is Cool?</form:label></td>
		<td><form:checkbox path="cool"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Save Widget"/></td>
	</tr>
</table>
</form:form>
