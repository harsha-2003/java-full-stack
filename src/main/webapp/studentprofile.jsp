<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Profile</title>
    <link rel="stylesheet" href="css/StudentProfile.css">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
</head>
<body>
	<p style="text-align:center;font-size: 15pt">Hi ${username}</p>
	
    <div class="area">
        <div class="buttons">
            <button type="button"><i class="fa fa-user fa-2x"></i> View Profile</button>
            <button type="button"><i class="fa fa-comment fa-2x"></i> Chat </button>
            <button type="button"><i class="fa fa-bell fa-2x"></i> Notices</button>
        </div>
        <div class="notices">
            <c:forEach items="${nlist}" var="list">
    <div class="notice-card">
        <h3>${list.title}</h3>
        <p>${list.content}</p>

        <!-- Create a button to download the file -->
        <a href="/downloadFile/${list.id}" class="btn btn-primary" role="button">Download File</a>

        <div class="status">
            <span class="status-label">Status:</span>
            <span class="status-value" onclick="toggleStatus(this)">Done</span>
        </div>
    </div>
</c:forEach>
            <div class="notice-card">
                <h3>Submission of reports and certificates</h3>
                <p>Student must submit there all their records and previous high school records <br> And should upload in the message section </p>
                <div class="status">
                    <span class="status-label">Status:</span>
                    <span class="status-value" onclick="toggleStatus(this)">Done</span>
                </div>
                <div class="notice-actions">
                    <!-- <button type="button"><i class="fa fa-pencil"></i> Update</button> -->
                    <!-- <button type="button"><i class="fa fa-trash-o"></i> Delete</button> -->
                </div>
            </div>
            
            <div class="notice-card">
                <h3>Registration semester 1</h3>
                <p>Registration of sem 1 on 12/07/2023 (offline) <br>Check out the code, time, and place in chat, message for further details </p>
                <div class="status">
                    <span class="status-label">Status:</span>
                    <span class="status-value" onclick="toggleStatus(this)">Done</span>
                </div>
                <div class="notice-actions">
                    <!-- <button type="button"><i class="fa fa-tick"></i> Update</button> -->
                    <!-- <button type="button"><i class="fa fa-trash-o"></i> Delete</button> -->
                </div>
            </div>
            
            <!-- Add more notice cards as needed -->
        </div>
    </div>
    <nav class="main-menu">
        <ul>
            <li>
                <a href="#">
                    <i class="fa fa-user fa-2x"></i>
                    <span class="nav-text">
                        Profile
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-bell fa-2x"></i>
                    <span class="nav-text">
                        Notices
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-comments fa-2x"></i>
                    <span class="nav-text">
                        Chat
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-comments fa-2x"></i>
                    <span class="nav-text">
                        ${counselor}
                    </span>
                </a>
            </li>
            <!-- Add more navigation items specific to student profile -->
        </ul>
        <ul class="logout">
            <li>
                <a href="Home.html">
                    <i class="fa fa-power-off fa-2x"></i>
                    <span class="nav-text">
                        Logout
                    </span>
                </a>
            </li>  
        </ul>
    </nav>
    <script>
        function toggleStatus(element) {
            const currentValue = element.textContent;
            element.textContent = currentValue === 'Done' ? 'Pending' : 'Pending';
            
            // Toggle color for status
            if (element.textContent === 'Pending' ) {
                element.style.color = '#ff5733'; // Green for "Done"
            } else {
                element.style.color = '#00a300'; // Orange for "Pending"
            }
        }
    </script>
</body>
</html>
