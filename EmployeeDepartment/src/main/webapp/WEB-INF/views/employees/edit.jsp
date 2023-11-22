<%@page import="com.valtech.EmployeeDepartment.models.EmployeeModels"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%EmployeeModels employees = (EmployeeModels) request.getAttribute("employees"); %>
<form method="post" action="save?id=<%= employees.getId()%>">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id" value="<%= employees.getId()%>"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name" value="<%= employees.getName()%>"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="<%= employees.getAge()%>"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" value="<%= employees.getExperience()%>"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority" value="<%= employees.getSeniority()%>"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="<%= employees.getSalary()%>"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department" value="<%= employees.getDepartment().getId()%>"/></td>
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