<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h3>여기는 회원가입 존</h3>
	<hr>

	<form action="join.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><input type="text" name="role"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>

</body>
</html>