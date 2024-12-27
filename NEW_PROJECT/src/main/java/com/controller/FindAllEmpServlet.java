package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dto.Admin;
import com.dto.Employee;
@WebServlet("/findAllEmp")
public class FindAllEmpServlet  extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = (Admin)req.getSession().getAttribute("admin");
		if(admin!=null) {
			int adminId = admin.getId();
			AdminDao admindao= new AdminDao();
			Admin adminID=admindao.findByEId(adminId);
			List<Employee> listOfEmployee = adminID.getEmployees();
			req.getSession().setAttribute("listOfEmployee", listOfEmployee);
			req.getRequestDispatcher("EmployeeDashboard.jsp").include(req, resp);
			}else {
			 resp.getWriter().print("<h1>DO LOGIN FIRST</h1>");
			 req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
		}
	}

}
