<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Eventi</title>
	
	<!-- reference our style sheet -->
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista Eventi</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
					
			<form:form action="search" method="GET">
                Cerca Evento: <input type="text" name="searchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th></th>
					<th>Settore</th>
					<th></th>
					<th>Data</th>
					<th></th>
					<th>Luogo</th>
					<th></th>
					<th>Azioni</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempEvent" items="${events}">
					
					<c:url var="detailsLink" value="/event/details">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="updateLink" value="/event/update">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/event/delete">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="subscribeLink" value="/event/subscribe">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="unsubscribeLink" value="/event/unsubscribe">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					
					<tr>
						<td> <a href="${detailsLink}">${tempEvent.title}</a></td>
						<td></td>
						<td> ${tempEvent.sector} </td>
						<td></td>
						<td> ${tempEvent.date} </td>
						<td></td>
						<td> ${tempEvent.place} </td>
						<td></td>
						
						<security:authorize access="hasRole('UNIVERSITY')">
							<td> <a href="${updateLink}">Update</a>
							<a href="${deleteLink}"	onclick="if (!(confirm('Sei sicuro di voler eliminare l'evento?\n(Permanente)'))) return false">Elimina</a></td>
						</security:authorize>
						
						<security:authorize access="hasRole('STUDENT')">
							<security:authentication var="username" property="principal.username"/>
							<c:set var="subbed" scope="page" value="false"/>
							<c:forEach var="sub" items="${tempEvent.subs}">
								<c:if test="${username eq sub.user.username}">
									<c:set var="subbed" value="true"/>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${!subbed}"><td><a href="${subscribeLink}">Iscrivi</a></td></c:when>
								<c:otherwise><td><a href="${unsubscribeLink}">Disiscrivi</a></td></c:otherwise>
							</c:choose>
						</security:authorize>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/home">Homepage</a>
		</p>
	</div>
	

</body>

</html>
