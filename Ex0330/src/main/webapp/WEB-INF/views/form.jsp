<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
	</head>
	<body>
	  <h2>form의 페이지</h2>
	  <form action="formOk" method="post" name="form">
	    <label>아이디</label>
	    <input type="text" name="id" ><br>
	    <label>비밀번호</label>
	    <input type="password" name="pw" ><br>
	    <input type="submit" value="전송" ><br>
	  </form>
	</body>
</html>