<%@page import="org.aptogether.domain.FeeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication var="principal" property="principal" />
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport"
         content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="author" content="">
      <title>마이페이지</title>
      <!-- Custom fonts for this template-->
      <link href="/resources/vendor/fontawesome-free/css/all.min.css"
         rel="stylesheet" type="text/css">
      <link
         href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
         rel="stylesheet">
      <!-- Custom styles for this template-->
      <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
      <style type="text/css">
      	.wrap-info{
      		padding: 10px 5px;
      		font-size: 22px;
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
            <!-- Page Heading -->
            <div
               class="d-sm-flex align-items-center justify-content-between mb-4">
               <h1 class="h3 mb-0 text-gray-800">${principal.name }님 환영합니다</h1>
<!--                <a href="#"
                  class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                  class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>  -->
            </div>
            <!-- Content Row -->
            <div class="row">
               <!-- 관리비조회 -->
               <div class="col-xl-12 col-lg-12">
                  <div class="card shadow mb-4">
                     <!-- Card Header - Dropdown -->
                     <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">나의 정보</h6>
                     </div>
                     <!-- Card Body1 -->
                     <div class="card" >
                        <div class="card-body">
                        	<div class="wrap-info">
                        		ID : ${principal.id }
                        	</div>
                        	
                        	<div class="wrap-info">
                        		이름 : ${principal.name }
                        	</div>
                        	
							<div class="wrap-info">
								비밀번호 변경하기 {}
                        	</div>
 							
                        </div>
                     </div>
                  </div>
               </div>
            </div>
      <!-- End of Main Content -->
      <!-- Footer -->
      <!-- End of Footer -->
      </div>
      <!-- End of Content Wrapper -->
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
      <!-- End of Page Wrapper -->
      <!-- Scroll to Top Button-->
      <a class="scroll-to-top rounded" href="#page-top"> <i
         class="fas fa-angle-up"></i>
      </a>
      <!-- Logout Modal-->
      <jsp:include page="logoutModal.jsp"></jsp:include>
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
      <script src="/resources/js/moment.min.js"></script>
      <script src="/resources/js/demo/chart-area-demo.js"></script>
      <script src="/resources/js/demo/chart-pie-demo.js"></script>
      <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
      <script
         src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
      <script src="/resources/js/demo/datatables-demo.js"></script>
   </body>
</html>

