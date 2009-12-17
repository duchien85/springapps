<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Welcome</title>
</head>
<body>

<h2>Resource Message: <fmt:message key="welcome" /></h2>

<h3>Model Message: ${modelMessage}</h3>

<tt:pageDebug debugPage="false" debugRequest="true" />
</body>
</html>
