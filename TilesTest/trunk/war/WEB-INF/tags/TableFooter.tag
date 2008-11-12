<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="colspan" type="java.lang.Integer" required="true" %>
<%@ attribute name="baseUrl" type="java.lang.String" required="true" %>
<%@ attribute name="dataPage" type="com.studerb.web.util.DataPage" required="true" %>

<c:if test="${dataPage.info.maxPage == 0}">
    <tr>
        <td colspan="${colspan}">
            No Records
        </td>
    </tr>
</c:if>

<tfoot>
    <tr>
        <td colspan="${colspan}">
            <c:choose>
                <c:when test="${dataPage.info.maxPage != 0}">
                    <c:if test="${dataPage.info.prev}">
                        <a class="navButton" href="${baseUrl}?viewName=${dataPage.info.viewName}&changeEvent=FIRST">|&lt;</a>
                        <a class="navButton" href="${baseUrl}?viewName=${dataPage.info.viewName}&changeEvent=PREV">&lt;</a>
                    </c:if>
                    Page ${dataPage.info.currentPage} of ${dataPage.info.maxPage}
                    <c:if test="${dataPage.info.next}">
                        <a class="navButton" href="${baseUrl}?viewName=${dataPage.info.viewName}&changeEvent=NEXT">&gt;</a>
                        <a class="navButton" href="${baseUrl}?viewName=${dataPage.info.viewName}&changeEvent=LAST">&gt;|</a>
                    </c:if>
                </c:when>
                <c:otherwise>
                    Page 1 of 1
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</tfoot>
