<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h2><fmt:message key="views.c.message"/></h2>

<p>&nbsp;</p>
<h3>Id: ${flowExecutionId}</h3>

<form method="POST" />
	<input type="hidden" name="_flowExecutionId" value="${flowExecutionId}"/>
	<input type="submit" name="_eventId_submitB" value="Go to B"/><br/>
	<input type="submit" name="_eventId_submitD" value="Go to D"/>
</form>

