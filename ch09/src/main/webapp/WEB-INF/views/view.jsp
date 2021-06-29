<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$('#boardDisp').load("list.do", "pageNum=${pageNum}");
	//	$('#boardDisp').load("list.do table", "pageNum=${pageNum}"); 취향에 따라 선택
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">게시글 상세 내역</h2>
	<table class="table table-striped">
		<tr>
			<td>제목</td>
			<td colspan="3">${board.subject }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer }</td>
			<td>이메일</td>
			<td>${board.email }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.readcount }</td>
			<td>작성일</td>
			<td>${board.reg_date }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3"><pre>${board.writer }</pre></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<a href="list.do?pageNum=${pageNum }" class="btn btn-info">게시글 목록</a>
				<a href="updateForm.do?num=${board.num }&pageNum=${pageNum }" class="btn btn-warning">수정</a>
				<!-- 회원 게시글일 경우에는 deleteForm없이 삭제 확인 후 바로 삭제 -->
				<a href="deleteForm.do?num=${board.num }&pageNum=${pageNum }" class="btn btn-danger">삭제</a>
				<a href="insertForm.do?num=${board.num }&pageNum=${pageNum }" class="btn btn-info">답글</a>
			</td>
		</tr>
	</table>
	<div id="boardDisp"></div>
</div>
</body>
</html>