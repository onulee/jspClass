<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>list</title>
	</head>
	<body>
	  <h2>list</h2>
	  <table>
	    <tr>
	      <td>페이지</td>
	      <td>${page} </td>
	    </tr>
	    <tr>
	      <td>검색 카테고리</td>
	      <td>${category} </td>
	    </tr>
	    <tr>
	      <td>검색내용</td>
	      <td>${search} </td>
	    </tr>
	   
	    
	  
	  </table>
	</body>
</html>