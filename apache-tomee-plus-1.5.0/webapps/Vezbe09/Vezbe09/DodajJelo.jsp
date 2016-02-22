
<%@page
	import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<script src="./menuvertical.js" type="text/javascript"></script>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./home.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>
<script>
	
<%ArrayList<Jelo> list = new ArrayList<Jelo>();%>
	$(document).ready(function() {

		$("#btn2").click(function() {
			var str = "<li>" + $("#${jelo.jelo_id}").prop("value") + "</li>"
			$("ol").append(str);

		});
	});
</script>

<body>
	<div id="wrapper">



		<c:if test="${sessionScope.admin!=null}">
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




		</c:if>







































		<c:if test="${sessionScope.gost!=null}">
			<ul>

				<li><a href="./InitRestoranController"><i
						class="fa fa-cutlery"></i>
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




		</c:if>




		<c:if test="${sessionScope.menadzer!=null}">
			<ul>
				<li><a href="./InitRestoranController"><i
						class="fa fa-cutlery"></i>
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

				<form action="./DodajJeloController" method="post">
					<table>
						<tr>
							<td>Ime :</td>
							<td><input type="text" id="ime_menija" name="ime_menija"
								required="required"></td>
							<td>&nbsp;</td>
						</tr>


						<tr>
							<td>Jela:</td>
							<td><select name="jela">
									<c:forEach items="${svaJela}" var="jelo">
										<option id="${jelo.jelo_id}"value="${jelo.jelo_id}">${jelo.naziv}</option>

									</c:forEach>

							</select></td>

							<td><button type="button" id="btn2" name="ivan">Dodaj</button></td>
						</tr>
						<tr>

						</tr>
						<tr>
							<td><a href="jelovnici.jsp"
								class="action-button shadow animate yellow">Odustani</a></td>
							<td>
								<button type="submit">Sacuvaj podatke</button>
							</td>
						</tr>

					</table>

				</form>
				


			</ul>
		</c:if>

	</div>


</body>
</html>