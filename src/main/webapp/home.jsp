<%@ page import="java.util.List" %>
<%@ page import="com.capgemini.training.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

<a href="addemp">Register Emp</a>

<h2>View All Employees</h2>

<!-- 🔍 SEARCH BOX -->
<form action="search" method="get">
    <input type="text" name="keyword" 
           placeholder="Search by name or email"
           value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : "" %>">
    <input type="submit" value="Search">
</form>

<br>

<%
List<Employee> listOfEmp = (List<Employee>) request.getAttribute("emplist");
String msg = (String) request.getAttribute("message");
%>

<!-- ❌ SHOW MESSAGE IF NO RESULT -->
<%
if(msg != null){
%>
    <h3 style="color:red;"><%= msg %></h3>
<%
}
%>

<table border="1">

<tr>
    <th>ID</th>
    <th>Emp ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Contact No</th>
    <th>City</th>
    <th>View</th>
    <th>Edit</th>
    <th>Delete Action</th>
</tr>

<%
if(listOfEmp != null && !listOfEmp.isEmpty()){
    for(Employee emp : listOfEmp){
%>

<tr>
    <td><%= emp.getId() %></td>
    <td><%= emp.getEmpId() %></td>
    <td><%= emp.getEmpName() %></td>
    <td><%= emp.getEmpEmail() %></td>
    <td><%= emp.getEmpContactNo() %></td>
    <td><%= emp.getEmpCity() %></td>

    <!-- VIEW -->
    <td>
        <a href="view-emp?empid=<%= emp.getId() %>">View</a>
    </td>

    <!-- EDIT -->
    <td>
        <a href="editemp?id=<%= emp.getId() %>">Edit</a>
    </td>

    <!-- DELETE -->
    <td>
        <a href="deleteemp?id=<%= emp.getId() %>"
           onclick="return confirm('Are you sure you want to delete?')">
           Delete
        </a>
    </td>

</tr>

<%
    }
} else {
%>

<!-- ❌ IF NO DATA -->
<tr>
    <td colspan="9" style="text-align:center; color:red;">
        No employees found
    </td>
</tr>

<%
}
%>

</table>

</body>
</html>