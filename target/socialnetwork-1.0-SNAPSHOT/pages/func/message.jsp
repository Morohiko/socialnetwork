<%@ page import="Model.Data" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Message" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="sendMsg" class="Controller.message.SendMessage" scope="session"/>
<jsp:useBean id="viewMsg" class="Controller.message.ViewMessage" scope="session"/>

<form name="message" action="message.jsp" method="post">
    <a href="../myPage.jsp">My Page</a><br/>
    Message <br>
    <%//request.setAttribute("idUser");%>
    <%viewMsg.doPost(request, response);%>
    <%@include file="../fragments/msgsList.jspf"%>
    <table>
        <tr><td> msg: </td><td> <input name="message" value="" required="true"> </td></tr>
    </table>
    <input name="sendMsg" type="submit" value="yes"/>
    <%sendMsg.doPost(request, response);%>
</form>
</body>
</html>
