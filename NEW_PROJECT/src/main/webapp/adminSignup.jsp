 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminsignUup</title>

</head>
<body>
	
		<form action="adminsignup" method="post">
		<fieldset>
		<legend>AdminSignUp</legend>
			Name:<input type="text" name="name" required="required"> <br><br>
			Email:<input type="email" name="email" required="required"> <br><br>
			Password:<input type="password" name="pass" required="required"> <br><br>
			<input type="submit" value="SUBMIT">
			<input type="reset" value="CANCLE"><br>
			<span>if you have an account <a href="adminLogin.jsp">login here</a></span>
		</fieldset>
		</form>
	
</body>
</html>
 