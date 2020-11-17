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
	</p>
	<security:authorize access="hasRole('COMPANY')">
		<a href="${pageContext.request.contextPath}/newOffer">Publica una nuova offerta</a>
		<br><br>
	</security:authorize>
	<a href="${pageContext.request.contextPath}/listOffer">Ricerca offerte</a>
	<br><br>
	<security:authorize access="hasRole('UNIVERSITY')">
		<a href="${pageContext.request.contextPath}/event/new">Crea un nuovo evento</a>
		<br><br>
	</security:authorize>
	<a href="${pageContext.request.contextPath}/event/list">Ricerca eventi</a>
	<br><br>
	
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<input type="submit" value="Logout">			
	</form:form>

</body>

</html>