<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Counselling Pulse</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css">
    
</head>

<body>
<%@ include file="navbar.jsp" %>
    <div class="login">
        <div class="imgg"><img src="images/Login-amico.png"></div>
        <div class="loginhero">
            <div class="boxlog">
                <form class="box" method="post" action="userdashboard">
                    <h1>Login</h1>
                    <input type="text" name="email" placeholder="Email">
                    <input type="password" name="pwd" placeholder="Password">
                    <input type="submit" name="" value="Login">
                    <a href="" type="link">Forgot Password</a>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
