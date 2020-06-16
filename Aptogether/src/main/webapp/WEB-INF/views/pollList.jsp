<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/resources/css/Poll.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="menu.jsp"%>

		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<div
				class="d-sm-flex align-items-center justify-content-between mb-4">
				<h1 class="h3 mb-0 text-gray-800">투표생성</h1>
			</div>

			<!-- Content Row -->
			<div class="flex-column">
				<!-- 투표생성 모달 열기 -->
				<div class="mb-4 margin-auto max-width-card">
					<button type="button"
						class="text-white margin-auto btn custom-bg btn-lg"
						data-toggle="modal" data-target="#poll_modal">생성조지기</button>
				</div>

				<!-- pollList 출력 -->
				<c:forEach var="poll" items="${list}">
					<div class="card custom-bg mb-4 margin-auto max-width-card">

						<div class="card-body text-white">
							<h5 class="card-title">${poll.question }</h5>
							<p class="small text-white">${poll.contents }</p>
						</div>
						<div class="card-footer small text-white custom-bg">
							<img id="poll_hitcount" src="/resources/img/eye.png"> 조회수 :
							${poll.hitcount} <span class="margin-left-span"> <fmt:parseDate
									var="date" value="${poll.endDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
									value="${date }" pattern="yyyy년 M월 dd일 마감" />
								<button class="custom-bg text-white btn btn-outline-light"
									onclick="location.href='/keeper/pollDetail?seq=${poll.pollSeq }'">
									참여목록</button></span>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- 투표생성 모달 -->
			<div class="modal fade" id="poll_modal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<form action="/keeper/pollInsert" method="post">
						<div class="modal-content">
							<div class="modal-header">
								<div class="modal-title" id="myModalLabel">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">제목</span>
										</div>
										<input class="form-control" type="text" name="question">
									</div>
								</div>
								<button type="button" class="close off" onclick="deloption()"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="input-group margin-bottom-button">
									<div class="input-group-prepend">
										<span class="input-group-text">내용</span>
									</div>
									<textarea name="contents" class="form-control"
										aria-label="With textarea"></textarea>
								</div>
								<div class="option_input">
									<div class="inputs input-group margin-bottom-button">
										<div class="input-group-prepend">
											<span class="input-group-text">항목</span>
										</div>
										<input class="form-control" id="options" type="text"
											name="options">
										<button type="button" class="btn btn-outline-dark"
											onclick="add()" id="create">
											<span>Add</span>
										</button>
									</div>
								</div>
								<div class="input input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">시작</span>
									</div>
									<input type="date" name="startDate">
								</div>
								<div class="input input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">마감</span>
									</div>
									<input type="date" name="endDate">
								</div>



								<div class="modal-footer">
									<input type="submit" class="btn btn-outline-info" value="저장">
									<button type="button" class="off btn btn-outline-dark"
										onclick="deloption()" data-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->

	<!-- Footer -->
	<footer class="sticky-footer bg-white">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Copyright &copy; Your Website 2019</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->




	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<!-- 	<script src="/resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<!-- 	<script src="/resources/js/demo/chart-area-demo.js"></script>
	<script src="/resources/js/demo/chart-pie-demo.js"></script> -->
	<script src="/resources/js/poll.js"></script>

</body>

</html>
