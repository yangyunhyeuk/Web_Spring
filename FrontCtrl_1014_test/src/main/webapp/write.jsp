<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>글 작성하기</h3>
	<form method="post" action="write.do">
		<input type="hidden" name="id" value="${mid}">
		<table border="1">
			<tr>
				<td><input type="text" min="1" name="title" placeholder="제목"></td>
			</tr>
			<tr>
				<td><input type="text" min="1" name="content" placeholder="내용"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id="write" class="button primary" value="등록"></td>
			</tr>
		</table>
	</form>


</body>
</html>