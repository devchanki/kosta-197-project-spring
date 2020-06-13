	var i = 1;
	var selected = -1;

	function add() {
		$('.option_input')
				.append(
						'<div id="input' + i + '" class = "intputs input-group margin-bottom-button" ><div class="input-group-prepend"><span class="input-group-text">항목</span></div><input id="options" type="text" class="form-control" name="options"><button type="button" class="btn btn-outline-dark" onclick="del('
								+ i
								+ ')" id="create_form"> <span aria-hidden="true">Del</span> </button></div>');
		i++;
	}

	function del(el) {
		$("#input" + el).remove();
	}

	function deloption() {
		$('.off').on('click', function() {
			$('.intputs').remove();
		})
	}

	$('#selectClose').click(function(){
		location.reload();
	})
	
	
	
	function showData(a,b,c) {
		$('#myModalLabel').html(b);
		$('#myModalContents').html(c);
		$('.option_modal_body').html("");
		$.ajax({
			url: "/tenant/pollOptionList",
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify({
				"pollSeq" : a
			}) ,
			success: function(data) {
				for(let i =0; i < data.length; i++){
					console.log(data[i]);

					$('.option_modal_body').append(
					
					'<div class="input-group"><div class="input-group-prepend">'
					 +'<div class="input-group-text">'
					 +'<input type="radio" name="seq" value="'
					 + data[i].optionSeq
					 +'" aria-label="Radio button for following text input">'
					 +'</div>'
					 +'</div>'
					 +'<input type="text" class="form-control"  aria-label="Text input with radio button" value="'
					 + data[i].optionText + '"readonly>'
					 +'</div>'
					)
				}
			}
		})
	}
	
	
	function selectOption() {
		selected = $('.input-group input:radio[name=seq]:checked').val();
		console.log(selected);
		resizeCanvas();
	}
	
//	$(window).load (function () {
//		console.log('aa');
//		
//	})
//	
//	
	
	
	
	
	
	
	
	
	
	
	
