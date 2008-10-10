<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<c:set var="title" value="Welcome to JBPM Demo" />
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<h2><fmt:message key="welcome"/></h2>

<p>&nbsp;</p>
<ul>
<!-- <li><a href="<c:url value='/testJbpm.html'/>">Do JBPM Test</a></li> -->
<li><a href="<c:url value='/showProcessInstances.html'/>">Show Process Instances Test</a>a</li>
<li><a href="<c:url value='/testJbpmTemplate.html'/>">Do JBPM Template Test</a></li>
</ul>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>
