<%@page import="org.aptogether.domain.FeeVO"%>
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
      <link href="/resources/vendor/fontawesome-free/css/all.min.css"
         rel="stylesheet" type="text/css">
      <link
         href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
         rel="stylesheet">
      <!-- Custom styles for this template-->
      <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
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
               <h1 class="h3 mb-0 text-gray-800">${member.name }님환영합니다</h1>
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
                        <h6 class="m-0 font-weight-bold text-primary">관리비 추이</h6>
                     </div>
                     <!-- Card Body1 -->
                     <div class="card" style="margin: 30px 115px 20px 115px;"
                        align="center">
                        <div class="card-body">
                           <img src="/Aptogether/css/image/receipt.png" alt="관리비"
                              style="width: 100px; height: 100px; float: left;">
                           <c:choose>
                              <c:when test="${last eq null}">
                                 <h5 class="card-title">고지된 관리비가 없습니다.</h5>
                                 <h3 class="card-text">
                                    <b id="thisMonthFee"> 현재 관리비가 존재하지 않습니다. </b>
                                 </h3>
                              </c:when>
                              <c:otherwise>
                                 <h5 class="card-title">
                                    <fmt:parseDate var="date" value="${last.pay_date}"
                                       pattern="yyyy-MM-dd HH:mm:ss" />
                                    <fmt:formatDate value="${date }" pattern="yyyy년 MM월 관리비 " />
                                 </h5>
                                 <h3 class="card-text">
                                    <b> ${ last.getTotalValue()}원</b>
                                 </h3>
                                 <p class="card-text">
                                    <small class="text-muted">
                                       전월대비 
                                       <c:choose>
                                          <c:when
                                             test="${last.getTotalValue() gt beforeLast.getTotalValue()}">
                                             <img src="/Aptogether/css/image/up.png" alt="up"
                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
                                             ${last.getTotalValue() - beforeLast.getTotalValue()}원 증가	
                                          </c:when>
                                          <c:when
                                             test="${last.getTotalValue() lt beforeLast.getTotalValue()}">
                                             <img src="/Aptogether/css/image/down.png" alt="down"
                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
                                             ${beforeLast.getTotalValue() - last.getTotalValue()}원 감소
                                          </c:when>
                                          <c:when
                                             test="${last.getTotalValue() eq beforeLast.getTotalValue()}">
                                             <img src="/Aptogether/css/image/equal.png" alt="down"
                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
                                             관리비 부과액이 같습니다(증감액 0원)
                                          </c:when>
                                       </c:choose>
                                    </small>
                                 </p>
                              </c:otherwise>
                           </c:choose>
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

