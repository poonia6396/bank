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
			<h2>Employee Portal</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Account</h3>
	
		<form action="saveAccount"  method="POST">
			
			<input type="hidden" name="customerId" value="${customerId}"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!-- need to associate this data with customer id -->
			
			<table>
				<tbody>
					<tr>
						<td><label>Account Type:</label></td>
						<td><input type="text" name="accountType" /></td>
					</tr>
				
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/employee/listAccounts">Back to List</a>
		</p>
	
	</div>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="add-button" />
	
	</form:form>
</body>

</html>
