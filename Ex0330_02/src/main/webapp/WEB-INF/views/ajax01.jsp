<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		   function ajax_submit(){
			   alert("확인 버튼을 클릭했습니다.");
			   // {rname:"홍길동",rcontent:"내용"}
			   $.ajax({
				   url:"ajax_ok",
				   type:"get",
				   data:{
					   rname:$("#rname").val(),rcontent:$("#rcontent").val()
				   },
				   contentType:"application/json",
				   success:function(data){
					   alert("성공");
					   var txt = "<tr><td>작성자</td><td>";
					   txt = txt + data.rname+"</td></tr>";
					   txt = txt + "<tr><td>내용</td><td>";
					   txt = txt + data.rcontent+"</td></tr>";
					   $('#tbody').prepend(txt);
					   
				   },
				   error:function(){
					   alert("에러");
				   }
			   });

		   }
		
		</script>
		<style type="text/css">
		  table,td{border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	 <form action="" >
	    <label>작성자</label>
	    <input type="text" id="rname" name="rname"><br>
	    <label>내용</label>
	    <input type="text" id="rcontent" name="rcontent"><br>
	    
	    <button type="button" onclick="ajax_submit()">확인</button><br>
	 </form>
	 <!-- 목록 -->
	 <hr>
	     <h2>댓글 목록</h2>
	 <table>
		 <tbody id="tbody">
		    <tr>
		      <td>작성자</td>
		      <td>홍길동</td>
		    </tr>
		    <tr>
		      <td>내용</td>
		      <td>홍길동이 글을 적었습니다.</td>
		    </tr>
		 </tbody>
	 </table>
	 
	 
	</body>
</html>



