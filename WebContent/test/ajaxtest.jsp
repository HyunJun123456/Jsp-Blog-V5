<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="idCheck();">아이디 있니?</button>

<script type="text/javascript">
	function idCheck(){
		alert("실행됨?");
		var xhttp = new XMLHttpRequest();
		
		// 해당 함수는 통신이 끝나면 콜백
		  xhttp.onreadystatechange = function() {
			  if(this.readyState == 4 && this.status == 200){
				//document.getElementById("demo").innerHTML = this.responseText;
				alert(this.responseText);
			}
		}
		xhttp.open("GET", "http://localhost:8080/jspBlog/ajax", true);
		xhttp.send();
	}
</script>
</body>
</html>