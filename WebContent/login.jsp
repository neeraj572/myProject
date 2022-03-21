<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<h2>enter email and password to login here</h2>
<form action="Login" method="Post">
email<input type="text" name="email"/>
password<input type="text" name="password"/>
<input type="submit" value="login"/>

</form>
<%
if(request.getAttribute("errormsg")!=null)
out.println(request.getAttribute("errormsg"));
%>
<%
if(request.getAttribute("LogoutMsg")!=null)
out.println(request.getAttribute("LogoutMsg"));
%>
</body>
</html>