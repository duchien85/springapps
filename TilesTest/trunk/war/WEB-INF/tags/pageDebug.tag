<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="req" uri="http://jakarta.apache.org/taglibs/request-1.0" %>
<%@ taglib prefix="page" uri="http://jakarta.apache.org/taglibs/page-1.0" %>
<%@ attribute name="debugPage" type="java.lang.Boolean" required="true" %>
<%@ attribute name="debugRequest" type="java.lang.Boolean" required="true" %>

<div class="clean-gray" id="pageDebug">
<c:if test="${debugRequest}">
<table class="tablediv">
	<caption>Request Attributes</caption>
	<thead>
		<tr>
			<th width="10%">Name</th>
			<th width="90%">Value</th>
		</tr>
	</thead>
	<tbody>
	<req:attributes id="reqAtt">
	<tr>
		<td class="name" align="left">${reqAtt.name}</td>
		<td class="value" align="left">${reqAtt.value}</td>
	</tr>
	</req:attributes>
	</tbody>
	<tfoot></tfoot>
</table>
</c:if>

<c:if test="${debugPage}">
<table class="tablediv">
	<caption>Page Attributes</caption>
	<thead>
		<tr>
			<th width="10%">Name</th>
			<th width="90%">Value</th>
		</tr>
	</thead>
	<tbody>
	<page:attributes id="pageAtt">
	<tr>
		<td class="name" align="left">${pageAtt.name}</td>
		<td class="value" align="left">${pageAtt.value}</td>
	</tr>
	</page:attributes>
	</tbody>
	<tfoot></tfoot>
</table>
</c:if>
</div>
