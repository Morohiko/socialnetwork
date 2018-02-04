<%@ page import="Model.Data" %>
<%@ page import="Model.AnotherUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="another" scope="request" class="Controller.AnotherPage"/>
<%another.doPost(request, response);%>
<%another.createAnotherPage();%>
anotherPage<br/>
<%AnotherUser anotherUser = Data.getInstance().getAnotherUser();%>
ID = <%=anotherUser.getId()%><br/>
username = <%=anotherUser.getUsername()%><br/>
<a href="myPage.jsp">My Page</a><br/>

</body>
</html>
