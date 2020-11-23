<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Event</title>
	<style>
   		.fixed {
        	resize: none;
      	}
    </style>
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
							<td><form:input size="45" maxlength="45" path="title"/></td>
						</tr>
						<tr>
							<td><label>Settore di riferimento:</label></td>
							<td><form:input size="45" maxlength="45" path="sector"/></td>
						</tr>
						<tr>
							<td><label>Data dell'evento:</label></td>
							<td><form:input placeholder="AAAA-MM-DD" type="date" path="date"/></td>
						</tr>
						<tr>
							<td><label>Luogo dell'evento:</label></td>
							<td><form:input size="45" maxlength="45" path="place"/></td>
						</tr>
						<tr>
							<td><label>Descrizione dello stage:</label></td>
							<td><form:textarea class="fixed" rows="6" cols="80" maxlength="440" path="details.description"/></td>
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