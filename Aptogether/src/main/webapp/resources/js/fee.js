console.log("$Fee module$");


var feeServcie = (function() {
	
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
	
	
	function insertFee(fee, callback, error) {
		console.log("insert fee.....");
		
		$.ajax({
			type : "post",
			url : "/keeper1/insertFee",
			data : JSON.stringify(fee),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
			if (callback) {
				callback(result);
				alert("입력에 성공하셨습니다.");
				location.reload();
			} else {
				alert("잠시후 다시 시도해주세요.");
			}
		},
		error : function(xhr, status, er) {
			if(error){
				error(er);
			}
		}
	  });
	}
	
	
	
	
	return {
		findMember : findMember,
		insertFee : insertFee
	};
})();
