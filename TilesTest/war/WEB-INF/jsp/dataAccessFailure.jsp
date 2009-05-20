<%
Exception ex = (Exception) request.getAttribute("exception");
%>

<h1>Data access failure: <%= ex.getMessage() %></h1>

<div style="overflow:auto">
<%
ex.printStackTrace(new java.io.PrintWriter(out));
%>
</div>

