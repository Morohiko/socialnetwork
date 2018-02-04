<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Congratulation with registration <br/>
<jsp:useBean id="userInfo" scope="request" class="Controller.UserInformation"/>
Username:
<%=userInfo.getUserName()%> <br/>
Password:
<%=userInfo.getUserPassword()%><br/>
</body>
</html>
