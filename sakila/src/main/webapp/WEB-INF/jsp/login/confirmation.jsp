<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Forgot Password Confirmation</title>
</head>
<body>

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true" />

<c:choose>
  <c:when test="${param.confirm == 'forgotpassword'}">
    <h1 class="clean-ok">Your password has been reset!</h1>
  </c:when>
  <c:when test="${param.confirm == 'forgotusername'}">
    <h1 class="clean-ok">Your User Name: ${param.username}</h1>
  </c:when>
  <c:otherwise>
    <h1 class="clean-error">Bad Confirmation...</h1>
  </c:otherwise>
</c:choose>
</body>
</html>