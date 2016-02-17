<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires",0);
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="prijava"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./login.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<form id="login" action="./LoginAdminController" method="post" accept-charset="UTF-8">
    <h1><fmt:message key="prijava"/></h1>
    <fieldset id="inputs">
        <input id="username" type="text" name="korisnickoIme"  placeholder="<fmt:message key="korisnickoIme"/>" autofocus="autofocus" required="required">   
        <input id="password" type="password" name="lozinka" placeholder="<fmt:message key="lozinka"/>" required="required">
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="<fmt:message key="prijaviSe"/>">
        </a><a href="start.jsp">Vrati se nazad</a>
    </fieldset>
</form>


</body>
</html>

