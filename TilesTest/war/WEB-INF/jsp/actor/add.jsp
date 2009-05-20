<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Add New Actor</h2>

<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
	<div id="clean-error">${flashError}</div>
</c:if>

<tt:errors name="actorModel"></tt:errors>

<form:form modelAttribute="actorModel" method="post">
 
	<table>
		<tr>
			<td>
				<form:input path="id" cssClass="displayNone" size="50"/>
				<form:label path="firstName" cssErrorClass="errors">*First Name</form:label>
			</td>
			<td>
				<form:input path="firstName" size="50"/>

			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastName" cssErrorClass="errors">*Last Name</form:label>
			</td>
			<td>
				<form:input path="lastName" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="_eventId_continue" value="Continue" />
				
			</td>
			<td>
				<input type="submit" name="_eventId_cancel" value="Cancel"/>
			</td>
		</tr>
	</table>

</form:form>

<tt:pageDebug debugPage="false" debugRequest="true"/>