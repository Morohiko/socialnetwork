<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myPage</title>
</head>
<body>
<jsp:useBean id="userInfo" scope="request" class="Controller.UserInformation"/>
MyPage<br/>
<table>
    <tr><td>
        she yakas infa <br/>
        <a href="func/people.jsp">people</a>
        <a href="func/friends.jsp">friends</a>
    </td><td>
        <%userInfo.doPost(request, response);%>
        <%try{%>
        Id:
        <%=userInfo.getUserId()%><br/>
        Username:
        <%=userInfo.getUserName()%><br/>
        Password:
        <%=userInfo.getUserPassword()%><br/>
        <%}catch(Exception e){
            System.out.println("getUser jsp");
            response.sendRedirect("registration.jsp");
        }%>
    </td></tr>
</table>
<a href="func/remove.jsp">exit</a>
</body>
</html>