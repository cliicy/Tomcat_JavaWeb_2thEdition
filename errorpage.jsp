<%@ page import="java.io.*" %>
<!-- set the Chinese output -->
<%@ page contentType="text/html; charset=GB2312" %>
<%@ page isErrorPage="true" %>

<html><head><title>Error Page</title></head>
<body>
<p> Error from Server side:<%= exception.getMessage() %>
</p>
<p> The reason of Error is: <% exception.printStackTrace(new PrintWriter(out)); %>
</p>

</body>
</html>