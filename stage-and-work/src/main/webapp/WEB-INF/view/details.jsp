<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<title>Dettagli</title>
	</head>

	<body>
	<c:choose>
		<c:when test="${!empty event}">
			<c:set var="title" value="${event.title}"/>
			<c:set var="description" value="${event.details.description}"/>
		</c:when>
		<c:when test="${!empty stage}">
			<c:set var="title" value="${stage.title}"/>
			<c:set var="description" value="${stage.details.description}"/>
		</c:when>
		<c:when test="${!empty work}">
			<c:set var="title" value="${work.title}"/>
			<c:set var="description" value="${work.details.description}"/>
		</c:when>
	</c:choose>
	<br><br>
	Titolo:
	<br>
	${title}
	<br><br>
	Descrizione: 
	<br>
	${description}
	<br><br>
	<button type="button" name="back" onclick="history.back()">Back</button>
	<br><br>
	<a href="list">To list</a>
	</body>
</html>