<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>
<html>
	<head>
		<title><fmt:message key="prijava"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./registracija.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<form id="login" action="" method="post" accept-charset="UTF-8">
<h1>Registracija</h1>
    <fieldset id="inputs">
		<a href="loginKorisnik.jsp" class="action-button shadow animate blue">Korisnik</a>
		<a href="loginMenadzer.jsp" class="action-button shadow animate red">Menadzer</a>
		<a href="login.jsp" class="action-button shadow animate green">Admin</a>
    </fieldset>
</form>


</body>
</html>