<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body style="background-color: #fdccbc;">
	<jsp:include page="header.jsp"></jsp:include>

	<section class="h-100 gradient-custom">
		<div class="container py-5">
			<div class="row d-flex justify-content-center my-4">
				<div class="col-md-8">
					<div class="card mb-4">
						<div class="card-header py-3">
							<h5 class="mb-0">
								Cart - <span class="text-primary">${cart.getItems().size()}</span>item
							</h5>
						</div>
						<div class="card-body">

							<!-- Single item -->
							<c:forEach items="${cart.getItems()}" var="it">
								<div class="row">
									<div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
										<!-- Image -->
										<div class="bg-image hover-overlay hover-zoom ripple rounded"
											data-mdb-ripple-color="light">
											<img src="${it.getProductImg()}" class="w-100" alt="" /> <a
												href="#!">
												<div class="mask"
													style="background-color: rgba(251, 251, 251, 0.2)"></div>
											</a>
										</div>
										<!-- Image -->
									</div>

									<div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
										<!-- Data -->
										<p>
											<strong>${it.getName()}</strong>
										</p>
										<p>Brand: ${it.getBrand()}</p>
										<form action="cartedit" method="post">
											<input type="hidden" value="${it.getProductId()}" name="pid">
											<button type="input" class="btn btn-primary btn-sm me-1 mb-2"
												data-mdb-toggle="tooltip" title="Remove item" name="action"
												value="remove">
												<i class="fas fa-trash"></i>
											</button>
										</form>
										<button type="button" class="btn btn-danger btn-sm mb-2"
											data-mdb-toggle="tooltip" title="Move to the wish list">
											<i class="fas fa-heart"></i>
										</button>
										<!-- Data -->
									</div>

									<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
										<!-- Quantity -->
										<div class="d-flex mb-4" style="max-width: 300px">
											<form action="cartedit" method="post">
												<input type="hidden" value="${it.getProductId()}" name="pid">
												<input type="hidden" value="abstract" name="action">
												<button class="btn btn-primary px-3 me-2"
													onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
													<i class="fas fa-minus"></i>
												</button>
											</form>


											<div class="form-outline">
												<input id="form1 text-left" min="0" name="quantity"
													value="${it.getNum()}" type="number" class="form-control" />
												<label class="form-label" for="form1">Quantity</label>
											</div>
											<form action="cartedit" method="post">
												<input type="hidden" value="${it.getProductId()}" name="pid">
												<input type="hidden" value="add" name="action">
												<button class="btn btn-primary px-3 ms-2"
													onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
													<i class="fas fa-plus"></i>
												</button>
											</form>

										</div>
										<!-- Quantity -->

										<!-- Price -->
										<p class="text-start text-md-center">
											<strong>${it.getNum()*it.getPrice()}</strong>
										</p>
										<!-- Price -->
									</div>
								</div>
								<br>
								<br>
							</c:forEach>
							<!-- Single item -->
						</div>
					</div>

					<div class="card mb-4">
						<div class="card-body">
							<p>
								<strong>Expected shipping delivery</strong>
							</p>
							<p class="mb-0">${dateS} to ${dateE }</p>
						</div>
					</div>
					<div class="card mb-4 mb-lg-0">
						<div class="card-body">
							<p>
								<strong>We accept</strong>
							</p>
							<img class="me-2" width="45px"
								src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
								alt="Visa" /> <img class="me-2" width="45px"
								src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
								alt="American Express" /> <img class="me-2" width="45px"
								src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
								alt="Mastercard" /> <img class="me-2" width="45px"
								src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.webp"
								alt="PayPal acceptance mark" />
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card mb-4">
						<div class="card-header py-3">
							<h5 class="mb-0">Summary</h5>
						</div>
						<form action="/PRJ321x/cart" method="post">
							<div class="card-body">
								<ul class="list-group list-group-flush">
									<li
										class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
										Products <span>$${cart.getAmount()}</span>
									</li>
									<li
										class="list-group-item d-flex justify-content-between align-items-center px-0">
										Shipping <span>$${cart.getAmount()*(2/100)}</span>
									</li>
									<li
										class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
										<div>
											<strong>Total amount</strong> <strong>
												<p class="mb-0">(including VAT)</p>
											</strong>
										</div> <span><strong>$${cart.getAmount() +
												cart.getAmount()*0.02}</strong></span>
									</li>
								</ul>

								<button type="submit" class="btn btn-primary btn-lg btn-block">
									Go to Pay
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"></script>
</body>
</html>