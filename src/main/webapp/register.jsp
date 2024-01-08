<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Counseling Pulse</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <style type="text/css">
    #password-strength {
        margin-top: 5px;
    }

    .strong {
        color: green;
    }

    .medium {
        color: orange;
    }

    .weak {
        color: red;
    }
</style>
    
    <script type="text/javascript">
    function checkPasswordStrength() {
        var password = document.getElementById("password").value;
        var strengthBadge = document.getElementById("strengthBadge");

        // Define the regular expressions for different password strengths
        var strongRegex = /^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&]).*$/;
        var mediumRegex = /^(?=.{6,})(?=.*\d)(?=.*[a-z]).*$/;

        if (strongRegex.test(password)) {
            strengthBadge.className = "strong";
            strengthBadge.innerHTML = "Strong";
        } else if (mediumRegex.test(password)) {
            strengthBadge.className = "medium";
            strengthBadge.innerHTML = "Medium";
        } else {
            strengthBadge.className = "weak";
            strengthBadge.innerHTML = "Weak";
        }
    }
</script>
    
</head>

<body>
 <jsp:include page="navbar.jsp" />
    <div class="register">
        <div class="imgg"><img src="images/register_1.png" >
        </div>

        <div class="registerformandhero">
            </div>

            <div class="registerform">
                <form class="box" method="post" action="registeruser">
                    <h1>Register</h1>
                    <div class="row">
                        <input type="text" name="username" placeholder="Username">
                        <input type="email" name="email" placeholder="Email">
                    </div>
                    <div class="row">
                        <input type="password" name="password" placeholder="Password" onkeyup="checkPasswordStrength()">
                        <input type="password" name="confirmPassword" placeholder="Confirm Password">
                    </div>
                    
                    <div class="row">
                        <select name="college">
					    <option value="" disabled selected>Select College</option>
					    <c:forEach items="${unilist}" var="university">
					        <option value="${university.name}"><c:out value="${university.name}" /></option>
					    </c:forEach>
					</select>
					<select name="gender">
					    <option value="" disabled selected>Select Gender</option>
					    <option value="Male">Male</option>
					    <option value="Female">Female</option>
					</select>
                    </div>
                    <input type="submit" value="Register">
                </form>
            </div>
        </div>
    </div>
</body>

</html>
