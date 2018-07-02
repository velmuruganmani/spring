<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Role</title>
	<!-- Reference our style sheet -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 
	<!--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" /> -->
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>Role</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<table>
			<tr>
				<th>Description</th>
				<c:forEach var="tempRole" items="${role}" >
					<tr>
						<td>${tempRole.description}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>

</body>
</html>