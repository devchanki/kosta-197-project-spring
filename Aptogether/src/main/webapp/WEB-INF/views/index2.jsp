<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
<link href="/resources/css/index.css" rel="stylesheet">
<link href="/resources/css/styles.css" rel="stylesheet" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aptogether - Main</title>


<style type="text/css">
.w3agile-ser h3 {
	font-size: 40px;
	text-align: center;
	margin-bottom: 50px;
	color: #fab001;
	font-weight: 600;
}

.w3agile-ser {
	padding: 5em 0;
	background-color: white;
	min-height: 400px;
}

.w3agile-ser-left {
	display: inline-block;
	width: 700px;
	height: 100px;
	margin: 1em;
}

.container {
	width: 1170px;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.w3agile-ser-top {
	border: 2px solid #175597;
	padding: 6px 14px;
}

.ser-lft h4 {
	font-size: 20px;
	color: #8c9ab4;
	font-weight: 600;
}

.ser-rgt h5 {
	display: inline-block;
	font-size: 20px;
	color: #175597;
}
</style>


</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/Aptogether/">Aptogether</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			</ul>
			<a class="btn btn-outline-dark my-2 my-sm-0" href="/createApt">아파트
				생성하기</a>
		</div>
	</nav>




	<!-- 	<div class="container-fluid main-section"> -->
	<!-- 		<div class="container"> -->
	<!-- 			<div class="row"> -->
	<!-- 				<div class="col-xl-5 select-box"> -->
	<!-- 					<div class="user">아파트 주민이십니까?</div> -->
	<!-- 					<a class="link" href="/tenant/signup"> 회원가입 </a> <a class="link" -->
	<!-- 						href="/tenant/signin"> 로그인 </a> -->
	<!-- 				</div> -->
	<!-- 				<div class="offset-xl-2 col-xl-5 select-box"> -->
	<!-- 					<div class="user">관리사무소 회원이십니까?</div> -->
	<!-- 					<a class="link" href="/keeper/signup"> 회원가입 </a> <a class="link" -->
	<!-- 						href="/keeper/signin"> 로그인 </a> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->


	<div class="w3agile-ser">
		<div class="container">
			<h3>APTOGETHER</h3>

			<div class="col-md-4 w3agile-ser-left">
				<div class="w3agile-ser-top">
					<div class="ser-lft">
						<h4>01</h4>
					</div>
					<div class="ser-rgt">
						<h5>입주민</h5>
					</div>
					<div class="clearfix">
								<a class="link" href="/tenant/signup"> 회원가입 </a> 
								<a class="link" href="/tenant/signin"> 로그인 </a> 
					</div>
				</div>
			</div>

			<div class="col-md-4 w3agile-ser-left">
				<div class="w3agile-ser-top">
					<div class="ser-lft">
						<h4>02</h4>
					</div>
					<div class="ser-rgt">
						<h5>관리자</h5>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>




	<div id="layoutAuthentication_footer">
		<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">KOSTA 197기 3기</div>
					<div>
						<a>김기찬 이철민 양현수 박서희 사현정 장성권</a>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>

</html>
