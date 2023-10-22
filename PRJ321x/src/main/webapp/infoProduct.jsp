<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.css"
	rel="stylesheet" />
<link href="/PRJ321x/css/style.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container mt-5">
		<div class="card mb-8">
			<div class="row g-0">
				<div class="col-md-6">
					<img src="${ detail.getProductImg()}" alt="error img"
						class="img-fluid rounded-start mt-3 mb-3" />
				</div>
				<div class="col-md-6">
					<div class="card-body">
						<h1 class="card-title text-center">${detail.getName()}</h1>
						<div class="justify-content-start">
							<h3>
								Brand: <span class="fs-4">${detail.getBrand()}</span>
							</h3>
						</div>
						<div class="justify-content-start mt-3">
							<h3>
								Type: <span class="fs-4">${detail.getType()}</span>
							</h3>

						</div>
						<div class="mt-4 mb-5">
							<h3>Infomation:</h3>
							<p class="card-text fs-5">${detail.getDes()}</p>
						</div>

						<div class=" d-flex justify-content-between mt-3 mb-3 fs-4">
							<h4 class="font-weight-bold">Quality:</h4>
							<p>
								<c:forEach var="i" begin="1" end="4">
									<i class="fas fa-star"></i>
								</c:forEach>
								<i class="fas fa-star-half-stroke"></i>
							</p>
						</div>

						<div class=" d-flex justify-content-between mt-3 mb-3">
							<h4>Price:</h4>
							<h4 class="text-decoration-underline text-danger">$${detail.getPrice()}</h4>
						</div>
						<div class=" d-flex justify-content-between mt-3">
							<a href="#!" class="btn btn-danger">Buy</a> <a href="#!"
								class="btn btn-success">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"></script>
</body>
</html>