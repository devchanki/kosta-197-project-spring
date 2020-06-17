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
		<%@ include file="managerMenu.jsp"%>

		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<div
				class="d-sm-flex align-items-center justify-content-between mb-4">
				<h1 class="h3 mb-0 text-gray-800">투표상세</h1>
			</div>
			<!-- Content Row -->
			<div class="flex-column">

				<table class="table table-hover table-borderless">
					<thead>
						<tr class="table-primary">
							<th scope="col">동</th>
							<th scope="col">호수</th>
							<th scope="col">이름</th>
							<th scope="col">선택</th>
							<th scope="col">서명</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dt" items="${detail}">
							<tr>
								<td>${dt.dong}</td>
								<td>${dt.ho}</td>
								<td>${dt.name}</td>
								<td>${dt.optionSeq}</td>
								<td><img
									src="/keeper/pollSignThumnail?fileName=${dt.fileName}"
									onclick="imgName('${dt.fileName}')"
									data-toggle="modal" data-target="#showimg_modal"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="modal fade" id="showimg_modal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<img class="bigPicture" >
					</div>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->


	</div>
	<!-- End of Main Content -->

	<!-- Footer -->
	<jsp:include page="footer.jsp" />
	<!-- End of Footer -->

	</div>
	<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include page="logoutModal.jsp" />

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>
	<script src="/resources/js/poll.js"></script>

	<!-- Page level plugins -->
	<!-- 	<script src="/resources/vendor/chart.js/Chart.min.js"></script> -->

	<!-- Page level custom scripts -->
	<!-- 	<script src="/resources/js/demo/chart-area-demo.js"></script>
	<script src="/resources/js/demo/chart-pie-demo.js"></script> -->

</body>

</html>
