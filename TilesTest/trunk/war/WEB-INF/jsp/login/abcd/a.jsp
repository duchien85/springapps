<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<h1>A</h1>
<h2>${flowExecutionUrl}</h2>

<tt:pageDebug debugPage="false" debugRequest="true"/>

<form method="post" />
	<input type="submit" name="_eventId_submitB" value="Go to B"/><br/>
	<input type="submit" name="_eventId_submitC" value="Go to C"/>
</form>
