<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Customers</title>
	<!-- Reference our style sheet -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 
	<!--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />-->
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>Customer</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
		<!-- put new button: Add Customer -->
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button" />
	
		<!-- add our html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
				<!-- Loop over and print out customers -->
				<c:forEach var="tempCustomer" items="${customers}" >
				
					<!-- Construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<!-- Construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- Dispaly the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure want to delete this'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<div id="content">
			<div>
				<input type="button" value="Role" onclick="window.location.href='showRole'; return false;" class="add-button" />
			</div>
		</div>
	</div>
</div>

</body>
</html>