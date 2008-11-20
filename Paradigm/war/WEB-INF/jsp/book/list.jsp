<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags" %>

<c:url value="/book/changePage.htm" var="changePage" scope="page" />
<c:url value="/book/sort.htm" var="changeSort" scope="page" />


<c:if test="${not empty flashScope.message}">
	<div class="clean-ok">${flashScope.message}</div>
</c:if>

<c:if test="${not empty flashScope.error}">
	<div class="clean-error">${flashScope.error}</div>
</c:if>

<div id="pageTitle">
<h2>Books</h2>
</div>


<div>
<table class="dataTable">
 	<thead>
    	<tr>
        	<tt:sortHeader column="bookName" baseUrl="${changeSort}" dataPage="${books}">Book Name</tt:sortHeader>
            <tt:sortHeader column="price" baseUrl="${changeSort}" dataPage="${books}">Price</tt:sortHeader>
            <tt:sortHeader column="initialTime" baseUrl="${changeSort}" dataPage="${books}">Initial Time</tt:sortHeader>
            <tt:sortHeader column="cool" baseUrl="${changeSort}" dataPage="${books}">Cool?</tt:sortHeader>
            <th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
    <tt:TableFooter colspan="6" dataPage="${books}" baseUrl="${changePage}"/>
	<tbody>
	<c:forEach items="${books.data}" var="w" varStatus="st">
            <tr class="${st.index % 2 == 0 ? 'odd' : 'even'}">
                <td>${w.bookName}</td>
                <td>$${w.price}</td>
                <td><joda:format value="${w.initialTime}" style="M-"/></td>
                <td>${w.cool}</td>
				<td><a href="<c:url value="/book/edit.htm"/>?bookId=${w.id}"><img src="<c:url value="/images/Sweetie/png-24/16-tag-pencil.png" />"/></a></td>
				<td><a href="<c:url value="/book/delete.htm"/>?bookId=${w.id}"><img src="<c:url value="/images/Sweetie/png-24/16-em-cross.png" />"/></a></td>
			</tr>
	</c:forEach>
	</tbody>
</table>
</div><!-- end .form_table -->
