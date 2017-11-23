<html>
<head><title></title></head>
<body>
<H1>
You hit the page:
<%! int hitcount=1; %>
<%-- just for mark comment --%>
<%
int count=0;
hitcount=count++;
%>
<%=hitcount++ %>
times
</H1>
</body>
</html>