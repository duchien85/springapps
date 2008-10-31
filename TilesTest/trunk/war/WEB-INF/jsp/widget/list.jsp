<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<h2>${message}</h2>
<div class="form_table">
<table class="yui-skin-sam">
	<thead>
		<tr>
		<th>Widget Name</th>
		<th>Price</th>
		<th>Initial Time</th>
		<th>Cool?</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
	<thead>
	<tbody>
	<c:forEach items="${widgets}" var="w" varStatus="st">
            <tr class="${st.index % 2 == 0 ? 'odd' : 'even'}">
                <td>${w.widgetName}</td>
                <td>$${w.price}</td>
                <td><joda:format value="${w.initialTime}" style="M-"/></td>
                <td>${w.cool}</td>
				<td><a href="<c:url value="/widget/edit.htm"/>?widgetId=${w.id}">Edit</a></td>
				<td><a href="<c:url value="/widget/delete.htm"/>?widgetId=${w.id}">Delete</a></td>
			</tr>
	</c:forEach>
	</tbody>
</table>
</div><!-- end .form_table -->

<a href="<c:url value="/widget/add.htm"/>">Add a Widget</a>