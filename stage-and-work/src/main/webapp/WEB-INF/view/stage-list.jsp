<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Stage</title>
	
	<style>
	
	td.long {
		width: 300px;
		border: 1px solid grey;
		padding: 5px;
		}
	td.short {
		text-align: center;
		border: 1px solid grey;
		width: 120px;
		padding: 5px;
		}
	
	</style>
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
			
		
			<table>
				<tr>
					<th>Titolo</th>
					<th>Settore</th>
					<th>Tipo</th>
					<th>Inizio</th>
					<th>Durata</th>
					<th>Convalidata</th>
					<th>Azienda</th>
				</tr>
				
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
						<td class="long"> <a href="${detailsLink}">${tempStage.title}</a></td>
						<td class="long"> ${tempStage.sector} </td>
						<td class="short"> 
							<c:choose>
								<c:when test="${tempStage.tipo}">
									Curriculare
								</c:when>
								<c:otherwise>
									Extracurriculare
								</c:otherwise>
							</c:choose>
						</td>
						<td class="short"> ${tempStage.startingDate} </td>
						<td class="short"> ${tempStage.endingDate} </td>
						<td class="short"> 
							<c:choose>
								<c:when test="${tempStage.validated}">
									Si
								</c:when>
								<c:otherwise>
									No
								</c:otherwise>
							</c:choose>
						</td>
						<td class="short"> ${tempStage.company.name} </td>
						
						<security:authorize access="hasRole('COMPANY')">
							<security:authentication var="username" property="principal.username"/>
							<c:if test="${username eq tempStage.company.user.username}">
								<td class="short"><a href="${updateLink}">Update</a></td>|
								<td class="short"><a href="${deleteLink}" 
									onclick="return confirm('Sei sicuro di voler eliminare questa offerta?')">Elimina</a></td>
							</c:if>
						</security:authorize>
						
						<c:if test="${tempStage.validated}">
							<security:authorize access="hasRole('STUDENT')">
								<td class="short">
									<security:authentication var="username" property="principal.username"/>
									<c:set var="subbed" scope="page" value="false"/>
									<c:forEach var="sub" items="${tempStage.subs}">
										<c:if test="${username eq sub.user.username}">
											<c:set var="subbed" value="true"/>
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${!subbed}"><a href="${subscribeLink}"
											onclick="alert('Candidatura completatata con successo');">Iscrivi</a></c:when>
										<c:otherwise><a href="${unsubscribeLink}"
											onclick="return confirm('Sei sicuro di voler togliere la candidatura a questa offerta?')">Disiscrivi</a></c:otherwise>
									</c:choose>
								</td>
							</security:authorize>
						</c:if>

						<security:authorize access="hasRole('UNIVERSITY')">
							<td class="short">
								<c:choose>
									<c:when test="${!tempStage.validated}"><a href="${convalidateLink}"
										onclick="alert('Offerta convalidata con successo');">Convalida</a></c:when>
									<c:otherwise><a href="${invalidateLink}"
										onclick="return confirm('Sei sicuro di voler Invalidare questa offerta?')">Invalida</a></c:otherwise>
								</c:choose>
							</td>
						</security:authorize>
						
						<c:if test="${tempStage.tutor == null}">
							<td class="short">
								<c:choose>
									<c:when test="${tempStage.tipo}">
										<security:authorize access="hasRole('UNIVERSITY')">
											<a href="${tutorLink}">Assegna Tutor</a>
										</security:authorize>
									</c:when>
									<c:otherwise>
										<security:authorize access="hasRole('COMPANY')">
											<a href="${tutorLink}">Assegna Tutor</a>
										</security:authorize>
									</c:otherwise>
								</c:choose>
							</td>
						</c:if>
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
