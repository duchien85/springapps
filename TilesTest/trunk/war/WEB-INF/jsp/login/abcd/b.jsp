<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h2><fmt:message key="views.b.message"/></h2>

<p>&nbsp;</p>
<h3>Id: ${flowExecutionId}</h3>

<form method="POST" />
	<input type="hidden" name="_flowExecutionId" value="${flowExecutionId}"/>
	<input type="submit" name="_eventId_submitC" value="Go to C"/><br/>
	<input type="submit" name="_eventId_submitD" value="Go to D"/>
</form>

