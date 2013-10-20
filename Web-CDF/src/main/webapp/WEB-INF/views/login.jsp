<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.loginpage.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="label.loginpage.title" />
	</h1>

	<P>The username is ${username.username}.</P>
	<span style="float: right"> <a href="?lang=en">en</a> | <a
		href="?lang=fr">fr</a>
	</span>

	<form:form method="POST" commandName="loginForm" action="loginAction">
		<table>
			<tr>
				<td><spring:message code="label.username" /> :</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.password" /> :</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>