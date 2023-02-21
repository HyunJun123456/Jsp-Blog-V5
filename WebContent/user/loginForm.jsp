<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!-- x-www-form-urlencoded key : value 형태로 들어감 -->
<div class="container">
	<form action="/jspBlog/user?cmd=login" method="post">
		<div class="form-group">
			<input type="text" name="username" id="username" class="form-control" placeholder="Enter Username" required="required">
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control" placeholder="Enter Password" required="required">
		</div>
		<button type="submit" class="btn btn-primary">로그인완료</button>
	</form>
</div>
</body>
</html>