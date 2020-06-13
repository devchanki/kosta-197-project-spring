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
<link href="/resources/css/sign.css" rel="stylesheet">
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
				<h1 class="h3 mb-0 text-gray-800">투표참여</h1>
			</div>

			<!-- Content Row -->
			<div class="flex-column">
				<!-- pollList 출력 -->
				<c:forEach var="poll" items="${list}">
					<div class="card custom-bg mb-4 margin-auto max-width-card"
						data-toggle="modal" data-target="#option_modal"
						onclick="showData(${poll.pollSeq} , '${poll.question}', '${poll.contents }'  )">
						<div class="card-body text-white">
							<h5 class="card-title">${poll.question }</h5>
							<p class="small text-white">
								<c:set var="contents" value="${poll.contents }" />
								${fn:substring(contents,0,20)}...
							</p>
						</div>
						<div class="card-footer custom-bg small text-white">
							<img id="poll_hitcount" src="/resources/img/eye.png"> 조회수 :
							${poll.hitcount} <span class="margin-left-span"><fmt:parseDate
									var="date" value="${poll.endDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
									value="${date }" pattern="yyyy년 MM월 dd일 마감" /> </span>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- 투표선택 모달 시작 -->
			<div class="modal fade" id="option_modal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel"></h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<h5 id="myModalContents"></h5>
						</div>
						<div class="modal-body">
							<div class="alert alert-danger" role="alert">선택 해 주세요.</div>
							<div class="option_modal_body"></div>
							<div class="modal-footer">
								<button id="optionSelect" type="button" onclick="selectOption()"
									data-toggle="modal" class="btn btn-outline-info">선택</button>
								<button id="selectClose" type="button"
									class="btn btn-outline-dark" data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 투표선택 모달 끝 -->

			<!-- 전자서명 모달 시작 -->
			<div class="modal fade" id="sign_modal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel1">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div id="signature-pad" class="m-signature-pad">
							<div class="m-signature-pad--body">
								<canvas width="300" height="400" id="cpad"></canvas>

							</div>
							<div class="m-signature-pad--footer">
								<button type="button"
									class="btn btn-outline-danger button clear" data-action="clear">지우기</button>
								<button type="button" class="btn btn-outline-info button save"
									data-action="save" data-dismiss="modal">저장</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 전자서명 모달 끝 -->
		</div>
		<!-- End of Main Content -->
	</div>


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
	<script src="/resources/js/signature_pad.min.js"></script>

	<!-- Page level plugins -->
	<!-- 		<script src="/Aptogether/vendor/chart.js/Chart.min.js"></script>

	Page level custom scripts
	<script src="/Aptogether/js/demo/chart-area-demo.js"></script>
	<script src="/Aptogether/js/demo/chart-pie-demo.js"></script> -->
	<script src="/resources/js/poll.js"></script>
	<script src="/resources/js/sign.js"></script>
	<script>
		/* $('#d').click(function(){
			location.reload();
		}) */
 		$(function () {
			console.log($("#signature-pad canvas")[0]);
			resizeCanvas();
		}) 

	</script>

</body>

</html>
