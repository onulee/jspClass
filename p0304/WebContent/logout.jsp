<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   session.invalidate();    
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그아웃</title>
		<script type="text/javascript">
		  alert("로그아웃 되었습니다.");
		  location.href="index.jsp";
		</script>
	</head>
	<body>
	
	</body>
</html>