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
		<p>Curriculare: <input type="checkbox" name="curricular" /></p>
		<p>Convalidato: <input type="checkbox" name="validated" /></p>
		<p>Azienda: <input type="text" name="company" /></p>	
		<p>Da: <input type="date" name="fromDate"/></p>
		<p>A: <input type="date" name="toDate"/></p>
		<input type="submit" value="Search" />
	</form:form>
</body>
</html>