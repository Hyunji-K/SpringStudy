<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href ="resources/css/style.css" rel ="stylesheet" />
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">  --><!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>회원 가입</title>
</head>
<script>
/* $(function(){
	$("#userID").blur(function(){
		
	});
	
}); */
function checkUserIdExist(){
	
	var userID = $("#userID").val();
	
	if(userID.length == 0){
		alert('아이디를 입력해주세요');
		return;
	}
	alert(userID);
	$.ajax({
		url : 'ID_Check.do',
		type : 'POST',
		data : {
			"userID" : userID
		},
		dataType : 'json', 
		success : function(data){
			if(data == 0){
				alert("사용하실 수 있는 아이디입니다.");
			}else{
				alert("중복된 아이디가 존재합니다.");
			}
		},
		error : function(){
			alert('error');
		}
	
	});
}
/*입력창 클릭시 중복버튼 초기화  */
function resetUserIdExist(){
	$("#userIdExist").val('false');
}
</script>
<body>
	<article class="container">
		<div class="page-header">
			<div class="col-md-6 col-md-offset-3">
				<h3>회원가입</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form:form action="insertUser.do" method="post" commandName="user">
			
			<!-- 아이디 -->
				<div class="form-group">
					<label for="userID">아이디</label> 
					<div class="input-group">
					<input type="text" class="form-control" id="userID" name="userID" placeholder="ID" onkeypress="resetUserIdExist()"> 
					<div class="input-group-append">
						<button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</button>
					</div>
				</div>
					<form:errors path="userID" cssClass="error"/>
				</div>
				<div class="form-group">
					<label for="userPwd">비밀번호</label> 
					<input type="password" 	class="form-control" id="userPwd" name="userPwd"
						placeholder="PASSWORD">
					<form:errors path="userPwd" cssClass="error"/>
				</div>
				<!-- <div class="form-group">
					<label for="pw2">비밀번호 확인</label> <input type="password"
						class="form-control" id="userPwd2" name="userPwd2"
						placeholder="Confirm Password">
					<div class="eheck_font" id="pw2_check"></div>
				</div> -->
				<div class="form-group">
					<label for="userName">이름</label>
					 <input type="text" class="form-control" id="userName" name="userName" placeholder="Name">
					<form:errors path="userName" cssClass="error"/>
				</div>
				<div class="form-group">
					<label for="userEmail">이메일 주소</label> <input type="email" 	class="form-control" id="userEmail" name="userEmail"
						placeholder="E-mail">
					<form:errors path="userEmail" cssClass="error"/>
				</div>
				<div class="form-group">
					<label for="userPhone">휴대폰 번호('-'없이 번호만 입력해주세요)</label> 
					<input type="tel" class="form-control" id="userPhone" name="userPhone"
						placeholder="Phone Number">
					<form:errors path="userPhone" cssClass="error"/>
			
				</div>
				<!-- <div class="form-group">
					<input class="form-control" style="width: 40%; display: inline;"
						placeholder="우편번호" name="mem_oaddress" id="mem_oaddress"
						type="text" readonly="readonly">
					<button type="button" class="btn btn-default"
						onclick="execPostCode();">
						<i class="fa fa-search"></i> 우편번호 찾기
					</button>
				</div>
				<div class="form-group">
					<input class="form-control" style="top: 5px;" placeholder="도로명 주소"
						name="mem_address" id="mem_address" type="text"
						readonly="readonly" />
				</div> -->
				<div class="form-group">
					<label for="userAddress">주소</label>
					<input class="form-control" placeholder="주소"
						name="userAddress" id="userAddress" type="text" />
				</div>
				<div class="form-group">
					<label for="adminYN">관리자 구분 </label>
					 <input type="checkbox"	id="adminYN" name="adminYN" value="0">관리자 
					<input type="checkbox" id="adminYN" name="adminYN" value="1">일반회원
				</div>
				<div class="form-group text-center">
					<button type="submit" class="btn btn-primary">회원가입</button>
				</div>
			</form:form>
		</div>
	</article>
</body>
</html>