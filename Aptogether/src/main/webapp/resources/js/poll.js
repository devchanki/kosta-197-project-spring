	
	var i = 1;
	var selected = -1;
	var checked = false;
	var listUrl = null;
	var template = "option_modal";


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
	
	function imgName(fileName){
		console.log(fileName.substring(2, fileName.length));
		fileName = fileName.substring(2, fileName.length);
		console.log( '/keeper/pollSignBigPicture?fileName=' + fileName);
		$('.bigPicture').attr('src', '/keeper/pollSignBigPicture?fileName=' + fileName);
		console.log(fileName);
	}
	
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
			
				if(!selected){
					$('.alert').show();
				}else{
					$('.alert').alert('close');
						$('#option_modal').modal('hide');
					$('.alert').toggle();
					resizeCanvas();
					$('#sign_modal').modal('show');
				}
	
	}
	
		
		 $("[data-action]").on("click", function(){
			 if($(this).data("action")=="1"){
				 listUrl = "/tenant/pollAllList";
			 }else if($(this).data("action")=="2"){
				 listUrl = "/tenant/pollOnList";
			 }else if($(this).data("action")=="3"){
				 listUrl = "/tenant/pollEndList";
				 template = "endList_modal";
			 }
			 
			 $.ajax({
				 	url: listUrl,
					type: "GET",
					dataType: "json",
					success: function(data) {
						
						$('.pollList').html('');
						for(let i =0; i < data.length; i++){
							console.log(data[i]);
							

							var time = moment(data[i].endDate).format('LL');
							console.log(time);
							$('.pollList').append(
										 '<div class="card custom-bg mb-4 margin-auto max-width-card"'
										 +	'data-toggle="modal" data-target="#'
										 + template
										 +	'" onclick="showData('
										 + data[i].pollSeq
										 + ', &quot;'
										 + data[i].question
										 + '&quot;, &quot;'
										 + data[i].contents
										 + '&quot;)">'
										 +	'<div class="card-body text-white">'
										 +	'<h5 class="card-title">'
										 + data[i].question
										 + '</h5>'
										 +	'<p class="small text-white">'
										 + data[i].contents
										 +	'</p></div>'
										 +	'<div class="card-footer custom-bg small text-white">'
										 +	'<img id="poll_hitcount" src="/resources/img/eye.png">'
										 +	' 조회수 :  '
										 + data[i].hitcount
										 +'<span class="margin-left-span"> ' 
										 +  time
										 +' 마감 '
										 +	'</span>'
										 +	'</div></div>'
								)
				 
						}
					}
			 })
		 })

	
	
	
	
	
	
	
	
	
	
