<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<h1>Contact Us</h1>
<hr/>

<tt:errors name="contactModel" />

<c:if test="${not empty contactMessage}">
	<div id="contactMessage" class="errors">
		${contactMessage}
	</div>
</c:if>

<form:form id="contact" modelAttribute="contactModel" method="post" enctype="multipart/form-data">
	<form:hidden path="maxUploads" />
<table>
	<tr>
		<td align="right" valign="top">
			<form:label path="recipientEmail" cssErrorClass="errors">*To:</form:label>
		</td>
		<td align="left">
			<form:input path="recipientEmail" />
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
			<form:label path="attachments" cssErrorClass="errors">Attachments</form:label>
			<input type="button" id="addAttachmentButton" onclick="addAttachment()" value="Add an attachment" />
		</td>
		<td id="attachmentColumn">	
			<c:forEach items="${attachments}" varStatus="stat" var="current">
				<input type="file" id="attachments[${stat.index}]" name="attachments[$stat.index}]" /><br/>
			</c:forEach>
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

var maxUploads = $F('maxUploads');

function createNewAttachment(index){
	var newId = 'attachments[' + index + ']';
	var el = new Element('input' ,{'type':'file', 'id':newId, 'name':newId});
	$('attachmentColumn').insert(el).insert('<br/>');
	el.focus();
}

function addAttachment(){
	var fileInputs = $$('input[type="file"]');
	if (fileInputs.size() >= maxUploads){
		alert("There is a maximum of " + maxUploads  + " attachments.");
		return false;
	}
	createNewAttachment(fileInputs.size());
}

</script>
