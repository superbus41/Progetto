<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Lavori</title>
	
	<!-- reference our style sheet -->
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista Lavori</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
					
			<form:form action="search" method="GET">
                Cerca Lavoro: <input type="text" name="searchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th></th>
					<th>Settore</th>
					<th></th>
					<th>Valida</th>
					<th></th>
					<th>Azione</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempWork" items="${works}">
				
					<c:url var="detailsLink" value="/work/details">
						<c:param name="eventId" value="${tempEvent.id}"/>
					</c:url>
					<c:url var="updateLink" value="/work/update">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/work/delete">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="convalidateLink" value="/work/convalidate">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="invalidateLink" value="/work/invalidate">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="subscribeLink" value="/work/subscribe">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="unsubscribeLink" value="/work/unsubscribe">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					
					<tr>
						<td> ${tempWork.title} </td>
						<td></td>
						<td> ${tempWork.sector} </td>
						<td></td>
						<td> ${tempWork.validated} </td>
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
									<c:when test="${!tempWork.validated}"><a href="${convalidateLink}">Convalida</a></c:when>
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
