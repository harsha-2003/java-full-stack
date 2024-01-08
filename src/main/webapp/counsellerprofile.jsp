<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/CounsellerProfile.css">
</head>
<body>

    <script src="Script.js"></script>
    <div class="area">
        <div class="buttons">
            <a href="addnotice">
    <button type="button">
        <i class="fa fa-plus fa-2x"></i> Add Notice
    </button>
</a>

            <button type="button"><i class="fa fa-trash-o fa-2x"></i> Delete Notice</button>
            <button type="button"><i class="fa fa-pencil fa-2x"></i> Update Notice</button>
        </div>

        <div class="notices">
        	<c:forEach items="${nlist}" var="list">
        		<div class="notice-card">
                <h3>${list.title}</h3>
                <p>${list.content}</p>
                <div class="notice-actions">
                    <button type="button"><i class="fa fa-pencil"></i> Update</button>
                    <!-- <button type="button"><i class="fa fa-trash-o"></i> Delete</button> -->
                </div>
            </div>
			</c:forEach>
            <div class="notice-card">
                <h3>Submission of reports and certificates</h3>
                <p>Student must submit there all their records and previous high school records <br> And should upload in the message section </p>
                <div class="notice-actions">
                    <button type="button"><i class="fa fa-pencil"></i> Update</button>
                    <!-- <button type="button"><i class="fa fa-trash-o"></i> Delete</button> -->
                </div>
            </div>

            <div class="notice-card">
                <h3>Registration semester 1</h3>
                <p>Registration of sem 1 on 12/07/2023 (offline) <br>Check out the code, time, and place in chat, message for further details </p>
                <div class="notice-actions">
                    <button type="button"><i class="fa fa-pencil"></i> Update</button>
                    <!-- <button type="button"><i class="fa fa-trash-o"></i> Delete</button> -->
                </div>
            </div>
            
            <!-- Add more notice cards as needed -->
        </div>
    </div>

    <nav class="main-menu">
        <ul>
            <li>
                <a href="https://jbfarrow.com">
                    <i class="fa fa-user fa-2x"></i>
                    <span class="nav-text">
                        Profile
                    </span>
                </a>
            </li>
            <li>
                <a href="">
                    <i class="fa fa-pencil fa-2x"></i>
                    <span class="nav-text">
                        Notices status
                    </span>
                </a>
            </li>
            <li class="has-subnav">
                <a href="#">
                    <i class="fa fa-globe fa-2x"></i>
                    <span class="nav-text">
                        Student Requests
                    </span>
                </a>
            </li>
            <li>
                <a href="studentList">
                    <i class="fa fa-film fa-2x"></i>
                    <span class="nav-text">
                        Student Records
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-report fa-2x"></i>
                    <span class="nav-text">
                        Send Report
                    </span>
                </a>
            </li>
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
        // JavaScript code for handling the notice form visibility
        document.addEventListener("DOMContentLoaded", function () {
            const addNoticeBtn = document.getElementById("addNoticeBtn");
            const noticeForm = document.getElementById("noticeForm");
            const cancelNoticeBtn = document.getElementById("cancelNoticeBtn");

            addNoticeBtn.addEventListener("click", () => {
                noticeForm.style.display = "block"; // Show the form
            });

            cancelNoticeBtn.addEventListener("click", () => {
                noticeForm.style.display = "none"; // Hide the form
            });

            // Example data and logic for submitting the form
            // ... (Keep the rest of the JavaScript code as provided in the previous responses)
        });
    </script>
</body>
</html>
