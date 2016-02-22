
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />
<jsp:useBean id="restoranRezervacija"
	type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
	scope="request" />


<html>
<head>
<script src="./menuvertical.js" type="text/javascript"></script>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./home.css" rel="stylesheet" type="text/css" /><script>( function( $ ) {
$( document ).ready(function() {
$('#cssmenu').prepend('<div id="menu-button">Menu</div>');</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>
	<div id='cssmenu'>



		<c:if test="${sessionScope.admin!=null}">
			<ul>
				<li><a href="restorani.jsp"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="#"><i class="fa fa-users"></i>
						<div>
							<fmt:message key="prijatelji" />
						</div></a></li>
				<li><a href="#"><i class="fa fa-user"></i>
						<div>
							<fmt:message key="mojNalog" />
						</div></a></li>
				<li><a href="#"><i class="fa fa-rocket"></i>
						<div>
							<c:out value="${admin.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${admin.lastName}"></c:out>
						</div></a></li>
				</li>
				<li><a href="./LogoutController"><i
						class="fa fa-times-circle-o"></i>
						<div>
							<fmt:message key="odjava" />
						</div> </a></li>

			</ul>
		</c:if>







		<c:if test="${sessionScope.gost!=null}">
			<ul>

				<li><a href="restorani.jsp"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="./PrijateljiController"><i class="fa fa-users"></i>
						<div>
							<fmt:message key="prijatelji" />
						</div></a></li>

				<li><a href="mojeposete.jsp"></i><i class="fa fa-thumbs-up"></i>
						<div>
							<fmt:message key="mojeposete" />
						</div></a></li>

				<li><a href="home.jsp"><i class="fa fa-user"></i>
						<div>
							<c:out value="${gost.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${gost.lastName}"></c:out>
						</div></a></li>
				<li><a href="./LogoutController"><i
						class="fa fa-times-circle-o"></i>
						<div>
							<fmt:message key="odjava" />
						</div> </a></li>
			</ul>

			<form action="">
				<table>
					<tbody>
						<tr>
							<td>Restoran :</td>
							<td><input type="text" value="${restoranRezervacija.naziv}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>Datum i vreme:</td>
							<td><input type="datetime" name="datumIVreme"></td>
						</tr>
						<tr>
							<td>Trajanje:</td>
							<td><input type="number"></td>
						</tr>
						<tr>
							<td>Izaberi Sto</td>
							<td><a href="#">Konfiguracija restorana</a></td>
						</tr>

						<tr>
							<td>Pozovi prijatelje:</td>
							<td><a href="#">Pozovi prijatelje</a></td>
						</tr>

						<tr>
							<td colspan="2"><button type="submit">Kreiraj
									Rezervaciju</button></td>
						</tr>
					</tbody>
				</table>


			</form>
			<a href="#" class="action-button shadow animate yellow">Izmeni
				profil</a>
		</c:if>











		<c:if test="${sessionScope.menadzer!=null}">
			<ul>
				<li><a href="restorani.jsp"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="#"><i class="fa fa-users"></i>
						<div>
							<fmt:message key="prijatelji" />
						</div></a></li>
				<li><a href="#"><i class="fa fa-user"></i>
						<div>
							<fmt:message key="mojNalog" />
						</div></a></li>

				<li><a href="./LogoutController"><i
						class="fa fa-paper-plane"></i>
						<div>
							<c:out value="${menadzer.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${menadzer.lastName}"></c:out>
						</div> </a></li>
				<li><a href="./LogoutController"><i
						class="fa fa-times-circle-o"></i>
						<div>
							<fmt:message key="odjava" />
						</div> </a></li>

			</ul>
		</c:if>

	</div>


</body>
</html>