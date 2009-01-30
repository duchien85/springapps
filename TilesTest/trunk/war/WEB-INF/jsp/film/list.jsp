<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>


<c:if test="${not empty flashScope.message}">
	<div class="clean-ok">${flashScope.message}</div>
</c:if>

<c:if test="${not empty flashScope.error}">
	<div class="clean-error">${flashScope.error}</div>
</c:if>

<div id="pageTitle">
<h2>Films</h2>
</div>

<div>
${filmTable}
</div>