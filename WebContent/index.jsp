<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>인덱스 페이지입니다.</h1>
</body>
</html>
<!--
	어느 폴더에 들어갈까? 컨텍스트 path
	localhost:8080 mywork 폴더
	localhost:8080/blog 	mywork 폴더의 blog 폴더의 webcontent 폴더 진입
	mywork 폴더의 blog 폴더의 webcontent 폴더의 index.jsp를 요청
	http://localhost:8080/jspBlog/index.jsp
  -->
<!-- 
	대부분 웹브라우저에서 요청함
	웹브라우저는 jsp 파일을 이해할 수 없음
	자바를 컴파일 할 수 없음
	avi, txt 정적인 파일은 해석가능
	톰캣은 해석이 가능해서
	서블릿으로 변환함 (지바 파일로 바꿈) - 자바 파일에서 html로 응답해주는 방법
	index_jsp.java로 바꿔 버림
	컴파일 시킴
	index_jsp.class
	실행 시킴
	결과로 index.html로 변환됨
	자바 코드를 톰캣이 해석해서 html에 결과를 뿌림
	톰캣은 WAS라고 부름
	웹서버라고 하지 않음
	
	 -->
