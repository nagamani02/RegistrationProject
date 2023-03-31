<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body bgcolor="skyblue">

<form action="RegistrationForm" method="post">

<p>Enter FirstName: <input type="text" name="firstname" required></p>
<p>Enter MiddleName: <input type="text" name="middlename"></p>
<p>Enter LastName: <input type="text" name="lastname" required></p>
<p>Email: <input type="text" name="email" required></p>
<p>Confirm Email:<input type="text" name="confirm email"></p>
<p>Password: <input type="password" name="password" required></p>
<p>Confirm Password: <input type="password" name="confirm password"></p>
<p>Phone Number: <input type="text" name="phoneno" required></p>
<p>Address Line1: <input type="text" name="address line1" required></p>
<p>Address Line2: <input type="text" name="address line2" required></p>
<p>City: <input type="text" name="city" required></p>
<p>State: <input type="text" name="state" required></p>
<p>Zipcode: <input type="text" name="zipcode" required></p>
<input type="submit" value="cancel" onclick="window.location='Home.jsp'"> 
<input type="submit" value="send"> 
</form>
</body>
</html>