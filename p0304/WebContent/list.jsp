<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<c:choose>
		  <c:when test="${session_flag == 'fail' || session_flag ==null }">
		    <script type="text/javascript">
		      alert('로그인 하셔야 접속이 가능합니다.');
		      location.href="login.html";
		    </script>
		  </c:when>
		</c:choose>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/notice_list.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="search.do" name="search_Form" method="post">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" name="search" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="12%">
        <col width="44%">
        <col width="17%">
        <col width="17%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach var="dto" items="${list}">
      <tr>
        <td><span class="table-notice">${dto.bId }</span></td>
        <td class="table-title">
           <c:forEach begin="1" end="${dto.bIndent }">└▶</c:forEach>
             <a href="content_view.do?category=${category}&search=${search}&bId=${dto.bId}&page=${page}">${dto.bTitle }</a>
        </td>
        <td>${dto.bName }</td>
        <td><fmt:formatDate value="${dto.bDate}" pattern="YYYY/MM/dd"/></td>
        <td>${dto.bHit }</td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
      <!-- 처음으로 -->
      <a href="list.do?category=${category}&search=${search}&page=1"><li class="first"></li></a>
      <!-- 이전페이지   1-> 0 -->
      <c:if test="${page<=1}">
         <li class="prev"></li>
      </c:if>
      <c:if test="${page>1}">
        <a href="list.do?category=${category}&search=${search}&page=${page-1}"><li class="prev"></li></a>
      </c:if>
      <c:forEach var="nowPage" begin="${startPage}" end="${endPage}">
	      <c:if test="${page == nowPage}">
	         <li class="num"><div>${nowPage}</div></li>
	      </c:if>
	      <c:if test="${page != nowPage}">
	        <a href="list.do?category=${category}&search=${search}&page=${nowPage}"><li class="num"><div>${nowPage}</div></li></a>
	      </c:if>
      </c:forEach>
      <!-- 다음페이지 -->
      <c:if test="${page<maxPage}">
         <a href="list.do?category=${category}&search=${search}&page=${page+1}"><li class="next"></li></a>
      </c:if>
      <c:if test="${page>=maxPage}">
         <li class="next"></li>
      </c:if>
      <!-- 최대페이지 -->
      <a href="list.do?category=${category}&search=${search}&page=${maxPage}"><li class="last"></li></a>
    </ul>

    <a href="write_view.do"><div class="write">쓰기</div></a>
  </section>

</body>
</html>