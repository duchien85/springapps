<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="name" type="java.lang.String" required="true" %>

<spring:hasBindErrors name="${name}">
    <ul><span class="errors">
        <c:forEach items="${errors.allErrors}" var="error">
            <li><spring:message message="${error}"/></li>
        </c:forEach>
        </span>
    </ul>
</spring:hasBindErrors>
