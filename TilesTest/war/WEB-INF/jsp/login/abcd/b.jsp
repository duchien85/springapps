<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h1>B</h1>
<h2>${flowExecutionUrl}</h2>
<tt:pageDebug debugPage="false" debugRequest="true"/>

<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<form method="post" />
	<input type="submit" name="_eventId_submitC" value="Go to C"/><br/>
	<input type="submit" name="_eventId_submitD" value="Go to D"/>
</form>

