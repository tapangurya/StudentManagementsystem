<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Sign-Up</title>
<style>
/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-image: url("city-committed-education-collage-concept.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0;
    height: 100vh;
}

.navbar {
    width: 100%;
    background-color: rgba(0, 0, 0, 0.7);
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    position: fixed;
    top: 0;
    z-index: 1000;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
}

.navbar a {
    text-decoration: none;
    color: white;
    margin: 0 15px;
    font-size: 18px;
}

.navbar a:hover {
    color: #00ff99;
}

.navbar .nav-buttons {
    display: flex;
    align-items: center;
}

.navbar .nav-buttons a {
    background-color: #007BFF;
    color: white;
    padding: 8px 15px;
    border-radius: 5px;
    margin-left: 10px;
    transition: background-color 0.3s ease;
}

.navbar .nav-buttons a:hover {
    background-color: #0056b3;
}

/* Image Slider */
.slider-container {
    width: 100%;
    margin-top: 10px; /* To avoid overlap with navbar */
    overflow: hidden;
    height:100%;
}

.slider {
    display: flex;
    width: 100%; /* Number of images x 100% */
    animation: slide 12s infinite;
}

.slider img {
    width: 100%;
    
    flex-shrink: 0;
}

@keyframes slide {
    0% { transform: translateX(0%); }
    33% { transform: translateX(-100%); }
    66% { transform: translateX(-200%); }
    100% { transform: translateX(0%); }
}

/* Form Container */
.container {
    margin-top: 100px; /* Adjust for navbar */
    border: 2px solid #04f749;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 4px 15px #0400fd81;
    background-color: transparent;
    backdrop-filter: blur(5px);
    width: 350px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

/* Form Styles */
.title-box {
    display: inline-block;
    padding: 5px 10px;
    background-color: transparent;
    box-shadow: 0 0 20px rgba(3, 197, 39, 0.5);
    border-radius: 8px;
    margin-bottom: 10px;
}

.p_title {
    font-size: 20px;
    font-weight: bold;
    color: #0008ff;
    text-align: center;
}

.form-group {
    margin-bottom: 20px;
    width: 100%;
    padding: 5px;
    box-sizing: border-box;
}

label {
    margin-bottom: 5px;
    display: block;
    color: #2200ff;
}

input[type="text"], input[type="email"], input[type="password"] {
    width: 90%;
    padding: 7px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 0 20px rgba(0, 123, 255, 0.5);
    background-color: #9fb9d6;
}

input[type="submit"], input[type="reset"] {
    padding: 5px 10px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    width: 45%;
}

input[type="submit"] {
    background-color: #007BFF;
    color: white;
}

input[type="reset"] {
    background-color: #dc3545;
    color: white;
}

.login-link {
    color: #00ff99;
    text-align: center;
}

#form-button {
    display: flex;
    justify-content: space-between;
}
</style>
</head>
<body>
    <!-- Navbar -->
    <div class="navbar">
        <div class="nav-links">
            <a href="home.jsp">Home</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </div>
        <div class="nav-buttons">
            <a href="adminLogin.jsp">Login</a>
            <a href="adminSignup.jsp">Signup</a>
        </div>
    </div>

    <!-- Image Slider -->
    <div class="slider-container">
        <div class="slider">
            <img src="background-learner1.jpg" alt="Image 1">
            <img src="Main_132798919141988502.jpg" alt="Image 2">
            <img src="student.jpg" alt="Image 3">
        </div>
    </div>
    

</body>
</html>
