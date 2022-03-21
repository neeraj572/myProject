<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration page</title>
</head>
<body>
<h2>register here</h2>
<form action="Reg" method="Post">
name<input type="text" name="name"/>
city<input type="text" name="city"/>
email<input type="text" name="email"/>
mobile<input type="text" name="mobile"/>
<input type="submit" value="save"/>

</form>
<%
if(request.getAttribute("msg")!=null)
out.println(request.getAttribute("msg"));

%>
</body>
</html>