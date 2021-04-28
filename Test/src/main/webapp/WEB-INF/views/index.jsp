<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>메인페이지</title>
		<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
		<script type="text/javascript">
		function test(i){
			var a = $('#'+i+'-1').text();
			var b = $('#'+i+'-2').text();
			var c = $('#'+i+'-3').text();
			alert("데이터 정보값 : "+a+","+b+","+c);
		}
		
		</script>
	</head>
	<body>
	  <ul>
	  <c:choose>
	    <c:when test="${session_flag==null || session_flag=='fail' }">
	        <h3>로그인이 되어 있지 않습니다.</h3>
	        <li><a href="./event">이벤트</a></li>
	        <li><a href="../member/login">로그인</a></li>
	        <li><a href="join.do">회원가입</a></li>
	        <p></p>
	        
	        <p></p>
	        <p></p>
	        <table>
	          <tr>
	           <th>번호</th>
	           <th>이름</th>
	           <th>책제목</th>
	           <th>대여</th>
	          </tr>
	          <tr>
	           <td id="1-1">111</td>
	           <td id="1-2">홍길동</td>
	           <td id="1-3">좋은 하루</td>
	           <td id="1-4">
	             <button type="button" onclick="test(1)">1번 버튼</button>
	           </td>
	          </tr>
	          <tr>
	           <td id="2-1">222</td>
	           <td id="2-2">이순신</td>
	           <td id="2-3">빅데이터 기술</td>
	           <td id="2-4">
	             <button type="button" onclick="test(2)">2번 버튼</button>
	           </td>
	          </tr>
	        </table>
	    </c:when>
	    <c:otherwise>
	        <h3>${session_nName} 님 접속을 환영합니다.</h3>
		    <li><a href="../member/logout">로그아웃</a></li>
		    <li><a href="modify.do">회원정보수정</a></li>
		    <li><a href="view.do">회원정보보기</a></li>
	        <li><a href="list.do">게시판리스트</a></li>
	    </c:otherwise>
	  </c:choose>
	    <hr>
	  </ul>
	</body>
</html>