<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Save Customer</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/add-customer-style.css" />" rel="stylesheet">

<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/> --%>

<style>
      .error {
         color: #ff0000;
      }
</style>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>Customer Form</h2>
	</div>
</div>

<div id="container">
	<h3>Save Customer</h3>
	
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	<!-- Need to associate this data with customer id -->
	<form:hidden path="id"/>
	
		<table>
			<tbody>		
				<tr>				
					<td><label>First Name</label></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors  path="firstName" cssClass = "error"/></td>			
				</tr>
				
				<tr>
					<td><label>Last Name</label></td>
					<td><form:input path="lastName" /></td>
					<td></td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass = "error"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" Class="save"/></td>
				</tr>
			</tbody>
		</table>	
	</form:form>
<div style="clear; both;"></div>
<p><a href="<c:url value="/customer/list"/>">Back to List</a></p>
<%--<p><a href="${pageContext.request.contextPath}/customer/list">Back to List</a></p> --%>
</div>

</body>
</html>