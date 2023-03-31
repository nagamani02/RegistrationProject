<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile page</title>
</head>
<body>
<form>
<% 
String firstname=(String)request.getAttribute("firstname");
String lastname=(String)request.getAttribute("lastname");
out.print("Hello " +firstname+","+lastname+" welcome to my app");
%>
</form>

</body>
</html>