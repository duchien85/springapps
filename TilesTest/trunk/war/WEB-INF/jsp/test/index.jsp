<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1"%>
<%@ taglib prefix="tt" tagdir="/WEB-INF/tags"%>


<h1>Test</h1>

<form:form method="post" modelAttribute="widget">
	<input type="submit" value="Submit" id="submit" name="submit" />
</form:form>