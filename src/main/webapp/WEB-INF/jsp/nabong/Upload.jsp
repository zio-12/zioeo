<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>파일업로드</title>
</head>
<body>
	<form action="/fileUpload.do" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		 내용 : <input type="text" name="text"><br> 
		 업로드 한사람 : <input type="text" name="id"><br> 
		 파일 : <input type="file" name="file"><br> 
		 <input type="submit" name="업로드" value="업로드"><br>
	</form>
</body>
</html>

