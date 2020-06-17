<%@page import="org.aptogether.domain.TenantFeeInfoVO"%>
<%@page import="org.aptogether.domain.FeeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
   List<TenantFeeInfoVO> list = (List<TenantFeeInfoVO>) request.getAttribute("tenantFeeInfo");
   List<TenantFeeInfoVO> listReverse = new ArrayList<TenantFeeInfoVO>();
   if (list != null) {
   	for (int i = list.size() - 1; i >= 0; i--) {
   		listReverse.add(list.get(i));
   	}
   	request.setAttribute("reverseFee", listReverse);
   }
%>
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
      <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
      <link  href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"  rel="stylesheet">
      <!-- Custom styles for this template-->
      <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
      <style type="text/css">
      .card-body .table{
          	color: black;
    	  	font-weight: bolder;
    	}
		.card-body .table thead tr{
			height: 60px;
		} 
		.card-body .table thead tr th{
			vertical-align: middle;
		} 		
		.card-body .table tbody tr {
			height: 60px;
		}
		.card-body .table tbody tr td{
			vertical-align: middle;
		}		
		.pieCharts canvas{
			display: inline;
		}
		.pieCharts{
			float: left;
			width: 300px;
			margin: 15px 15px 0 10px;
		}
		.pieDate{
			position: relative;
			left: 95px;
		}
		.pieFee{
			    position: relative;
			    left: 115px;
			    top: 15px;
		}
      </style>
      <script type="text/javascript">
			var data = [];
			var label = [];
			
			<c:forEach items="${reverseFee}" var = "feeInfo">
			console.log("${feeInfo}");
			data.push(${feeInfo.getTotalFee()});
			console.log("${feeInfo.deadlineDate}");
			var tmpDate = new Date("${feeInfo.deadlineDate}");
         	console.log(tmpDate);
         	console.log(tmpDate.getFullYear());
         	label.push(tmpDate.getFullYear() + "-" + (tmpDate.getMonth()+1));
			</c:forEach>
			
	          var pieData1 = [${last.getGeneralBill()}, ${last.getSecurityBill()}, ${last.getCleaningBill()}, ${last.getFumigationBill()},
	          							${last.getElevatorBill()}, ${last.getElectricityBill()}, ${last.getWaterBill()} ];
	          var pieData2 = [${beforeLast.getGeneralBill()}, ${beforeLast.getSecurityBill()}, ${beforeLast.getCleaningBill()}, ${beforeLast.getFumigationBill()},
	          							${beforeLast.getElevatorBill()}, ${beforeLast.getElectricityBill()}, ${beforeLast.getWaterBill()} ];
	          var pieData3= [${thirdLast.getGeneralBill()}, ${thirdLast.getSecurityBill()}, ${thirdLast.getCleaningBill()}, ${thirdLast.getFumigationBill()},
	          							${thirdLast.getElevatorBill()}, ${thirdLast.getElectricityBill()}, ${thirdLast.getWaterBill()} ];
	          var pieData4 = [${fourthLast.getGeneralBill()}, ${fourthLast.getSecurityBill()}, ${fourthLast.getCleaningBill()}, ${fourthLast.getFumigationBill()},
	          							${fourthLast.getElevatorBill()}, ${fourthLast.getElectricityBill()}, ${fourthLast.getWaterBill()} ];
	          var pieData5 = [${fifthLast.getGeneralBill()}, ${fifthLast.getSecurityBill()}, ${fifthLast.getCleaningBill()}, ${fifthLast.getFumigationBill()},
	          							${fifthLast.getElevatorBill()}, ${fifthLast.getElectricityBill()}, ${fifthLast.getWaterBill()} ];
	          var pieData6 = [${sixthLast.getGeneralBill()}, ${sixthLast.getSecurityBill()}, ${sixthLast.getCleaningBill()}, ${sixthLast.getFumigationBill()},
	          							${sixthLast.getElevatorBill()}, ${sixthLast.getElectricityBill()}, ${sixthLast.getWaterBill()} ];
	          
	          
	          pieData1.push;
	          pieData2.push;
	          pieData3.push;
	          pieData4.push;
	          pieData5.push;
	          pieData6.push;
    </script>
   </head>
   <body id="page-top">
      <!-- Page Wrapper -->
      <div id="wrapper">
         <!-- Sidebar -->
         <%@ include file="userMenu.jsp"%>
         <!-- Begin Page Content -->
          <div class="container-fluid">
            <!-- Page Heading -->
            <div  class="d-sm-flex align-items-center justify-content-between mb-4">
               <h1 class="h3 mb-0 text-gray-800"><c:out value="${last.getName()}"/>님 환영합니다</h1>
            </div>
            <!-- Content Row -->
            <div class="row">
               <!-- 관리비조회 -->
               <div class="col-xl-8 col-lg-8">
                  <div class="card shadow mb-4">
                     <!-- Card Header - Dropdown -->
                     <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between" style="font-weight: bolder;color: #4e73df!important;">
              	        <fmt:parseDate var="date" value="${last.levyDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                        <fmt:formatDate value="${date}" pattern="yyyy년 MM월 관리비 " />
                     </div>
                     <!-- Card Body1 -->
                        <div class="card-body">
                        	<div class="cardContent1" style="float: left;">
                           		<img src="/resources/img/receipt.png" alt="관리비" style="width: 100px; height: 100px;">
                        	</div>
                        	<div class="cardContent2" style="float: left;height: 100px;margin: 10px 0 5px 15px;">
                                 <c:choose>
	                               <c:when test="${last eq null}">
	                                 <h5 class="card-title">고지된 관리비가 없습니다.</h5>
	                                 <h3 class="card-text">
	                                    <b id="thisMonthFee"> 현재 관리비가 존재하지 않습니다. </b>
	                                 </h3>
	                               </c:when>
	                               <c:otherwise>
	                                 <h1 class="card-text">
	                                    <b>${last.getTotalFee()}원</b>
	                                 </h1>
		                              <p class="card-text">
	                                    
	                                       전월대비 
	                                       <c:choose>
	                                          <c:when
	                                             test="${last.getTotalFee() gt beforeLast.getTotalFee()}">
	                                             <img src="/resources/img/up.png" alt="up"
	                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
	                                             ${last.getTotalFee() - beforeLast.getTotalFee()}원
	                                          </c:when>
	                                          <c:when
	                                             test="${last.getTotalFee() lt beforeLast.getTotalFee()}">
	                                             <img src="/resources/img/down.png" alt="down"
	                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
	                                             ${beforeLast.getTotalFee() - last.getTotalFee()}원
	                                          </c:when>
	                                          <c:when
	                                             test="${last.getTotalFee() eq beforeLast.getTotalFee()}">
	                                             <img src="/resources/img/equal.png" alt="down"
	                                                style="width: 20px; height: 20px; padding-bottom: 3px;">
	                                             관리비 부과액이 같습니다(증감액 0원)
	                                          </c:when>
	                                       </c:choose>
	                                    
	                                 </p>
                                 	</c:otherwise>
                                 </c:choose>
                       		</div>
							<div class="cardContent3" style="float: left;height: 100px;margin-left: 50px;">
                                 <p class="card-text">
                                          <small class="text-muted" style="position: relative; top: 63px;">
                                             <fmt:parseDate
                                                var="date" value="${last.deadlineDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="납부기한은 yyyy년 MM월 dd일 입니다 " />
                                          </small>
                                  </p>
                           </div>
                        </div>
                     <!-- Card Body2 -->
                     <div class="card-body">
                        <div class="chart-area">
                           <canvas id="myAreaChart"></canvas>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- 관리비 상세내역 -->
               <div class="col-xl-4 col-lg-4">
                  <div class="card shadow mb-4">
                     <!-- Card Header - Dropdown -->
                     <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between" style=" height: 56.53px;">
                        <h6 class="m-0 font-weight-bold text-primary">관리비 상세내역</h6>
                     </div>
                   <!--   <div class="accordion" id="accordionExample"> -->
