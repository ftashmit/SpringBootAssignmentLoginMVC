<%@ page import="com.capgemini.training.entity.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee</title>
</head>

<body >

    <h2 align="center">View Employee Details</h2>

    <table align="center" border="1">
        <tr>
            <td>Emp Id</td>
            <td><%= emp.getEmpId() %></td>
        </tr>

        <tr>
            <td>Emp Name</td>
            <td><%= emp.getEmpName() %></td>
        </tr>

        <tr>
            <td>Emp Email</td>
            <td><%= emp.getEmpEmail() %></td>
        </tr>

        <tr>
            <td>Emp Contact No</td>
            <td><%= emp.getEmpContactNo() %></td>
        </tr>

        <tr>
            <td>Emp City</td>
            <td><%= emp.getEmpCity() %></td>
        </tr>
    </table>

</body>
</html>