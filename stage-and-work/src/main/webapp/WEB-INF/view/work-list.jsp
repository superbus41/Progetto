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
					
			<a href="${pageContext.request.contextPath}/work/search">Ricerca lavoro</a>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th>Settore</th>
					<th>Valida</th>
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
						<td> <a href="${detailsLink}"> ${tempWork.title}</a></td>
						<td> ${tempWork.sector} </td>
						<td> ${tempWork.validated} </td>
						<td> ${tempWork.company.name} </td>
						
						
						<security:authorize access="hasRole('COMPANY')">
							<security:authentication var="username" property="principal.username"/>
							<c:if test="${username eq tempWork.company.user.username}">
								<td> <a href="${updateLink}">Update</a> |
								<a href="${deleteLink}" onclick="return confirm('Sei sicuro di voler eliminare questo lavoro?')">Elimina</a></td>
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
								<c:choose>
									<c:when test="${!subbed}"><td><a href="${subscribeLink}">Iscrivi</a></td></c:when>
									<c:otherwise><td><a href="${unsubscribeLink}">Disiscrivi</a></td></c:otherwise>
								</c:choose>
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
