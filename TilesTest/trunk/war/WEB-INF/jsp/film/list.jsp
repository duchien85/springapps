<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<c:url value="/film/changePage.htm" var="changePage" scope="page" />
<c:url value="/film/sort.htm" var="changeSort" scope="page" />


<c:if test="${not empty flashScope.message}">
	<div class="clean-ok">${flashScope.message}</div>
</c:if>

<c:if test="${not empty flashScope.error}">
	<div class="clean-error">${flashScope.error}</div>
</c:if>

<div id="pageTitle">
<h2>Films</h2>
</div>


<div>
<table class="dataTable">
 	<thead>
    	<tr>
        	<tt:sortHeader column="title" baseUrl="${changeSort}" dataPage="${films}">Film Name</tt:sortHeader>
            <tt:sortHeader column="description" baseUrl="${changeSort}" dataPage="${films}">Description</tt:sortHeader>
            <tt:sortHeader column="releaseYear" baseUrl="${changeSort}" dataPage="${films}">Release Year</tt:sortHeader>
            <th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
    <tt:TableFooter colspan="6" dataPage="${films}" baseUrl="${changePage}"/>
	<tbody>
	<c:forEach items="${films.data}" var="f" varStatus="st">
            <tr class="${st.index % 2 == 0 ? 'odd' : 'even'}">
                <td>${f.title}</td>
                <td>$${f.description}</td>
                <td>${f.releaseYear}</td>
				<td><a href="<c:url value="/film/edit.htm"/>?filmId=${f.id}"><img src="<c:url value="/images/Sweetie/png-24/16-tag-pencil.png" />"/></a></td>
				<td><a href="<c:url value="/film/delete.htm"/>?filmId=${f.id}"><img src="<c:url value="/images/Sweetie/png-24/16-em-cross.png" />"/></a></td>
			</tr>
	</c:forEach>
	</tbody>
</table>
</div><!-- end .form_table -->
