<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<%
	ArrayList<Products> listProduct = (ArrayList) request.getAttribute("listProduct");
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<%-- Sử dụng foreach load dữ liệu từ db và hiển thị lên trên ws --%>
	<div class="container mb-5">
		<div class="container mt-5 mb-4">
			<h3>${allProduct}
				<span class="text-primary">${count}</span>
			</h3>
		</div>
		<div class="row row-cols-1 row-cols-md-3 g-4 ${center}">
			<c:choose>
				<c:when test="${listProduct!=null}">
					<c:forEach items="${listProduct}" var="item">
						<div class="col-sm-12 col-md-6 col-lg-4 mb-3">
							<div class="card">
								<img src="${item.getProductImg()}" class="card-img-top mt-3"
									alt="Hollywood Sign on The Hill" />
								<div class="card-body">
									<h3 class="card-title">${item.getName()}</h3>
									<h6>Brand: ${item.getBrand()}</h6>
									<h6>Type: ${item.getType()}</h6>
									<div class=" d-flex justify-content-between">
										<h4>Price:</h4>
										<h4>${item.getPrice()}$</h4>
									</div>
									<p>
										<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
											class="fas fa-star"></i> <i class="fas fa-star"></i> <i
											class="fas fa-star-half-stroke"></i>
									</p>
									<div class=" d-flex justify-content-between">
										<a href="detail?productId=${item.getProductId()}"
											class="btn btn-danger">Buy</a> 
											<a class="btn btn-success"
											href="cartedit?productId=${item.getProductId()}">Add to cart</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="justify-content-center">
						<h2 class="text-danger text-center">Not product match with
							your search try something else</h2>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${check.equals('checked')}">
			<c:if test="${listProduct!=null}">
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link fs-3">Previous</a>
						</li>
						<c:forEach begin="1" end="${requestScope.numpage}" var="i">
							<li class="page-item"><a
								class="${i==page?'active':''} page-link fs-3"
								href="home?page=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link fs-3" href="#">Next</a></li>
					</ul>
				</nav>
			</c:if>
		</c:if>
	</div>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"></script>
</body>
</html>