<!--                            <div class="card-header" id="headingOne">
                              <h2 class="mb-0">
                                 <button class="btn btn-link collapsed" type="button"
                                    data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true" aria-controls="collapseOne">
                                 상세내역조회</button>
                              </h2>
                           </div> -->
                          <!--  <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample"> -->
                              <div class="card-body" style="height: 515px;">
                                 <table class="table">
                                    <c:choose>
                                       <c:when test="${not empty beforeLast}">
                                          <thead>
                                             <tr>
                                                <th scope="row">항목</th>
                                                <th scope="row">전월</th>
                                                <th scope="row">당월</th>
                                             </tr>
                                          </thead>
                                          <tbody>
                                             <tr>
                                                <td>일반관리비</td>
                                                <td>${ beforeLast.getGeneralBill() }원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getGeneralBill() gt beforeLast.getGeneralBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getGeneralBill() lt beforeLast.getGeneralBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getGeneralBill() eq beforeLast.getGeneralBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${ last.getGeneralBill() }원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>경비비</td>
                                                <td>${ beforeLast.getSecurityBill()}원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getSecurityBill() gt beforeLast.getSecurityBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getSecurityBill() lt beforeLast.getSecurityBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getSecurityBill() eq beforeLast.getSecurityBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${ last.getSecurityBill()}원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>청소비</td>
                                                <td>${ beforeLast.getCleaningBill() }원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getCleaningBill() gt beforeLast.getCleaningBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getCleaningBill() lt beforeLast.getCleaningBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getCleaningBill() eq beforeLast.getCleaningBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${ last.getCleaningBill() }원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>소독비</td>
                                                <td>${beforeLast.getFumigationBill()}원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getFumigationBill() gt beforeLast.getFumigationBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getFumigationBill() lt beforeLast.getFumigationBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getFumigationBill() eq beforeLast.getFumigationBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${last.getFumigationBill()}원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>승강비유지비</td>
                                                <td>${beforeLast.getElevatorBill()}원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getElevatorBill() gt beforeLast.getElevatorBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getElevatorBill() lt beforeLast.getElevatorBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getElevatorBill() eq beforeLast.getElevatorBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${last.getElevatorBill()}원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>전기세</td>
                                                <td>${beforeLast.getElectricityBill()}원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getElectricityBill() gt beforeLast.getElectricityBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getElectricityBill() lt beforeLast.getElectricityBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getElectricityBill() eq beforeLast.getElectricityBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${last.getElectricityBill()}원
                                                </td>
                                             </tr>
                                             <tr>
                                                <td>수도세</td>
                                                <td>${beforeLast.getWaterBill()}원</td>
                                                <td>
                                                   <c:choose>
                                                      <c:when
                                                         test="${last.getWaterBill() gt beforeLast.getWaterBill()}">
                                                         <img src="/resources/img/up.png" alt="up"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getWaterBill() lt beforeLast.getWaterBill()}">
                                                         <img src="/resources/img/down.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                      <c:when
                                                         test="${last.getWaterBill() eq beforeLast.getWaterBill()}">
                                                         <img src="/resources/img/equal.png" alt="down"
                                                            style="width: 20px; height: 20px; padding-bottom: 3px;">
                                                      </c:when>
                                                   </c:choose>
                                                   ${last.getWaterBill()}원
                                                </td>
                                             </tr>
                                          </tbody>
                                       </c:when>
                                       <c:when test="${ not empty last and empty beforeLast}">
                                          <thead>
                                             <tr>
                                                <th scope="row">항목</th>
                                                <th scope="row">당월</th>
                                             </tr>
                                          </thead>
                                          <tbody>
                                             <tr>
                                                <td>일반관리비</td>
                                                <td>${last.getGeneralBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>경비비</td>
                                                <td>${last.getSecurityBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>청소비</td>
                                                <td>${last.getCleaningBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>소독비</td>
                                                <td>${last.getFumigationBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>승강비유지비</td>
                                                <td>${last.getElevatorBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>전기세</td>
                                                <td>${last.getElectricityBill()}원</td>
                                             </tr>
                                             <tr>
                                                <td>수도세</td>
                                                <td>${last.getWaterBill()}원</td>
                                             </tr>
                                          </tbody>
                                       </c:when>
                                       <c:otherwise>
                                          관리비 데이터가 존재하지 않습니다.
                                       </c:otherwise>
                                    </c:choose>
                                 </table>
                              </div>
                         <!--   </div> -->
                       <!--  </div> -->
<%--                         <div class="card">
                           <div class="card-header" id="headingTwo">
                              <h2 class="mb-0">
                                 <button class="btn btn-link collapsed" type="button"
                                    data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false" aria-controls="collapseTwo">
                                 월별청구내역</button>
                              </h2>
                           </div>
                           <div id="collapseTwo" class="collapse"
                              aria-labelledby="headingThree" data-parent="#accordionExample">
                              <div class="card-body">
                                 <table class="table">
                                    <thead>
                                       <th scope="row">월별</th>
                                       <th scope="row">관리비 납입액</th>
                                       <th scope="row">차트보기</th>
                                    </thead>
                                    <tbody>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date" value="${last.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${last.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal1">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal1" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="lastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span> 
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date"
                                                value="${beforeLast.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${beforeLast.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal2">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal2" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="beforeLastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span>
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date"
                                                value="${thirdLast.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${thirdLast.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal3">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal3" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="thirdLastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span>
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date"
                                                value="${fourthLast.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${fourthLast.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal4">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal4" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="fourthLastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span>
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date"
                                                value="${fifthLast.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${fifthLast.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal5">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal5" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="fifthLastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span>
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                       <tr>
                                          <td>
                                             <fmt:parseDate var="date"
                                                value="${sixthLast.levyDate}"
                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                             <fmt:formatDate
                                                value="${date }" pattern="yyyy년 MM월" />
                                          </td>
                                          <td>${sixthLast.getTotalFee()}원</td>
                                          <td>
                                             <!-- Button trigger modal -->
                                             <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#exampleModal6">
                                             상세보기</button> <!-- Modal -->
                                             <div class="modal fade" id="exampleModal6" tabindex="-1"
                                                role="dialog" aria-labelledby="exampleModalLabel"
                                                aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                   <div class="modal-content">
                                                      <div class="modal-header">
                                                         <h5 class="modal-title" id="exampleModalLabel">관리비
                                                            차트 상세보기
                                                         </h5>
                                                         <button type="button" class="close"
                                                            data-dismiss="modal" aria-label="Close">
                                                         <span aria-hidden="true">&times;</span>
                                                         </button>
                                                      </div>
                                                      <div class="modal-body">
                                                         <div class="chart-pie pt-4 pb-2">
                                                            <canvas id="sixthLastPieChart"></canvas>
                                                         </div>
                                                         <div class="mt-4 text-center small">
                                                            <span class="mr-2"> <i
                                                               class="fas fa-circle text-primary"></i> 일반관리비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-success"></i> 경비비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #ccce26"></i>청소비
                                                            </span> <span class="mr-2"> <i class="fas fa-circle"
                                                               style="color: #d2b9e3"></i>소독비
                                                            </span><br> <span class="mr-2"> <i
                                                               class="fas fa-circle" style="color: #ff9232"></i>승강기유지비
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-warning"></i>전기세
                                                            </span> <span class="mr-2"> <i
                                                               class="fas fa-circle text-info"></i>수도세
                                                            </span>
                                                         </div>
                                                      </div>
                                                      <div class="modal-footer">
                                                         <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close</button>
                                                      </div>
                                                   </div>
                                                </div>
                                             </div>
                                          </td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                        </div> --%>
<!--                      </div> -->
               </div>
            </div>
            
            	<div class="col-xl-12 col-lg-12">
            		<div class="card shadow mb-12" >
            			<div class="card-body" style="height: 630px;">
            			
                         <div class="mt-4 text-left ">
                              <span class="mr-2"> <i class="fas fa-circle text-primary"></i> 일반관리비</span>
                              <span class="mr-2"> <i class="fas fa-circle text-success"></i> 경비비</span> 
                              <span class="mr-2"> <i class="fas fa-circle"  style="color: #ccce26"></i>청소비</span>
                              <span class="mr-2"> <i class="fas fa-circle"  style="color: #d2b9e3"></i>소독비</span>
                              <span class="mr-2"> <i class="fas fa-circle" style="color: #ff9232"></i>승강기유지비</span>
                              <span class="mr-2"> <i class="fas fa-circle text-warning"></i>전기세</span>
                              <span class="mr-2"> <i class="fas fa-circle text-info"></i>수도세</span>
                           </div>
            				
            				
		                    <div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${sixthLast.levyDate }" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>
		                       <canvas id="sixthLastPieChart"></canvas>
		                       <span class="pieFee">${sixthLast.getTotalFee()}원</span>
		                    </div>  
		                    
							<div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${fifthLast.levyDate }" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>							
		                        <canvas id="fifthLastPieChart"></canvas>
		                        <span class="pieFee">${fifthLast.getTotalFee()}원</span>
		                    </div>
		                    
		                    <div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${fourthLast.levyDate }" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>		                    
		                       <canvas id="fourthLastPieChart"></canvas>
		                       <span class="pieFee">${fourthLast.getTotalFee()}원</span>
		                    </div> 		                    

 							<div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${thirdLast.levyDate }" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>							
		                        <canvas id="thirdLastPieChart"></canvas>
		                        <span class="pieFee">${thirdLast.getTotalFee()}원</span>
		                    </div>
		                                     
		                    <div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${beforeLast.levyDate }" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>		                    
		                       <canvas id="beforeLastPieChart"></canvas>
		                       <span class="pieFee">${beforeLast.getTotalFee()}원</span>
		                    </div> 
            			
            				<div class="chart-pie pt-4 pb-2 pieCharts" >
		                    	<span class="pieDate">
		                    	<fmt:parseDate  var="date" value="${last.levyDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                <fmt:formatDate value="${date }" pattern="yyyy년 MM월 "/>
                                </span>            				
		                        <canvas id="lastPieChart"></canvas>
		                        <span class="pieFee">${last.getTotalFee()}원</span> 
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

