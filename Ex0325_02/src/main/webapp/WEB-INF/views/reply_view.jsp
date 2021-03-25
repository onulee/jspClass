<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
</head>
<body>
<section>
    <h1>답글</h1>
    <hr>

    <form action="reply.do" name="reply" method="post" enctype="multipart/form-data">
      <table>
      <input type="hidden" name="bId" value="${dto.bId }">
      <input type="hidden" name="bGroup" value="${dto.bGroup }">
      <input type="hidden" name="bStep" value="${dto.bStep }">
      <input type="hidden" name="bIndent" value="${dto.bIndent }">
      <input type="hidden" name="category" value="${category }">
      <input type="hidden" name="page" value="${page }">
      <input type="hidden" name="search" value="${search }">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bName" value="${dto.bName }">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="bTitle" value="[답글] ${dto.bTitle }">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
<textarea name="bContent" cols="50" rows="10">

---------------------------
[답글]
${dto.bContent }
</textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="fileName" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">답변완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='list.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>