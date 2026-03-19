<%@ page import="com.capgemini.training.entity.Employee" %>

<%
Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>

<form action="updateemp" method="post">
    <table>

        <!-- Hidden ID -->
        <input type="hidden" name="id" value="<%= emp.getId() %>">

        <tr>
            <td>Employee ID :</td>
            <td><input type="text" name="empId" value="<%= emp.getEmpId() %>"></td>
        </tr>

        <tr>
            <td>Name :</td>
            <td><input type="text" name="empName" value="<%= emp.getEmpName() %>"></td>
        </tr>

        <tr>
            <td>Email :</td>
            <td><input type="email" name="empEmail" value="<%= emp.getEmpEmail() %>"></td>
        </tr>

        <tr>
            <td>Contact No :</td>
            <td><input type="text" name="empContactNo" value="<%= emp.getEmpContactNo() %>"></td>
        </tr>

        <tr>
            <td>City :</td>
            <td><input type="text" name="empCity" value="<%= emp.getEmpCity() %>"></td>
        </tr>

        <tr>
            <td><input type="submit" value="Update Employee"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>

    </table>
</form>

</body>
</html>