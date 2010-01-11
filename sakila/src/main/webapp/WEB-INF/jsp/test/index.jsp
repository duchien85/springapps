<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="req" uri="http://jakarta.apache.org/taglibs/request-1.0"%>
<html>
<head>
<meta name="decorator" content="yui_doc2_t2_1grid">
<title>Test</title>
</head>
<body>

<h1>Test</h1>
<ul>
  <req:attributes id="loop">
    <li>Name: ${loop.name} &nbsp; &nbsp;| &nbsp; Value: ${loop.value}</li>
  </req:attributes>
</ul>
<form:form method="post" modelAttribute="widget">
  <input type="submit" value="Submit" id="submit" name="submit" />
</form:form>
</body>
</html>