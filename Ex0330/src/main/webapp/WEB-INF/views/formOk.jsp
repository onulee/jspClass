<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
	</head>
	<body>
	  <h2>로그인 결과</h2>
	  <table>
	     <tr>
	       <td>입력한 아이디</td>
	       <td>${memberDto.id}</td>
	     </tr>
	     <tr>
	       <td>입력한 패스워드</td>
	       <td>${memberDto.pw}</td>
	     </tr>
	     <tr>
	       <td>로그인 결과</td>
	       <td>
		       <c:if test="${result==1}">
		          <p>입력한 id,pw가 일치합니다.</p>
		       </c:if>
		       <c:if test="${result==-1}">
		          <p style="color:red">입력한 id,pw가 일치하지 않습니다.</p>
		       </c:if>
	       </td>
	     </tr>
	  </table>
	</body>
</html>