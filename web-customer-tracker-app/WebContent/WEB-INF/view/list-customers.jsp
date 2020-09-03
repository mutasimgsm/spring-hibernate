<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer list</title>
	<style>
	
		table {
			border: none;
			font-size: 16px;
		}
		
		tr th, tr td {
			padding: 10px;
		}
		
		tr th {
			color: #fff;
			background: blue;
		}
		
		tr td {
			color: #fff;
			background: green;
		}
		
		 a {
			color: #fff;
			font-weight: bold;
		}
	</style>
	
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
</head>
<body>

<div class="list-container">
<h3>CRM - Customer Relationship Manager</h3>

<h3>
	<a href="addForm" style="background: blue; font-weight: bold; color: #fff; padding: 5px;">Add New</a>
</h3>
<table class="list">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="customer" items="${customers}">
	
	<!-- construct an update link with customer id -->
	<c:url var="updateLink" value="/customer/updateCustomer">
		<c:param name="customerId" value="${customer.id}"/>
	</c:url>
	
	<!-- construct a delete link with customer id -->
	<c:url var="deleteLink" value="/customer/deleteCustomer">
		<c:param name="customerId" value="${customer.id}"/>
	</c:url>
	
		<tr>
			<td>${customer.firstName}</td>
			<td>${customer.lastName}</td>
			<td>${customer.email}</td>
			<td>
				<a href="${updateLink}">Update</a>
				|
				<a href="${deleteLink}"
				onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
				>
				Delete
				</a>
			</td>
		</tr>
	</c:forEach>
		
	</tbody>
</table>
</div>
</body>
</html>