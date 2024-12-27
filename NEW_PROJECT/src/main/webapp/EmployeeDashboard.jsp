<%@page import="com.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeDashboard</title>
</head>
<body>
	<%List<Employee>list=(List<Employee>)session.getAttribute("listOfEmployee");
	if(list!=null){
	%>
	
	<h1>Welcome</h1>
	<table border="1" cellpading ="2px" cellspacing="2px">
            <thead>
            <tr>
                <th>EMP.NO</th>
                <th>EMP_ID</th>
                <th>EMP_NAME</th>
                <th>EMP_EMAIL</th>
                <th>EMP_PHONE_NUMBER</th>
                <th>EMP_GENDER</th>
                <th>EMP_DOB</th>
               
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            </thead>
            <tbody>
            <%
            int i = 1;
            for (Employee e : list) {
            %>
            <tr>
                <td><%=i++%></td>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getEmail()%></td>
                <td><%=e.getPhone()%></td>
                <td><%=e.getGender()%></td>
                <td><%=e.getDOB()%></td>
                <td><a href="updateEmployee.jsp?id=<%=e.getId()%>"><button>UPDATE</button></a></td>
                <td><a href="deleteEmployee?id=<%=e.getId()%>"><button>DELETE</button></a></td>
            </tr>
             
            
            <%
            }
	}
            %>
        </tbody>
        <a href="logout"><button>Admin Logout</button> </a>
        <a href="admindashBorad.jsp"> <button>Home</button></a>
        
        
</body>
</html>