<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	<c:out value="${session_flag}"></c:out>
		<c:choose>
		  <c:when test="${session_flag == 'fail' || session_flag ==null }">
		    <h3>로그인이 되어 있지 않습니다.</h3>
		  </c:when>
		  <c:otherwise>
		     <h3>${session_nickName }님 환영합니다.</h3>
		  </c:otherwise>
		</c:choose>
	  <ul>
	    <li><a href="list.do">게시판리스트</a></li>
	    <hr>
	    <li><a href="login.html">로그인</a></li>
	    <li><a href="join.do">회원가입</a></li>
	    <li><a href="view.do">회원정보보기</a></li>
	    <li><a href="modify.do">회원정보수정</a></li>
	    <li><a href="logout.jsp">로그아웃</a></li>
	  </ul>
	  
	</body>
</html>	