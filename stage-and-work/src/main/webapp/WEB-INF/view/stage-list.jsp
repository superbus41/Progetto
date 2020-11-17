<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Stage</title>
	
	<!-- reference our style sheet -->
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista Stage</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
					
			<form:form action="searchStage" method="GET">
                Cerca Stage: <input type="text" name="searchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th></th>
					<th>Settore</th>
					<th></th>
					<th>Tipo</th>
					<th></th>
					<th>Inizio</th>
					<th></th>
					<th>Fine</th>
					<th></th>
					<th>Valida</th>
					<th></th>
					<th>Azioni</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempStage" items="${stages}">
				
					<c:url var="detailsLink" value="/stage/details">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="updateLink" value="/stage/update">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/stage/delete">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="convalidateLink" value="/stage/convalidate">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="invalidateLink" value="/stage/invalidate">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="subscribeLink" value="/stage/subscribe">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="unsubscribeLink" value="/stage/unsubscribe">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					
					
					<tr>
						<td> ${tempStage.title} </td>
						<td></td>
						<td> ${tempStage.sector} </td>
						<td></td>
						<td> ${tempStage.tipo} </td>
						<td></td>
						<td> ${tempStage.startingDate} </td>
						<td></td>
						<td> ${tempStage.endingDate} </td>
						<td></td>
						<td> ${tempStage.validated} </td>
						<td></td>
						<td> <a href="${detailsLink}">Dettagli</a></td>
						
						<security:authorize access="hasRole('COMPANY')">
							<td> <a href="${updateLink}">Update</a> |
							<a href="${deleteLink}" onclick="if (!(confirm('Sei sicuro di voler eliminare l'evento?\n(Permanente)'))) return false">Elimina</a></td>
						</security:authorize>
						
						<c:if test="${tempStage.validated}">
							<security:authorize access="hasRole('STUDENT')">
								<td><a href="${subscribeLink}">Candida</a> | <a href="${unsubscribeLink}">Annulla</a></td>
							</security:authorize>
						</c:if>

						<security:authorize access="hasRole('UNIVERSITY')">
							<td>
								<c:choose>
									<c:when test="${!tempStage.validated}"><a href="${convalidateLink}">Convalida</a></c:when>
									<c:otherwise><a href="${invalidateLink}">Invalida</a></c:otherwise>
								</c:choose>
							</td>
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
