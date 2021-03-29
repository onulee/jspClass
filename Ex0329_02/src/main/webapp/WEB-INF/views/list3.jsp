<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>list3</title>
	</head>
	<body>
	  <h2>list3</h2>
	  <table>
	    <tr>
	      <td>게시글 수</td>
	      <td>${map.listCount} </td>
	    </tr>
	    <tr>
	      <td>현재 페이지</td>
	      <td>${map.nowPage} </td>
	    </tr>
	    <tr>
	      <td>최대 페이지</td>
	      <td>${map.maxpage} </td>
	    </tr>
	    <tr>
	      <td>첫 페이지</td>
	      <td>${map.startpage} </td>
	    </tr>
	    <tr>
	      <td>끝 페이지</td>
	      <td>${map.endpage} </td>
	    </tr>
	   
	    
	  
	  </table>
	</body>
</html>