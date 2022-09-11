<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%="Deleted Shoe ID : "+ request.getAttribute("shoeid") %><br>

<br><form action="return.jsp">
<input type="submit" value="Return to Shoe Page">
</form>
</body>
</html>