<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
       function testAjax(){
    	   
    	   alert("로그인 체크합니다.");
    	   $.ajax({
			   url:"/testAjax",
			   type:"get",
			   data:{
				   "date":$("#date").val(),"location":$("#location").val()
			   },
			   contentType:"application/json",
			   dataType:"json",
			   success:function(data){
				   var arr = data.response.body.items.item;
			       var html;
			        for(var i in arr){
			            html += '<tr>';
			            html += '<td>'+arr[i].tm+'</td>';
			            html += '<td>'+arr[i].thema+'</td>';
			            html += '<td>'+arr[i].courseId+'</td>';
			            html += '<td>'+arr[i].courseAreaId+'</td>';
			            html += '<td>'+arr[i].courseAreaName+'</td>';
			            html += '<td>'+arr[i].courseName+'</td>';
			            html += '<td>'+arr[i].sky+'</td>';
			            html += '<td>'+arr[i].rhm+'</td>';
			            //....
			            html += '</tr>';
			        }
			        $('#data').html(html);
			   },
			   error:function(){
				   alert("에러");
			   }
		   });
    	   
       }
    
    </script>
<title>ajax테스트</title>
<style type="text/css">
   table,th,td{border:1px solid black; border-collapse: collapse;}
</style>
</head>
<body>
	<h2>ajax테스트</h2>
	<form>
		<label>날짜(예시:2020122010)</label> <input type="text" id="date" name="date"><br>
		<label>관광지명</label> <input type="text" id="location" name="location"><br>
		<input type="button" onclick="testAjax()" value="검색">
	</form>
	
	<table>
		<thead>
		   <tr>
		     <td>예보시각</td>
		     <td>테마</td>
		     <td>코스ID</td>
		     <td>관광지지역아이디</td>
		     <td>관광지지역이름</td>
		     <td>관광지명</td>
		     <td>하늘상태</td>
		     <td>습도</td>
		   </tr>
		</thead>
       <tbody id="data">
       
       </tbody>
	</table>

</body>
</html>