<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<p style="text-align:center;font-size: 15pt">Hello Admin ${username }</p>
    <script src="Script.js"></script>
    <div class="area">
        <div class="request-card">
            <h3><i class="fa fa-bell"></i> Counselor Requests</h3>
            <p>View and manage requests from counselors.</p>
        </div>
        <div class="help-desk-card">
            <h3><i class="fa fa-info-circle"></i> Student Help Desk</h3>
            <p>Provide assistance to students and address their inquiries.</p>
        </div>
        <div class="help-desk-card">
            <h3><i class="fa fa-info-circle"></i> Add Counsellor</h3>
            <p>Provide assistance to students and address their inquiries.</p>
            <a href="registerCounseller">Add a Counselor</a> <!-- Add this line -->
        </div>
        <div class="help-desk-card">
            <h3><i class="fa fa-info-circle"></i> Add University</h3>
            <p>Add new Universities</p>
            <a href="registerUniversity">Add University</a> <!-- Add this line -->
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
                <a href="#">
                    <i class="fa fa-list fa-2x"></i>
                    <span class="nav-text">
          
                        Counselors List
                    </span>
                </a>
            </li>
            <li class="has-subnav">
                <a href="#">
                    <i class="fa fa-list fa-2x"></i>
                    <span class="nav-text">
                        Students Lists
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
</body>
</html>
