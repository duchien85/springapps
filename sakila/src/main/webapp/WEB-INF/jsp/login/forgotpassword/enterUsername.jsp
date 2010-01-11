<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Enter User Name</title>
</head>
<body>

<h2>Enter your Username</h2>

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true" />

<tt:errors name="webSecurityModel"></tt:errors>

<form:form modelAttribute="webSecurityModel" method="post">
  <table>
    <tr>
      <td><form:label path="username" cssErrorClass="errors">*Username</form:label></td>
      <td><form:input path="username" size="50" /></td>
    </tr>
    <tr>
      <td><input type="submit" name="_eventId_continue" value="Continue" /></td>
      <td><input type="submit" name="_eventId_cancel" value="Cancel" /></td>
    </tr>
  </table>

</form:form>

<script type="text/javascript">
	$('username').focus();
</script>
</body>
</html>