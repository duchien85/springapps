<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h2><fmt:message key="views.a.message"/></h2>

<p>&nbsp;</p>
<h3><%= (String)request.getAttribute("flowExecutionKey") %></h3>
<h3>Id: ${flowExecutionId}</h3>
<form method="POST" />
	<input type="hidden" name="_flowExecutionId" value="${_flowExecutionId}"> 
	<input type="hidden" name="_flowId" value="${flowId}"> 
	<input type="submit" name="_eventId_submitB" value="Go to B"/><br/>
	<input type="submit" name="_eventId_submitC" value="Go to C"/>
</form>
