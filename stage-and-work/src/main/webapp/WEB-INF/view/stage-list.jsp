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
					
			<a href="${pageContext.request.contextPath}/stage/search">Ricerca stage</a>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th>Settore</th>
					<th>Tipo</th>
					<th>Inizio</th>
					<th>Fine</th>
					<th>Valida</th>
					<th>Azienda</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempStage" items="${stages}">
				
					<c:url var="detailsLink" value="/stage/details">
						<c:param name="stageId" value="${tempStage.id}"/>
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
						<td> <a href="${detailsLink}">${tempStage.title}</a></td>
						<td> ${tempStage.sector} </td>
						<td> ${tempStage.tipo} </td>
						<td> ${tempStage.startingDate} </td>
						<td> ${tempStage.endingDate} </td>
						<td> ${tempStage.validated} </td>
						<td> ${tempStage.company.name} </td>
						
						<security:authorize access="hasRole('COMPANY')">
							<security:authentication var="username" property="principal.username"/>
							<c:if test="${username eq tempStage.company.user.username}">
								<td> <a href="${updateLink}">Update</a> |
								<a href="${deleteLink}" onclick="return confirm('Sei sicuro di voler eliminare questo stage?')">Elimina</a></td>
							</c:if>
						</security:authorize>
						
						<c:if test="${tempStage.validated}">
							<security:authentication var="username" property="principal.username"/>
							<security:authorize access="hasRole('STUDENT')">
								<c:set var="subbed" scope="page" value="false"/>
								<c:forEach var="sub" items="${tempStage.subs}">
									<c:if test="${username eq sub.user.username}">
										<c:set var="subbed" value="true"/>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${!subbed}"><td><a href="${subscribeLink}">Iscrivi</a></td></c:when>
									<c:otherwise><td><a href="${unsubscribeLink}">Disiscrivi</a></td></c:otherwise>
								</c:choose>
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
