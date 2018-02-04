<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <jsp:useBean id="valid1" class="Controller.Validation" type="Controller.Validation" scope="request"/>
</head>
<body>
<%@include file="fragments/reg.jspf"%>
<br>
<%@include file="fragments/log.jspf"%>
<%valid1.doPost(request, response);%>
</body>
</html>