<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  파일 업로드는 기본적으로 post방식 전송을 진행합니다. 
		enctype(인코딩 타입)을 "multipart/form-data"로 반드시 지정-->
	<form action="${pageContext.request.contextPath }/fileupload/upload_ok" method="post" enctype="multipart/form-data">
		파일 선택: <input type="file" name="file"> <br>
		<input type="submit" value="전송">
	</form>
	
	
	<hr><hr>
	
	<!--  파일 개숫 제한 안하고 여러개 파일 업로드 가능 -->
	<form action="${pageContext.request.contextPath }/fileupload/upload_ok2" method="post" enctype="multipart/form-data">
		파일 선택: <input type="file" name="files" multiple="multiple"> <br> <!-- 여러개의 파일 올릴 수 있음 -->
		<input type="submit" value="전송">
	</form>
	
	<hr><hr>
	
	<!-- 최대 3개까지만 업로드 가능 1개나 2개만 해도 가능 -->
	<form action="${pageContext.request.contextPath }/fileupload/upload_ok3" method="post" enctype="multipart/form-data">
		파일 선택: <input type="file" name="file"> <br>
		파일 선택: <input type="file" name="file"> <br>
		파일 선택: <input type="file" name="file"> <br>
		<input type="submit" value="전송">
	</form>
	
	

</body>
</html>


<!--  파일 받는거 테스트 -->