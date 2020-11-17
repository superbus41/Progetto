
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<title>Save Stage</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>New Stage Form</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Stage</h3>
			<form:form action="saveStage" modelAttribute="stage" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>Titolo dell'offerta:</label></td>
							<td><form:input path="title"/></td>
						</tr>
						<tr>
							<td><label>Settore di riferimento:</label></td>
							<td><form:input path="sector"/></td>
						</tr>
						<tr>
							<td><label>Stage curriculare:</label></td>
							<td><form:checkbox path="tipo"/></td>
						</tr>
						<tr>
							<td><label>Data di inizio:</label></td>
							<td><form:input path="startingDate" type="date"/></td>
						</tr>
						<tr>
							<td><label>Data di fine:</label></td>
							<td><form:input path="endingDate" type="date"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/home">Homepage</a>
			</p>
		</div>
	</body>
</html>