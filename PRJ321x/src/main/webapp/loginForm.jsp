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

	<%
	String user="",pass="",remember="";
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
		for(Cookie item: cookies){
			if(item.getName().equals("cUser")){
				user = item.getValue();
			}
			if(item.getName().equals("cPass")){
				pass = item.getValue();
			}
			if(item.getName().equals("cRem")){
				remember = item.getValue();
			}
		}
	}
	
	
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container mt-5 mb-5 mb-lg-0 pb-5">
		<div class="row">
			<div class="col-8">
				<h2 class="text-danger .bg-danger">${message}</h2>
				
				<form action="login" method="post">
					
					<!-- username input -->
					<div class="form-outline mt-5 mb-4">
						<label class="form-label" for="form2Example1"><b>User name</b></label> 
						<input 
							type="text" id="form2Example1"
							class="form-control border border-4" name="username"
							value="<%=user %>"/>
					</div>

					<!-- Password input -->
					<div class="form-outline mt-5 mb-4 b">
						<label class="form-label" for="form2Example2"><b>Password</b></label> <input
							type="password" id="form2Example2"
							class="form-control border border-4" name="password"
							value="<%=pass %>" />
					</div>

					<!-- 2 column grid layout for inline styling -->
					<div class="row mb-4">
						<div class="col d-flex justify-content-center">
							<!-- Checkbox -->
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="remember"
									id="form2Example34"/
									value="1"
									<%=remember.equals("1")? "checked='/check'":"" %>> 
								<label class="form-check-label"
									for="form2Example34"> Remember me </label>
							</div>
						</div>

						<div class="col">
							<!-- Simple link -->
							<a href="#!">Forgot password?</a>
						</div>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-4">Sign
						in</button>

					<!-- Register buttons -->
					<div class="text-center">
						<p>
							Not a member? <a href="#!">Register</a>
						</p>
					</div>
				</form>
			</div>
			<div class="col-4 mt-5 mb-2">
				<div
					class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-white"
					style="background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/003.webp');">
					<h1 class="mb-3 h2">Welcome Back</h1>

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