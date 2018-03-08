<%@ page import="java.util.List" %>
<%@ page import="Model.AnotherUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Friends jsp<br/>
<form name="search" action="friends.jsp" method="post">
    <table>
        <td> searchUsername </td><td> <input name="searchUsername" type="text" value="" required="true"> </td>
        <input name="searchBtn" type="submit" value="searchUsername"/>
    </table>
</form>
<jsp:useBean id="friendList" class="Controller.FriendListController" scope="session"/>
<jsp:useBean id="friend" class="Controller.FriendController" scope="session"/>
<%friend.doPost(request, response);%>
<%friendList.doPost(request, response);%>
<%List<AnotherUser> list = friendList.getFriendList();%>
<a href="../myPage.jsp">My Page</a><br/>
<%for (AnotherUser user : list) {%><br/>
Id = <%=user.getId()%>
Username = <%=user.getUsername()%>
<a href="../anotherPage.jsp?do=search&id=<%=user.getId()%>">page</a>
<a href="friends.jsp?do=remove&id=<%=user.getId()%>">remove</a>
<a href="message.jsp?do=open&id=<%=user.getId()%>">message</a>
<%}%>
</body>
</html>