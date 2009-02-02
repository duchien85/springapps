<h1>Reset Your Password Confirmation</h1>

<c:if test="${not empty flashMessage}">
	<div class="clean-ok">${flashMessage}</div>
</c:if>

<c:if test="${not empty flashError}">
	<div id="clean-error">${flashError}</div>
</c:if>

<tt:pageDebug debugPage="false" debugRequest="true"/>

<tt:errors name="webSecurityModel"/>


<div>
	<p>Your password has been reset!</p>
</div>