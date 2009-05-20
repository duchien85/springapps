<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h1>Inactive Staff Member</h1>

<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
	<div id="clean-error">${flashError}</div>
</c:if>

<p>Your Staff Account is not active - Please call Customer Service</p>