<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<html>
<head>
	<title><spring:message code="label.loginpage.title"/></title>
</head>
<body>
<h1>
	<spring:message code="label.loginpage.title"/>
</h1>

<P>  The time on the server is ${serverTime}. ${locale} </P>
<P>  The username is ${username.username}. </P>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=fr">fr</a>
</span>
<form action="loginForm" method="post">
   <input name="username" value="john" />
   <input name="password" value="pass" />
   <input type="submit"/>
</form>

</body>
</html>