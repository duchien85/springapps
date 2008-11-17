<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="name" type="java.lang.String" required="true" %>

<spring:hasBindErrors name="${name}">
	<div class="clean-error">
	<ul>
        <c:forEach items="${errors.allErrors}" var="error">
            <li><spring:message message="${error}"/></li>
        </c:forEach>
    </ul>
	</div>
</spring:hasBindErrors>
