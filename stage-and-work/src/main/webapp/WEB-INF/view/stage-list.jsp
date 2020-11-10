<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
				
					<c:url var="detailsLink" value="/offer/details">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="updateLink" value="/offer/updateStage">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/offer/deleteStage">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="validateLink" value="/offer/validate">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="invalidateLink" value="/offer/invalidate">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="subscribeLink" value="/offer/subscribe">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="unsubscribeLink" value="/offer/unsubscribe">
						<c:param name="eventId" value="${tempEvent.id}"/>
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
						<td> <a href="${updateLink}">Update</a> |
						<a href="${deleteLink}" onclick="if (!(confirm('Sei sicuro di voler eliminare l'evento?\n(Permanente)'))) return false">Elimina</a></td>
						<td><a href="${subscribeLink}">Candida</a> | <a href="${unsubscribeLink}">Annulla</a></td>
						<td><a href="${validateLink}">Convalida</a> | <a href="${invalidateLink}">Annulla</a></td>
						
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
