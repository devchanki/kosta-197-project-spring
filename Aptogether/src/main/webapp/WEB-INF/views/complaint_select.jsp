<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html class="no-js" lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="/Aptogether/src/main/webapp/resources/css/complaint_select.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v4.0.2/bootstrap-float-label.min.css"/>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/Aptogether/src/main/webapp/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/Aptogether/src/main/webapp/resources/js/jquery-1.10.2.min.js"></script>
<script src="/Aptogether/src/main/webapp/resources/js/modernizr.custom.min.js"></script>
<script src="/Aptogether/src/main/webapp/resources/js/imagebox.js"></script>
<script>

</script>
</head>
<body>
	<div id = "maintitle">�ο��� �������ּ���.</div>
	<hr align="center" style="border: solid 5px #3300FF; width: 30%;">
	
	<div id="quickmain">
	<div id="modal">
    <div class="row">
            <div class="col-lg-6 offset-lg-3 col-sm-6 offset-sm-3 col-12">   
            
                <form class="card w-100 card-block bg-faded" action = "../apto/insertAction.do" method="post" class="form-horizontal"
                enctype="multipart/form-data">
                      <legend class="m-b-1 text-center text-info"> <strong> Contact us </strong></legend>
                      <div class="form-group input-group">
                        <span class="has-float-label">
                           <input id="Title" name="Title" type="text" placeholder="*����" class="form-control">
                          <label for="first">����</label>
                        </span>
                      </div>
                      
                      <div class="form-group input-group">
                        <span class="has-float-label">
                            <input id="Email" name="Email" type="text" placeholder="�̸���" class="form-control">
                          <label for="email">�̸���</label>
                        </span>
                      </div>
                      <div class="form-group input-group">
                        <span class="has-float-label">
                          <input id="Tel" name="Tel" type="text" placeholder="����ó" class="form-control">
                          <label for="contact">����ó</label>
                        </span>
                      </div>
                      <div class="form-group input-group">
                        <span class="has-float-label">
                         <textarea class="form-control" id="Content" name="Content" placeholder="*�� ������ �ۼ����ּ���." rows="7"></textarea>
                          <label for="message">����</label>
                        </span>
                      </div>
                       <!-- <div class="form-group input-group">
                        <span class="has-float-label">
                          <input id="Fname" name="Fname" type="file" placeholder="����" class="form-control">
                          <label for="contact">���� ÷��</label>
                        </span>
                      </div> -->
                      
                     <div class="form-content">
                     	


                            <div class="col-md-12 text-center">
                            	
                            	<input type="button" id="cancel" value="���"> 
                            	
                                <button type="submit" class="btn btn-primary btn-lg"
                           >�� ��</button>
                            </div>
                        </div>
                        
                </form>
        </div>	
    </div>
    </div>



			<div id="quickline1"> <span class="quick1">
			<a style="text-decoration:none"> <img src="./img/noise.png">
						<dl>
						<dt>��������</dt>
					</dl>
					</a>	
			</span>
			 <span class="quick1"> 
			<img src="./img/parking.png"></a>
					<dl>
						<dt>��������</dt>
						
					</dl>
			</span>
			</div>
			<div id="quickline2"> 
			<span class="quick2">
			 <a style="text-decoration:none">
			<img src="./img/trash.png"></a>
					<dl>
						<dt>������ ��������</dt>
					</dl>
			</span> <span class="quick2">
			<img src="./img/choice.png">
						<dt>��Ÿ</dt>
					
					</dl>
			</span>
			</div>
		</div>
	
	

<script>
/* function click_button(var a) {
	$("#modal").toggle();
} */
var matches = document.querySelectorAll("span.quick1, span.quick2, #cancel");
	for(var i = 0; i < matches.length; i++){
		matches[i].onclick = function(){
			$("#modal").toggle();
		}
	}

</script>

</body>
</html>