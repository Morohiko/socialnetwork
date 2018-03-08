<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<%@ page import="Model.Data" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
people
<jsp:useBean id="allUSerInfo" scope="request" class="Controller.AllUserInformation"/>
<jsp:useBean id="friendList" scope="request" class="Controller.FriendListController"/>
<%allUSerInfo.doPost(request, response);%>
<a href="../myPage.jsp">My Page</a><br/>

<form name="search" action="people.jsp" method="post">
    <table>
        <td> searchUsername </td><td> <input name="searchUsername" type="text" value="" required="true"> </td>
        <input name="searchBtn" type="submit" value="searchUsername"/>
    </table>
</form>
<%allUSerInfo.getList();%>
<%List<User> list = Data.getInstance().getUserList();%>

<%for (User user : list) {%><br/>
Id = <%=user.getId()%>
Username = <%=user.getUsername()%>
<a href="../anotherPage.jsp?do=search&id=<%=user.getId()%>">page</a>
<a href="people.jsp?do=add&id=<%=user.getId()%>">addFriend</a>
<%}%>
<%friendList.doPost(request, response);%>

</body>
</html>
