<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

</head>

<body>
	<table>
		<form:form action="searchForm" method="GET">
		
			<tr><td>Titolo:</td>
			<td><input type="text" name="title" /></td></tr>
			
			<tr><td>Settore:</td>
			<td><input type="text" name="sector" /></td></tr>
			
			<tr><td>Azienda:</td>
			<td><input type="text" name="company" /></td></tr>
			
			<tr><td><input type="submit" value="Search" /></td></tr>
		</form:form>
	</table>
</body>
</html>