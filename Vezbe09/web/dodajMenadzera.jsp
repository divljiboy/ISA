
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>



<fmt:setBundle basename="messages.messages" />


<html>
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>
	<jsp:include page="./navbar.jsp" />

	<c:if test="${sessionScope.admin!=null}">


		<form action="./DodajMenadzeraController" method="post">
			<table>
				<tr>
					<td>Ime :</td>
					<td><input type="text" name="ime_menadzera"
						required="required"></td>
				</tr>
				<tr>
					<td>Prezime:</td>
					<td><input type="text" name="prezime_menadzera"
						required="required"></td>
				</tr>

				<tr>
					<td>Korisnicko ime:</td>
					<td><input type="text" name="korisnicko_ime"
						required="required"></td>
				</tr>
				<tr>
					<td>Lozinka:</td>
					<td><input type="text" name="lozinka" required="required"></td>
				</tr>
				<tr>
					<td>Id restorana:</td>
					<td><input type="number" name="id_restorana"
						required="required"></td>
				</tr>


				<tr>
					<td><a href="home.jsp"
						class="action-button shadow animate yellow">Odustani</a></td>
					<td>
						<button type="submit">Sacuvaj podatke</button>
					</td>
				</tr>

			</table>

		</form>




	</c:if>


</body>
</html>