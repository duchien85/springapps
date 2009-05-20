<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="left_nav">
	
		<div class="nav_section">
		<h2>Links</h2>
		<ul>
			<li><a href="<c:url value="/welcome.htm"/>">Home</a></li>
			<li><a href="<c:url value="/api/helloworld.htm"/>">HelloWorld WS</a></li>
			<li><a href="<c:url value="/contact/index.htm" />">Contact Us</a></li>
			
		</ul>
		</div>
		
		<div class="nav_section">
		<h2>Widgets</h2>
		<ul>
			<li><a href="<c:url value="/widget/list.htm"/>">List Widgets</a></li>
			<li><a href="<c:url value="/widget/add.htm"/>">Add a Widget</a></li>
			<li><a href="<c:url value="/widget/search/index.htm"/>">Search Widgets</a></li>
		</ul>
		</div>

		<div class="nav_section">
		<h2>Actors</h2>
		<ul>	
			<li><a href="<c:url value="/actor/list.htm"/>">List Actors</a></li>
			<li><a href="<c:url value="/actor/add.htm"/>">Add Actor</a></li>
		</ul>
		</div>
		
		<div class="nav_section">
		<h2>Films</h2>
		<ul>	
			<li><a href="<c:url value="/film/list.htm"/>">All Films (JMesa)</a></li>
		</ul>
		</div>
		
		<div class="nav_section">
		<h2>Login</h2>
		<ul>
			<li><a href="<c:url value="/login/forgotpassword.htm"/>">Forgot Password?</a></li>
			<li><a href="<c:url value="/login/forgotusername.htm"/>">Forgot Username?</a></li>
		</ul>
		</div>

</div> <!-- end #left_nav -->	