<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Work</title>
	<style>
   		.fixed {
        	resize: none;
      	}
    </style>
</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>New Work Form</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Work</h3>
			<form:form action="save" modelAttribute="work" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>Titolo dell'offerta:</label></td>
							<td><form:input size="45" maxlength="45" path="title"/></td>
						</tr>
						<tr>
							<td><label>Settore di riferimento:</label></td>
							<td><form:input size="45" maxlength="45" path="sector"/></td>
						</tr>
						<tr>
							<td><label>Descrizione del lavoro:</label></td>
							<td><form:textarea class="fixed" rows="6" cols="80" maxlength="450" path="details.description"/></td>
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