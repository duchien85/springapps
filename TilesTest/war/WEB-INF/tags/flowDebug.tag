<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="req" uri="http://jakarta.apache.org/taglibs/request-1.0" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="clean-gray" id="pageDebug">
<table class="tablediv">
	<caption>Flow RequestScope Attributes</caption>
	<thead>
		<tr>
			<th width="10%">Name</th>
			<th width="10%">Name</th>
			<th width="80%">Value</th>
		</tr>
	</thead>
	<tbody>
	<req:attributes id="reqAtt">
		<c:if test="${fn:containsIgnoreCase(reqAtt.name, 'flow')}">
			<tr>
				<td class="name" align="left">${reqAtt.name}</td>
				<td class="value" align="left">${reqAtt.value}</td>
			</tr>			
		</c:if>

	</req:attributes>
	</tbody>
	<tfoot></tfoot>
</table>
</div>
