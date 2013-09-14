<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
<h1>
	Login
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  The username is ${username.username}. </P>
<form action="loginForm" method="post">
   <input name="username" value="john" />
   <input name="password" value="pass" />
   <input type="submit"/>
</form>

</body>
</html>