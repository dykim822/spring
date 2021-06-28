<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		if(frm.password.value != frm.confirmPass.value) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			frm.password.focus();
			frm.password.value="";
			return false;
		}
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">게시글 입력</h2>
	<form action="insert.do" method="post" name="frm" onsubmit="return chk()">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="ref" value="${ref }">
		<input type="hidden" name="re_level" value="${re_level }">
		<input type="hidden" name="re_step" value="${re_step }">
	<table class="table table-bordered">
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="subject" required="required" autofocus="autofocus">
			</td>
		</tr>
		<!-- 회원게시판에서는 사용안하고 id나 회원이름으로 대체
		회원 게시판에서는 login하지 않으면 조회는 가능하지만 입력, 수정, 삭제는 못한다 -->
		<tr>
			<td>작성자</td>
			<td>
				<input type="text" name="writer" required="required">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" required="required">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" required="required">
			</td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td>
				<input type="password" name="confirmPass" required="required">
			</td>
		</tr>
		<!-- 여기까지 회원게시판에서는 필요없는 부분(비회원도 접근 가능하다면 필요) -->
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="40" name="content" required="required"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성" class="btn btn-warning">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>