<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h1>C</h1>
<h2>${flowExecutionUrl}</h2>


<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
	<div id="clean-error">${flashError}</div>
</c:if>

<form method="POST" />
	<input type="submit" name="_eventId_submitB" value="Go to B"/><br/>
	<input type="submit" name="_eventId_submitD" value="Go to D"/>
</form>

