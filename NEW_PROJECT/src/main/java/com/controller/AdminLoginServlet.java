package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dto.Admin;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        
        AdminDao adao = new AdminDao();
        Admin admin = adao.findByEmail(email);
        
        if (admin != null) {
            if (admin.getPassword().equals(pass)) {
                // Login successful
                resp.getWriter().print("<h1>Login Successfully: " + admin.getEmail() + "</h1>");
                HttpSession hs = req.getSession();
                hs.setAttribute("admin", admin);
                req.getRequestDispatcher("admindashBorad.jsp").include(req, resp);
            } else {
                // Incorrect password
                resp.getWriter().print("<h1>Incorrect Password</h1>");
                req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
            }
        } else {
            // Admin not found
            resp.getWriter().print("<h1>Register first</h1>");
            req.getRequestDispatcher("adminSignup.jsp").include(req, resp);
        }
    }
}
