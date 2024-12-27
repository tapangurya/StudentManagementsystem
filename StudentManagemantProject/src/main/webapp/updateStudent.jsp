<%-- <%@page import="com.dto.Admin"%>
<%@page import="com.dto.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student update</title>
</head>
<body>
	<%
        Admin admin = (Admin) session.getAttribute("ad");
        
        if (admin != null) { 
        	int sId= Integer.parseInt(request.getParameter("id"));
        	StudentDao studentdao = new StudentDao();
        	Student student=studentdao.findById(sId);
        
        %>
        <form action="updateStudent">
        	<fieldset>
        	<legend>UPDATE STUDENT</legend>
        	id:<input type="text" name="id" value="<%=student.getId()%>" readonly="readonly"><br><br>
        	name:<input type="text" name="fname" value="<%=student.getName()%>"><br><br>
        	DOB:<input type="date" name="dob" value="<%=student.getDOB()%>"><br><br>
        	Phone:<input type="tel" name="ph" value="<%=student.getPhone()%>"><br><br>
        	<input type="submit" value="UPDATE STUDENT">
			<input type="reset" value="CANCEL">
        	</fieldset>
        	<a href="logout"><button>ADMIN LOGOUT</button> </a>
        	<a href="adminDashBorad.jsp"><button>HOME</button> </a>
        </form>
        
        <%}else{
        	response.getWriter().print("<h1>DO LOGIN FIRST</h1>");
        	request.getRequestDispatcher("adminLogin.jsp").include(request, response);
        } %>
</body>
</html> --%>









<%@page import="com.dto.Admin"%>
<%@page import="com.dto.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Update</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    fieldset {
        border: 2px solid #007BFF;
        border-radius: 10px;
        padding: 20px;
        width: 300px;
        background-color: #fff;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    legend {
        font-size: 18px;
        font-weight: bold;
        color: #007BFF;
    }

    input[type="text"],
    input[type="date"],
    input[type="tel"] {
        width: calc(100% - 22px);
        padding: 8px;
        margin: 5px 0 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }

    input[type="submit"],
    input[type="reset"],
    a button,button {
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        background-color: #007BFF;
        color: white;
        font-size: 14px;
        cursor: pointer;
        transition: transform 0.2s ease, background-color 0.2s ease;
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover,
    a button:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }

    a {
        text-decoration: none;
        display: inline-block;
        margin-top: 10px;
    }

    a button {
        width: 100%;
        margin-bottom: 5px;
    }

    h1 {
        color: red;
        text-align: center;
    }
</style>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const buttons = document.querySelectorAll("button, input[type='submit'], input[type='reset']");
        buttons.forEach(button => {
            button.addEventListener("mouseover", () => {
                button.style.transform = "scale(1.1)";
            });
            button.addEventListener("mouseout", () => {
                button.style.transform = "scale(1)";
            });
        });
    });
    function goBack() {
    	  window.history.back();
    	}
</script>
</head>
<body>
	<%
        Admin admin = (Admin) session.getAttribute("ad");
        
        if (admin != null) { 
        	int sId = Integer.parseInt(request.getParameter("id"));
        	StudentDao studentdao = new StudentDao();
        	Student student = studentdao.findById(sId);
        %>
        <form action="updateStudent">
        	<fieldset>
        	<legend>UPDATE STUDENT</legend>
        	id: <input type="text" name="id" value="<%=student.getId()%>" readonly="readonly"><br>
        	name: <input type="text" name="fname" value="<%=student.getName()%>"><br>
        	DOB: <input type="date" name="dob" value="<%=student.getDOB()%>"><br>
        	Phone: <input type="tel" name="ph" value="<%=student.getPhone()%>"><br>
        	<input type="submit" value="UPDATE STUDENT">
			<input type="reset" value="CANCEL">
        	</fieldset>
        	<a href="logout"><button type="button">ADMIN LOGOUT</button></a>
        	<a href="home.jsp"><button type="button">HOME</button></a>
        	<!-- <button type="button">Back</button> -->
        	<button onclick="goBack()">Back</button></script>
        </form>
        
        <%} else {
        	response.getWriter().print("<h1>DO LOGIN FIRST</h1>");
        	request.getRequestDispatcher("adminLogin.jsp").include(request, response);
        } %>
</body>



</html>
