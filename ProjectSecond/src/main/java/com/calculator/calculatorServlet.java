package com.calculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cal")
public class calculatorServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int number1=Integer.parseInt(req.getParameter("num1"));
		 int number2=Integer.parseInt(req.getParameter("num2"));
		 
		 
		 HttpSession rs = req.getSession();
		 rs.setAttribute("number1",number1);
		 rs.setAttribute("number2",number2);
		 
		 
		 
		 
		 
		
		 
		 resp.getWriter().print("<h1>CALCULATOR Dashboard" + number1+"</h1>");
		 req.getRequestDispatcher("calDashboard.jsp").include(req, resp);
	}

}
