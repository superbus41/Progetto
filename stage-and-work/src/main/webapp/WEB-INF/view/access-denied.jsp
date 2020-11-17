<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Stage&Work - Access Denied</title>
</head>

<body>
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role: <security:authentication property="principal.authorities"/>
	</p>
	
	<h2>Access Denied - Not Authorized</h2>
	<hr>
	<a href="${pageContext.request.contextPath}/home">Back to Homepage</a>
		
</body>

</html>