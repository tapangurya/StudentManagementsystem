package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.EmployeeDao;

import com.dto.Admin;
import com.dto.Employee;


@WebServlet("/createEmp")
public class CreateEmpServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// createEmp?fname=rakesh&email=r%40gmail.com&pass=1234&ph=23456354678&dob=2013-04-26&gen=male&proj=javaproject
		Admin admin = (Admin) req.getSession().getAttribute("admin");
   	 if(admin!=null) 
   	 {
   		String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        Long phone = Long.parseLong(req.getParameter("ph")) ;
        String dob = req.getParameter("dob");
        String Gender = req.getParameter("gender");
        String project = req.getParameter("proj");
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setPassword(password);
        emp.setPhone(phone);
        emp.setProject(project);
        emp.setDOB(dob);
        emp.setGender(Gender);
        emp.setAdmin(admin);
        AdminDao adminD= new AdminDao();
        EmployeeDao sDao = new EmployeeDao();
        sDao.createEmployee(emp);
        Admin a =adminD.findByEId( admin.getId());
        List<Employee> listOfEmployee = a.getEmployees();
        req.getSession().setAttribute("listOfEmployee", listOfEmployee);
        resp.getWriter().print("<h1>Employee Created SuccessFully</h1>");
        req.getRequestDispatcher("EmployeeDashboard.jsp").include(req, resp);
   		
   	 }
   	 else {
   		 req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
   	 }
		
	}

}
