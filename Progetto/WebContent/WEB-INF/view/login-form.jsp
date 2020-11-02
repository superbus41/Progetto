<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

	<head>
		<title>Area riservata - Login</title>
		
		<style>
			.error {color:red}
		</style>
	</head>
	
	<body>
		<form action="processForm" method="GET">
			
			Username: <input type="text" name="username"/>
		
			<br><br>
			
			Password: <input type="text" name="password"/>
			
			<br><br>
			
			<input type="submit" value="Submit"/>
			
		</form>
	</body>
</html>