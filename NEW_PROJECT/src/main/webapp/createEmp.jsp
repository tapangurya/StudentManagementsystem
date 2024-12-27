<%@page import="com.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create EMP</title>
</head>
<body>
<form action="createEmp">
	<fieldset>
            <legend>CREATE EMPLOYEE</legend>
            EMP Name: <input type="text" name="name" required="required"> <br><br>
            EMP Email: <input type="email" name="email" required="required"> <br><br>
            EMP Password: <input type="password" name="pass" required="required"> <br><br>
            EMP Phone: <input type="tel" name="ph" required="required"> <br><br>
            EMP DOB: <input type="date" name="dob" required="required"> <br><br>
            Gender:
            <input type="radio" name="gender" value="male" required>MALE
            <input type="radio" name="gender" value="female">FEMALE
            <input type="radio" name="gender" value="other">OTHER<br><br>
            Project:<input type="text" name="proj" required="required"><br><br>
            <input type="submit" value="SIGNUP">
            <input type="reset" value="CANCEL">
        </fieldset>
</form>

</body>
</html>