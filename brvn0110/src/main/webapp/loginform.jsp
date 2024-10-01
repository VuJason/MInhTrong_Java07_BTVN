<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Login Form</h1>
	<form action="login" method="post">
	  UserName: <input type="text" name="username"/> <br/>
	  Password: <input type="password" name="password"/> <br/>
	  <button>Submit</button><br/>
	  <h3>${message}</h3>
	  
	</form>
</body>
</html>