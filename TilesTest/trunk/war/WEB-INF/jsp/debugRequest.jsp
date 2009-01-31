<%@page import="java.util.*" %>				
<ul>
<%
	for(Enumeration e = request.getAttributeNames(); e.hasMoreElements(); ){
		String attName = (String)e.nextElement();
		out.println("<li>" + attName + "</li>");
	}
%>
</ul>
