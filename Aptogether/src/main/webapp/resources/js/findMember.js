console.log("$Fee module$");


var FeeServcie = (function() {
	
	function findMember(param, callback, error) {
		console.log("find member.....");
		
		var aptSeq = param.aptSeq;
		var dong = param.dong;
		var ho = param.ho;
		
		$.get("/keeper1/" + aptSeq +"/" + dong + "/" + ho + ".json", function(result) {
			
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if(error){
				error();
			}
		});
	}
	return {
		findMember : findMember
	};
})();


























//var MQinfo = $('#MQinfo');
//
//$(function() {
//	//모달창 뜨기
//		$("#checkMQ").click(function() {
//			$("#findMQ-modal").modal('show');
//			return false;
//		});
//	//입주민번호 찾기 버튼	
//		$("#find_MQ").on('click', function() {
//					$.ajax({
//						type : "get",
//						url : "/keeper1/findMember",
//						data : {
//							dong : $('#dong').val(),
//							ho : $('#ho').val(),
//							aptSeq : 6,
//						},
//						success : function(result) {
//								console.log(result);
//								response = JSON.parse(result);
//								$('#findMQ-modal2').modal('show');
//								MQinfo.val("입주민번호 " + response.memberSeq + "　"+response.dong +"동  "+ response.ho+"호");
////								$('#moveMFR').attr("href", "/WEB-INF/view/InsertManageFee.jsp?memberSeq=" + response.memberSeq);
//						}
//					});
//					$("#findMQ-modal").modal('hide');
//		});
//		
//
//		$("#cancle_MQ").on('click', function() {
//			$('#dong').val('');
//			$('#ho').val('');
//		});
//		
//		$("#cancle_MQ2").on('click', function() {
//			$('#dong').val('');
//			$('#ho').val('');
//		});
//	
//});
