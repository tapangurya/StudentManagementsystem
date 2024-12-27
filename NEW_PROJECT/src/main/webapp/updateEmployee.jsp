<%@page import="com.dto.Employee"%>
<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update EMP</title>
</head>
<body>
	<%
        Admin admin = (Admin) session.getAttribute("admin");
        
        if (admin != null) { 
        	int eId= Integer.parseInt(request.getParameter("id"));
        	EmployeeDao empdao = new EmployeeDao();
        	Employee emp=empdao.findByEId(eId);
        	
        
        %>
        <form action="updateEmployee">
        	<fieldset>
        	<legend>UPDATE STUDENT</legend>
        	id:<input type="text" name="id" value="<%=emp.getId()%>" readonly="readonly"><br><br>
        	name:<input type="text" name="fname" value="<%=emp.getName()%>"><br><br>
        	DOB:<input type="date" name="dob" value="<%=emp.getDOB()%>"><br><br>
        	Phone:<input type="tel" name="ph" value="<%=emp.getPhone()%>"><br><br>
        	Project:<input type="text" name="proj" value="<%=emp.getProject() %>"><br><br>
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
</html>