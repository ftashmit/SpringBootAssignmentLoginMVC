<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.capgemini.training.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
<a href="register-emp.jsp">Register Emp</a>
<h2>View All Employees</h2>

<%
    List<Employee> listOfEmp = (List<Employee>) request.getAttribute("emplist");
%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Emp ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No</th>
        <th>City</th>
    </tr>

<%
    if(listOfEmp != null){
        for(Employee emp : listOfEmp){
%>
    <tr>
        <td><%= emp.getId() %></td>
        <td><%= emp.getEmpId() %></td>
        <td><%= emp.getEmpName() %></td>
        <td><%= emp.getEmpEmail() %></td>
        <td><%= emp.getEmpContactNo() %></td>
        <td><%= emp.getEmpCity() %></td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>