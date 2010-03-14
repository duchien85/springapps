<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <ul>
        <li><a href='<c:url value="/employees.htm" />'>Employees</a></li>
        <li><a href='<c:url value="/departments.htm" />'>Departments</a></li>
        <li><a href="<c:url value='/rest/application.wadl/'/>">WADL</a></li>
        <li>${modelMessage}</li>
    </ul>
</div>
