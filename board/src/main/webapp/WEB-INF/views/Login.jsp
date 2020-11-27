<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>


<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>로그인</title>

  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	
	<div class="jumbotron text-center"> 
			<h1>Crab's Board</h1> 
			<p>자유롭게 생각을 나눠봐요!</p> 
	</div>
			
	<div>
		<div class="card" style="width:20rem; border-radius:20px; float:left;">
			<div class="card-title" style="margin-top:30px; ">
				<h2 class="card-title text-center" style="color:#113366;">로그인</h2>
			</div>
			<div class="card-body">
		      <form id = "frm" class="form-signin" method="POST" action="/Login">
		        <h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
		        <label for="inputEmail" class="sr-only">Your ID</label>
		        <input type="text" id="id" name="id" class="form-control" placeholder="Your ID" required autofocus><BR>
		        <label for="inputPassword" class="sr-only">Password</label>
		        <input type="password" id="password" name="password"  class="form-control" placeholder="Password" required><br>
		        <div class="checkbox">
		          <label>
		            <input type="checkbox" value="remember-me"> 기억하기
		          </label>
	        </div>
	        <button id="btn-Regist" class="btn btn-lg btn-primary " type="button">회원가입</button>
	        <button id="btn-Yes" class="btn btn-lg btn-primary " type="submit">로 그 인</button>
	      </form>
	      
			</div>
			
		</div>
		<table class="table table-hover" style="width:74rem; float:right;">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>title</td>
						<td>writer</td>
						<td>2020-00-00</td>
						<td>1</td>
					</tr>
					<tr>
						<td>
							<ul class="pagination" >
								<li class="page-item"><a style="float:none;" class="page-link" href="#">1</a></li>
								<li class="page-item"><a style="float:none;" class="page-link" href="#">2</a></li>
								<li class="page-item"><a style="float:none;" class="page-link" href="#">3</a></li>
								<li class="page-item"><a style="float:none;" class="page-link" href="#">4</a></li>
								<li class="page-item"><a style="float:none;" class="page-link" href="#">5</a></li>
							</ul>
						</td>								
					</tr>
				</tbody>
		</table>
		
	</div>
			
	<div class="modal">
	</div>
    <!-- Optional JavaScript -->
  </body>
</html>

<script>

	$('#btn-Regist').click(function(){
		
  		var path = window.location.href;
		location.href = path + "/AccountRegist";
	});

	$( "#frm" ).submit(function( event ) {
	  event.preventDefault();
	  var path = window.location.href;
	  var url = path + $(this).attr("action");
	  var data = $(this).serialize(true);
	

	  
	  $.ajax({
		  url: url,
          type: "POST",
          data: data,
          dataType:"JSON",
          success: function(data){
        	  //login 성공 처리
        	  location.href = path  + "/Main";
          },
          error: function(){
        	  //로그인 실패 처리
        	  alert("로그인에 실패하였습니다.");
          } 
	  });
	});
</script>