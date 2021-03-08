<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	  <ul>
	    <li><a href="login.do">로그인</a></li>
	    <li><a href="join.do">회원가입</a></li>
	    <li><a href="list.do?check_search=0&search_data=''">회원전체리스트</a></li>
	    <li><a href="view.do">회원정보보기</a></li>
	    <li><a href="modify.do">회원정보수정</a></li>
	    <li><a href="logout.do">로그아웃</a></li>
	  </ul>
	  
	  <form action="listOne.do" method="post">
	     <label>이름</label>
	     <input type="text" id="name" name="name"><br>
	     <input type="submit" value="확인">
	  </form>
	
	  <form action="list.do" method="post">
	     <label>이름</label>
	     <input type="hidden" id="check_search" name="check_search" value="1"><br>
	     <input type="text" id="name" name="name"><br>
	     <input type="submit" value="확인">
	  </form>
	  
	  <form action="dateSearch.do" method="post">
	     <label>날짜1</label>
	     <input type="hidden" id="check_search" name="check_search" value="2"><br>
	     <input type="date" id="date" name="date"><br>
	     <input type="submit" value="확인">
	  </form>
	</body>
</html>	