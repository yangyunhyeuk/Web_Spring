<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>게시글 상세보기</h3>
	<hr>

	<table border="1">
		<tr>
			<td>id</td>
			<td>title</td>
			<td>writer</td>
			<td>content</td>
			<td>wdate</td>
		</tr>
		<tr>
			<td>${data.id}</td>
			<td>${data.title}</td>
			<td>${data.writer}</td>
			<td>${data.content}</td>
			<td>${data.wdate}</td>
		</tr>

	</table>

</body>
</html>