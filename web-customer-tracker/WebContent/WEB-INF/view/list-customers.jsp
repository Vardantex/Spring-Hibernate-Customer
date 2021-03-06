<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
	
	<!-- Ref stylesheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
	
		<!-- Add button  -->
		<input type="button" value="Add Customer" 
		onclick="window.location.href='showFormForAdd'; return false;" 
		class="add-button" />
	
		<!-- add out html table -->
	
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>action</th>
								
				<!-- Loop over output to print customers -->
				
				<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- Create a update link with customer id using core -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>					
					
					
					<!-- Create a delete link with customer id using core -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>					
					
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						
						<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" 
						onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
						</td>	
						
					</tr>				
				</c:forEach>
			</tr>
		</table>
	
	</div>
</div>	
	
</body>
</html>