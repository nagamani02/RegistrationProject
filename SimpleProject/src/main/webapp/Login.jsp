<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body bgcolor="beige">
<form action="LoginForm" method="post">
<p>Enter Email:<input type="text" name="email" required></p>
<p>Enter Password:<input type="password" name="password" required></p>
<input type="submit" value="cancel" onclick="window.location='Home.jsp'">
<input type="submit" value="send">
</form>
</body>
</html>