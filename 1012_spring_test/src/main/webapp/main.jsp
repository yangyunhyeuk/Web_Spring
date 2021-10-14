<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h3><a href="logout.jsp">로그아웃</a></h3>
<hr>
<h1>글 목록</h1>
<hr>
<table border="1">
	<tr>
		<td>글 번호</td><td>글 제목</td><td>글 작성자</td>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="getBoard.jsp?id=${v.id}">${v.id}</a></td><td>${v.title}</td><td>${v.writer}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<a href="insertBoard.jsp">글 작성</a>
</body>
</html>