<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light bg-light" >
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse" data-mdb-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<a class="navbar-brand" href="#">VPhone</a>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="cart">cart</a></li>
				</ul>

				<%-- search --%>
				<form action="/PRJ321x/search" method="post" class="d-flex input-group w-auto">
					<input type="search" class="form-control br-4"
						placeholder="Search..." aria-label="Search" name="textinp" value="${text}"/>
					<button class="btn btn-outline-success me-5 click" type="submit"
						data-mdb-ripple-color="dark">
						<i class="fas fa-magnifying-glass"></i>
					</button>
				</form>
				<%-- end search --%>

				<br>

				<c:choose>
					<c:when test="${sessionScope.user!=null}">
						<div class="d-flex align-items-center">
						
							<a href="#">
								<button type="button" class="btn bg-light text-primary me-3 txt">
									Welcome: ${user}
								</button>
							</a>
							

							<a href="logout">
								<button type="button" class="btn btn-danger me-3 txt">
									Log out
								</button>
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<%-- login and register --%>
						<div class="d-flex align-items-center">
							<a href="/PRJ321x/login?action=login"> <%-- loginForm.jsp --%>
								<button type="button" class="btn btn-primary px-3 me-2 txt">
									login</button>
							</a> <a href="register">
								<button type="button" class="btn btn-danger me-3 txt">
									Sign up</button>
							</a>
						</div>
						<%-- end login and register --%>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
</body>
</html>