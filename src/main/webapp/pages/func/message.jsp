<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 30.01.2018
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

fucking message
<jsp:useBean id="dialog" class="Controller.DialogController" scope="session"/>
<%dialog.doPost(request, response);%>
sss

</body>
</html>
