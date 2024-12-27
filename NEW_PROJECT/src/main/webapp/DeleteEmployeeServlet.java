package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dto.Admin;
import com.dto.Employee;
import com.dto.Student;

@WebServlet("/deleteEmployee")
public class DeleteStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin =(Admin) req.getSession().getAttribute("admin");
		if(admin!=null) {
		int empid =Integer.parseInt(req.getParameter("id")) ;
		// find student by id
		EmployeeDao employeeDao = new StudentDao();
		Employee employee = employeeDao.findById(empid);
		resp.getWriter().print("<h1> "+employee.getName()+" Deleted Successfully<h1/>");
		int adId = admin.getId();
		AdminDao adminDao = new AdminDao();
		 Admin admId = adminDao.findByEId(adId);
		 List<Student> listOfEmployee = admId.getStudents();
		 req.getSession().setAttribute("listOfEmployee", listOfEmployee);
		 req.getRequestDispatcher("EmployeeDashboard.jsp").include(req, resp);
		
		studentdao.deleteStudent(student);
		}else {
			resp.getWriter().print("<h1>DO LOGIN FIRST</h1>");
			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
		}
	}
}
