<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>List Widgets</title>
</head>
<body>

<h2>Edit actor [ACTOR_NAME}</h2>

<c:if test="${not empty flashMessage}">
  <div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
  <div id="clean-error">${flashError}</div>
</c:if>

<tt:errors name="actorModel"></tt:errors>

<form:form modelAttribute="actorModel" method="post">
  <table>
    <tr>
      <td><form:label path="firstName" cssErrorClass="errors">*First Name</form:label></td>
      <td><form:input path="firstName" size="50" /> <form:input path="id" cssClass="displayNone" size="50" /></td>
    </tr>
    <tr>
      <td><input type="submit" name="_eventId_continue" value="Continue" /></td>
      <td><input type="submit" name="_eventId_cancel" value="Cancel" /></td>
    </tr>
  </table>

</form:form>

<tt:pageDebug debugPage="false" debugRequest="true" />
</body>
</html>