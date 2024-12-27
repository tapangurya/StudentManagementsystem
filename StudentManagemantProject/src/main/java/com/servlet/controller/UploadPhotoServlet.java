package com.servlet.controller;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.AdminDao;
@WebServlet("/uploadPhoto")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class UploadPhotoServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "profile_photos";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        // Create directory if not exists
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Retrieve the uploaded file
        Part filePart = request.getPart("profile-photo");
        String fileName = filePart.getSubmittedFileName();
        String filePath = uploadPath + File.separator + fileName;

        // Save the file to the server
        filePart.write(filePath);

        // Update the file path in the database for the logged-in user
        String email = (String) request.getSession().getAttribute("userEmail");
        AdminDao adminDao = new AdminDao();
		// Assuming you have a method to update the DB:
        adminDao.updateProfilePhoto(email, UPLOAD_DIR + "/" + fileName);

        response.sendRedirect("adminDashBorad.jsp");
    }
}

