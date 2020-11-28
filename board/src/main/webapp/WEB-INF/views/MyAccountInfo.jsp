<%@page import="com.fasterxml.jackson.core.JsonParser"%>
<%@page import="com.jaewoong.board.DTO.AccountDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>내 정보</title>
    
    <% 
	//request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
	//request.setCharacterEncoding("EUC-KR");  //해당시스템의 인코딩타입이 EUC-KR일경우에
	
	String dto = request.getParameter("account");
	
	%>
    
  </head>

<body>
	
	
	
	<div class="jumbotron text-center"> 
			<h1>Crab's Board</h1> 
			<p>자유롭게 생각을 나눠봐요!</p> 
	</div>

	<div class="container">
		<div class="row">
                <div class="col-12">
                    <form>
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" class="form-control" id="id" aria-describedby="emailHelp" placeholder="Enter ID">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Name">
                        </div>
                        
                        <div class="form-group">
                        	<div>
                            	<label style="">Phone-Number</label>
                            </div>
                            <div style ="padding:10px 0px 0px 0px;">
	                            <input type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style = "width:400px; float:left;" class="form-control onlyNumber" id="phoneNumber" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
     	                       <input type="button" value="인증번호 전송" class="btn btn-primary" id ="sendCertificationNumber">
                            </div>
                            <div id="CertificationDiv" style ="padding:10px 0px 0px 0px; display:none;">
		                	    <input type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style = "width:400px; float:left;" class="form-control onlyNumber" id="CertificationNumber" data-rule-required="true"  maxlength="6">
		                	    <input type="button" value="인증하기" class="btn btn-primary" id ="Certification">
                        	</div>
                        </div>
                        <div class="form-group">
                            <label>Birth</label>
                            <input type="date" class="form-control" id="birth" placeholder="Birth">
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <table >
								<colgroup>
									<col style="width:20%"><col>
								</colgroup>
								<tbody>
									<tr>
										<input class="form-control" type="text" id="address" readonly>
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

<script language="javascript">

	$(document).ready(function(){
		var json = <%=request.getAttribute("account")%>;
		
		var id = json.id;
		var password = json.password;
		var name = json.name;
		var permission = json.permission;
		var birth = json.birth;
		var phoneNumber = json.phoneNumber;
		var address = json.address;
		
		
		$("#id").val(id);
		$("#password").val(password);
		$("#name").val(name);
		$("#permission").val(permission);
		$("#birth").val(birth);
		$("#phoneNumber").val(phoneNumber);
		$("#address").val(address);
	});
	
	$("#sendCertificationNumber").click(function(){
		//문자 인증 시스템 입력!
		$("#CertificationDiv").show();
	});
		
	</script>

</html>