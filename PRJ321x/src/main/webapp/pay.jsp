<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container">
		<div class="py-3 text-center">
			<h2>Checkout Order</h2>
		</div>

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Your cart</span> <span
						class="badge badge-secondary badge-pill">${cart.getItems().size()}</span>
				</h4>
				<ul class="list-group mb-3">
					<c:forEach items="${cart.getItems()}" var="it">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">${it.getName()}</h6>
								<small class="text-muted">${it.getBrand()}</small>
							</div> <span class="text-muted">${it.getNum()*it.getPrice()}</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong>${cart.getAmount()}</strong></li>
				</ul>

				<form class="card p-2">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Promo code">
						<div class="input-group-append ms-2">
							<button type="submit" class="btn btn-secondary">Redeem</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Billing address</h4>
				<form class="needs-validation" action="payment" method="post">
					<div class="mb-3">
						<label for="username">Name</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">@</span>
							</div>
							<input type="text" class="form-control" id="username"
								placeholder="your name" required >
							<div class="invalid-feedback" style="width: 100%;">Your
								name is required.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="email">Email</label>
						<input type="email" class="form-control" id="email"
							placeholder="you@example.com" required="required" name="email">
						<div class="invalid-feedback " style="width: 100%;">Please
							enter a valid email address for shipping updates.</div>
					</div>

					<div class="mb-3">
						<label for="address">Address</label> <input type="text"
							class="form-control" id="address" placeholder="1234 Main St"
							required name="address">
						<div class="invalid-feedback">Please enter your shipping
							address.</div>
					</div>
					<div class="mb-3">
						<label for="address">Phone</label> <input type="text"
							class="form-control" id="address" placeholder="09123456xxx"
							required>
						<div class="invalid-feedback">Please enter your shipping
							phone.</div>
					</div>
					<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
						to checkout</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"></script>
</body>
</html>