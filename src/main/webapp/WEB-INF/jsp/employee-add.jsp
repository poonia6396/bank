<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Admin Portal</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Employee</h3>
	
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Username:</label></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username"></form:errors></td>
					</tr>
				
				
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input type = "password" path="password" /></td>
						<td><form:errors path="password"></form:errors></td>
					</tr>
				
					<tr>
						<td><label>Confirm Password:</label></td>
						<td><form:input type = "password" path="passwordConfirm" /></td>
						<td><form:errors path="passwordConfirm"></form:errors></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admin/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>
