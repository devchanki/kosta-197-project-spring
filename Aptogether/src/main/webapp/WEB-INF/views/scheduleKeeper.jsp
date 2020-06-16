<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="principal" property="principal" />

<!DOCTYPE html>
<html lang="ko">
<!doctype html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>안녕하세요. 아파투게더입니다.</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">


<link href="/resources/css/styles.css" rel="stylesheet">

<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">

<link rel="stylesheet" href="/resources/css/fullcalendar.min.css">
<!--  	<link rel="stylesheet" href="/Aptogether/dist/vendor/css/bootstrap.min.css">  -->
<link rel="stylesheet" href="/resources/css/select2.min.css">
<link rel="stylesheet"
	href="/resources/css/bootstrap-datetimepicker.min.css">


<!-- 캘린더 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet" href="/resources/css/main.css">

<script src="//unpkg.com/popper.js@1/dist/umd/popper.min.js"></script>
<!-- <script src="//unpkg.com/jquery@3/dist/jquery.min.js"></script> -->


<script src="/resources/vendor/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<style type="text/css">
.scheduleAccept {
	vertical-align: middle;
	background: url( "/resources/img/check_circle_outline.svg" ) no-repeat;
	border: none;
	width: 32px;
	height: 32px;
	cursor: pointer;
	margin-top: 5px;
	margin-left: 7px;
}

.scheduleReject {
	vertical-align: middle;
	background: url( "/resources/img/highlight_off.svg" ) no-repeat;
	border: none;
	width: 32px;
	height: 32px;
	cursor: pointer;
	margin-top: 5px;
}

.scheduleRefresh {
	vertical-align: middle;
	background: url( "/resources/img/refresh-24px.svg" ) no-repeat;
	border: none;
	width: 32px;
	height: 32px;
	cursor: pointer;
	margin-top: 5px;
	position: relative;
	top: 76px;
	left: 4px;
	z-index: 9999px !important;
}
}
</style>


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include page="managerMenu.jsp"/>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<!-- 					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div> -->

					<!-- Content Row -->
					<div class="row">
						<div class="container">
							<!-- 일자 클릭시 메뉴오픈 -->
							<div id="contextMenu" class="dropdown clearfix">
								<ul class="dropdown-menu dropNewEvent card" role="menu"
									aria-labelledby="dropdownMenu"
									style="display: block; position: static; margin-bottom: 4px;">
									<li><a class="dropdown-item" href="#">등록</a></li>
									<div class="dropdown-divider"></div>
									<li><a class="dropdown-item" href="#" data-role="close">Close</a></li>
								</ul>
							</div>

