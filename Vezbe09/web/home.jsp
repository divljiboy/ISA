<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires",0);
%>
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

<body>
	<div id='cssmenu'>

		<c:if test="${sessionScope.admin!=null}">
			<ul >
				<li><a href="./InitRestoranController"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="./InitKorisniciController"><i class="fa fa-users"></i>
						<div>
							<fmt:message key="korisnici" />
						</div></a></li>
				<li><a href="./InitMenadzerController"><i class="fa fa-user"></i>
						<div>
							<fmt:message key="menadzeri" />
						</div></a></li>
				<li><a href="./InitJelovniciController"><i class="fa fa-glass"></i>
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


			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${admin.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${admin.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${admin.id}">
				</p>
			</form>

			<img id="e1"
				src="http://bradfrost.github.com/this-is-responsive/patterns/images/fpo_square.png"
				alt="Product Name" width="200px" height="200px" "/>
		</c:if>















		<c:if test="${sessionScope.gost!=null}">
			<ul>

				<li><a href="./InitRestoranController"><i class="fa fa-cutlery"></i>
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

			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${gost.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${gost.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${gost.id}">
				</p>
			</form>

			<img id="e1"
				src="http://bradfrost.github.com/this-is-responsive/patterns/images/fpo_square.png"
				alt="Product Name" width="200px" height="200px" "/>

		</c:if>

























		<c:if test="${sessionScope.menadzer!=null}">
			<ul>
				<li><a href="./InitRestoranController"><i class="fa fa-cutlery"></i>
						<div>
							<fmt:message key="restorani" />
						</div></a></li>
				<li><a href="./InitJelovniciController"><i class="fa fa-glass"></i>
						<div>
							<fmt:message key="jelovnici" />
						</div></a></li>
				<li><a href="home.jsp"><i
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


			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${menadzer.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${menadzer.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${menadzer.id}">
				</p>
			</form>

			<img id="e1"
				src="http://bradfrost.github.com/this-is-responsive/patterns/images/fpo_square.png"
				alt="Product Name" width="200px" height="200px" "/>
		</c:if>

	</div>


</body>
</html>