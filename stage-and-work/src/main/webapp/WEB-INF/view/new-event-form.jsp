<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Event</title>
</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>New Event Form</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Event</h3>
			<form:form action="save" modelAttribute="event" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>Titolo dell'evento:</label></td>
							<td><form:input path="title"/></td>
						</tr>
						<tr>
							<td><label>Settore di riferimento:</label></td>
							<td><form:input path="sector"/></td>
						</tr>
						<tr>
							<td><label>Data dell'evento:</label></td>
							<td><form:input path="date"/></td>
						</tr>
						<tr>
							<td><label>Luogo dell'evento:</label></td>
							<td><form:input path="place"/></td>
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