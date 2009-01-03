
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="left_nav">
	
	<ul>
		<li><a href="<c:url value="/welcome.htm"/>">Home</a></li>
		<li><a href="<c:url value="/widget/list.htm"/>">Widgets</a></li>
		<ul>
			<li><a href="<c:url value="/widget/add.htm"/>">Add a Widget</a></li>
			<li><a href="<c:url value="/widget/search/index.htm"/>">Search Widgets</a></li>
		</ul>

		<li><a href="<c:url value="/api/helloworld.htm"/>">HelloWorld WS</a></li>
		<li><a href="<c:url value="/actor/list.htm"/>">Actors (Jmesa)</a></li>
		<li><a href="<c:url value="/contact/index.htm" />">Contact Us</a></li>
	</ul>

</div> <!-- end #left_nav -->	