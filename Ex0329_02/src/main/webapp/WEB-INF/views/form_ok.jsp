<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form2</title>
	</head>
	<body>
	  <a href="/form2/${uploadFileName}"><h2>form2</h2></a>
	  <table>
	    <tr>
	      <td>아이디</td>
	      <td>${ boardDto.id} </td>
	    </tr>
	    <tr>
	      <td>이름</td>
	      <td>${ boardDto.name} </td>
	    </tr>
	    <tr>
	      <td>예전파일이름</td>
	      <td>${ fileName} </td>
	    </tr>
	    <tr>
	      <td>확장자</td>
	      <td>${ fileNameExtension} </td>
	    </tr>
	    <tr>
	      <td>저장위치</td>
	      <td>${ fileUrl} </td>
	    </tr>
	    <tr>
	      <td>변경파일이름</td>
	      <td>${ uploadFileName } </td>
	    </tr>
	    
	  
	  </table>
	</body>
</html>