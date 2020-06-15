<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<script src="/resources/vendor/jquery/jquery.js"></script>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
		<jsp:include page="managerMenu.jsp"></jsp:include>
		<!-- End of Topbar -->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">게시물 등록</h1>
			</div>
		</div>

		<!-- Begin Page Content -->
		<div class="row">
			<!-- start row -->
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel panel-heading">공지사항</div>
					<div class="panel-body">

						<!-- form 시작 -->
						<form role="form" action="/keeper/modifyNotice" method="post">
							<div class="form-group">
								<label>글번호</label><input class="form-control" name="noticeSeq"
									value='<c:out value="${notice.noticeSeq }"/>'
									readonly="readonly">
							</div>
							<div class="form-group">
								<label>제목</label><input class="form-control" name="title"
									value='<c:out value="${notice.title }"/>'>
							</div>

							<div class="form-group">
								<label>구분</label><input class="form-control" name="category"
									value='<c:out value="${notice.category }"/>'>
							</div>

							<div class="form-group">
								<label>text area</label>
								<textarea class="form-control" rows="3" name="content"><c:out
										value="${notice.content }" /></textarea>
							</div>
							<button type="submit" data-oper='modify' class="btn btn-success">수정</button>
							<button type="submit" data-oper='remove' class="btn btn-danger">삭제</button>
							<button type="submit" data-oper='list' class="btn btn-info">목록</button>
						</form>
					</div>
					<!-- end  panel-body -->
				</div>
				<!-- end panel -->
			</div>
		</div>
		<!-- end row -->

		<!-- Page Heading -->

		<!-- End of Main Content -->

		<script>
		$(function() {
			var formObj = $("form");
			$('button').on("click", function(e) {
				e.preventDefault();
				var operation = $(this).data("oper");
				console.log(operation);

				if (operation === 'remove') {
					formObj.attr("action", "/keeper/removeNotice");
				} else if (operation === 'list') {
					//move to list
					self.location = "/keeper/listNotice";
					return;
				}
				formObj.submit();
			});
		});
		
		
// 			$(document).ready(function() {
// 				var formObj = $("form");
// 				$('button').on("click", function(e) {
// 					e.preventDefault();
// 					var operation = $(this).data("oper");
// 					console.log(operation);

// 					if (operation === 'remove') {
// 						formObj.attr("action", "/keeper/removeNotice");
// 					} else if (operation === 'list') {
// 						//move to list
// 						self.location = "/keeper/listNotice";
// 						return;
// 					}
// 					formObj.submit();
// 				});
// 			});
		</script>


		<!-- /.container-fluid -->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>
					<div class="modal-body">정말 로그아웃 하시겠습니까?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="/Aptogether/member/logout.do">Logout</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End of Footer -->

	<!-- End of Content Wrapper -->

	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	<script src="/resources/js/demo/datatables-demo.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</body>

</html>