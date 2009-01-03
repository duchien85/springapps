<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h1>Contact Us</h1>
<hr/>
<tt:errors name="contactModel" />

<style>
</style>


<c:if test="${not empty contactMessage}">
	<div id="contactMessage" class="errors">
		${contactMessage}
	</div>
</c:if>

<form:form id="contact" modelAttribute="contactModel" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td align="right" valign="top">
			<form:label path="recipientEmail" cssErrorClass="errors">*To:</form:label>
		</td>
		<td align="left">
			<form:select path="recipientEmail">
				<form:option value=""></form:option>
				<form:options items="${recipientOptions}"/>
			</form:select>
		</td>
	</tr>
	<tr>
		<td align="right" valign="top">
			<form:label path="subject" cssErrorClass="errors">*Subject:</form:label>
		</td>
		<td align="left">
			<form:input path="subject" />
		</td>
	</tr>
	<tr>
		<td align="right" valign="top">
			<form:label path="message" cssErrorClass="errors">*Message:</form:label>
		</td>
		<td align="left">
			<form:textarea path="message" cols="40" rows="10" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="attachment0" cssErrorClass="errors">Attachment_0</form:label>
		<td>	
			<input type="file" id="attatchment0" name="attachment0" value="${attachment0.originalFileName}" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="attachment1" cssErrorClass="errors">Attachment_1</form:label>
		<td>	
			<input type="file" id="attatchment1" name="attachment1" value="${attachment1.originalFileName}" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="attachment2" cssErrorClass="errors">Attachment_2</form:label>
		<td>	
			<input type="file" id="attatchment2" name="attachment2" />
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td align="left">
			<input type="submit" value="Submit" />
		</td>
	</tr>
	
</table>
</form:form>


<script>
</script>
