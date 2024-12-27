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


@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//updateEmployee?id=3&fname=Mithun&dob=2002-10-08&ph=9382401453&proj=ADVANCED+JAVA+Project
		
		Admin admin = (Admin) req.getSession().getAttribute("admin");
	   	 if(admin!=null) {
	   		 int id = Integer.parseInt(req.getParameter("id"));
	   		 	String name = req.getParameter("fname");
	   	        Long phone = Long.parseLong(req.getParameter("ph")) ;
	   	        String dob = req.getParameter("dob");
	   	  // find Student object
	   	        EmployeeDao employeedao= new EmployeeDao();
	   	     Employee e= employeedao.findByEId(id);
	   	        e.setDOB(dob);
	   	        e.setName(name);
	   	        e.setPhone(phone);
	   	        // supdate
	   	     employeedao.createEmployee(e);
	   	        
	   	        int adId = admin.getId();
	   	        AdminDao admindao= new AdminDao();
	   	       Admin admi = admindao.findByEId(adId);
	   	       List<Employee> listOfEmployee = admi.getEmployees();
	   	    req.getSession().setAttribute("listOfEmployee", listOfEmployee);
	   	    resp.getWriter().print("<h1>"+e.getName()+" data Updated Success Fully</h1>");
	   	    
			req.getRequestDispatcher("EmployeeDashboard.jsp").include(req, resp);
	   	       
		}else {
			resp.getWriter().print("<h1>DO LOGIN FIRST</h1>");
			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
		}
	}
}
