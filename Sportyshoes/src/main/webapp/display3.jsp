
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
<%= "Shoe id : " + request.getAttribute("shoeid")%><br>
<%= "Quantity : " + request.getAttribute("quantity")%><br>
<%= "Payment to be paid : " + request.getAttribute("pay1")%><br>
<br>
<form action="pay.jsp">
<input type="submit" value="Pay">
</form>

</body>
</html>

