<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
					<th>Settore</th>
					<th>Azione</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempWork" items="${works}">
				
					<c:url var="updateLink" value="/work/workUpdate">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/work/workDelete">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					
					<tr>
						<td> ${tempWork.title} </td>
						<td> ${tempWork.sector} </td>
						
						<td> <a href="${updateLink}">Update</a>|
						<a href="${deleteLink}"
							onclick="if (!(confirm('Sei sicuro di voler eliminare l'offerta?\n(Permanente)'))) return false">Elimina</a></td>
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
