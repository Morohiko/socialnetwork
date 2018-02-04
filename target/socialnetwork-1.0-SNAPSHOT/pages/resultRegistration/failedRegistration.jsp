<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Validation is failed, please try another login or paыsword
<jsp:useBean id="valid1" class="Controller.Validation" type="Controller.Validation" scope="request"/>
<%@include file="../fragments/reg.jspf"%>
<%valid1.doPost(request, response);%>
</body>
</html>
