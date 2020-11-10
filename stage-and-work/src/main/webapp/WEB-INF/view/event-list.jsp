<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
						<td> ${tempEvent.title} </td>
						<td></td>
						<td> ${tempEvent.sector} </td>
						<td></td>
						<td> ${tempEvent.date} </td>
						<td></td>
						<td> ${tempEvent.place} </td>
						<td></td>
						
						<td> <a href="${detailsLink}">Dettagli</a></td>
						<td> <a href="${updateLink}">Update</a>
						<a href="${deleteLink}"	onclick="if (!(confirm('Sei sicuro di voler eliminare l'evento?\n(Permanente)'))) return false">Elimina</a></td>
						<td><a href="${subscibeLink}">Subscribe</a><a href="${unsubscibeLink}">Unsubscribe</a></td>
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
