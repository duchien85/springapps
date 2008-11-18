<%
Exception ex = (Exception) request.getAttribute("exception");
%>

<h1>Data access failure: <%= ex.getMessage() %></h1>

<p>
<%
ex.printStackTrace(new java.io.PrintWriter(out));
%>
</p>
