<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Profile Page</title>
</head>
<body>
	<h1>Profile</h1>

	<form:select path="aList">
		<form:option value="NONE" label="--- Select ---" />
		<form:options items="${aList}" />
	</form:select>
</body>
</html>