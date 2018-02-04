<%@ page import="Model.Data" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Data.getInstance().removeUser(request.getSession().getId());%>
<%response.sendRedirect("../registration.jsp");%>
</body>
</html>
