<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register University - Counseling Pulse</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>

<body>
<jsp:include page="navbar.jsp" />
    <div class="register">
   
        <div class="imgg"><img src="images/university.jpg" >
        </div>

        <div class="registerformandhero">
        </div>

        <div class="registerform">
            <form class="box" method="post" action="registeruniversity">
                <h1>Register University</h1>
                <div class="row">
                    <input type="text" name="id" placeholder="ID">
                </div>
                <div class="row">
                    <input type="text" name="universityname" placeholder="University Name">
                </div>
                <div class="row">
                    <input type="password" name="password" placeholder="password">
                </div>
                <input type="submit" value="Register">
            </form>
        </div>
    </div>
</body>

</html>
