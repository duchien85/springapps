<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Add Actor Confirmation</title>
</head>
<body>

<h2>Confirmation</h2>

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true" />
</body>
</html>