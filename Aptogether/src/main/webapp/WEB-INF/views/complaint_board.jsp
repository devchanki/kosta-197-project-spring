<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
<title>안녕하세요. 아파투게더입니다.</title>

<!-- Custom fonts for this template-->
<link href="/resources/css/all.min.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/css/complaint_board.css">
	<style>
		.active a{
			color: red;
		}
	</style>
	</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="userMenu.jsp"%>
		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Content Row -->
			<div class="row">
				<div class="col-xl-12">
					<div id="maintitle">나의 민원</div>
					<hr align="center" style="border: solid 2px #CCCCCC; width: 65%;">


					<div id="comptable ">
						<div id="accordion">
							<c:forEach var="aaa" items="${list}">
								<div id="accotitle">${aaa.comptitle }</div>
								<div class="accocontent">
									<div id="contenttext">
										<p>
											제목: ${aaa.comptitle }<br> 
											내용: ${aaa.compcontent } <br>
										</p>
									</div>
									




									  <div id="buttonArea">
											<a class ="example_c" href="/tenant/complaint/remove?compbno=${ aaa.compbno }">문의
												취소</a> 
									</div> 
								</div>
							</c:forEach>
						</div>
					</div>




					<div class='pull-right'>
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li class="paginate_button previous"><a
									href="${pageMaker.startPage -1}">Previous</a></li>
							</c:if>
							
							<c:forEach var="num" begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}">
								<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">
									<a href="${num }">${num}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next}">
								<li class="paginate_button next"><a
									href="${pageMaker.endPage + 1 }">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>

				


	<a class="example_f" href="/tenant/complaint/select"
	rel="nofollow"><span>민원 작성</a>
				
				
			</div>
		</div>
	</div>
	<!-- End of Main Content -->

	<!-- End of Footer -->

	<!-- End of Content Wrapper -->
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	
	<!-- End of Page Wrapper -->

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
						<span aria-hidden="true">x</span>
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

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/js/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#accordion").accordion();
		});
	</script>
	
	<form id='actionForm' action="/tenant/complaint/getlist"
					method='get'>
					<input type='hidden' name='pageNum'
						value='${pageMaker.cri.pageNum }'> <input type='hidden'
						name='amount' value='${pageMaker.cri.amount }'>
				</form>
				
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var result = '<c:out value="${result}"/>';

							checkModal(result);

							history.replaceState({}, null, null);

							function checkModal(result) {

								if (result === '' || history.state) {
									return;
								}

								if (parseInt(result) > 0) {
									$(".modal-body").html(
											"게시글 " + parseInt(result)
													+ " 번이 등록되었습니다.");
								}

								$("#myModal").modal("show");
							}
							$("#regBtn").on("click", function() {
								self.location = "/tenant/complaint/write";
							});
							var actionForm = $("#actionForm");

							$(".paginate_button a").on(
									"click",
									function(e) {
										e.preventDefault();

										console.log('click');

										actionForm
												.find("input[name='pageNum']")
												.val($(this).attr("href"));
										actionForm.submit();
									});
						});
		
	
	</script>
	
</body>



</html>