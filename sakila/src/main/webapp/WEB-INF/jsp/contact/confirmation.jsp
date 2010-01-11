<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>

<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Contact Us Confirmation</title>
</head>
<body>

<h1>Email Sent</h1>

<h2>Details</h2>
${flashScope.contactModel}

</body>
</html>