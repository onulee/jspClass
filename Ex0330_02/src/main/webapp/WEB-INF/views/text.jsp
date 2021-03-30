<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax append</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		   function list_insert(){
			   $("#list").prepend("<li>"+$('#title').val() +"</li>");
		   }
		
		</script>
	</head>
	<body>
	  <form action="" method="get">
	     <input type="text" id="title" name="title">
	     <button type="button" onclick="list_insert()">추가</button>
	  </form>
	
	
	  <ul id="list">
	    <li>01번째 목록</li>
	    <li>02번째 목록</li>
	  </ul>
	</body>
</html>