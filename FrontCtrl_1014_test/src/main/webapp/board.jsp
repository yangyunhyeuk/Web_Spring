<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function PageMove(page) {
		location.href = "board.do?page=" + page;
	}
</script>
</head>
<body>

	<h2>${mid}님이입장하셨습니다</h2>
	<a href="write.jsp">글 작성하기</a>
	<br>
	<br>
	<br>
	<br>
	<br>

	<table border="1">
		<tr>
			<td>id</td>
			<td>title</td>
			<td>wdate</td>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.id}</td>
				<td><a href="post.do?&id=${b.id}">${b.title}</a></td>
				<td>${b.wdate}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="toolbar-bottom">
			<div class="toolbar mt-lg">
				<div class="sorter">
					<a href="javascript:PageMove(${paging.firstPageNo})">맨앞으로</a> <a
						href="javascript:PageMove(${paging.prevPageNo})">앞으로</a>

					<c:forEach var="i" begin="${paging.startPageNo}"
						end="${paging.endPageNo}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNo}">
								<a href="javascript:PageMove(${i})">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:PageMove(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<a href="javascript:PageMove(${paging.nextPageNo})">뒤로</a> <a
						href="javascript:PageMove(${paging.finalPageNo})">맨뒤로</a>

				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<hr>
		<br>
		<br>
		<br>






























	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${not empty datas}">
			<table border="1">
				<tr>
					<td>id</td>
					<td>title</td>
					<td>wdate</td>
				</tr>
				<c:forEach var="b" items="${datas}">
					<tr>
						<td>${b.id}</td>
						<td><a href="post.do?&id=${b.id}">${b.title}</a></td>
						<td>${b.wdate}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>작성된 게시글이 없습니다</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>