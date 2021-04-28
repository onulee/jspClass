<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>Insert title here</title>
		<script type="text/javascript">
				function uploadFile(){
		            var form = $('#FILE_FORM')[0];
		            var formData = new FormData(form);
		            formData.append("files", $("#FILE_TAG")[0].files[0]);
		            formData.append("files", $("#FILE_TAG2")[0].files[0]);
		
		            $.ajax({
		                url: '/file_insert',
		                        processData: false,
		                        contentType: false,
		                        data: formData,
		                        type: 'POST',
		                        success: function(result){
		                            alert("업로드 성공!!");
		                            alert("name:"+result);
		                        }
		                });
		        }
		
		
		</script>
		
	</head>
	<body>
		<form id="FILE_FORM" method="post" enctype="multipart/form-data" action="/file_insert">
            <input type="file" id="FILE_TAG" name="files"><br>
            <input type="file" id="FILE_TAG2" name="files"><br>
            <input type="submit" value="전송" >
            <p></p>
            <a class="ui-shadow ui-btn ui-corner-all" href="javascript:uploadFile();">전송</a>
        </form>
	</body>
</html>