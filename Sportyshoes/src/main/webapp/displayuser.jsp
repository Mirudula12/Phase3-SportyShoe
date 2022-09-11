
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@ page import="com.example.demo.*" %>
    <%@ page  import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<User> a=(List<User>)request.getAttribute("list");
%>

<table  border="1">
<tr><th>user</th><th>password</th><th>id</th><th>email</th></tr>
<%for(User ee:a){ %><tr><td><%=ee.getUser()%></td><td><%=ee.getPassword() %></td><td><%=ee.getUid() %></td><td><%=ee.getEmail() %></td></tr><%} %></table><br>

<form action="edituser.jsp">
<input type="submit" value="Edit">
</form><br>

<form action="deleteuser.jsp">
<input type="submit" value="Delete">
</form><br>
</body>
</html>

