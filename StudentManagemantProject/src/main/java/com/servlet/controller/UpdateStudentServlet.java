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
import com.dto.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		updateStudent?id=8&name=TapanGurya&dob=2002-07-27&ph=9382401072
		
	Admin admin = (Admin) req.getSession().getAttribute("ad");
   	 if(admin!=null) {
   		 int id = Integer.parseInt(req.getParameter("id"));
   		 	String name = req.getParameter("fname");
   	        Long phone = Long.parseLong(req.getParameter("ph")) ;
   	        String dob = req.getParameter("dob");
   	  // find Student object
   	        StudentDao studentdao= new StudentDao();
   	        Student s= studentdao.findById(id);
   	        s.setDOB(dob);
   	        s.setName(name);
   	        s.setPhone(phone);
   	        // supdate
   	        studentdao.createStudent(s);
   	        
   	        int adId = admin.getId();
   	        AdminDao admindao= new AdminDao();
   	       Admin admi = admindao.findByEId(adId);
   	       List<Student> listOfStudent = admi.getStudents();
   	    req.getSession().setAttribute("listOfStudent", listOfStudent);
   	    resp.getWriter().print("<h1>"+s.getName()+" data Updated Success Fully</h1>");
   	    
		req.getRequestDispatcher("studentDashboard.jsp").include(req, resp);
   	       
	}else {
		resp.getWriter().print("<h1>DO LOGIN FIRST</h1>");
		req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
	}

}
}
