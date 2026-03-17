<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Employee</title>
</head>
<body>

<form action="addemp" method="post">
    <table>

        <tr>
            <td>Employee ID :</td>
            <td><input type="text" name="empId"></td>
        </tr>

        <tr>
            <td>Name :</td>
            <td><input type="text" name="empName"></td>
        </tr>

        <tr>
            <td>Email :</td>
            <td><input type="email" name="empEmail"></td>
        </tr>

        <tr>
            <td>Contact No :</td>
            <td><input type="text" name="empContactNo"></td>
        </tr>

        <tr>
            <td>City :</td>
            <td><input type="text" name="empCity"></td>
        </tr>

        <tr>
            <td><input type="submit" value="Add Employee"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>

    </table>
</form>

</body>
</html>