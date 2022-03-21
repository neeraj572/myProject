<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet" %>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border='1'>
<tr>
<th>name</th>
<th>city</th>
<th>email</th>
<th>mobile</th>
<th>delete</th>
<th>update</th>
</tr>

<%
ResultSet result=(ResultSet)request.getAttribute("res");
while(result.next()){
	%>
	
	
	<tr>
	<td><%=result.getString(1) %></td>
	<td><%=result.getString(2) %></td>
	<td><%=result.getString(3) %></td>
	<td><%=result.getString(4) %></td>
	<td><a href="DeleteController?email=<%=result.getString(3) %>">delete</a></td>
	<td><a href="UpdateController?email=<%=result.getString(3) %>&mobile=<%=result.getString(4) %>">update</a></td>
	</tr>
<% 
}
%>
</table>
</body>
</html>