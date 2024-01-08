<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="border-collapse: collapse; width: 100%;">
    <tr style="background-color: #f9f9f9;">
        <th style="border: 1px solid #ccc; padding: 10px; text-align: left;">Name</th>
        <th style="border: 1px solid #ccc; padding: 10px; text-align: left;">ID</th>
        <th style="border: 1px solid #ccc; padding: 10px; text-align: left;">Email</th>
        <th style="border: 1px solid #ccc; padding: 10px; text-align: left;">Photo</th>
        <th style="border: 1px solid #ccc; padding: 10px; text-align: left;">Records</th>
    </tr>
    <c:forEach items="${slist}" var="student">
        <tr>
            <td style="border: 1px solid #ccc; padding: 10px;">${student.name}</td>
            <td style="border: 1px solid #ccc; padding: 10px;">${student.id}</td>
            <td style="border: 1px solid #ccc; padding: 10px;">${student.email}</td>
            <td style="border: 1px solid #ccc; padding: 10px;">[Photo]</td>
            <td style="border: 1px solid #ccc; padding: 10px;">
                <a href="<Your_Records_Link_Here">View Records</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>