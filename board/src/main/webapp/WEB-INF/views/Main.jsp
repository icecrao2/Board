<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>게시판</title>
  </head>
	<body>
		
		<div class="jumbotron text-center"> 
			<h1>Crab's Board</h1> 
			<p>자유롭게 생각을 나눠봐요!</p> 
		</div>
		
		<div>
			<div class="card" style="width:20rem; border-radius:20px; float:left;">
				<div class="card-title" style="margin-top:30px; ">
					<h2 class="card-title text-center" style="color:#113366;">환영합니다!</h2>
				</div>
				<div class="card-body">
		        <h5 class="form-signin-heading" style="text-align:center;">ID님</h5>
		        <h5 class="form-signin-heading" >등급 : </h5>
		        <button id="btn-accountInfo" class="btn btn-lg btn-primary " type="button">회원정보</button>
		        <button id="btn-logout" class="btn btn-lg btn-primary " type="button" style = "float:right;">로그아웃</button>
		      
		      
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
			
		
	</body>
</html>