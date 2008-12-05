<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<c:url value="/actor/changePage.htm" var="changePage" scope="page" />
<c:url value="/actor/sort.htm" var="changeSort" scope="page" />

<c:if test="${not empty flashScope.message}">
	<div class="clean-ok">${flashScope.message}</div>
</c:if>

<c:if test="${not empty flashScope.error}">
	<div class="clean-error">${flashScope.error}</div>
</c:if>

<div id="pageTitle">
<h2>Sakila Actors</h2>
</div>

<div>
<table class="dataTable">
 	<thead>
    	<tr>
        	<tt:sortHeader column="firstName" baseUrl="${changeSort}" dataPage="${actors}">First Name</tt:sortHeader>
            <tt:sortHeader column="lastName" baseUrl="${changeSort}" dataPage="${actors}">Last Name</tt:sortHeader>
            <th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
    <tt:TableFooter colspan="6" dataPage="${actors}" baseUrl="${changePage}"/>
	<tbody>
	<c:forEach items="${actors.data}" var="a" varStatus="st">
            <tr class="${st.index % 2 == 0 ? 'odd' : 'even'}">
                <td>${a.firstName}</td>
                <td>${a.lastName}</td>
				<td><a href="<c:url value="/actor/edit.htm"/>?actorId=${a.id}"><img src="<c:url value="/images/Sweetie/png-24/16-tag-pencil.png" />"/></a></td>
				<td><a href="<c:url value="/actor/delete.htm"/>?actorId=${a.id}"><img src="<c:url value="/images/Sweetie/png-24/16-em-cross.png" />"/></a></td>
			</tr>
	</c:forEach>
	</tbody>
</table>
</div><!-- end .form_table -->
