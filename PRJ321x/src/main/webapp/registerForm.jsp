<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container mt-5 mb-5 mb-lg-0 pb-5">
		<div class="row">
			<div class="col-8">
				<h2 class="text-danger">${mess}</h2>
				<form action="/PRJ321x/register" method="post">
					<!-- 2 column grid layout with text inputs for the first and last names -->
					<div class="row mt-4 mb-4">
						<div class="col">
							<div class="form-outline">
								<label class="form-label" for="form3Example1">Name</label>
								<input type="text" id="form3Example1" class="form-control border border-4" 
								name="username"/>
							</div>
						</div>
						<div class="col">
							<div class="form-outline">
								<label class="form-label" for="form3Example2">Email</label>
								<input type="text" id="form3Example2" class="form-control border border-4" 
								name="email"/>
							</div>
						</div>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<label class="form-label" for="form3Example3">Password</label> <input type="password" id="form3Example3"
							class="form-control border border-4" 
							name="password"/>
					</div>

					<!-- Repassword input -->
					<div class="form-outline mb-4">
						<label class="form-label" for="form3Example4">Password again</label>
						<input type="password" id="form3Example4" class="form-control border border-4" 
						name="repass"/>
					</div>
					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-4">Sign
						up</button>

					<!-- Register buttons -->
					<div class="text-center">
						<p>or sign up with:</p>
						<button type="button" class="btn btn-secondary btn-floating mx-1">
							<i class="fab fa-facebook-f"></i>
						</button>

						<button type="button" class="btn btn-secondary btn-floating mx-1">
							<i class="fab fa-google"></i>
						</button>

						<button type="button" class="btn btn-secondary btn-floating mx-1">
							<i class="fab fa-twitter"></i>
						</button>

						<button type="button" class="btn btn-secondary btn-floating mx-1">
							<i class="fab fa-github"></i>
						</button>
					</div>
				</form>

			</div>
			<div class="col-4 mt-5 mb-2">
				<div
					class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-white"
					style="background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/003.webp');height:26rem;">
					<h1 class="mb-3 h2">Register Form</h1>

					<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
						Repellendus praesentium labore accusamus sequi, voluptate debitis
						tenetur in deleniti possimus modi voluptatum neque maiores dolorem
						unde? Aut dolorum quod excepturi fugit.</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>