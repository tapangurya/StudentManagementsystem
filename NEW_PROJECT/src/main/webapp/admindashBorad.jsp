 <%@page import="com.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <div>
        <h1>Admin Dashboard</h1>
        
        <% 
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin != null) { 
        %>
                <a href="createEmp.jsp"><button>create Employee</button></a>
                <a href="findAllEmp"><button>Find All</button></a>
                <a href="logout"><button>Admin Logout</button> </a>
                <a href="adminLogin.jsp"> <button>Home</button></a>
                <a href="socialmediaAccount"><button>SocialMedia</button></a>
               
                
        <% 
            } else { 
        %>
            <h1>Please login first.</h1>
            <a href="adminLogin.jsp">Login</a>
        <% 
            } 
        %>
    </div>
</body>
</html>
 
 
  