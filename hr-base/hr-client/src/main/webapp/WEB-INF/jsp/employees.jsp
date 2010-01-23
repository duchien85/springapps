<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta name="decorator" content="ext_base">
<title>HR Employees</title>
<script type="text/javascript" src="<c:url value='/js/employees.js'/>"></script>
<script type="text/javascript">
Ext.namespace("HR");
HR.employeesXml = '${employeesXml}';
</script>

</head>
<body>
    <div class="content" class="container">
        <div id="employees_grid"></div>
    </div>
    <div>
        <h2>Employees</h2>
    </div>
</body>
</html>


