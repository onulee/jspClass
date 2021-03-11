<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <script type="text/javascript">
	      $(function(){
	    	  $('#getResult').click( function() {
	              $.ajax({
	                  url:'login.do',
	                  dataType:'json',
	                  type:'POST',
	                  data:{
	                	  'login_id':$('#login_id').val(),
	                	  'login_pw':$('#login_pw').val()
	                  },
	                  success:function(result){
	                      if(result['result']==true){
	                        alert('로그인 성공!');
	                      }
	                  },
	                  fail:function(result){
	                	  
	                  }
	              });
	          })
	      });
    
    </script>
	</head>
	<body>
	
	</body>
</html>