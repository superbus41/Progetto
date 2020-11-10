<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Works</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Work Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<input type="button" value="Add Work"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			
			<form:form action="search" method="GET">
                Search work: <input type="text" name="searchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Titolo</th>
					<th>Settore</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our works -->
				<c:forEach var="tempWork" items="${works}">
				
					<c:url var="updateLink" value="/work/showFormUpdate">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/work/delete">
						<c:param name="workId" value="${tempWork.id}"/>
					</c:url>
					
					<tr>
						<td> ${tempWork.title} </td>
						<td> ${tempWork.sector} </td>
						<td> <a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this work?\n(Permanent)'))) return false">Delete</a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>