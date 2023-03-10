<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<div class="container">
	<form action="/jspBlog/user?cmd=join" method="post" onsubmit="return valid()"><!-- submit 될 때 무조건 실행됨 -->
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-info" onClick="usernameCheck()">중복체크</button>
		</div>
		<div class="form-group">
			<input type="text" name="username" id="username" class="form-control" placeholder="Enter Username" required="required">
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control" placeholder="Enter Password" required="required">
		</div>
		<div class="form-group">
			<input type="email" name="email" class="form-control" placeholder="Enter Email" required="required">
		</div>
		<div class="form-group">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
			</div>
			<input type="text" id="address" name="address" class="form-control" placeholder="Enter Address" required="required" readonly="readonly">
		</div>
		<button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>
</div>
<script>
	var isChecking = false;
	
	function valid(){
		if(isChecking == false){
			alert("아이디 중복체크를 해주세요");
		}
		return isChecking;
	}
	
	function usernameCheck(){
		// DB에서 확인해서 정상이면 isChecking = true
		var username = $("#username").val(); // document querySelector와 같은 의미
		/*
			<div id="a" value="ddd"><p>안녕</p></div>
			document.querySelector("#a");
			$("#a").text(); -> 안녕
			$("#a").html(); -> <p>안녕</p>
			$("#a").value(); -> ddd
		*/
		/* var a = "{\"result\" : \"있어\"}";
		var b = {result : "있어"};
		console.log(a);
		console.log(b.result); */
		
		$.ajax({
			type: "POST",
			url: "/jspBlog/user?cmd=usernameCheck", // http:localhost:8080/jspBlog 생략가능
			data: username, // 요청할 때 들고갈 body data
			contentType: "text/plain; charset=utf-8", // 던져줄 데이터의 타입
			dataType: "text" // 응답 받을 데이터의 타입을 적으면 자바스크립트 오브젝트로 파싱해줌.
		}).done(function(data){ // 요청이 끝나면 함수 실행
			if(data === "ok"){ // 유저네임 있다는 것
				isChecking = false;
				alert('유저네임이 중복되었습니다.');
			}else{
				isChecking = true;
			}
		}); 
			
			
	}

	/*language="javascript" 옛날 버전에서 적어주는 거임  */
	// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
	//document.domain = "abc.go.kr";
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/jspBlog/user/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr) {
		var addressEl = document.querySelector("#address");
		addressEl.value = roadFullAddr;
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		//document.form.roadFullAddr.value = roadFullAddr; 
	}
</script>
</body>
</html>