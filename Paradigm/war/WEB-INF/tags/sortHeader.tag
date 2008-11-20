<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="column" type="java.lang.String" required="true" %>
<%@ attribute name="baseUrl" type="java.lang.String" required="true" %>
<%@ attribute name="dataPage" type="com.paradigm.web.util.DataPage" required="true" %>

<c:choose>
    <c:when test="${dataPage.info.sort eq column}">
        <c:set var="selectedClass" value="selected" scope="page" />
    </c:when>
    <c:otherwise>
        <c:set var="selectedClass" value="" scope="page" />
    </c:otherwise>
</c:choose>


<th>
    <a href="${baseUrl}?viewName=${dataPage.info.viewName}&column=${column}" class="${selectedClass}">
        <jsp:doBody />
        <c:if test="${dataPage.info.sort eq column}">
            <c:choose>
                <c:when test="${dataPage.info.sortDesc}">
                    <img src="<c:url value="/images/sort_column_descending.gif" />" alt="down" border="0" height="10" width="10" />
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/images/sort_column_ascending.gif" />" alt="up" border="0" height="10" width="10" />
                </c:otherwise>
            </c:choose>
        </c:if>
    </a>
</th>