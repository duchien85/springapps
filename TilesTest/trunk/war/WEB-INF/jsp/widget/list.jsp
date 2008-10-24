<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>${message}</h2>
<div class="form_table">
<table>
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
                <td>${w.price}</td>
                <td>${w.initialTime}</td>
                <td>${w.cool}</td>
				<td><a href="<c:url value="/widget/edit.htm"/>?id=${pd.id}">Edit</a></td>
				<td><a href="<c:url value="/widget/delete.htm"/>?id=${pd.id}">Delete</a></td>
			</tr>
	</c:forEach>
	</tbody>
</table>
</div><!-- end .form_table -->

<a href="<c:url value="/widget/add.htm"/>">Add a Widget</a>