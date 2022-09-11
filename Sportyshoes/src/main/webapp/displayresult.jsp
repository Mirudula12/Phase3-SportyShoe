
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
<%List<Shoes> a=(List<Shoes>)request.getAttribute("list");
%>

<table  border="1">
<tr><th>id</th><th>name</th><th>cost</th></tr>
<%for(Shoes ee:a){ %>
<tr><td><%=ee.getShoeid()%></td><td><%=ee.getShoename() %></td><td><%=ee.getCost() %></td></tr>
<%} %>
</table><br>
<form action="edit.jsp">
<input type="submit" value="Edit Shoes by Id"></form><br>
<form action="delete.jsp">
<input type="submit" value="Delete Shoes by Id"></form><br>
<form action="return.jsp">
<input type="submit" value="Return to Shoe Page"></form><br>
</body>
</html>

