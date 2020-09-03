<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Customer Form</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="form-container">
		<h2>Customer Form</h2>
		<i>Fill out the form. Asterisk <span>*</span> means required.
		</i> <br>
		<br>

		<form:form action="submitCustomer" modelAttribute="customer">
			<form:hidden path="id" />
			
		<table class="form">
			<tbody>
				<tr>
					<td>First name <span>*</span>:</td>
					<td><form:input path="firstName" class="form-control"/></td>
					<form:errors path="firstName" cssClass="error" />
				</tr>	
				<tr>
					<td>Last name <span>*</span>:</td>
					<td><form:input path="lastName" class="form-control"/></td>
					<form:errors path="lastName" cssClass="error" />
				</tr>
				<tr>
					<td>Email <span>*</span>:</td>
					<td><form:input path="email" class="form-control"/></td>
					<form:errors path="email" cssClass="error" />
				</tr>
				<tr>
					<td></td><td><input type="submit" value="Submit" class="form-control" style="width: 50%; background: blue; color: white"/></td>
				</tr>		
			</tbody>
		</form:form>
		
		</table>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>
	</div>
</body>
</html>