<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Stage&Work Home Page</h2>
	<hr>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role: <security:authentication property="principal.authorities"/>
		<br><br>
	</p>
	<security:authorize access="hasRole('COMPANY')">
		<a href="${pageContext.request.contextPath}/stage/new">Nuova offerta di Stage</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/work/new">Nuova offerta di Lavoro</a>
		<br><br>
	</security:authorize>
	<a href="${pageContext.request.contextPath}/stage/list">Lista offerte di stage</a>
	<br><br>
	<a href="${pageContext.request.contextPath}/work/list">Lista offerte di Lavoro</a>
	<br><br>
	<security:authorize access="hasRole('UNIVERSITY')">
		<a href="${pageContext.request.contextPath}/event/new">Nuovo evento</a>
		<br><br>
	</security:authorize>
	<a href="${pageContext.request.contextPath}/event/list">Lista eventi</a>
	<br><br>
	
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<input type="submit" value="Logout">			
	</form:form>

</body>

</html>