
		var canvas = document.querySelector("#cpad");

        var sign = new SignaturePad(canvas, {
            minWidth: 2,
            maxWidth: 3,
            penColor: "black"
        });
        
        $("[data-action]").on("click", function(){
            if ( $(this).data("action")=="clear" ){
                sign.clear();
            }
            else if ( $(this).data("action")=="save" ){
                if (sign.isEmpty()) {
                    alert("사인해 주세요");
                } else {
                	var formData = new FormData();
                	formData.append("optionSeq",selected);
                	var blobBin = atob(sign.toDataURL().split(',')[1]);	// base64 데이터 디코딩
                    var array = [];
                    for (var i = 0; i < blobBin.length; i++) {
                        array.push(blobBin.charCodeAt(i));
                    }
                    var file = new Blob([new Uint8Array(array)], {type: 'image/png'});	// Blob 생성
                    formData.append("file", file);	// file data 추가
                	
                	console.log(sign.toDataURL());
                    $.ajax({
                        url : '/tenant/pollSignUpload',
                        method : "POST",
                        processData : false,
                        contentType : false,
                        enctype: 'multipart/form-data',
                        data : formData,
                        success : function(result){
                            alert("저장완료 : " + result.filename);
                            sign.clear();
                        },
                        error : function(res){
                            console.log(res);
                        }
                    });
                }
            }
        });
         
         
        function resizeCanvas(){
            var canvas = $("#signature-pad canvas")[0];
     
            var ratio =  Math.max(window.devicePixelRatio || 1, 1);
            canvas.width = canvas.offsetWidth * ratio;
            canvas.height = canvas.offsetHeight * ratio;
            canvas.getContext("2d").scale(ratio, ratio);
        }
        $(window).on("resize", function(){
            resizeCanvas();
        });
        resizeCanvas();
        
        
        $('#sign_modal').on('shown.bs.modal', function (e) {
        	resizeCanvas()
        	drawSignature()
        	})