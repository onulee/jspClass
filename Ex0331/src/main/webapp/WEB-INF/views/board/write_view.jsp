<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
       function writeCheck(){
    	   alert("성공");
    	   /* if($("#btitle").val()==""){
    		   alert("타이틀을 꼭 적으셔야 합니다.");
    		   $("#btitle").focus();
    		   return false;
    	   } */
    	   
    	   $.ajax({
			   url:"./write1",
			   type:"post",
			   enctype:"multipart/form-data",
			   data: new FormData($('#writeForm')[0]),
		       processData: false,
		       contentType: false,
		       cache: false,
			   success:function(data){
					alert("게시판 등록이 완료되었습니다.");
					location.href="./list";
			   },
			   error:function(){
				   alert("에러");
			   }
		   });
    	   
    	   
       }
    
    </script>
  
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/write.css">
</head>
<body>
<section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="./write" id="writeForm" name="writeForm" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname" id="bname">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" id="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" id="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" onclick="writeCheck()" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='./list'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>