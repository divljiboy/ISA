<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik"%>
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
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
<script src="./menuvertical.js" type="text/javascript"></script>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./home.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/jelovnici.jsp?Nijeuspelo") {
			alert("Upis nije ispavan!");
		}
	}
</script>	
	
	
	
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>
	<div id='cssmenu'>



		<c:if test="${sessionScope.admin!=null}">
			<jsp:useBean id="sviJelovnici"
				type="java.util.List<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik>"
				scope="session" />
			<ul>
				<li><a href="./InitRestoranController"><i
						class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="./InitKorisniciController"><i
						class="fa fa-users"></i>
						<div>
							<fmt:message key="korisnici" />
						</div></a></li>
				<li><a href="./InitMenadzerController"><i
						class="fa fa-user"></i>
						<div>
							<fmt:message key="menadzeri" />
						</div></a></li>
				<li><a href="InitJelovniciController"><i
						class="fa fa-glass"></i>
						<div>
							<fmt:message key="jelovnici" />
						</div></a></li>

				<li><a href="InitJelaController"><i class="fa fa-lemon-o"></i>
						<div>
							<fmt:message key="jela" />
						</div></a></li>

				<li><a href="home.jsp"><i class="fa fa-rocket"></i>
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

			<form>
				<table>
					<thead>
						<tr>
							<th>Naziv jelovnika</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sviJelovnici}" var="jelovnik">
							<tr>
								<td align="center"><a
									href="./AdminJelovniciController?id=${jelovnik.id}">${jelovnik.naziv}</a></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</form>
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

			<table>
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>

				<c:forEach items="${gosti}" var="prijatelj">
					<tr>
						<td>${prijatelj.firstName}</td>
						<td>${prijatelj.lastName}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
				prijatelji
			</table>


		</c:if>




		<c:if test="${sessionScope.menadzer!=null}">
			<jsp:useBean id="restoran"
				type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
				scope="session" />
			<jsp:useBean id="jelovnici"
				type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik>"
				scope="session" />
			<ul>
				<li><a href="restorani.jsp"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="./InitJelovniciController"><i
						class="fa fa-glass"></i>
						<div>
							<fmt:message key="jelovnici" />
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

			<form action="./IzmenaRestoranaMenadzer" method="post">
				<table>
					<thead>
						<th align="center"  colspan="2">Jelovnici</th>
					</thead>
					<tbody>
						<c:forEach items="${jelovnici}" var="jelovnik">
							<tr>
								<td><a href="./IzmenaMenijaMenadzer?id=${jelovnik.id}">${jelovnik.naziv}</a>
								</td>
								<td><a href="./ObrisiJelovnik?id=${jelovnik.id}">Obrisi</a> </td>
							</tr>
						</c:forEach>


						<tr>
							<td>&nbsp;</td>
							<td><a href="./DodajJelovnik">Kreiraj Jelovnik</a>
							</td>
						</tr>
					</tbody>
				</table>

			</form>




		</c:if>

	</div>


</body>
</html>