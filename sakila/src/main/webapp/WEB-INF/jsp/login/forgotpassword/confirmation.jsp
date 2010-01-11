<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>

<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Reset Password Confirmation</title>
</head>
<body>

<h1>Reset Your Password Confirmation</h1>

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true" />

<tt:errors name="webSecurityModel" />


<div>
<p>Your password has been reset!</p>
</div>
</body>
</html>