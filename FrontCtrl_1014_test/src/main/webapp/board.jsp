<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>${mid}님이입장하셨습니다</h2>
	<a href="write.do">글 작성하기</a>
	<br>
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${empty datas}">
			<h3>작성된 게시글이 없습니다</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>id</td>
					<td>title</td>
					<td>wdate</td>
				</tr>
				<c:forEach var="b" items="${datas}">
					<tr>
						<td>${b.id}</td>
						<td>${b.title}</td>
						<td>${b.wdate}</td>
					</tr>

				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>