<!-- 							<div id="wrapper"> -->
<!-- 								<div id="toggle_dong"> -->
<!-- 									<input type="checkbox" class="filter" id="dong_toggle"  -->
<!-- 										data-toggle="toggle" data-on="우리 동" data-off="전체 일정" -->
<!-- 										data-height="30" data-onstyle="dark"> -->
<!-- 								</div> -->
<!-- 							</div> -->


							<div id="wrapper">
								<div id="loading"></div>
								<div id="calendar"></div>
							</div>


							<!-- 일정 추가 MODAL -->
							<div class="modal fade" tabindex="-1" role="dialog"
								id="eventModal">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title"></h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">x</span>
											</button>
										</div>

										<div class="modal-body">

											<div class="container-fluid">
												<div class="col-12">
													<input class="IdNewEvent" id="edit-Id" type="hidden">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<input class="SeqNewEvent" id="edit-Apt-Seq" type="hidden" value="${principal.aptSeq}">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<input class="AuthNewEvent" id="edit-auth" type="hidden">
												</div>
											</div>



											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-title">일정명</label> <input
														class="inputModal" type="text" name="edit-title"
														id="edit-title" required="required">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-dong">동</label> <input
														class="inputModal" type="text" name="edit-dong"
														id="edit-dong" required="required">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-start">시작</label> <input
														class="inputModal" type="datetime-local" name="edit-start"
														id="edit-start">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-end">끝</label> <input
														class="inputModal" type="datetime-local" name="edit-end"
														id="edit-end">
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-type">구분</label> 
													<select class="inputModal" type="text" name="edit-type" id="edit-type">
														<option value="등록">등록</option>
														<option value="수정">수정</option>
													</select>
												</div>
											</div>

											<div class="container-fluid">
												<div class="col-12">
													<label class="col-4" for="edit-color">색상</label> <select
														class="inputModal" name="Color" id="edit-color">
														<option value="#F5A9A9" style="color: #F5A9A9;">주요일정</option>
														<option value="#A9D0F5" style="color: #A9D0F5;">전체일정</option>
														<option value="#F5D0A9" style="color: #F5D0A9;">동일정</option>
													</select>
												</div>
											</div>
											<div class="container-fluid">
												<div class="col-12"
													style="display: flex; align-items: center;">
													<label class="col-4" for="edit-desc">설명</label>
													<textarea rows="4" cols="50" class="inputModal"
														name="edit-desc" id="edit-desc"></textarea>
												</div>
											</div>
										</div>
										<div class="modal-footer modalBtnContainer-addEvent">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">취소</button>
											<button type="button" class="btn btn-primary" id="save-event">저장</button>
										</div>
										<div class="modal-footer modalBtnContainer-modifyEvent">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">닫기</button>
											<button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
											<button type="button" class="btn btn-primary"
												id="updateEvent">저장</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
					</div>

					<!-- table -->

					<div class="container" id="auth_tb">
						<button type="button" class="scheduleRefresh"></button>

						<div id="wrapper">
							<table id="auth_table" class="display">


								<thead>
									<tr>
										<!-- 									<th>글번호</th> -->
										<th>제목</th>
										<th>상세내역</th>
										<th>동</th>
										<th>Start date</th>
										<th>end date</th>
										<th>구분</th>
										<th>비고</th>
									</tr>
								</thead>
								<c:forEach items="${list }" var="schedule">
									<tr>
										<%-- <td><c:out value="${schedule.scheduleSeq }"/></td> --%>
										<td><c:out value="${schedule.title }" /></td>
										<td><c:out value="${schedule.contents }" /></td>
										<td><c:out value="${schedule.dong }" /></td>
										<td><c:out value="${schedule.startDate }" /></td>
										<td><c:out value="${schedule.endDate }" /></td>
										<td><c:out value="${schedule.states }" /></td>
										<td>
										
											<button type="button" class="scheduleAccept"
												value="${schedule.scheduleSeq }"></button>
											<button type="button" class="scheduleReject"
												value="${schedule.scheduleSeq }"></button>
										</td>
									</tr>
								</c:forEach>
								<tbody>

								</tbody>
							</table>
						</div>


					</div>
				</div>
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2019</span>
					</div>
				</div>
			</footer>
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
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">X</span>
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

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script
		src="/resources/js/fullcalendar/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<!-- 	<script src="/Aptogether/js/demo/chart-area-demo.js"></script>
	<script src="/Aptogether/js/demo/chart-pie-demo.js"></script>
	<script src="/Aptogether/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="/Aptogether/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	<script src="/Aptogether/js/demo/datatables-demo.js"></script> -->
	<script src="/resources/js/moment.min.js"></script>
	<script
		src="/resources/js/fullcalendar/bootstrap/js/bootstrap-datetimepicker.min.js"></script>

	<script src="/resources/js/scripts.js"></script>

	<script
		src="/resources/js/fullcalendar/bootstrap/js/fullcalendar.min.js"></script>
	<script src="/resources/js/fullcalendar/bootstrap/js/ko.js"></script>
	<script src="/resources/js/fullcalendar/bootstrap/js/select2.min.js"></script>
	<script src="/resources/js/fullcalendar/mainKeeper.js"></script>
	<script src="/resources/js/fullcalendar/addEventKeeper.js"></script>
	<script src="/resources/js/fullcalendar/editEventKeeper.js"></script>
	<script src="/resources/js/fullcalendar/etcSetting.js"></script>

	<!-- 캘린더 크기 조정 -->
	<script>
		$(document).ready(function() {
					$(window).resize(
							function() {$('#calendar').fullCalendar('option', 'height', get_calendar_height());
							});

					//set fullcalendar height property
					$('#calendar').fullCalendar({
						//options
						height : get_calendar_height
					});

				});
	</script>

	<!-- 승인 테이블 script -->
	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#auth_table').DataTable({
				"scrollY" : "200px",
				"scrollCollapse" : true,
				"paging" : false
			});
		});
	</script>

	<!-- 버튼 onclick script-->
	<script type="text/javascript">
		$(document).ready(function() {
			$('.scheduleAccept').on('click', function() {
				$.ajax({
					url : "/keeper/admitSchedule/" + $(this).val(),
					type : "put",
					dataType : "json",
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						alert('요청이 등록되었습니다.');
						location.reload();
					}
				});

			});
			
			//.. 요청 삭제
			$('.scheduleReject').on('click', function() {
				$.ajax({
					type : "delete",
					url : "/keeper/" + $(this).val(),
					dataType : "json",
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						alert('요청이 삭제되었습니다.');
						location.reload();
					}
				});

			});
			
 			//.. 새로고침
			$('.scheduleRefresh').on('click', function() {
				$.ajax({
					type : "get",
				      url: "/keeper/admitShowSchedule/"+'${principal.aptSeq}',
				      dataType: "json",
				      success: function (response) {
				    	  console.log("start.....");
				    	  console.log(response);
				      }
				    });
				}); //ajax 끝
			
			});
		
	</script>

	<link
		href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css"
		rel="stylesheet">
	<script
		src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>



</body>
</html>