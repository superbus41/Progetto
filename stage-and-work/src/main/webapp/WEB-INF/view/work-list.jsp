<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Lavori</title>
	
	<!-- reference our style sheet -->
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
			<h2>Lista Lavori</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
					
			<a href="${pageContext.request.contextPath}/work/search">Ricerca lavoro</a>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th>Settore</th>
					<th>Convalidata</th>
					<th>Azienda</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempWork" items="${works}">
					
					<c:url var="detailsLink" value="/work/details">
						<c:param name="workId" value="${tempWork.id}"/>
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
						<td class="long"> <a href="${detailsLink}"> ${tempWork.title}</a></td>
						<td class="long"> ${tempWork.sector} </td>
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
						<td class="short"> ${tempWork.company.name} </td>
						
						
						<security:authorize access="hasRole('COMPANY')">
							<security:authentication var="username" property="principal.username"/>
							<c:if test="${username eq tempWork.company.user.username}">
								<td class="short"><a href="${updateLink}">Update</a></td>|
								<td class="short"><a href="${deleteLink}" 
									onclick="return confirm('Sei sicuro di voler eliminare questa offerta?')">Elimina</a></td>
							</c:if>
						</security:authorize>
						
						<c:if test="${tempWork.validated}">
							<security:authorize access="hasRole('STUDENT')">
								<security:authentication var="username" property="principal.username"/>
								<c:set var="subbed" scope="page" value="false"/>
								<c:forEach var="sub" items="${tempWork.subs}">
									<c:if test="${username eq sub.user.username}">
										<c:set var="subbed" value="true"/>
									</c:if>
								</c:forEach>
								<td class="short">
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
									<c:when test="${!tempWork.validated}"><a href="${convalidateLink}"
										onclick="alert('Offerta convalidata con successo');">Convalida</a></c:when>
									<c:otherwise><a href="${invalidateLink}"
										onclick="return confirm('Sei sicuro di voler Invalidare questa offerta?')">Invalida</a></c:otherwise>
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
