<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Employee</title>
</head>
<body>
<form method="post" action="save">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Create"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>