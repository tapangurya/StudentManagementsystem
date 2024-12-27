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

@WebServlet("/deleteEmployee")
public class DeleteEmpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin =(Admin) req.getSession().getAttribute("admin");
		if(admin!=null) {
		int empid =Integer.parseInt(req.getParameter("id")) ;
		// find student by id
		EmployeeDao empdao = new EmployeeDao();
		Employee emp = empdao.findByEId(empid);
		resp.getWriter().print("<h1> "+emp.getName()+" Deleted Successfully<h1/>");
		int adId = admin.getId();
		AdminDao adminDao = new AdminDao();
		 Admin admId = adminDao.findByEId(adId);
		 List<Employee> listOfEmployee = admId.getEmployees();
		 req.getSession().setAttribute("listOfEmployee", listOfEmployee);
		 req.getRequestDispatcher("EmployeeDashboard.jsp").include(req, resp);
		
		 empdao.deleteEmployee(emp);
		}else {
			resp.getWriter().print("<h1>DO LOGIN FIRST</h1>");
			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
		}
	}
}
