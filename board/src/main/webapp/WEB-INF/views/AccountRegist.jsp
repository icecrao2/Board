<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>회원가입</title>
  </head>

<body>
	<script language="javascript">
		// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
		//document.domain = "abc.go.kr";
		
		function goPopup(){
			var path = window.location.href;
			
			// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		    var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		    
			// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
		};
		/** API 서비스 제공항목 확대 (2017.02) **/
		function jusoCallBack(roadAddrPart1, addrDetail, roadAddrPart2, zipNo){
		
			$("#roadAddrPart1").val(roadAddrPart1);
			$("#roadAddrPart2").val(roadAddrPart2);
			$("#addrDetail").val(addrDetail);
			$("#zipNo").val(zipNo);			
		};
	</script>
	<div class="jumbotron text-center"> 
			<h1>Crab's Board</h1> 
			<p>자유롭게 생각을 나눠봐요!</p> 
	</div>

	<div class="container">
		<div class="row">
                <div class="col-12">
                    <form id = "AccountRegistForm" action="http://localhost:8080/board//accountform" method="post">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" name="id" class="form-control" id="id" aria-describedby="emailHelp" placeholder="Enter ID">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Name">
                        </div>
                        
                        <div class="form-group">
                        	<div>
                            	<label style="">Phone-Number</label>
                            </div>
                            <div style ="padding:10px 0px 0px 0px;">
	                            <input type="text" name="phoneNumber" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style = "width:400px; float:left;" class="form-control onlyNumber" id="phoneNumber" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
     	                       <input type="button" value="인증번호 전송" class="btn btn-primary" id ="sendCertificationNumber">
                            </div>
                            <div id="CertificationDiv" style ="padding:10px 0px 0px 0px; display:none;">
		                	    <input type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style = "width:400px; float:left;" class="form-control onlyNumber" id="CertificationNumber" data-rule-required="true"  maxlength="6">
		                	    <input type="button" value="인증하기" class="btn btn-primary" id ="Certification">
                        	</div>
                        </div>
                        <div class="form-group">
                            <label>Birth</label>
                            <input type="date" name="birth" class="form-control" id="birth" placeholder="Birth">
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <table>
								<colgroup>
									<col style="width:20%"><col>
								</colgroup>
								<tbody>
									<tr>
										<th>우편번호</th>
										<td>
										    <input class="form-control" type="hidden" id="confmKey" value=""  >
											<input class="" type="text" id="zipNo" readonly style="width:100px">
											<input class="btn btn-primary" type="button"  value="주소검색" onclick="goPopup();">
										</td>
									</tr>
									<tr>
										<th>도로명주소</th>
										<td><input class="form-control" type="text" id="roadAddrPart1" style="width:85%"></td>
									</tr> 
									<tr>
										<th>상세주소</th>
										<td>
											<input class="form-control" type="text" id="addrDetail" style="width:40%" value="">
											<input class="form-control" type="text" id="roadAddrPart2"  style="width:40%" value="">
										</td>
									</tr>
								</tbody>
							</table>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
     	</div>
	</div>
	
	

</body>

<script>
	$("#sendCertificationNumber").click(function(){
		//문자 인증 시스템 입력!
		$("#CertificationDiv").show();
	});

	$("#AccountRegistForm").submit(function(){
		
		event.preventDefault();
	  	var url = $(this).attr("action");
	  	var data = $(this).serialize(true);

	  	data += "&zipno="+$("#zipNo").val();
	 	data += "&roadAddrPart1="+$("#roadAddrPart1").val();
	  	data += "&addrDetail="+$("#addrDetail").val();
	  	data += "&roadAddrPart2="+$("#roadAddrPart2").val();
	  	
		$.ajax({
			  url: "http://localhost:8080/board//accountform",
	          type: "POST",
	          data: data,
	      //    dataType:"text",
	          success: function(data){
	        	  
	        	  alert(data.address);
	          },
	          error:function(request, error) {

	  			alert("fail");

		  		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	
		  		}
		  });
	});

</script>

</html>