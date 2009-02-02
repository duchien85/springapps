<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h2>Resource Message: <fmt:message key="welcome" /></h2>

<h3>Model Message: ${modelMessage}</h3>

<tt:pageDebug debugPage="false" debugRequest="true"/>