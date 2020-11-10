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
					<th>Settore</th>
					<th>Tipo</th>
					<th>Inizio</th>
					<th>Fine</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempStage" items="${stages}">
				
					<c:url var="updateLink" value="/offer/stageUpdate">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/event/stageDelete">
						<c:param name="stageId" value="${tempStage.id}"/>
					</c:url>
					
					<tr>
						<td> ${tempStage.title} </td>
						<td> ${tempStage.sector} </td>
						<td> ${tempStage.tipo} </td>
						<td> ${tempStage.startingDate} </td>
						<td> ${tempStage.endingDate} </td>
						
						<td> <a href="${updateLink}">Update</a>|
						<a href="${deleteLink}" onclick="if (!(confirm('Sei sicuro di voler eliminare l'evento?\n(Permanente)'))) return false">Elimina</a></td>
						
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
