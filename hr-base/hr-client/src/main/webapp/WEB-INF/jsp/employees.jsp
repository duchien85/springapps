<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta name="decorator" content="ext_base">
<title>HR Employees</title>
<script type="text/javascript" src="<c:url value='/js/employees.js'/>"></script>
</head>
<body>
    <div class="content" class="container">
        <div id="employees_grid"></div>
    </div>
    <div>
        <h2>Employees: ${fn:length(myList)}</h2>
        <p>${employees}</p>
<!--        <c:forEach var="sites" items="${model.site_names}" varStatus="status">-->
<!--        <a href="${model.site_urls[status.index]}" title="sites"><c:out value="${status.count}"/>. <c:out value="${model.site_names[status.index]}"/>-->
<!--</c:forEach> -->
    </div>
</body>
</html>


