<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memberList페이지</title>
		<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	  <table>
	    <tr>
	      <th>아이디</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>입사일</th>
	      <th>월급</th>
	    </tr>
	    <c:forEach var="dto" items="${list}">
		    <!-- 반복 시작 -->
		    <tr>
		      <td>${dto.employee_id }</td>
		      <td>${dto.emp_name }</td>
		      <td>${dto.phone_number }</td>
		      <td>${dto.hire_date }</td>
		      <td>${dto.salary }</td>
		    </tr>
		    <!-- 반복 끝 -->
	    </c:forEach>
	  </table>
	
	</body>
</html>