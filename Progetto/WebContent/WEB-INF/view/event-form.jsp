<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
		<form:form action="processEvent" modelAttribute="event">
			
			Titolo: <form:input path="titolo"/>
		
			<br><br>
			
			Descrizione: <form:input path="descrizione"/>
			
			<br><br>
			
			<input type="submit" value="Submit"/>
			
		</form:form>
</body>
</html>