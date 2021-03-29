<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>page1</title>
	</head>
	<body>
	  <h2>page1</h2>
	  <ul>
	    <c:set var="page" value="1"></c:set>
	    <c:set var="category" value="all"></c:set>
	    <c:set var="search" value="게시판"></c:set>
	    <!-- 파라미터 전달방법 -->
	    <a href="list?page=${page}&category=${category}&search=${search}">
	      <li> 파라미터 보내기</li>
	    </a>
	    <!-- PathVariable 전달방법 -->
	    <a href="list2/${page}/${category}/${search}">
	      <li>PathValiable 보내기</li>
	    </a>
	    <!-- Map 전달방법 -->
	    <a href="list3/${page}/${category}/${search}">
	      <li>Map 전달방법</li>
	    </a>
	  </ul>
	</body>
</html>



