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
<link href="/PRJ321x/css/admin.css" rel="stylesheet" />
</head>
<body>
	<%
	String admin = "";
	Object obj = session.getAttribute("user");
	if (obj != null) {
		admin = obj.toString();
	}
	%>


	<div class="d-flex align-items-start bg-light mb-3 h-100">
		<div class="sidebar">
			<div class="bg-image"
				style="background-image: url('https://mdbcdn.b-cdn.net/img/new/standard/city/041.webp'); height: 150px;">
			</div>
			<div>
				<ul>
					<li><a href="#">DashBoard</a></li>
					<li><a href="#">Information</a></li>
					<li><a href="#">Setting</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-light bg-white">
				<!-- Container wrapper -->
				<div class="container-fluid">
					<!-- Toggle button -->
					<button class="navbar-toggler" type="button"
						data-mdb-toggle="collapse"
						data-mdb-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-bars"></i>
					</button>

					<!-- Collapsible wrapper -->
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<!-- Navbar brand -->
						<a class="navbar-brand mt-2 mt-lg-0" href="#"> <img
							src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
							height="15" alt="MDB Logo" loading="lazy" />
						</a>
						<!-- Left links -->
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link" href="#">Dashboard</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">Team</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Projects</a>
							</li>
						</ul>
						<!-- Left links -->
					</div>
					<!-- Collapsible wrapper -->

					<!-- Right elements -->
					<div class="d-flex align-items-center">
						<!-- Icon -->
						<a class="link-secondary me-3" href="#"> <i
							class="fas fa-shopping-cart"></i>
						</a>

						<!-- Notifications -->
						<div class="dropdown">
							<a class="link-secondary me-3 dropdown-toggle hidden-arrow"
								href="#" id="navbarDropdownMenuLink" role="button"
								data-mdb-toggle="dropdown" aria-expanded="false"> <i
								class="fas fa-bell"></i> <span
								class="badge rounded-pill badge-notification bg-danger">1</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-end"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="#">Some news</a></li>
								<li><a class="dropdown-item" href="#">Another news</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul>
						</div>
						<!-- Avatar -->
						<div class="dropdown">
							<a class="dropdown-toggle d-flex align-items-center hidden-arrow"
								href="#" id="navbarDropdownMenuAvatar" role="button"
								data-mdb-toggle="dropdown" aria-expanded="false"> <img
								src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
								class="rounded-circle" height="25"
								alt="Black and White Portrait of a Man" loading="lazy" />
							</a>
							<ul class="dropdown-menu dropdown-menu-end"
								aria-labelledby="navbarDropdownMenuAvatar">
								<li><a class="dropdown-item" href="#">My profile</a></li>
								<li><a class="dropdown-item" href="#">Settings</a></li>
								<li><a class="dropdown-item" href="#">Logout</a></li>
							</ul>
						</div>
					</div>
					<!-- Right elements -->
				</div>
				<!-- Container wrapper -->
			</nav>
			<!-- Navbar -->

			<div class="mt-5 mb-5">
				<h1>
					Welcome back:
					<%=admin%></h1>
			</div>

			<h2>Data list</h2>
			<table class="table align-middle mb-0 bg-white">
				<thead class="bg-light">
					<tr>
						<th>Name</th>
						<th>Title</th>
						<th>Status</th>
						<th>Position</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="d-flex align-items-center">
								<img src="https://mdbootstrap.com/img/new/avatars/8.jpg" alt=""
									style="width: 45px; height: 45px" class="rounded-circle" />
								<div class="ms-3">
									<p class="fw-bold mb-1">John Doe</p>
									<p class="text-muted mb-0">john.doe@gmail.com</p>
								</div>
							</div>
						</td>
						<td>
							<p class="fw-normal mb-1">Software engineer</p>
							<p class="text-muted mb-0">IT department</p>
						</td>
						<td><span class="badge badge-success rounded-pill d-inline">Active</span>
						</td>
						<td>Senior</td>
						<td>
							<button type="button" class="btn btn-link btn-sm btn-rounded">
								Edit</button>
						</td>
					</tr>
					<tr>
						<td>
							<div class="d-flex align-items-center">
								<img src="https://mdbootstrap.com/img/new/avatars/6.jpg"
									class="rounded-circle" alt="" style="width: 45px; height: 45px" />
								<div class="ms-3">
									<p class="fw-bold mb-1">Alex Ray</p>
									<p class="text-muted mb-0">alex.ray@gmail.com</p>
								</div>
							</div>
						</td>
						<td>
							<p class="fw-normal mb-1">Consultant</p>
							<p class="text-muted mb-0">Finance</p>
						</td>
						<td><span class="badge badge-primary rounded-pill d-inline">Onboarding</span>
						</td>
						<td>Junior</td>
						<td>
							<button type="button"
								class="btn btn-link btn-rounded btn-sm fw-bold"
								data-mdb-ripple-color="dark">Edit</button>
						</td>
					</tr>
					<tr>
						<td>
							<div class="d-flex align-items-center">
								<img src="https://mdbootstrap.com/img/new/avatars/7.jpg"
									class="rounded-circle" alt="" style="width: 45px; height: 45px" />
								<div class="ms-3">
									<p class="fw-bold mb-1">Kate Hunington</p>
									<p class="text-muted mb-0">kate.hunington@gmail.com</p>
								</div>
							</div>
						</td>
						<td>
							<p class="fw-normal mb-1">Designer</p>
							<p class="text-muted mb-0">UI/UX</p>
						</td>
						<td><span class="badge badge-warning rounded-pill d-inline">Awaiting</span>
						</td>
						<td>Senior</td>
						<td>
							<button type="button"
								class="btn btn-link btn-rounded btn-sm fw-bold"
								data-mdb-ripple-color="dark">Edit</button>
						</td>
					</tr>
				</tbody>
			</table>
			<nav aria-label="...">
				<ul class="pagination pagination-circle justify-content-center">
					<li class="page-item"><a class="page-link">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#">2 <span class="visually-hidden">(current)</span></a>
					</li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>