<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Accounts</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/common.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Portal</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
		

			
			
				<form:form action="${pageContext.request.contextPath}/employee/showFormForAddAccount" 
			   method="POST">
					<input type="hidden" name="customerId" value="${customerId}"/>
					<input type="submit" value="Add Account" class="add-button" />
	
			</form:form>
			
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Account Number</th>
					<th>Type</th>
					<th>Balance</th>
					<th>Action</th>
					
				</tr>
				
				<!-- loop over and print our Accounts -->
				<c:forEach var="tempAccount" items="${accounts}">
				
					<!-- construct an "update" link with Account id -->
					<c:url var="deleteLink" value="/employee/deleteAccount">
						<c:param name="accountId" value="${tempAccount.id}" />
					</c:url>
					
					<tr>
						<td> ${tempAccount.id} </td>
						<td> ${tempAccount.accountType} </td>
						<td> ${tempAccount.accountBalance} </td>
						
						
						
							<td>
							
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this Account?'))) return false">Delete</a>
								
							</td>
							
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<p></p>
		
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="add-button" />
	
	</form:form>

</body>

</html>









