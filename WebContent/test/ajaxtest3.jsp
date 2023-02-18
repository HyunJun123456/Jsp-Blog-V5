<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<button onclick="idCheck();">아이디 있니?</button>
<div id="box"></div>
<script type="text/javascript">
	function idCheck(){
		fetch("http://localhost:8080/jspBlog/ajax").then(function(data){
			return data.text(); // 리턴이 필요함
		}).then(function(data){ // 파싱해줘야함
			alert(data);
		});
	}
</script>
</body>
</html>