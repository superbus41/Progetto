<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

</head>

<body>
	<form:form action="searchForm" method="GET">
		<p>Titolo: <input type="text" name="title" /></p>
		<p>Settore: <input type="text" name="sector" /></p>
		<p>Luogo: <input type="text" name="place" /></p>
		<p>Università: <input type="text" name="university" /></p>	
		<p>Data: <input type="date" name="date"/></p>
		<input type="submit" value="Search" />
	</form:form>
</body>
</html>