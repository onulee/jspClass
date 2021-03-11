<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 체크</title>
		<c:out value="${ session_flag}"></c:out>
		<c:choose>
		  <c:when test="${session_flag == 'fail' || session_flag ==null }">
		    <script type="text/javascript">
		      alert('로그인 아이디,패스워드가 일치하지 않습니다. 다시 입력하시기 바랍니다.');
		      location.href="login.html";
		    </script>
		  </c:when>
		  <c:otherwise>
		     <script type="text/javascript">
		       alert('로그인 성공! 환영합니다.');
		       location.href="list.do";
		     </script>
		  </c:otherwise>
		</c:choose>
	</head>
	<body>
	
	</body>
</html>