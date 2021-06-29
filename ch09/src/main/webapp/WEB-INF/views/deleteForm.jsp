<!-- 회원게시판일 경우에는 deleteForm은 필요없다 -->
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
			alert("비밀번호가 일치하지 않습니다");
			frm.password.focus();
			frm.password.value="";
			return false;
		}
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">게시글 삭제 확인</h2>
	<form action="delete.do" name="frm" onsubmit="return chk()">
		<input type="hidden" name="confirmPass" value="${board.password }">
		<input type="hidden" name="num" value="${board.num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<table class="table table-hover">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="삭제" class="btn btn-danger">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>