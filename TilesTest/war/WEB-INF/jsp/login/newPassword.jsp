<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h1>Reset Your Password</h1>

<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
	<div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true"/>

<tt:errors name="webSecurityModel"/>

<form:form modelAttribute="webSecurityModel" method="post"> 
	<table>
		<tr>
			<td>
				<form:label path="password" cssErrorClass="errors">*New Password</form:label>
			</td>
			<td>
				<form:password path="password" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="confirmPassword" cssErrorClass="errors">*Confirm Password</form:label>
			</td>
			<td>
				<form:password path="confirmPassword" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="_eventId_continue" value="Continue"/><br/>
			</td>
			<td>
				<input type="submit" name="_eventId_cancel" value="cancel"/><br/>
				
			</td>
		</tr>
	</table>

</form:form>

<script type="text/javascript">
$('password').focus();
</script>
