<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer form page</title>

<link type="text/css"
	rel="stylesheet" 
	href="${pageContet.request.contextPath}/resources/css/style.css">

<link type="text/css"
	rel="stylesheet" 
	href="${pageContet.request.contextPath}/resources/css/add-customer-style.css">
	
	
</head>
<body>
customer form placeholder

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<table>
			<tbody>
				<tr>
					<td><label>First Name: </label></td>
					<td><form:input path="firstName"/>
				</tr>
				<tr>
					<td><label>Last Name: </label></td>
					<td><form:input path="lastName"/>
				</tr>
				<tr>
					<td><label>email: </label></td>
					<td><form:input path="email"/>
				</tr>
							<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
	
	
			</tbody>
		</table>
		
		</form:form>	

<br/>
	<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
	
	
	</div>


</body>
</html>